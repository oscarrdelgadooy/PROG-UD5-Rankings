import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import net.salesianos.element.Tobacco;

public class App {
    public static void main(String[] args) throws Exception {
        String[] opciones = {
            "Añadir elemento",
            "Editar elemento",
            "Mostrar elemento",
            "Eliminar elemento",
            "Salir del programa."
        };

        final List<Tobacco> nombres = new ArrayList<>();
        nombres.add(new Tobacco("Marlboro", 4, 5.2f, 20));
        nombres.add(new Tobacco("Lm", 4, 3.8f, 20));
        nombres.add(new Tobacco("Paramount", 1, 2.3f, 20));
        nombres.add(new Tobacco("Benson&Hedges 100s", 3, 3.2f, 20));
        nombres.add(new Tobacco("Corona", 2, 3.5f, 20));
        nombres.add(new Tobacco("Kruger", 0, 3f, 20));
        nombres.add(new Tobacco("Chesterfield 24s", 3, 3.8f, 24));

        int ask;
        do {
            int selection = JOptionPane.showOptionDialog(
                null,
                "Elige una opción:",
                "Menú Principal",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opciones,
                opciones[0]
            );

            if (selection == 0) {
                JTextField nameTobacco = new JTextField();
                JTextField rankingTobacco = new JTextField();
                JTextField priceTobacco = new JTextField();
                JTextField sizeTobacco = new JTextField();

                Object[] campos = {
                    "Nombre:", nameTobacco,
                    "Ranking (número):", rankingTobacco,
                    "Precio:", priceTobacco,
                    "Tamaño (cantidad de cigarrillos):", sizeTobacco
                };

                int result = JOptionPane.showConfirmDialog(null, campos, "Añadir nuevo Tobacco", JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    try {
                        String nombre = nameTobacco.getText();
                        int ranking = Integer.parseInt(rankingTobacco.getText().trim());
                        float price = Float.parseFloat(priceTobacco.getText().trim());
                        int size = Integer.parseInt(sizeTobacco.getText().trim());

                        nombres.add(new Tobacco(nombre, ranking, price, size));
                        JOptionPane.showMessageDialog(null, "Tobacco añadido.");
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Por favor, introduce valores numéricos válidos.");
                    }
                }
            }

            else if (selection == 1) {
                if (nombres.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No hay elementos para editar.");
                } else {
                    String[] nombresArray = new String[nombres.size()];
                    int i = 0;
                    for (Tobacco t : nombres) {
                        nombresArray[i] = t.getName();
                        i++;
                    }

                    String seleccionado = (String) JOptionPane.showInputDialog(
                        null,
                        "Selecciona el tabaco a editar:",
                        "Editar Tobacco",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        nombresArray,
                        nombresArray[0]
                    );

                    Tobacco tabacoEditar = null;
                    if (seleccionado != null) {
                        for (Tobacco t : nombres) {
                            if (t.getName().equals(seleccionado)) {
                                tabacoEditar = t;
                                break;
                            }
                        }
                    }

                    if (tabacoEditar != null) {
                        JTextField nameTobacco = new JTextField(tabacoEditar.getName());
                        JTextField rankingTobacco = new JTextField(String.valueOf(tabacoEditar.getRanking()));
                        JTextField priceTobacco = new JTextField(String.valueOf(tabacoEditar.getPrice()));
                        JTextField sizeTobacco = new JTextField(String.valueOf(tabacoEditar.getNumberCigarretes()));

                        Object[] campos = {
                            "Nombre:", nameTobacco,
                            "Ranking (número):", rankingTobacco,
                            "Precio:", priceTobacco,
                            "Tamaño (cantidad de cigarrillos):", sizeTobacco
                        };

                        int result = JOptionPane.showConfirmDialog(null, campos, "Editar Tobacco", JOptionPane.OK_CANCEL_OPTION);

                        if (result == JOptionPane.OK_OPTION) {
                            try {
                                String nombreNuevo = nameTobacco.getText();
                                int rankingNuevo = Integer.parseInt(rankingTobacco.getText().trim());
                                float priceNuevo = Float.parseFloat(priceTobacco.getText().trim());
                                int sizeNuevo = Integer.parseInt(sizeTobacco.getText().trim());

                                tabacoEditar.setName(nombreNuevo);
                                tabacoEditar.setRanking(rankingNuevo);
                                tabacoEditar.setPrice(priceNuevo);
                                tabacoEditar.setNumberCigarretes(sizeNuevo);

                                JOptionPane.showMessageDialog(null, "Tabaco actualizado:\n" + tabacoEditar);
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Por favor, introduce valores numéricos válidos.");
                            }
                        }
                    }
                }
            }else if(selection == 2){
                if (nombres.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No hay elementos para mostrar.");
                    return;
                }

                StringBuilder sb = new StringBuilder();
                for (Tobacco e : nombres) {

                    sb.append("Nombre: ").append(e.getName()).append("\n");
                    sb.append("Ranking: ").append(e.getRanking()).append("\n");
                    sb.append("Precio: ").append(e.getPrice()).append("\n");
                    sb.append("Número de cigarrillos: ").append(e.getNumberCigarretes()).append("\n");
                    sb.append("----------------------------\n");
                }

                JOptionPane.showMessageDialog(null, sb.toString(), "Ranking de Elementos", JOptionPane.INFORMATION_MESSAGE);

            }else if(selection == 3){
                if (nombres.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No hay elementos para borrar.");
                } else {
                    String[] nombresArray = new String[nombres.size()];
                    int i = 0;
                    for (Tobacco t : nombres) {
                        nombresArray[i] = t.getName();
                        i++;
                    }

                    String seleccionado = (String) JOptionPane.showInputDialog(
                        null,
                        "Selecciona el tabaco a borrar:",
                        "Borrar Tobacco",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        nombresArray,
                        nombresArray[0]
                    );

                    Tobacco tabacoBorrar = null;
                    if (seleccionado != null) {
                        for (Tobacco t : nombres) {
                            if (t.getName().equals(seleccionado)) {
                                tabacoBorrar = t;
                                break;
                            }
                        }
                    }

                    if (tabacoBorrar != null) {
                        int result = JOptionPane.showConfirmDialog(null, tabacoBorrar, "Borrar Tobacco", JOptionPane.OK_CANCEL_OPTION);

                        if (result == JOptionPane.OK_OPTION) {
                            try {
                                for (Tobacco t : nombres) {
                                    if (tabacoBorrar != null && t.equals(tabacoBorrar)) {
                                        nombres.remove(nombres.indexOf(tabacoBorrar));
                                        JOptionPane.showMessageDialog(null, "Tabaco borrado.");
                                        break;
                                    }
                                }
                            } catch (ConcurrentModificationException e) {
                                JOptionPane.showMessageDialog(null, "Por favor, introduce valores numéricos válidos.");
                            }
                        }
                    }
                }
            }

            ask = JOptionPane.showConfirmDialog(null, "¿Quieres continuar?");
        } while (JOptionPane.OK_OPTION == ask);
    }
}

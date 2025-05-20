import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import net.salesianos.element.Tobacco;

public class App {
    public static void main(String[] args) throws Exception {
        String[] opciones = {
                "Add tobacco",
                "Modify tobacco",
                "Show tobaccos",
                "Delete tobacco",
                "Exit the program."
        };

        final List<Tobacco> nombres = new ArrayList<>();
        nombres.add(new Tobacco("Marlboro", 4, 5.2f, 20));
        nombres.add(new Tobacco("Lm", 4, 3.8f, 20));
        nombres.add(new Tobacco("Paramount", 1, 2.3f, 20));
        nombres.add(new Tobacco("Benson&Hedges 100s", 3, 3.2f, 20));
        nombres.add(new Tobacco("Corona", 2, 3.5f, 20));
        nombres.add(new Tobacco("Kruger", 0, 3f, 20));
        nombres.add(new Tobacco("Chesterfield 24s", 3, 3.8f, 24));

        int selection = 0;
        do {
            try {

                selection = JOptionPane.showOptionDialog(
                        null,
                        "Select an option:",
                        "Menu",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        opciones,
                        opciones[0]);

                if (selection == 0) {
                    JTextField nameTobacco = new JTextField();
                    JTextField rankingTobacco = new JTextField();
                    JTextField priceTobacco = new JTextField();
                    JTextField sizeTobacco = new JTextField();

                    Object[] campos = {
                            "Name: ", nameTobacco,
                            "Ranking (number): ", rankingTobacco,
                            "Price: ", priceTobacco,
                            "Size: ", sizeTobacco
                    };

                    int result = JOptionPane.showConfirmDialog(null, campos, "Add new Tobacco",
                            JOptionPane.OK_CANCEL_OPTION);

                    if (result == JOptionPane.OK_OPTION) {
                        try {
                            String nombre = nameTobacco.getText();
                            int ranking = Integer.parseInt(rankingTobacco.getText().trim());
                            float price = Float.parseFloat(priceTobacco.getText().trim());
                            int size = Integer.parseInt(sizeTobacco.getText().trim());

                            nombres.add(new Tobacco(nombre, ranking, price, size));
                            JOptionPane.showMessageDialog(null, "Tobacco added.");
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Please, introduce valid numbers.");
                        }
                    }
                }

                else if (selection == 1) {
                    if (nombres.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "There are not elements to modify..");
                    } else {
                        String[] nombresArray = new String[nombres.size()];
                        int i = 0;
                        for (Tobacco t : nombres) {
                            nombresArray[i] = t.getName();
                            i++;
                        }

                        String seleccionado = (String) JOptionPane.showInputDialog(
                                null,
                                "Select the tobacco to modify:",
                                "Modify tobacco",
                                JOptionPane.PLAIN_MESSAGE,
                                null,
                                nombresArray,
                                nombresArray[0]);

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
                                    "Name:", nameTobacco,
                                    "Ranking (número): ", rankingTobacco,
                                    "Price: ", priceTobacco,
                                    "Size:", sizeTobacco
                            };

                            int result = JOptionPane.showConfirmDialog(null, campos, "Modify tobacco.",
                                    JOptionPane.OK_CANCEL_OPTION);

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

                                    JOptionPane.showMessageDialog(null, "Tobacco updated:\n" + tabacoEditar);
                                } catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null,
                                            "Please, introduce valid numbers.");
                                }
                            }
                        }
                    }
                } else if (selection == 2) {
                    if (nombres.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "There are not elements to show.");
                        return;
                    }

                    StringBuilder sb = new StringBuilder();
                    for (Tobacco e : nombres) {

                        sb.append("Name: ").append(e.getName()).append("\n");
                        sb.append("Ranking: ").append(e.getRanking()).append("\n");
                        sb.append("Price: ").append(e.getPrice()).append("\n");
                        sb.append("Cigerretes: ").append(e.getNumberCigarretes()).append("\n");
                        sb.append("----------------------------\n");
                    }

                    JOptionPane.showMessageDialog(null, sb.toString(), "Ranking of elements",
                            JOptionPane.INFORMATION_MESSAGE);

                } else if (selection == 3) {
                    if (nombres.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "There are not elements to delete.");
                    } else {
                        String[] nombresArray = new String[nombres.size()];
                        int i = 0;
                        for (Tobacco t : nombres) {
                            nombresArray[i] = t.getName();
                            i++;
                        }

                        String seleccionado = (String) JOptionPane.showInputDialog(
                                null,
                                "Please select the tobacco to delete:",
                                "Delete tobacco",
                                JOptionPane.PLAIN_MESSAGE,
                                null,
                                nombresArray,
                                nombresArray[0]);

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
                            int result = JOptionPane.showConfirmDialog(null, tabacoBorrar, "Delete tobacco.",
                                    JOptionPane.OK_CANCEL_OPTION);

                            if (result == JOptionPane.OK_OPTION) {

                                for (Tobacco t : nombres) {
                                    if (tabacoBorrar != null && t.equals(tabacoBorrar)) {
                                        nombres.remove(nombres.indexOf(tabacoBorrar));
                                        JOptionPane.showMessageDialog(null, "Tobacco deleted.");
                                        break;
                                    }
                                }

                            }
                        }
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please, introduce valid numbers.");
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Canceled operation | Null");
            } catch (IndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "Index error: " + e.getMessage());
            } catch (ConcurrentModificationException e) {
                JOptionPane.showMessageDialog(null, "Cannot modify the list while you are indexing over.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Petó...: " + e.getMessage());
            }

        } while (selection != 4);
    }
}

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import net.salesianos.element.Tobacco;

public class App {
    public static void main(String[] args) throws Exception {     
        String[] opciones = { "Añadir elemento", "Editar elemento", "Mostrar elemento", "Eliminar elemento", "Salir del programa." };


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
            int seleccion = JOptionPane.showOptionDialog(
                null,
                "Elige una opción:",
                "Menú Principal",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opciones,
                opciones[4]
            );
        if (seleccion == 0) {
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
                    JOptionPane.showMessageDialog(null, "Tobacco añadido:\n");
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor, introduce valores numéricos válidos.");
                }
            }        
        }

        if (seleccion == 1) {
        int result = JOptionPane.showInputDialog(null, nombres, "Editar tobacco(elegir)", JOptionPane.OK_CANCEL_OPTION);
   
        }

        ask = JOptionPane.showConfirmDialog(null, "¿Quieres continuar?");
    } while (JOptionPane.OK_OPTION == ask);
        
}
}
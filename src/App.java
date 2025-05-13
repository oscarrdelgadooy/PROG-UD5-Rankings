import javax.swing.JOptionPane;

import net.salesianos.element.Tobacco;

public class App {
    public static void main(String[] args) throws Exception {        
        final Tobacco[] typesTobaccos = {
            new Tobacco("Marlboro", 4, 5.2f, 20),
            new Tobacco("Lm", 4, 3.8f, 20),
            new Tobacco("Paramount", 1, 2.3f, 20),
            new Tobacco("Benson&Hedges", 0, 0, 0)
        };

        int ask = JOptionPane.showConfirmDialog(null, "¿Quieres continuar?");
        do {

        } while (JOptionPane.OK_OPTION == ask);
    }
}

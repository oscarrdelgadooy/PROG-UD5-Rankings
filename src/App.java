import javax.swing.JOptionPane;

import net.salesianos.element.Tobacco;

public class App {
    public static void main(String[] args) throws Exception {        
        final Tobacco[] typesTobaccos = {
            new Tobacco("Marlboro", 4, 5.2f, 20),
            new Tobacco("Lm", 4, 3.8f, 20),
            new Tobacco("Paramount", 1, 2.3f, 20),
            new Tobacco("Benson&Hedges 100s", 3, 3.2f, 20),
            new Tobacco("Chesterfield 24s", 3, 3.8f, 24),
            new Tobacco("Kruger", 0, 3f, 20),
            new Tobacco("Corona", 2, 3.5f, 20)
        };

        int ask = JOptionPane.showConfirmDialog(null, "¿Quieres continuar?");
        do {

        } while (JOptionPane.OK_OPTION == ask);
    }
}

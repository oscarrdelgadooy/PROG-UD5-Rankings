import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import net.salesianos.element.Tobacco;

public class App {
    public static void main(String[] args) throws Exception {     
        
        final List<Tobacco> nombres = new ArrayList<>();
        nombres.add(new Tobacco("Marlboro", 4, 5.2f, 20));
        nombres.add(new Tobacco("Lm", 4, 3.8f, 20));
        nombres.add(new Tobacco("Paramount", 1, 2.3f, 20));
        nombres.add(new Tobacco("Benson&Hedges 100s", 3, 3.2f, 20));
        nombres.add(new Tobacco("Corona", 2, 3.5f, 20));
        nombres.add(new Tobacco("Kruger", 0, 3f, 20));
        nombres.add(new Tobacco("Chesterfield 24s", 3, 3.8f, 24));

        int ask = JOptionPane.showConfirmDialog(null, "¿Quieres continuar?");
        do {

        } while (JOptionPane.OK_OPTION == ask);
    }
}

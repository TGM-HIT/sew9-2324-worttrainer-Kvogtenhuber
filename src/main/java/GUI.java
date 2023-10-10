import java.awt.*;
import java.awt.image.*;
import java.net.MalformedURLException;
import java.util.ArrayList;
import javax.swing.*;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 * Worttrainer wird geladen und am Schluss gespeichert, alles überprüft und ausgegeben und angezeigt.
 */
public class GUI {
    public static void main(String[] arg) {
        //Paar p1 = new Paar("Wort", "https://www.cleverfiles.com/howto/wp-content/uploads/2018/03/minion.jpg");
        //Paar p2 = new Paar("WORT", "https://www.cleverfiles.com/howto/wp-content/uploads/2018/03/minion.jpg");
        ArrayList<Paar> list = new ArrayList<>();
        //list.add(p1);
        //list.add(p2);
        Worttrainer wt = new Worttrainer(list);
        //wt.laden();

        SuL laden = new Laden();
        wt = laden.sTrAtEgYpAtTeRn(wt);


        list = wt.getList();

        boolean weiter = true;

        String eingabe = "";
        while(weiter) {
            for (int i = 0; i < list.size(); i++) {
                ImageIcon icon = new ImageIcon(list.get(i).getBild());

                while (icon.getIconWidth() > 300 || icon.getIconHeight() > 300) {
                    Image image = icon.getImage(); // transform it
                    Image newimg = image.getScaledInstance((int) (icon.getIconWidth() / 1.5), (int) (icon.getIconHeight() / 1.5), java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
                    icon = new ImageIcon(newimg);  // transform it back
                }

                JLabel label = new JLabel(icon);


                eingabe = JOptionPane.showInputDialog(
                        null,
                        label,
                        "Worttrainer",
                        JOptionPane.PLAIN_MESSAGE
                );
                if (eingabe.equals("")) {
                    weiter = false;
                    break;
                }
                wt.addTry(list.get(i).checkWord(eingabe));
                if (list.get(i).checkWord(eingabe)) {
                    eingabe = "richtig!";
                } else {
                    eingabe = "falsch!";
                }
                JOptionPane.showMessageDialog(null, "Das war " + eingabe);
            }
        }
        JOptionPane.showMessageDialog(null,"Statistik: " + wt.getVersuche() + " Versuche, " + wt.getGeschafft() + " davon sind richtig.");
        //wt.speichern();

        SuL speichern = new Speichern();
        speichern.sTrAtEgYpAtTeRn(wt);
    }
}
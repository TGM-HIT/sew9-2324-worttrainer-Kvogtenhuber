import java.net.MalformedURLException;
import java.util.ArrayList;
import javax.swing.*;
import java.net.URL;
public class GUI {
    public static void main(String[] arg) throws MalformedURLException {
        //Paar p1 = new Paar("Wort", "https://www.cleverfiles.com/howto/wp-content/uploads/2018/03/minion.jpg");
        //Paar p2 = new Paar("WORT", "https://www.cleverfiles.com/howto/wp-content/uploads/2018/03/minion.jpg");
        ArrayList<Paar> list = new ArrayList<>();
        //list.add(p1);
        //list.add(p2);
        Worttrainer wt = new Worttrainer(list);
        wt.laden();
        list = wt.getList();

        String eingabe = "";
        for(int i=0; i<list.size();i++) {
            ImageIcon icon = new ImageIcon(list.get(i).getBild());

            JLabel label = new JLabel(icon);

            eingabe = JOptionPane.showInputDialog(
                    null,
                    label,
                    "Worttrainer",
                    JOptionPane.PLAIN_MESSAGE
            );
            wt.addTry(list.get(i).checkWord(eingabe));
        }
        JOptionPane.showMessageDialog(null,"Statistik: " + wt.getVersuche() + " Versuche, " + wt.getGeschafft() + " davon sind richtig.");
        wt.speichern();
    }
}
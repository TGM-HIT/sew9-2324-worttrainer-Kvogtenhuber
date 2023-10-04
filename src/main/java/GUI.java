import java.net.MalformedURLException;
import java.util.ArrayList;
import java.net.URL;
public class GUI {
    public static void main(String[] arg) throws MalformedURLException {
        Paar p1 = new Paar("Wort", new URL("https://www.cleverfiles.com/howto/wp-content/uploads/2018/03/minion.jpg"));
        Paar p2 = new Paar("WORT", new URL("https://www.cleverfiles.com/howto/wp-content/uploads/2018/03/minion.jpg"));
        ArrayList<Paar> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        Worttrainer wt = new Worttrainer(list);
        wt.speichern();
        System.out.println("JDJD");
    }
}

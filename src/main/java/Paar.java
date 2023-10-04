import java.net.URL;

public class Paar {
    private String wort;
    private URL bild;

    public Paar(String wort, URL bild){
        this.wort = wort;
        this.bild = bild;
    }

    public boolean checkWord(String wort){
        return this.wort.equals(wort);
    }
}

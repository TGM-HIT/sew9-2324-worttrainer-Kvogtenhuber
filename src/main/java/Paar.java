import javax.swing.*;
import java.io.Serializable;
import java.net.*;

/**
 * Paar Klasse.
 * Speichert ein Wort und eine URL dazu.
 */
public class Paar {
    private String wort;
    private URL bild;

    /**
     * Konstruktor
     */
    public Paar() {
    }

    /**
     * Konstruktor
     * @param wort das Wort
     * @param bild das Bild
     */
    public Paar(String wort, String bild){
        this.wort = wort;
        if(isURLValid(bild)) {
            try {
                this.bild = new URL(bild);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "ERROR FALSCHES URL BEI WORT: " + wort);
        }
    }

    /**
     * toString Methode
     * @return das Wort
     */
    @Override
    public String toString(){
        return this.wort;
    }

    /**
     * Getter Methode
     * @return wort
     */
    public String getWort(){
        return wort;
    }

    /**
     * Die URL wird zurückgegeben
     * @return die URL
     */
    public URL getBild(){
        return bild;
    }

    /**
     * Setter Methode für Wort
     * @param wort das Wort
     */
    public void setWort(String wort) {
        this.wort = wort;
    }

    /**
     * Setter Methode für Bild
     * @param bild das Bild
     */
    public void setBild(URL bild) {
        this.bild = bild;
    }

    /**
     * das eingegebene Wort wird verglichen
     * @param wort das eingegebene Wort
     * @return obs das selbe Wort ist oder nicht
     */
    public boolean checkWord(String wort){
        return this.wort.equals(wort);
    }

    /**
     * überprüft ob die URL valid ist
     * @param urlString die URL als String
     * @return obs valid ist
     */
    public static boolean isURLValid(String urlString) {
        try {
            URL urll = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) urll.openConnection();
            connection.setRequestMethod("HEAD"); // Use the HEAD method for a lightweight check
            int responseCode = connection.getResponseCode();
            return responseCode == HttpURLConnection.HTTP_OK;
        } catch (Exception e) {
            // URL is not valid or cannot be reached
            return false;
        }
    }
}

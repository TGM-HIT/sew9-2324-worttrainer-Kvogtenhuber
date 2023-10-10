import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.*;

/**
 * Das ist der Worttrainer
 */
public class Worttrainer{
    private ArrayList<Paar> paare;
    private int versuche;
    private int geschafft;

    /**
     * Konstruktor
     * @param paare die Paare
     */
    public Worttrainer(ArrayList<Paar> paare){
        this.paare = paare;
        versuche = 0;
    }

    /**
     * Zweiter Konstruktor
     */
    public Worttrainer(){
        this.paare = new ArrayList<>();
        versuche = 0;
    }

    /**
     * Versuche und wie viele davon richtig sind werden upgedated
     * @param geschafft obs richtig ist
     */
    public void addTry(boolean geschafft){
        versuche++;
        if(geschafft){
            this.geschafft++;
        }
    }

    /**
     * Getter Methode für die Liste
     * @return die Liste
     */
    @JsonIgnore
    public ArrayList<Paar> getList(){
        return paare;
    }

    /**
     * Getter Methode für die Anzahl der Versuche
     * @return die Anzahl der Versuche
     */
    public int getVersuche(){
        return this.versuche;
    }

    /**
     * Getter Methode für die Anzahl der richtigen Versuche
     * @return die Anzahl der richtigen Versuche
     */
    public int getGeschafft(){
        return this.geschafft;
    }

    /**
     * Speichert das Worttrainer Objekt
     * @return obs geschafft wurde
     */
    /*
    public boolean speichern() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);

        try {
            // Serialize and save the ArrayList to a JSON file
            objectMapper.writeValue(new File("worttrainer.json"), this);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    */
    /**
     * Ladet das Worttrainer Objekt
     * @return obs geschafft wurd
     */
    /*
    public boolean laden() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);

        try {
            // Deserialize and load the ArrayList from the JSON file
            Worttrainer wt = objectMapper.readValue(new File("worttrainer.json"), new TypeReference<Worttrainer>() {});
            ArrayList<Paar> loadedList = wt.getList();

            this.versuche = wt.getVersuche();
            this.geschafft = wt.getGeschafft();
            this.paare = loadedList;
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
     */
}


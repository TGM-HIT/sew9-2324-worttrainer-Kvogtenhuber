import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.*;

public class Worttrainer {
    private ArrayList<Paar> paare;
    private int versuche;
    private int geschafft;

    public Worttrainer(ArrayList<Paar> paare){
        this.paare = paare;
        versuche = 0;
    }

    public Worttrainer(){
        this.paare = new ArrayList<>();
        versuche = 0;
    }

    public void addTry(boolean geschafft){
        versuche++;
        if(geschafft){
            this.geschafft++;
        }
    }

    public int getVersuche(){
        return this.versuche;
    }

    public int getGeschafft(){
        return this.geschafft;
    }

    public boolean speichern() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);

        try {
            // Serialize and save the ArrayList to a JSON file
            objectMapper.writeValue(new File("arraylist.json"), paare);
            objectMapper.writeValue(new File("worttrainer.json"), this);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean laden() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);

        try {
            // Deserialize and load the ArrayList from the JSON file
            ArrayList<Paar> loadedList = objectMapper.readValue(new File("arraylist.json"), new TypeReference<ArrayList<Paar>>(){});
            Worttrainer wt = objectMapper.readValue(new File("worttrainer.json"), new TypeReference<Worttrainer>() {});
            this.versuche = wt.getVersuche();
            this.geschafft = wt.getGeschafft();
            // Use the loaded ArrayList
            for (Paar item : loadedList) {
                System.out.println(item);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}

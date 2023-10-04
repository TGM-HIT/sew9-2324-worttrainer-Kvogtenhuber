import org.apache.commons.configuration2.*;
import org.apache.commons.configuration2.builder.*;
import org.apache.commons.configuration2.builder.fluent.*;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

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

    public boolean speichern() {
        try {
            // Konfigurationsdatei erstellen oder laden
            Parameters params = new Parameters();
            File propertiesFile = new File("data.properties");

            // Erstellen Sie eine FileBasedConfiguration-Instanz für die Properties-Datei
            FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
                    new FileBasedConfigurationBuilder<>(FileBasedConfiguration.class)
                            .configure(params.fileBased()
                                    .setFile(propertiesFile));

            // Laden Sie die Konfiguration aus der Datei
            Configuration config = builder.getConfiguration();

            // Array erstellen und Daten hinzufügen
            config.setProperty("arraylist",paare);

            // Konfigurationsdatei speichern
            builder.save();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean laden() {
        try {
            // Konfigurationsdatei erstellen oder laden
            Parameters params = new Parameters();
            File propertiesFile = new File("data.properties");

            // Erstellen Sie eine FileBasedConfiguration-Instanz für die Properties-Datei
            FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
                    new FileBasedConfigurationBuilder<>(FileBasedConfiguration.class)
                            .configure(params.fileBased()
                                    .setFile(propertiesFile));

            // Laden Sie die Konfiguration aus der Datei
            Configuration config = builder.getConfiguration();

            ArrayList<Paar> loadedArrayList = new ArrayList<>(config.getList(Paar.class, "arraylist"));

            // Konfigurationsdatei speichern
            builder.save();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Laden implements SuL{
    @Override
    public Worttrainer sTrAtEgYpAtTeRn(Worttrainer wt2) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);

        try {
            // Deserialize and load the ArrayList from the JSON file
            Worttrainer wt = objectMapper.readValue(new File("worttrainer.json"), new TypeReference<Worttrainer>() {});
            ArrayList<Paar> loadedList = wt.getList();
            return wt;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public class Speichern implements SuL{
    @Override
    public Worttrainer sTrAtEgYpAtTeRn(Worttrainer wt) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        try {
            // Serialize and save the ArrayList to a JSON file
            objectMapper.writeValue(new File("worttrainer.json"), wt);
            return wt;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

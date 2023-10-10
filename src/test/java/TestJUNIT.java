import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testet alles
 */
public class TestJUNIT {
    @Test
    void check(){
        Worttrainer wt = new Worttrainer();
        SuL sp = new Speichern();
        SuL la = new Laden();
        assertNotNull(sp.sTrAtEgYpAtTeRn(wt), "Speichern hat nicht funktioniert");
        assertNotNull(la.sTrAtEgYpAtTeRn(wt), "Laden hat nicht funktioniert");
    }
}

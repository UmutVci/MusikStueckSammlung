import com.umutavci.MusikStueckSammlung;
import com.umutavci.Musikstueck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MusikStueckSammlungTest {
    private MusikStueckSammlung sammlung;

    @BeforeEach
    public void setUp(){
        sammlung = new MusikStueckSammlung();

        sammlung.musikStueckEinfügen(new Musikstueck("Shape of You", "Ed Sheeran", 240));
        sammlung.musikStueckEinfügen(new Musikstueck("Bohemian Rhapsody", "Queen", 354));
        sammlung.musikStueckEinfügen(new Musikstueck("Blinding Lights", "The Weeknd", 200));

    }

    @Test
    public void testMusikStueckeNachTitelSortierung() {
        List<Musikstueck> sortierteListe = sammlung.getAlleMusikStueckeNachTitel();

        assertEquals("Blinding Lights", sortierteListe.get(0).getTitel());
        assertEquals("Bohemian Rhapsody", sortierteListe.get(1).getTitel());
        assertEquals("Shape of You", sortierteListe.get(2).getTitel());
    }

    @Test
    public void testMusikStueckeNachLaengeSortierung() {
        List<Musikstueck> sortierteListe = sammlung.getAlleMusikStueckeNachLaenge();

        assertEquals(200, sortierteListe.get(0).getLaenge());
        assertEquals(240, sortierteListe.get(1).getLaenge());
        assertEquals(354, sortierteListe.get(2).getLaenge());
    }

    @Test
    public void testMusikStueckEinfügenMitDuplikat() {
        // Aynı başlığa sahip bir müzik parçası eklemeyi dene
        Musikstueck duplikat = new Musikstueck("Shape of You", "Ed Sheeran", 250);

        // Duplikat eklemenin hata fırlatıp fırlatmadığını kontrol et
        assertThrows(IllegalArgumentException.class, () -> sammlung.musikStueckEinfügen(duplikat));
    }

    @Test
    public void testMusikStueckEinfügenErfolgreich() {
        // Yeni bir müzik parçası ekle
        Musikstueck neuesStueck = new Musikstueck("Hello", "Adele", 295);
        sammlung.musikStueckEinfügen(neuesStueck);

        // Listeye başarılı şekilde eklenip eklenmediğini kontrol et
        List<Musikstueck> sortierteListe = sammlung.getAlleMusikStueckeNachTitel();
        assertTrue(sortierteListe.stream().anyMatch(stueck -> stueck.getTitel().equals("Hello")));
    }

}

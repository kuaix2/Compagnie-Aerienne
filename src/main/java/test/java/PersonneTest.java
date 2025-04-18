import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonneTest {

    Personne personne1 = new Personne(1, "BENARD", "ALLAN","59 rue belle","0304004050");
    Personne personne2 = new Personne(2, "Chuang","Shu-han","Paris","01 23 45 67 80");

    @Test
    @DisplayName("Obtenir le nom")
    public void testGetNom() {
        assertEquals("BENARD", personne1.getNom(), "Le nom doit être \"BENARD\"");
    }


    @Test
    @DisplayName("Définir l'adresse")
    public void testSetAdresse() {
        personne2.setAdresse("Chez Batman");
        assertEquals("Chez Batman", personne2.getAdresse(), "L'adresse doit être \"Chez Batman\"");
    }
}
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PassagerTest {
    @Test
    void constructeurEtAccesseurs() {
        Passager p = new Passager(1,"Chuang","Shu-han","Paris","01 23 45 67 80","Passport1111");
        assertEquals("Chuang", p.getNom());

    }
}

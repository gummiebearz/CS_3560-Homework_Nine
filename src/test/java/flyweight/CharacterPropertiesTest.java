package flyweight;

import org.junit.jupiter.api.Test; // Needed for @Test annotation

import static org.junit.jupiter.api.Assertions.assertEquals;

class CharacterPropertiesTest {
    @Test
    void gettersReturnConstructorValues() {
        CharacterProperties p = new CharacterProperties("Arial", 12, "Red");
        assertEquals("Arial", p.getFont());
        assertEquals(12, p.getSize());
        assertEquals("Red", p.getColor());
    }
}

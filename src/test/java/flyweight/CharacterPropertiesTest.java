package flyweight;

import main.flyweight.CharacterProperties;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CharacterPropertiesTest {
    void gettersReturnConstructorValues() {
        CharacterProperties p = new CharacterProperties("Arial", 12, "Red");
        assertEquals("Arial", p.getFont());
        assertEquals(12, p.getSize());
        assertEquals("Red", p.getColor());
    }
}

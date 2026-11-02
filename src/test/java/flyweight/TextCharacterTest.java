package flyweight;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TextCharacterTest {
    CharacterProperties arial = PropertiesFactory.getCharacterProperties("Arial", 12, "Red");
    TextCharacter c = new TextCharacter('H', arial);

    @Test
    void testGetValue() {
        assertEquals('H', c.getValue());
    }

    @Test
    void testGetFont() {
        assertEquals("Arial", c.getFont());
    }

    @Test
    void testGetSize() {
        assertEquals(12, c.getSize());
    }

    @Test
    void testGetColor() {
        assertEquals("Red", c.getColor());
    }

    @Test
    void testGetProperties() {
        assertSame(arial, c.getProperties());
    }

    @Test
    void testSetProperties() {
        CharacterProperties calibri = PropertiesFactory.getCharacterProperties("Calibri", 14, "Blue");

        c.setProperties(calibri);

        assertSame(calibri, c.getProperties());
    }
}

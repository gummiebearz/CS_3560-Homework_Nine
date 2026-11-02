package flyweight;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PropertiesFactoryTest {
    @Test
    void testGetCharacterProperties() {
        CharacterProperties p1 = PropertiesFactory.getCharacterProperties("Arial", 12, "Red");
        CharacterProperties p2 = PropertiesFactory.getCharacterProperties("Arial", 12, "Red");
        CharacterProperties p3 = PropertiesFactory.getCharacterProperties("Calibri", 14, "Blue");

        assertSame(p1, p2);     // same style is shared
        assertNotSame(p1, p3);  // different style is a different object
    }

    @Test
    void testGetPoolSize() {
        int before = PropertiesFactory.getPoolSize();

        PropertiesFactory.getCharacterProperties("PoolTestFont", 1, "Teal"); // new style

        assertEquals(before + 1, PropertiesFactory.getPoolSize());
    }
}

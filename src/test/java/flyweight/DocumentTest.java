package flyweight;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DocumentTest {
    Document doc;

    @BeforeEach
    void setUp() {
        doc = new Document();
        doc.addCharacter('H', "Arial", 12, "Red");
        doc.addCharacter('i', "Calibri", 14, "Blue");
    }

    @AfterEach
    void cleanUp() {
        new File("testDoc.txt").delete(); // remove the file made by save
    }

    @Test
    void testAddCharacter() {
        doc.addCharacter('!', "Verdana", 16, "Black");

        assertEquals("Hi!", doc.getText());
    }

    @Test
    void testGetText() {
        assertEquals("Hi", doc.getText());
    }

    @Test
    void testEditCharacterStyle() {
        doc.editCharacter(0, "Verdana", 16, "Black");

        assertEquals("Hi", doc.getText()); // text stays the same
    }

    @Test
    void testEditCharacterValueAndStyle() {
        doc.editCharacter(0, 'J', "Verdana", 16, "Black");

        assertEquals("Ji", doc.getText());
    }

    @Test
    void testDisplay() {
        assertDoesNotThrow(() -> doc.display());
    }

    @Test
    void testSave() {
        doc.save("testDoc");

        assertTrue(new File("testDoc.txt").exists());
    }

    @Test
    void testLoad() {
        doc.save("testDoc");

        Document loaded = new Document();
        loaded.load("testDoc");

        assertEquals("Hi", loaded.getText());
    }
}

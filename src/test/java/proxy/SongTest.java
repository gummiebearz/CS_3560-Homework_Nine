package proxy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SongTest {
    Song song = new Song(1, "Perfect", "Ed Sheeran", "Divide", 263);

    @Test
    void testGetId() {
        assertEquals(1, song.getId());
    }

    @Test
    void testGetTitle() {
        assertEquals("Perfect", song.getTitle());
    }

    @Test
    void testGetArtist() {
        assertEquals("Ed Sheeran", song.getArtist());
    }

    @Test
    void testGetAlbum() {
        assertEquals("Divide", song.getAlbum());
    }

    @Test
    void testGetDuration() {
        assertEquals(263, song.getDuration());
    }

    @Test
    void testToString() {
        assertEquals("1: Perfect by Ed Sheeran [Divide, 263s]", song.toString());
    }
}

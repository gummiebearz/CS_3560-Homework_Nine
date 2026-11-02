package proxy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RealSongServiceTest {
    RealSongService service;

    @BeforeEach
    void setUp() {
        service = new RealSongService();
        service.addSong(new Song(1, "Shape of You", "Ed Sheeran", "Divide", 234));
        service.addSong(new Song(2, "Perfect", "Ed Sheeran", "Divide", 263));
    }

    @Test
    void testAddSong() {
        service.addSong(new Song(3, "Home", "Michael Buble", "Call Me Irresponsible", 226));

        assertEquals("Home", service.searchById(3).getTitle());
    }

    @Test
    void testSearchById() {
        assertEquals("Perfect", service.searchById(2).getTitle());
    }

    @Test
    void testSearchByTitle() {
        List<Song> songs = service.searchByTitle("Perfect");

        assertEquals(1, songs.size());
    }

    @Test
    void testSearchByAlbum() {
        List<Song> songs = service.searchByAlbum("Divide");

        assertEquals(2, songs.size());
    }
}

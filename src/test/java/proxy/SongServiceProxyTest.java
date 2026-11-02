package proxy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SongServiceProxyTest {
    SongServiceProxy proxy;

    @BeforeEach
    void setUp() {
        RealSongService real = new RealSongService();
        real.addSong(new Song(1, "Shape of You", "Ed Sheeran", "Divide", 234));
        real.addSong(new Song(2, "Perfect", "Ed Sheeran", "Divide", 263));
        proxy = new SongServiceProxy(real);
    }

    @Test
    void testSearchById() {
        long start = System.currentTimeMillis();
        Song first = proxy.searchById(1);
        long firstTime = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        Song second = proxy.searchById(1);
        long secondTime = System.currentTimeMillis() - start;

        assertEquals("Shape of You", first.getTitle());
        assertEquals(first, second);
        assertTrue(secondTime < firstTime); // cached call is faster
    }

    @Test
    void testSearchByTitle() {
        long start = System.currentTimeMillis();
        List<Song> first = proxy.searchByTitle("Perfect");
        long firstTime = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        List<Song> second = proxy.searchByTitle("Perfect");
        long secondTime = System.currentTimeMillis() - start;

        assertEquals(1, first.size());
        assertEquals(first, second);
        assertTrue(secondTime < firstTime);
    }

    @Test
    void testSearchByAlbum() {
        long start = System.currentTimeMillis();
        List<Song> first = proxy.searchByAlbum("Divide");
        long firstTime = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        List<Song> second = proxy.searchByAlbum("Divide");
        long secondTime = System.currentTimeMillis() - start;

        assertEquals(2, first.size());
        assertEquals(first, second);
        assertTrue(secondTime < firstTime);
    }
}

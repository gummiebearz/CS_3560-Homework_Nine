package main.proxy;

import java.util.List;

public class Tester {
    public static void main(String[] args) {
        // Add songs to the list before the main.main.proxy is initialized
        RealSongService realService = new RealSongService();
        realService.addSong(new Song(1, "Shape of You", "Ed Sheeran", "Divide", 234));
        realService.addSong(new Song(2, "Perfect", "Ed Sheeran", "Divide", 263));
        realService.addSong(new Song(3, "Blinding Lights", "The Weeknd", "After Hours", 200));
        realService.addSong(new Song(4, "Levitating", "Dua Lipa", "Future Nostalgia", 203));
        realService.addSong(new Song(5, "Home", "Michael Buble", "Call Me Irresponsible", 226));

        // Initialize main.main.proxy
        SongService proxy = new SongServiceProxy(realService);

        // Each song is searched twice:
        // 1st round is slow (not in cache),
        // 2nd round is cached
        for (int round = 1; round <= 2; round++) {
            System.out.println(">>> ROUND " + round + " <<<");

            for (int id = 1; id <= 5; id++) {
                long start = System.currentTimeMillis();
                Song song = proxy.searchById(id);
                System.out.println("searchById(" + id + "): " + (System.currentTimeMillis() - start) + " ms");

                printSong(song);

                System.out.println("---------------------------------");

                start = System.currentTimeMillis();
                List<Song> titleResults = proxy.searchByTitle(song.getTitle());
                System.out.println("searchByTitle(" + song.getTitle() + "): " + (System.currentTimeMillis() - start) + " ms");

                for(Song titledSong : titleResults) {
                    printSong(titledSong);
                }

                System.out.println("---------------------------------");

                start = System.currentTimeMillis();
                List<Song> albumResults = proxy.searchByAlbum(song.getAlbum());
                System.out.println("searchByAlbum(" + song.getAlbum() + "): " + (System.currentTimeMillis() - start) + " ms");

                for(Song albumSong : albumResults) {
                    printSong(albumSong);
                }

                System.out.println("---------------------------------");
            }

            System.out.println();
        }
    }

    public static void printSong(Song s) {
        System.out.println("> Song details:");
        System.out.println("[ID]: " + s.getId());
        System.out.println("[Title]: " + s.getTitle());
        System.out.println("[Artist]: " + s.getArtist());
        System.out.println("[Album]: " + s.getAlbum());
        System.out.println();
    }
}
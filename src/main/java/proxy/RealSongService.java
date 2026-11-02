package proxy;

import java.util.ArrayList;
import java.util.List;

public class RealSongService implements SongService {
    private final List<Song> songs;

    public RealSongService() {
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }

    @Override
    public Song searchById(Integer songID) {
        try {
            // Add 1s delay for each call
            Thread.sleep(1000);

            for(Song song : songs) {
                if(song.getId() == songID) {
                    return song;
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Thread error: " + e.getMessage());
        }

        return null;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        List<Song> matchedTitleSongs = new ArrayList<>();
        try {
            // Add 1s delay for each call
            Thread.sleep(1000);

            for(Song song : songs) {
                if(song.getTitle().equals(title)) {
                    matchedTitleSongs.add(song);
                }
            }

            return matchedTitleSongs;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Thread error: " + e.getMessage());
        }

        return matchedTitleSongs;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        List<Song> matchedAlbumSongs = new ArrayList<>();

        try {
            // Add 1s delay for each call
            Thread.sleep(1000);

            for(Song song : songs) {
                if(song.getAlbum().equals(album)) {
                    matchedAlbumSongs.add(song);
                }
            }

            return matchedAlbumSongs;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Thread error: " + e.getMessage());
        }

        return matchedAlbumSongs;
    }
}

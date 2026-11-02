package proxy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SongServiceProxy implements SongService {
    private final SongService realService;

    private final Map<Integer, Song> idCache;
    private final Map<String, List<Song>> titleCache;
    private final Map<String, List<Song>> albumCache;

    public SongServiceProxy(SongService realService) {
        this.realService = realService;

        this.idCache = new HashMap<>();
        this.titleCache = new HashMap<>();
        this.albumCache = new HashMap<>();
    }

    @Override
    public Song searchById(Integer songId) {
        if(idCache.containsKey(songId)) {
            return idCache.get(songId);
        }

        Song song = realService.searchById(songId);
        idCache.put(songId, song);

        return song;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        if(titleCache.containsKey(title)) {
            return titleCache.get(title);
        }

        List<Song> songs = realService.searchByTitle(title);
        titleCache.put(title, songs);

        return songs;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        if(albumCache.containsKey(album)) {
            return albumCache.get(album);
        }

        List<Song> songs = realService.searchByAlbum(album);
        albumCache.put(album, songs);

        return songs;
    }
}
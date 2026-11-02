package main.proxy;

public class Song {
    private final int id;
    private final String title;
    private final String artist;
    private final String album;
    private final int duration; // in seconds

    public Song(int id, String title, String artist, String album, int duration) {
        this.id = id;
        this.title = title;
        this.album = album;
        this.artist = artist;
        this.duration = duration;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getArtist() {
        return this.artist;
    }

    public String getAlbum() {
        return this.album;
    }

    public int getDuration() {
        return this.duration;
    }

    @Override
    public String toString() {
        return id + ": " + title + " by " + artist + " [" + album + ", " + duration + "s]";
    }
}

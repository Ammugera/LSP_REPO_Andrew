package org.howard.edu.lsp.midterm.question5;

/**
 * This class represent music media type
 */
public class Music implements Streamable {
    private String title;

    /**
     * Constructor to set the music title
     * @param title the title of the music track
     */
    public Music(String title) {
        this.title = title;
    }

    /**
     * Plays the music
     */
    @Override
    public void play() {
        System.out.println("Playing music: " + title);
    }

    /**
     * Pauses the music
     */
    @Override
    public void pause() {
        System.out.println("Paused music: " + title);
    }

    /**
     * Stops the music
     */
    @Override
    public void stop() {
        System.out.println("Stopped music: " + title);
    }

    /**
     * Adds the music to a playlist
     * @param playlistName the name of the playlist
     */
    public void addToPlaylist(String playlistName) {
        System.out.println("Added " + title + " to " + playlistName + " playlist");
    }
}

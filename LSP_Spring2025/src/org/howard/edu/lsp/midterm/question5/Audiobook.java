package org.howard.edu.lsp.midterm.question5;

/**
 * This class represent an audiobook
 */
public class Audiobook implements Streamable {
    private String title;

    /**
     * Constructor to set the audiobook title
     * @param title the title of the audiobook
     */
    public Audiobook(String title) {
        this.title = title;
    }

    /**
     * Plays the audiobook
     */
    @Override
    public void play() {
        System.out.println("Playing audiobook: " + title);
    }

    /**
     * Pauses the audiobook
     */
    @Override
    public void pause() {
        System.out.println("Paused audiobook: " + title);
    }

    /**
     * Stops the audiobook
     */
    @Override
    public void stop() {
        System.out.println("Stopped audiobook: " + title);
    }

    /**
     * Sets the playback speed for the audiobook
     * @param speed the new playback speed
     */
    public void setPlaybackSpeed(double speed) {
        System.out.println("Setting playback speed of audiobook: " + title + " to " + speed + "x");
    }
}
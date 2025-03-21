package org.howard.edu.lsp.midterm.question5;

/**
 * This class represent a movie
 */
public class Movie implements Streamable {
    private String title;

    /**
     * Constructor to set the movie title
     * @param title the title of the movie
     */
    public Movie(String title) {
        this.title = title;
    }

    /**
     * Plays the movie
     */
    @Override
    public void play() {
        System.out.println("Playing movie: " + title);
    }

    /**
     * Pauses the movie
     */
    @Override
    public void pause() {
        System.out.println("Paused movie: " + title);
    }

    /**
     * Stops the movie
     */
    @Override
    public void stop() {
        System.out.println("Stopped movie: " + title);
    }

    /**
     * Rewinds the movie by given seconds/minutes (integer value)
     * @param seconds the number of seconds to rewind
     */
    public void rewind(int seconds) {
        System.out.println("Rewinding movie: " + title + " by " + seconds + " minutes");
    }
}

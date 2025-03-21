package org.howard.edu.lsp.midterm.question5;

/**
 * A driver class to demonstrate the media streaming service.
 */
public class StreamingServiceDriver {
    /**
     * Main method to run the streaming service demo.
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        // Create instances of different media types
        Streamable music = new Music("Still a Friend - Incognito");
        Streamable movie = new Movie("Avengers End Game");
        Streamable audiobook = new Audiobook("A Promised Land – Barack Obama");

        // Test common behaviours for all media types
        System.out.println("Testing common behaviours for all media types:\n");

        // Test Music
        System.out.println("Testing Music:");
        music.play();
        music.pause();
        music.stop();
        System.out.println();

        // Test Movie
        System.out.println("Testing Movie:");
        movie.play();
        movie.pause();
        movie.stop();
        System.out.println();

        // Test Audiobook
        System.out.println("Testing Audiobook:");
        audiobook.play();
        audiobook.pause();
        audiobook.stop();
        System.out.println();

        // Test unique behaviours for each media type
        // Movie specific behaviour: rewind
        Movie movieWithRewind = (Movie) movie;
        movieWithRewind.rewind(30);
        System.out.println();

        // Audiobook specific behaviour: setPlaybackSpeed
        Audiobook audiobookWithSpeed = (Audiobook) audiobook;
        audiobookWithSpeed.setPlaybackSpeed(1.5);
        System.out.println();

        // Music specific behaviour: addToPlaylist
        Music musicWithPlaylist = (Music) music;
        musicWithPlaylist.addToPlaylist("Favorites");
        System.out.println();
    }
}

package org.howard.edu.lsp.midterm.question2;

/**
 * A driver class to test the Book class.
 */
public class BookDriver {
    /**
     * Main method to run tests for Book.
     * @param args command line args.
     */
    public static void main(String[] args) {
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "123456789", 1925);
        Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "123456789", 1925);
        Book book3 = new Book("A Promised Land", "Barack Obama", "9780593239681", 2020);

        // test the equals method
        System.out.println(book1.equals(book2)); // should print true
        System.out.println(book1.equals(book3)); // should print false

        // test the toString method
        System.out.println(book1); // Expected output: Title: The Great Gatsby, Author: F. Scott Fitzgerald, ISBN: 123456789, Year Published: 1925
    }
}
package org.howard.edu.lsp.midterm.question2;

/**
 * Represents a book in the libary.
 * This class store details like title, author, ISBN and the year published.
 */
public class Book {
    private String title;
    private String author;
    private String ISBN;
    private int yearPublished;

    /**
     * Constructor to create a new Book.
     * @param title the title of the book
     * @param author the author of the book
     * @param ISBN the ISBN number of the book
     * @param yearPublished the year the book was published
     */
    public Book(String title, String author, String ISBN, int yearPublished) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.yearPublished = yearPublished;
    }

    /**
     * gets the title of the book.
     * @return the book title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * sets the title of the book.
     * @param title the new title.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * gets the author of the book.
     * @return the book author.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * sets the author of the book.
     * @param author the new author.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * gets the ISBN of the book.
     * @return the book ISBN.
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * sets the ISBN of the book.
     * @param ISBN the new ISBN.
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * gets the year the book was published.
     * @return the published year.
     */
    public int getYearPublished() {
        return yearPublished;
    }

    /**
     * sets the year the book was published.
     * @param yearPublished the new published year.
     */
    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    /**
     * overrides equals to compare two books based on ISBN and author.
     * @param obj the object to compare with.
     * @return true if the books are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        return this.ISBN.equals(other.ISBN) && this.author.equals(other.author);
    }

    /**
     * returns a string representation of the book.
     * @return a string description of the book.
     */
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + ISBN + ", Year Published: " + yearPublished;
    }
}
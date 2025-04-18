package org.howard.edu.lsp.assignment6;

/** To be thrown when largest()/smallest() are called on an empty set */
public class IntegerSetException extends Exception {
    public IntegerSetException(String message) {
        super(message);
    }
}
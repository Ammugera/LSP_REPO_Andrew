package org.howard.edu.lsp.lspfinal.question2;

/**
 * Exception thrown when a task cannot be found
 */
public class TaskNotFoundException extends Exception {
    public TaskNotFoundException(String message) {
        super(message);
    }
}

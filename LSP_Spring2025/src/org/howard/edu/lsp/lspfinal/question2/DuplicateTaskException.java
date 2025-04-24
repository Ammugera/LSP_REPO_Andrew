package org.howard.edu.lsp.lspfinal.question2;

/**
 * checked exception thrown when a task name already exists
 */
public class DuplicateTaskException extends Exception {
    public DuplicateTaskException(String message) {
        super(message);
    }
}

package org.howard.edu.lsp.lspfinal.question2;

/**
 * Enumeration of allowed task statuses
 */
public enum Status {
    TODO, IN_PROGRESS, DONE;

    /**
     * Convert a string from the user to a Status
     *
     * @param value raw status text
     * @return matching Status constant
     * @throws IllegalArgumentException if the text is not one of the three values
     */
    public static Status fromString(String value) {
        return Status.valueOf(value.trim().toUpperCase());
    }
}

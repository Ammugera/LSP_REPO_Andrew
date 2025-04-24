package org.howard.edu.lsp.lspfinal.question3;

public abstract class AbstractReport {

    /** Template method that defines the full report workflow. */
    public final void generateReport() {
        loadData();
        formatData();
        printReport();
    }
    
    /** loads data */
    protected abstract void loadData();
    /** formats data*/
    protected abstract void formatData();
    /**prints final report*/
    protected abstract void printReport();
}

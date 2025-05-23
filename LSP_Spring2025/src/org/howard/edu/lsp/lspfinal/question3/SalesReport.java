package org.howard.edu.lsp.lspfinal.question3;

/** Report for the Sales department */
public class SalesReport extends AbstractReport {

    @Override
    protected void loadData() {
        System.out.println("Loading sales data...");
    }

    @Override
    protected void formatData() {
        System.out.println("Formatting sales data...");
    }

    @Override
    protected void printReport() {
        System.out.println("Printing sales report.\n");
    }
}

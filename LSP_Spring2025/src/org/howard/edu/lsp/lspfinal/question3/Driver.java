package org.howard.edu.lsp.lspfinal.question3;


public class Driver {
    public static void main(String[] args) {
        AbstractReport salesReport     = new SalesReport();
        AbstractReport inventoryReport = new InventoryReport();

        salesReport.generateReport();
        inventoryReport.generateReport();
    }
}

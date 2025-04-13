package org.howard.edu.lsp.assignment5;

/**
 * The driver class for testing the IntegerSet implementation.
 */
public class Driver {
    /**
     * The main method that tests the IntegerSet operations.
     * 
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        
        IntegerSet set1 = new IntegerSet();
        set1.add(10);
        set1.add(20);
        set1.add(30);
        System.out.println("Value of Set 1: " + set1.toString());
        System.out.println("Smallest value in Set 1: " + set1.smallest());
        System.out.println("Largest vqlue in Set 1: " + set1.largest());
        
        
        IntegerSet set2 = new IntegerSet();
        set2.add(30);
        set2.add(40);
        set2.add(50);
        System.out.println("Value of Set 2: " + set2.toString());
        
        
        System.out.println("Performing union of Set A and Set B:");
        set1.union(set2);
        System.out.println("Result after union, Set 1: " + set1.toString());
    }
}
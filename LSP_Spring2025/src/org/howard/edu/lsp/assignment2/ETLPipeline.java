package org.howard.edu.lsp.assignment2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ETLPipeline {

    // main method to run the etl process
    public static void main(String[] args) {
        // define file paths (input & output) relative to project root
        String inputFilePath = "data/products.csv";
        String outputFilePath = "data/transformed_products.csv";
        
        // call the etl process function
        processETL(inputFilePath, outputFilePath);
    }
    
    // this function extracts data from the input file, transforms it, and loads it to the output file
    private static void processETL(String inputFile, String outputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
             
            // read header line and ignore it because we dont process headers
            String headerLine = reader.readLine(); // just skip the header
            // write new header with extra column for price range
            writer.write("ProductID,Name,Price,Category,PriceRange");
            writer.newLine();
            
            String line;
            // process each record from the input file line-by-line
            while ((line = reader.readLine()) != null) {
                // split csv line using comma as delimiter
                String[] fields = line.split(",");
                
                // if there are not enough fields, skip this record (wtf, this line is bad)
                if (fields.length < 4) {
                    continue;
                }
                
                // extract each field and trim whitespace
                String productId = fields[0].trim();
                String name = fields[1].trim();
                double price = Double.parseDouble(fields[2].trim());
                String category = fields[3].trim();
                
                // convert product name to uppercase as required
                name = name.toUpperCase(); // converting name to upper case
                
                // if the product is in electronics, apply discount and adjust category if needed
                if (category.equalsIgnoreCase("Electronics")) {
                    price = price * 0.9; // applying a 10% discount
                    price = round(price, 2); // rounding price to two decimal places
                    
                    // if discounted price is greater than 500 then update category
                    if (price > 500) {
                        category = "Premium Electronics";
                    }
                }
                
                // determine the price range based on the updated price value
                String priceRange = determinePriceRange(price);
                
                // build the output record string in csv format
                String outputLine = productId + "," + name + "," + price + "," + category + "," + priceRange;
                writer.write(outputLine);
                writer.newLine();  // move to next line in output file
            }
            
            // if we reach here, etl is complete
            System.out.println("etl process completed and output written to " + outputFile);
            
        } catch (IOException e) {
            // error while reading or writing files, so display a message
            System.err.println("error: unable to read or write file. pls check file path and permissions.");
        }
    }
    
    // this helper function rounds a double value to the specified number of decimal places
    private static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException("places must be non-negative"); // error check here
        }
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    
    // this function determines the price range based on price value
    private static String determinePriceRange(double price) {
        // low range: $0 - $10
        if (price >= 0 && price <= 10) {
            return "Low";
        }
        // medium range: $10.01 - $100
        else if (price > 10 && price <= 100) {
            return "Medium";
        }
        // high range: $100.01 - $500
        else if (price > 100 && price <= 500) {
            return "High";
        }
        // premium range: $500.01 and above
        else {
            return "Premium";
        }
    }
}
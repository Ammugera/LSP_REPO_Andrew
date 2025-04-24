package org.howard.edu.lsp.lspfinal.question1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    /* 
     * Adding items 
     */

    @Test
    @DisplayName("Testing adding valid item")
    void addValidItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Book", 25.0);
        assertEquals(1, cart.getItemCount());
    }

    @Test
    @DisplayName("Testing adding item with 0 price (expect exception)")
    void addZeroPrice() {
        ShoppingCart cart = new ShoppingCart();
        assertThrows(IllegalArgumentException.class,
                     () -> cart.addItem("Gift", 0.0));
    }

    @Test
    @DisplayName("Testing adding item with negative price (expect exception)")
    void addNegativePrice() {
        ShoppingCart cart = new ShoppingCart();
        assertThrows(IllegalArgumentException.class,
                     () -> cart.addItem("Gift", -5.0));
    }

    @Test
    @DisplayName("Testing adding item with empty name (expect exception)")
    void addEmptyName() {
        ShoppingCart cart = new ShoppingCart();
        assertThrows(IllegalArgumentException.class,
                     () -> cart.addItem("", 10.0));
    }

    /*
     * Removing items 
     */

    @Test
    @DisplayName("Testing removing existing item")
    void removeExistingItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Pen", 2.0);
        assertTrue(cart.removeItem("Pen"));
        assertEquals(0, cart.getItemCount());
    }

    @Test
    @DisplayName("Testing removing non-existent item")
    void removeNonexistentItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Pencil", 1.0);
        assertFalse(cart.removeItem("Eraser"));
        assertEquals(1, cart.getItemCount());
    }
    
    /*
     * Cart size update 
     */

    @Test
    @DisplayName("Test cart size after add/remove")
    void cartSizeAddRemove() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("A", 1.0);
        cart.addItem("B", 2.0);
        assertEquals(2, cart.getItemCount());   // after two adds
        cart.removeItem("A");
        assertEquals(1, cart.getItemCount());   // after one remove
    }

    /* 
     * Total cost
     */

    @Test
    @DisplayName("Testing total cost without discount")
    void totalNoDiscount() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Shoes", 40.0);
        cart.addItem("Socks", 10.0);
        assertEquals(50.0, cart.getTotalCost(), 1e-6);
    }

    @Test
    @DisplayName("Testing total cost with discount")
    void totalWithDiscount() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Jacket", 100.0);
        cart.applyDiscountCode("SAVE10");
        assertEquals(90.0, cart.getTotalCost(), 1e-6);
    }

    @Test
    @DisplayName("Testing total cost with empty cart")
    void totalEmptyCart() {
        ShoppingCart cart = new ShoppingCart();
        assertEquals(0.0, cart.getTotalCost(), 1e-6);
    }

    /* 
     * Discount codes
     */

    @Test
    @DisplayName("Testing applying \"SAVE10\"")
    void applySave10() {
        ShoppingCart cart = new ShoppingCart();
        cart.applyDiscountCode("SAVE10");
        assertEquals(10.0, cart.getDiscountPercentage(), 1e-6);
    }

    @Test
    @DisplayName("Testing applying \"SAVE20\"")
    void applySave20() {
        ShoppingCart cart = new ShoppingCart();
        cart.applyDiscountCode("SAVE20");
        assertEquals(20.0, cart.getDiscountPercentage(), 1e-6);
    }

    @Test
    @DisplayName("Testing applying invalid code (expect exception)")
    void applyInvalidCode() {
        ShoppingCart cart = new ShoppingCart();
        assertThrows(IllegalArgumentException.class,
                     () -> cart.applyDiscountCode("SAVE50"));
    }
}
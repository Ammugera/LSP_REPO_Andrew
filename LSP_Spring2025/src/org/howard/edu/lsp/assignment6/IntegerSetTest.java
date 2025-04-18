package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

@DisplayName("IntegerSet Test Suite")
public class IntegerSetTest {

    private IntegerSet set1;
    private IntegerSet set2;

    @BeforeEach
    void init() {
        set1 = new IntegerSet();
        set2 = new IntegerSet();
    }

    @Test
    @DisplayName("clear() makes set empty")
    void testClearAndIsEmpty() {
        set1.add(1);
        set1.clear();
        assertTrue(set1.isEmpty());
    }

    @Test
    @DisplayName("length() returns correct size")
    void testLength() {
        assertEquals(0, set1.length());
        set1.add(5);
        assertEquals(1, set1.length());
    }

    @Test
    @DisplayName("add() inserts unique items; contains() reflects membership")
    void testAddAndContains() {
        set1.add(3);
        assertTrue(set1.contains(3));
        set1.add(3);
        assertEquals(1, set1.length());
    }

    @Test
    @DisplayName("remove() deletes existing items")
    void testRemove() {
        set1.add(4);
        set1.remove(4);
        assertFalse(set1.contains(4));
    }

    @Test
    @DisplayName("equals() identifies equal sets in any order")
    void testEquals() {
        set1.add(1); set1.add(2);
        set2.add(2); set2.add(1);
        assertTrue(set1.equals(set2));
        set2.add(3);
        assertFalse(set1.equals(set2));
    }

    @Test
    @DisplayName("largest() and smallest() on non‑empty set")
    void testLargestAndSmallest() throws IntegerSetException {
        set1.add(10); set1.add(-5); set1.add(3);
        assertEquals(10, set1.largest());
        assertEquals(-5, set1.smallest());
    }

    @Test
    @DisplayName("largest() throws when empty")
    void testLargestException() {
        assertThrows(IntegerSetException.class, () -> set1.largest());
    }

    @Test
    @DisplayName("smallest() throws when empty")
    void testSmallestException() {
        assertThrows(IntegerSetException.class, () -> set1.smallest());
    }

    @Test
    @DisplayName("union() merges all unique elements")
    void testUnion() {
        set1.add(1); set1.add(2);
        set2.add(2); set2.add(3);
        set1.union(set2);
        assertAll(
            () -> assertTrue(set1.contains(1)),
            () -> assertTrue(set1.contains(2)),
            () -> assertTrue(set1.contains(3)),
            () -> assertEquals(3, set1.length())
        );
    }

    @Test
    @DisplayName("intersect() keeps only common elements")
    void testIntersect() {
        set1.add(1); set1.add(2);
        set2.add(2); set2.add(3);
        set1.intersect(set2);
        assertEquals(1, set1.length());
        assertTrue(set1.contains(2));
    }

    @Test
    @DisplayName("diff() removes elements present in other set")
    void testDiff() {
        set1.add(1); set1.add(2); set1.add(3);
        set2.add(2);
        set1.diff(set2);
        assertAll(
            () -> assertFalse(set1.contains(2)),
            () -> assertTrue(set1.contains(1)),
            () -> assertTrue(set1.contains(3)),
            () -> assertEquals(2, set1.length())
        );
    }

    @Test
    @DisplayName("complement() yields elements in this set but not in the argument")
    void testComplement() {
        set1.add(1); set1.add(2);
        set2.add(2); set2.add(3);
        set1.complement(set2);
        assertAll(
            () -> assertTrue(set1.contains(1)),
            () -> assertFalse(set1.contains(2)),
            () -> assertFalse(set1.contains(3))
        );
    }

    @Test
    @DisplayName("toString() shows all elements")
    void testToString() {
        set1.add(5); set1.add(1);
        String s = set1.toString();
        assertTrue(s.contains("1") && s.contains("5"));
    }
}
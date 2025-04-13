package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a set of unique integers and provides common set operations.
 */
public class IntegerSet {
    // underlying list storing the integer values
    private List<Integer> values;

    /**
     * Constructs an empty IntegerSet.
     */
    public IntegerSet() {
        values = new ArrayList<>();
    }

    /**
     * Constructs an IntegerSet from an existing list of integers.
     * 
     * @param initial the initial list of integers.
     */
    public IntegerSet(ArrayList<Integer> initial) {
        values = new ArrayList<>(initial);
    }

    /**
     * Clears all elements from the set.
     */
    public void clear() {
        values.clear();
    }

    /**
     * Returns the number of elements in the set.
     * 
     * @return the size of the set.
     */
    public int length() {
        return values.size();
    }

    /**
     * Compares this set with another object for equality.
     * Two sets are considered equal if they contain the same elements irrespective of order.
     * 
     * @param other the object to compare with.
     * @return true if both sets contain the same elements, false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (other == null || getClass() != other.getClass())
            return false;
        IntegerSet compared = (IntegerSet) other;
        if (this.length() != compared.length())
            return false;
        for (Integer num : values) {
            if (!compared.values.contains(num))
                return false;
        }
        return true;
    }

    /**
     * Checks if a value is present in the set.
     * 
     * @param value the integer to search for.
     * @return true if the set contains the value, false otherwise.
     */
    public boolean contains(int value) {
        return values.contains(value);
    }

    /**
     * Returns the largest integer in the set.
     * 
     * @return the largest integer.
     * @throws RuntimeException if the set is empty.
     */
    public int largest() {
        if (isEmpty())
            throw new RuntimeException("Set is empty.");
        return Collections.max(values);
    }

    /**
     * Returns the smallest integer in the set.
     * 
     * @return the smallest integer.
     * @throws RuntimeException if the set is empty.
     */
    public int smallest() {
        if (isEmpty())
            throw new RuntimeException("Set is empty.");
        return Collections.min(values);
    }

    /**
     * Adds an integer to the set if it is not already present.
     * 
     * @param number the integer to add.
     */
    public void add(int number) {
        if (!contains(number))
            values.add(number);
    }

    /**
     * Removes an integer from the set if it is present.
     * 
     * @param number the integer to remove.
     */
    public void remove(int number) {
        values.remove((Integer) number);
    }

    /**
     * Performs the union of this set with another set.
     * 
     * @param otherSet the other IntegerSet.
     */
    public void union(IntegerSet otherSet) {
        for (int num : otherSet.values) {
            if (!contains(num))
                add(num);
        }
    }

    /**
     * Updates this set to contain only the elements that are present in both sets.
     * 
     * @param otherSet the other IntegerSet.
     */
    public void intersect(IntegerSet otherSet) {
        ArrayList<Integer> common = new ArrayList<>();
        for (int num : values) {
            if (otherSet.contains(num))
                common.add(num);
        }
        values = common;
    }

    /**
     * Updates this set to remove elements that are present in the other set (set difference: this minus otherSet).
     * 
     * @param otherSet the other IntegerSet.
     */
    public void diff(IntegerSet otherSet) {
        ArrayList<Integer> difference = new ArrayList<>();
        for (int num : values) {
            if (!otherSet.contains(num))
                difference.add(num);
        }
        values = difference;
    }

    /**
     * Updates this set to be the complement of itself with respect to the other set.
     * This means it will contain elements from the other set that are not present in this set.
     * 
     * @param otherSet the other IntegerSet representing the universal set.
     */
    public void complement(IntegerSet otherSet) {
        ArrayList<Integer> complementSet = new ArrayList<>();
        for (int num : otherSet.values) {
            if (!contains(num))
                complementSet.add(num);
        }
        values = complementSet;
    }

    /**
     * Returns true if the set contains no elements.
     * 
     * @return true if the set is empty, false otherwise.
     */
    public boolean isEmpty() {
        return values.isEmpty();
    }

    /**
     * Returns a string representation of the set.
     * 
     * @return a string that represents the set.
     */
    @Override
    public String toString() {
        return values.toString();
    }
}
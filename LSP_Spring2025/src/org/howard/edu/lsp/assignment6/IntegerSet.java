package org.howard.edu.lsp.assignment6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a set of unique integers and provides common set operations.
 */
public class IntegerSet {
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
     * Two sets are equal if they contain the same elements (order doesn’t matter).
     *
     * @param other the object to compare with.
     * @return true if both are IntegerSets with identical contents.
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        IntegerSet that = (IntegerSet) other;
        if (this.length() != that.length()) return false;
        for (Integer n : values) {
            if (!that.values.contains(n)) return false;
        }
        return true;
    }

    /**
     * Checks if a value is present in the set.
     *
     * @param value the integer to search for.
     * @return true if the set contains the value.
     */
    public boolean contains(int value) {
        return values.contains(value);
    }

    /**
     * Returns the largest integer in the set.
     *
     * @return the largest integer.
     * @throws IntegerSetException if the set is empty.
     */
    public int largest() throws IntegerSetException {
        if (isEmpty()) {
            throw new IntegerSetException("Set is empty.");
        }
        return Collections.max(values);
    }

    /**
     * Returns the smallest integer in the set.
     *
     * @return the smallest integer.
     * @throws IntegerSetException if the set is empty.
     */
    public int smallest() throws IntegerSetException {
        if (isEmpty()) {
            throw new IntegerSetException("Set is empty.");
        }
        return Collections.min(values);
    }

    /**
     * Adds an integer to the set if it is not already present.
     *
     * @param number the integer to add.
     */
    public void add(int number) {
        if (!contains(number)) {
            values.add(number);
        }
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
        for (int n : otherSet.values) {
            if (!contains(n)) {
                values.add(n);
            }
        }
    }

    /**
     * Updates this set to contain only the elements present in both sets.
     *
     * @param otherSet the other IntegerSet.
     */
    public void intersect(IntegerSet otherSet) {
        List<Integer> common = new ArrayList<>();
        for (int n : values) {
            if (otherSet.contains(n)) {
                common.add(n);
            }
        }
        values = common;
    }

    /**
     * Updates this set to remove elements that are present in the other set
     * (set difference: this minus otherSet).
     *
     * @param otherSet the other IntegerSet.
     */
    public void diff(IntegerSet otherSet) {
        List<Integer> difference = new ArrayList<>();
        for (int n : values) {
            if (!otherSet.contains(n)) {
                difference.add(n);
            }
        }
        values = difference;
    }

    /**
     * Updates this set to keep only those elements of this set
     * that are not in the argument set (complement relative to the argument).
     *
     * @param otherSet the IntegerSet to compare against.
     */
    public void complement(IntegerSet otherSet) {
        List<Integer> result = new ArrayList<>();
        for (int n : values) {
            if (!otherSet.contains(n)) {
                result.add(n);
            }
        }
        values = result;
    }

    /**
     * Returns true if the set contains no elements.
     *
     * @return true if empty.
     */
    public boolean isEmpty() {
        return values.isEmpty();
    }

    /**
     * Returns a string representation of the set.
     *
     * @return the set as a string.
     */
    @Override
    public String toString() {
        return values.toString();
    }
}
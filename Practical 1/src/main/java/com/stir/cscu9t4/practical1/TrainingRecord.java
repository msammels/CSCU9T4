package com.stir.cscu9t4.practical1;

import java.util.*;

/**
 * <p>
 *     <b><u>CSCU9T4 - Practical 1</u></b>
 *     <br />
 *     <b><u>TrainingRecord.java</u></b>
 * </p>
 * <p>
 *     An implementation of a Training Record as an ArrayList
 * </p>
 *
 * @author Michael Sammels
 * @version 01.02.2021
 */

public class TrainingRecord {
    private final List<Entry> tr;

    public TrainingRecord() {
        tr = new ArrayList<Entry>();
    } // Constructor

    // Add a record to the list
    public void addEntry(Entry e) {
        tr.add(e);
    } // addEntry

    // Look up the entry of a given day and month
    public String lookupEntry (int d, int m, int y) {
        ListIterator<Entry> iter = tr.listIterator();
        String result = "No entries found";

        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getDay() == d && current.getMonth() == m && current.getYear() == y)
                result = current.getEntry();
        }

        return result;
    } // lookupEntry

    // Count the number of entries
    public int getNumberOfEntries() {
        return tr.size();
    } // getNumberOfEntries

    // Clear all entries
    public void clearAllEntries() {
        tr.clear();
    } // clearAllEntries

    public String findAllEntries(int d, int m, int y) {
        ListIterator<Entry> iter = tr.listIterator();
        ArrayList<String> results = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getDay() == d && current.getMonth() == m && current.getYear() == y)
                results.add(current.getEntry());
        }

        for (var i : results) {
            result.append(i);
        }

        if(results.isEmpty()) {
            result = new StringBuilder("Error: No entries for entered date");
        }

        return result.toString();
    } // findAllEntries
} // TrainingRecord
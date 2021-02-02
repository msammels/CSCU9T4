package com.stir.cscu9t4.practical1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * <p>
 *     <b><u>CSCU9T4 - Practical 1</u></b>
 *     <br />
 *     <b><u>TrainingRecordGUI.java</u></b>
 * </p>
 * <p>
 *     GUI and main program for the Training Record
 * </p>
 *
 * @author Michael Sammels
 * @version 01.02.2021
 */

public class TrainingRecordGUI extends JFrame implements ActionListener {
    private final JTextField name = new JTextField(30);
    private final JTextField day = new JTextField(2);
    private final JTextField month = new JTextField(2);
    private final JTextField year = new JTextField(4);
    private final JTextField hours = new JTextField(2);
    private final JTextField mins = new JTextField(2);
    private final JTextField secs = new JTextField(2);
    private final JTextField dist = new JTextField(4);
    private final JButton addR = new JButton("Add");
    private final JButton lookUpByDate = new JButton("Look Up");
    private final JButton findAllByDate = new JButton ("Find All By Date");

    private final TrainingRecord myAthletes = new TrainingRecord();

    private final JTextArea outputArea = new JTextArea(5, 50);

    public static void main(String[] args) {
        new TrainingRecordGUI();
    } // main

    // Set up the GUI
    public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout());

        JLabel labn = new JLabel(" Name:");
        add(labn);
        add(name);
        name.setEditable(true);

        JLabel labd = new JLabel(" Day:");
        add(labd);
        add(day);
        day.setEditable(true);

        JLabel labm = new JLabel(" Month:");
        add(labm);
        add(month);
        month.setEditable(true);

        JLabel laby = new JLabel(" Year:");
        add(laby);
        add(year);
        year.setEditable(true);

        JLabel labh = new JLabel(" Hours:");
        add(labh);
        add(hours);
        hours.setEditable(true);

        JLabel labmm = new JLabel(" Mins:");
        add(labmm);
        add(mins);
        mins.setEditable(true);

        JLabel labs = new JLabel(" Secs:");
        add(labs);
        add(secs);
        secs.setEditable(true);

        JLabel labdist = new JLabel(" Distance (km):");
        add(labdist);
        add(dist);
        dist.setEditable(true);

        add(addR);
        addR.addActionListener(this);

        add(lookUpByDate);
        lookUpByDate.addActionListener(this);

        add(findAllByDate);
        findAllByDate.addActionListener(this);

        add(outputArea);
        outputArea.setEditable(false);

        setSize(720, 200);
        setVisible(true);
        blankDisplay();
    } // Constructor

    // Listen for and respond to GUI events
    public void actionPerformed(ActionEvent event) {
        String message = "";
        if (event.getSource() == addR) {
            message = addEntry("generic");
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        }
        if (event.getSource() == findAllByDate){
            message = findAllByDate();
        }
        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed

    public String addEntry(String what) {
        String message = "Record added\n";
        System.out.println("Adding " + what + " entry to the records");

        if(name.getText().trim().equals("")){
            return "Please add name.";
        }

        String n = name.getText();

        if (isInteger(month.getText())){
            return "Please enter the month as digits";
        }
        int m = Integer.parseInt(month.getText());

        if (isInteger(day.getText())){
            return "Please enter the day as digits";
        }
        int d = Integer.parseInt(day.getText());

        if (isInteger(year.getText())){
            return "Please enter the year as digits";
        }
        int y = Integer.parseInt(year.getText());

        float km = java.lang.Float.parseFloat(dist.getText());

        if (isInteger(hours.getText())){
            return "Please enter the hours as digits";
        }
        int h = Integer.parseInt(hours.getText());

        if (isInteger(mins.getText())){
            return "Please enter the minutes as digits";
        }
        int mm = Integer.parseInt(mins.getText());

        if (isInteger(secs.getText())){
            return "Please enter the seconds as digits";
        }
        int s = Integer.parseInt(secs.getText());

        Entry e = new Entry(n, d, m, y, h, mm, s, km);
        myAthletes.addEntry(e);
        return message;
    } // addEntry

    public String lookupEntry() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());

        outputArea.setText("looking up record ...");

        return myAthletes.lookupEntry(d, m, y);
    } // lookupEntry

    public void blankDisplay() {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");

    } // blankDisplay

    // Fills the input fields on the display for testing purposes only
    public void fillDisplay(Entry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
    } // fillDisplay

    public String findAllByDate(){
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());

        outputArea.setText("looking up record ...");

        return myAthletes.findAllEntries(d, m, y);
    }

    public static boolean isInteger(String str) {
        if (str == null) {
            return true;
        }

        int length = str.length();
        if (length == 0) {
            return true;
        }

        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return true;
            }
            i = 1;
        }

        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return true;
            }
        }
        return false;
    } // isInteger
} // TrainingRecordGUI

package com.stir.cscu9t4.practical2;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 *     <b><u>CSCU9T4 - Practical 2</u></b>
 *     <br />
 *     <b><u>FormatNames.java</u></b>
 * </p>
 * <p>
 *     Strings and files exercise
 * </p>
 *
 * @author Michael Sammels
 * @version 11.02.2021
 */

public class FormatNames {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyy");
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");

        File inputFile;             // The file we are reading in
        PrintWriter outputFile;     // The file we are writing to

        String formattedData = "";  // The formatted data for the file we are writing to
        String fileContent;
        String dateFormatter;
        String nameFormatter;
        String upperCaseArg = "-u";
        String htmlArg = "-h";

        Date date;
        Scanner inFile;

        if (args.length == 0) {
            System.err.println("Usage: FormatNames [-u] [-h] inputfile.txt outputfile.txt");
            System.exit(0);
        }

        try {
            // Grab the filename
            if (args[0].equalsIgnoreCase(upperCaseArg) || args[0].equalsIgnoreCase(htmlArg)) {
                inputFile = new File(args[args.length - 2]);
            } else if (args[1].equalsIgnoreCase(htmlArg) || args[1].equalsIgnoreCase(upperCaseArg)) {
                inputFile = new File(args[args.length - 2]); // Gets the name of the file and supplies it as a path
            } else {
                inputFile = new File(args[0]);
            }

            inFile = new Scanner(inputFile); // Read the file

            while (inFile.hasNextLine()) {
                // We have to store the value of each line
                fileContent = inFile.nextLine();

                // Here we are only storing the numbers (with the intention of parsing separately)
                dateFormatter = fileContent.replaceAll("[^0-9]", "");
                date = simpleDateFormat.parse(dateFormatter); // Parse the numbers into dates

                // Same as above, except for names
                nameFormatter = fileContent.replaceAll("[^a-zA-Z]", " ");

                // Middle initial
                nameFormatter = nameFormatter.replaceAll("\\s([^\\s])\\s", " $1. ");

                // Names and data are grouped together, for easy output
                formattedData = formattedData.concat(nameFormatter + "\t")
                        .concat(simpleDateFormat1.format(date) + "\n");
            }
        } catch (IOException | ParseException ex) {
            System.err.println("IOException: " + ex.getMessage() + " (input)");
        }

        try {
            // Grab the filename
            if (args[0].equalsIgnoreCase(upperCaseArg) || args[1].equalsIgnoreCase(upperCaseArg)) {
                outputFile = new PrintWriter(args[args.length - 1]);
                // Format the letters to be in UPPERCASE and then write the data to the specified file
                System.out.printf("%S\n", formattedData);
                outputFile.format("%S", formattedData);
            } else {
                outputFile = new PrintWriter(args[args.length - 1]);
                // Format the letters to be in Title Case and then write the data to the specified file
                System.out.print(toTitleCase(formattedData));
                outputFile.format(toTitleCase(formattedData));
            }

            // Parse to HTML
            if (args[0].equalsIgnoreCase(htmlArg) || args[1].equalsIgnoreCase(htmlArg)) {
                outputFile = new PrintWriter("output.html");
                if (args[0].equalsIgnoreCase(upperCaseArg) || args[1].equalsIgnoreCase(upperCaseArg)) {
                    System.out.printf("%S\n", formattedData);

                    outputFile.append(
                            "<html>" +
                                    "   <head>" +
                                    "       <title>Output</title>" +
                                    "   </head>" +
                                    "   <body>" +
                                    "       <p>" + String.format("%S\n", (formattedData)
                                    .replaceAll("(\r\n|\r|\n|\n\r)", "<br /><br />")) + "</p>" +
                                    "   </body>" +
                                    "</html>");
                } else {
                    System.out.print(toTitleCase(formattedData));

                    outputFile.append(
                            "<html>" +
                                    "   <head>" +
                                    "       <title>Output</title>" +
                                    "   </head>" +
                                    "   <body>" +
                                    "       <p>" + toTitleCase(formattedData)
                                    .replaceAll("(\r\n|\r|\n|\n\r)", "<br /><br />") + "</p>" +
                                    "   </body>" +
                                    "</html>");
                }
            }

            outputFile.close();
        } catch (FileNotFoundException ex) {
            System.err.println("FileNotFoundException: " + ex.getMessage() + " (output)");
        }
    } // main

    public static String toTitleCase(String text) {
        char[] chars = text.toLowerCase().toCharArray();
        boolean found = false;

        for (int i = 0; i < chars.length; i++) {
            if (!found && Character.isLetter(chars[i])) {
                chars[i] = Character.toUpperCase(chars[i]);
                found = true;
            } else if (Character.isWhitespace(chars[i]) || chars[i] == '.' || chars[i] == '\'') {
                found = false;
            }
        }

        return String.valueOf(chars);
    } // toTitleCase
} // FormatNames
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csculminating.gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import javax.swing.JFileChooser;

/**
 * Class to import and parse graph data from a CSV file.
 * Assumes the CSV has a header row, then data rows with 7 columns:
 * time, pos1, vel1, acc1, pos2, vel2, acc2
 * 
 * Stores the data in arrays for each variable, and also
 * groups them into a 2D array graphData for easy access.
 * 
 * @author CaGid4274
 */
public class ImportFile {
   
    // 2D array holding all data arrays together

    /**
     *
     */
    public double[][] graphData;
    
    // Separate arrays for each column of data

    /**
     *
     */
    public double[] time;

    /**
     *
     */
    public double[] pos1;

    /**
     *
     */
    public double[] pos2;

    /**
     *
     */
    public double[] vel1;

    /**
     *
     */
    public double[] vel2;

    /**
     *
     */
    public double[] acc1;

    /**
     *
     */
    public double[] acc2;
    
    // File Name
    public String fileName;
    /**
     *
     */
    public double[][] data;
    
    /**
     * Constructor that takes a File and attempts to parse the CSV data within.
     * @param file The CSV file to read data from
     */
    public ImportFile(File file)
    {
        findFile(file);  // Calls the method to read and parse the file
        fileName = file.getName();
    }

    /**
     * Reads the CSV file line by line and parses data into arrays.
     * Expects a header line to be skipped, then rows with 7 numeric columns.
     * @param file The CSV file to process
     */
    private void findFile(File file) {
        if (file == null) return;  // Do nothing if file is null

        // List to temporarily hold each row of doubles as an array
        List<double[]> dataList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            // Skip the header line (assumes first line is header)
            reader.readLine();

            // Read each subsequent line until EOF
            while ((line = reader.readLine()) != null) {
                // Split line by commas into string array
                String[] row = line.split(",");

                // Convert string values to doubles and store in a double array
                double[] doubleRow = new double[row.length];
                for (int i = 0; i < row.length; i++) {
                    doubleRow[i] = Double.parseDouble(row[i].trim());
                }
                // Add the row of doubles to the list
                dataList.add(doubleRow);
            }

            // Number of data rows read
            int numRows = dataList.size();

            // Initialize arrays to hold each column of data
            time = new double[numRows];
            pos1 = new double[numRows];
            vel1 = new double[numRows];
            acc1 = new double[numRows];
            pos2 = new double[numRows];
            vel2 = new double[numRows];
            acc2 = new double[numRows];

            // Extract columns from the list and fill the arrays
            for (int i = 0; i < numRows; i++) {
                double[] row = dataList.get(i);
                time[i] = row[0];   // time column
                pos1[i] = row[1];   // position of object 1
                vel1[i] = row[2];   // velocity of object 1
                acc1[i] = row[3];   // acceleration of object 1
                pos2[i] = row[4];   // position of object 2
                vel2[i] = row[5];   // velocity of object 2
                acc2[i] = row[6];   // acceleration of object 2
            }

            // Group all arrays into a 2D array for easier access
            graphData = new double[][] { time, pos1, vel1, acc1, pos2, vel2, acc2 };

        } catch (Exception e) {
            e.printStackTrace();  // Print any errors during file reading/parsing
        }
    }
}
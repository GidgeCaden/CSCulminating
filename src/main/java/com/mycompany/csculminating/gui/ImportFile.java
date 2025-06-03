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
 *
 * @author CaGid4274
 */
public class ImportFile {
   
    public double[][] graphData;
    
    
    public static void findFile(){
    
    JFileChooser fileChooser = new JFileChooser();

        int response = fileChooser.showOpenDialog(null); // select the file to open

        if (response == JFileChooser.APPROVE_OPTION) {
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());

            String csvFile = file.getAbsolutePath();
            BufferedReader reader = null;
            String line = "";

            List<double[]> dataList = new ArrayList<>();

            try {
                reader = new BufferedReader(new FileReader(csvFile));
                while ((line = reader.readLine()) != null) {
                    String[] row = line.split(",");

                    double[] doubleRow = new double[row.length];
                    for (int i = 0; i < row.length; i++) {
                        doubleRow[i] = Double.parseDouble(row[i].trim());
                    }

                    dataList.add(doubleRow);
                }

                // Convert to 2D array
                double[][] dataArray = new double[dataList.size()][];
                for (int i = 0; i < dataList.size(); i++) {
                    dataArray[i] = dataList.get(i);
                }

                // Optional: print the 2D array to verify
                for (double[] row : dataArray) {
                    for (double val : row) {
                        System.out.printf("%-10.2f", val);
                    }
                    System.out.println();
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (reader != null) reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

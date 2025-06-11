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
    
    public double[] time;
    public double[] pos1;
    public double[] pos2;
    public double[] vel1;
    public double[] vel2;
    public double[] acc1;
    public double[] acc2;
    
    public double[][] data;
    
    public ImportFile(File file)
    {
        findFile(file);
    }

    private void findFile(File file) {
        if (file == null) return;

        List<double[]> dataList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            // Skip header if necessary
            reader.readLine(); // assumes header row

            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                double[] doubleRow = new double[row.length];
                for (int i = 0; i < row.length; i++) {
                    doubleRow[i] = Double.parseDouble(row[i].trim());
                }
                dataList.add(doubleRow);
            }

            int numRows = dataList.size();
            time = new double[numRows];
            pos1 = new double[numRows];
            vel1 = new double[numRows];
            acc1 = new double[numRows];
            pos2 = new double[numRows];
            vel2 = new double[numRows];
            acc2 = new double[numRows];

            for (int i = 0; i < numRows; i++) {
                double[] row = dataList.get(i);
                time[i] = row[0];
                pos1[i] = row[1];
                vel1[i] = row[2];
                acc1[i] = row[3];
                pos2[i] = row[4];
                vel2[i] = row[5];
                acc2[i] = row[6];
            }

            graphData = new double[][] { time, pos1, vel1, acc1, pos2, vel2, acc2 };

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csculminating.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import javax.swing.JPanel;

/**
 *
 * @author CoBra1341
 */
public class GraphPanel extends JPanel{
    //Instatitates the Necessary Varibles 
    //3D Array Storing Multimple Graphs (Each With x and y Arrays)
    private double[][][] data;
    //Panel Dimensions
    private double panelWidth;
    private double panelHeight;
    //Axis Names
    private String xAxis;
    private String yAxis;
    //Scaling
    //Max X and Y Values For Scaling
    private double[] maxValues;
    private double xScale;
    private double yScale;
    //Padding Around the Graph
    private static final int  padding = 40;
    private static final int  graphOffSetX = 20;
    
    /* 
    * Creates a Graph Panel Object
    * @param data 3D Array Where Each 2D Array Represents a Graph's x and y Data
    * @param panel The Container Panel (Used to Get Initial Width/Height)
    */
    public GraphPanel(double[][][] data, JPanel panel)
    {
        this.data = data;
        //Set Layout and Background Color
        panel.setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        //Store Panel Size
        this.panelWidth = panel.getWidth();
        this.panelHeight = panel.getHeight();
        //Calculate Scaling For Each Graph (Note: Currently Only Uses the First Data Set)
        calculateScales(0);
        /*for(int i = 0; i < data.length; i++)
        {
            calculateScales(0);
        }*/
        
    }
    
    //Paints the Graph
    /*
    * Called Automatically When the Panel Needs to be Redrawn
    * Draws all Graphs in the Dataset Using Unique Colors
    */
    @Override
    protected void paintComponent(Graphics g)
    {
        //Cast to Graphics2D For Better Rendering
        Graphics2D g2 = (Graphics2D) g;
        //Calls the Superclass to Ensure Proper Rendering
        super.paintComponent(g);
        //Creates an AffineTransform Object
        AffineTransform original = g2.getTransform();
        //Draws Each Graph in the Data Array
        for(int k = 0; k < data.length; k++)
        {
            //Draws Connected Lines Between all the Points in the Graph
            for(int i = 1; i < data[k][0].length; i++)
            {      
                //Sets a Distinct Color for Each Graph Based on the Data's Index
                g2.setColor(Color.getHSBColor((float) k / data.length, 1.0f, 1.0f));
                g2.draw(new Line2D.Double((data[k][0][i-1] * xScale) + padding + graphOffSetX, ((panelHeight - data[k][1][i - 1]) * yScale) + padding, (data[k][0][i] * xScale) + padding + graphOffSetX, ((panelHeight - data[k][1][i]) * yScale) + padding));
            }
        }
        //Draws the x and y Axis Text
        //Draw x-Axis Ticks and Labels
        int xTicks = 10;
        for (int i = 0; i <= xTicks; i++) {
            double xVal = i * maxValues[0] / xTicks;
            g2.setColor(Color.BLACK);
            g2.drawLine((int)(xVal * xScale + padding + graphOffSetX), (int)(panelHeight - padding), (int)(xVal * xScale + padding + graphOffSetX), (int)(panelHeight - padding + 5));
            g2.drawString(String.format("%.1f", xVal), (int)(xVal * xScale + padding) - 10 + graphOffSetX, (int)(panelHeight - padding + 20));
        }

        //Draw y-Axis Ticks and Labels
        int yTicks = 10;
        for (int i = 0; i <= yTicks; i++) {
            double yVal = i * maxValues[1] / yTicks;
            g2.setColor(Color.BLACK);
            g2.drawLine(padding - 5 + graphOffSetX, (int)((panelHeight - padding) - yVal * yScale), padding + graphOffSetX, (int)((panelHeight - padding) - yVal * yScale));
            g2.drawString(String.format("%.1f", yVal), padding - 35 + graphOffSetX - 5, (int)((panelHeight - padding) - yVal * yScale) + 5);
        }
        //Sets the Text Color and Font
        g2.setColor(Color.BLACK);
        g2.setFont(new Font("SansSerif", Font.BOLD, 12));
        //Draw "Graph Title" Label Centered Under the Graph
        g2.drawString("Graph Title", (int)(panelWidth / 2) - 40, 20);
        //Draw "X Axis" Label Centered Under the Graph
        g2.drawString("X Axis", (int)(panelWidth / 2) - 20, (int)(panelHeight - 5));
        //Draw "Y Axis" Label Rotated Vertically on the Left
        g2.rotate(-Math.PI / 2);
        g2.drawString("Y Axis", (int)(-panelHeight / 2) - 20, 15);
        g2.setTransform(original); // Reset rotation
    }
    
    //Finds the Max Value of the X-Axis and Y-Axis
    /*
    * Finds the Maximum x and y Values in a 2D Dataset
    * Used for Scaling the Graph
    * @param data A Single 2D Dataset: data[0] = x-values, data[1] = y-values
    * @return xyValues An Array with Max x at Index 0 and Max y at Index 1
    */
    private double[] getMaxValues(double[][] data)
    {
        double[] xyValues = new double[2];
        double tempMaxX = data[0][0];
        double tempMaxY = data[1][0];
        for(int i = 0; i < data[0].length; i++)
        {
            if(data[0][i] > tempMaxX)
            {
                tempMaxX = data[0][i];
            }
            if(data[1][i] > tempMaxY)
            {
                tempMaxY = data[1][i];
            }
        }
        xyValues[0] += tempMaxX;
        xyValues[1] += tempMaxY;
        return xyValues;
    }
    
    /*
    * Calculates the Scaling Factors Based on a Given Graph's Max x and y values
    * @param array2D An Index of the 2D Graph data to use for Scale Calculation
    */
    private void calculateScales(int array2D)
    {
        this.maxValues = getMaxValues(data[array2D]);
        this.xScale = (panelWidth - 2 * padding) / maxValues[0];
        this.yScale = (panelHeight - 2 * padding) / maxValues[1];
    }
}
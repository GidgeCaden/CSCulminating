/*
 * GraphPanel.java
 * A custom JPanel used for rendering 2D graphs from multiple datasets.
 * Each graph uses the same x-values but can have multiple corresponding y-values.
 */

package com.mycompany.csculminating.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.io.File;
import javax.swing.JPanel;

/**
 * GraphPanel is a JPanel that draws multiple line graphs based on a shared x-axis dataset.
 * Each graph is drawn in a unique color, with axis ticks, labels, and a legend.
 * 
 * Assumes data[0] contains the x-values, and data[1], data[2], ... contain the corresponding y-values.
 * 
 * Author: CoBra1341
 */
public class GraphPanel extends JPanel {

    // Dataset: data[0] = x-values, data[1+] = various y-values
    private double[][] data;
    //File Used
    private ImportFile importedData;

    // Panel dimensions
    private static double panelWidth;
    private double panelHeight;

    // Axis labels (not fully implemented, placeholders)
    private String xAxis;
    private String yAxis;

    // Maximum values for scaling [maxX, maxY, minX, minY]
    private double[] maxValues;

    // Scaling factors to convert data units to pixels
    private double xScale;
    private double yScale;

    // Graph padding and offset
    private static final int padding = 40;
    private static final int graphOffSetX = 20;

    /**
     * Constructs a GraphPanel with the specified data.
     *
     * @param importedData An imported file that is turned into a 2D array: first array is x-values, subsequent arrays are y-values
     * @param panel The parent panel for determining width/height
     */
    public GraphPanel(ImportFile importedData, JPanel panel) {
        this.importedData = importedData;
        this.data = importedData.graphData;

        // Set layout and appearance
        panel.setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // Store dimensions for scaling and drawing
        this.panelWidth = panel.getWidth();
        this.panelHeight = panel.getHeight();

        // Calculate scaling based on the dataset
        calculateScales(this.data);
    }

    /**
     * Called automatically to redraw the panel.
     * Handles the drawing of graph lines, axes, ticks, and legend.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Cast to Graphics2D for advanced rendering features
        Graphics2D g2 = (Graphics2D) g;

        // Center line for y = 0
        double zeroY = panelHeight / 2.0;

        // Draw each graph line in a unique color
        for (int k = 1; k < data.length; k++) {
            for (int i = 1; i < data[0].length; i++) {
                g2.setColor(Color.getHSBColor((float) k / data.length, 1.0f, 1.0f));
                g2.draw(new Line2D.Double(
                    (data[0][i - 1] - maxValues[2]) * xScale + padding + graphOffSetX,
                    zeroY - data[k][i - 1] * yScale,
                    (data[0][i] - maxValues[2]) * xScale + padding + graphOffSetX,
                    zeroY - data[k][i] * yScale
                ));
            }
        }

        // Draw x-axis ticks and labels
        int xTicks = 10;
        for (int i = 0; i <= xTicks; i++) {
            double xVal = maxValues[2] + i * (maxValues[0] - maxValues[2]) / xTicks;
            int xPixel = (int)((xVal - maxValues[2]) * xScale + padding + graphOffSetX);
            g2.setColor(Color.BLACK);
            g2.drawLine(xPixel, (int)(panelHeight - padding), xPixel, (int)(panelHeight - padding + 5));
            g2.drawString(String.format("%.1f", xVal), xPixel - 10, (int)(panelHeight - padding + 20));
        }

        // Draw y-axis ticks and labels
        int yTicks = 10;
        for (int i = -yTicks / 2; i <= yTicks / 2; i++) {
            double yVal = i * (maxValues[1] / (yTicks / 2));
            int yPixel = (int) (zeroY - yVal * yScale);
            g2.drawLine(padding - 5 + graphOffSetX, yPixel, padding + graphOffSetX, yPixel);
            g2.drawString(String.format("%.1f", yVal), padding - 40 + graphOffSetX, yPixel + 5);
        }

        // Draw title and axis labels
        g2.setColor(Color.BLACK);
        g2.setFont(new Font("SansSerif", Font.BOLD, 12));
        g2.drawString(importedData.fileName, (int)(panelWidth / 2) - 40, 20); // Title
        g2.drawString("Time(s)", (int)(panelWidth / 2) - 20, (int)(panelHeight - 5)); // X-Axis

        // Draw vertical Y-axis label (rotated)
        g2.rotate(-Math.PI / 2);
        g2.drawString("Y Axis", (int)(-panelHeight / 2) - 20, 15);
        g2.rotate(-3 * Math.PI / 2); // Reset rotation

        // Draw legend
        int legendX = (int)(panelWidth - padding - 150);
        int legendY = 20;
        g2.setFont(new Font("SansSerif", Font.PLAIN, 12));
        g2.setColor(Color.BLACK);
        g2.drawString("Legend:", legendX, legendY);

        // Loop through data sets to label them in legend
        for (int k = 1; k < data.length; k++) {
            Color lineColor = Color.getHSBColor((float) k / data.length, 1.0f, 1.0f);
            g2.setColor(lineColor);
            g2.fillRect(legendX, legendY + 15 * k, 10, 10); // Color box

            g2.setColor(Color.BLACK);
            // Label based on data index (customize as needed)
            switch (k) {
                case 1 -> g2.drawString("Data Set 1: Position G(m)", legendX + 15, legendY + 15 * k + 10);
                case 2 -> g2.drawString("Data Set 1: Velocity G(m/s)", legendX + 15, legendY + 15 * k + 10);
                case 3 -> g2.drawString("Data Set 1: Acceleration G(m/s²)", legendX + 15, legendY + 15 * k + 10);
                case 4 -> g2.drawString("Data Set 1: Position Y(m)", legendX + 15, legendY + 15 * k + 10);
                case 5 -> g2.drawString("Data Set 1: Velocity Y(m/s)", legendX + 15, legendY + 15 * k + 10);
                case 6 -> g2.drawString("Data Set 1: Acceleration Y(m/s²)", legendX + 15, legendY + 15 * k + 10);
            }
        }
    }

    /**
     * Finds the maximum and minimum values in the dataset to calculate scaling.
     *
     * @param data The 2D graph data (x-values at index 0, y-values at index 1+)
     * @return Array: [maxX, maxY, minX, minY]
     */
    private double[] getMaxValues(double[][] data) {
        double[] xyValues = new double[4];

        double tempMaxX = data[0][0];
        double tempMinX = data[0][0];
        double tempMaxY = data[1][0];
        double tempMinY = data[1][0];

        for (int k = 1; k <= data.length - 1; k++) {
            for (int i = 0; i < data[0].length; i++) {
                // Update x bounds
                if (data[0][i] > tempMaxX) tempMaxX = data[0][i];
                if (data[0][i] < tempMinX) tempMinX = data[0][i];

                // Update y bounds
                if (data[k][i] > tempMaxY) tempMaxY = data[k][i];
                if (data[k][i] < tempMinY) tempMinY = data[k][i];
            }
        }

        xyValues[0] = tempMaxX;
        xyValues[1] = tempMaxY;
        xyValues[2] = tempMinX;
        xyValues[3] = tempMinY;

        return xyValues;
    }

    /**
     * Calculates the scaling factors used to convert data units into screen pixels.
     * Also stores max/min values for axis rendering.
     *
     * @param data The 2D graph dataset
     */
    private void calculateScales(double[][] data) {
        this.maxValues = getMaxValues(data);
        this.xScale = (panelWidth - 2 * padding - 140) / (maxValues[0] - maxValues[2]);
        this.yScale = (panelHeight - 2 * padding) / (2 * maxValues[1]); // Vertical scale centered around 0
    }
}
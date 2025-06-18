/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csculminating.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Panel that simulates and renders the motion of two carts,
 * either using real-time "cart mode" physics or frame-by-frame
 * playback from CSV data.
 * Supports different types of collisions: perfectly elastic,
 * inelastic with coefficient, or perfectly inelastic.
 * 
 * @author 1337
 */
public class SimulationPanel extends JPanel {
    
    // The imported data from CSV containing time, position, velocity, acceleration arrays
    private double data[][];
    
    // String specifying the type of collision ("pe", "e", or others)
    private String collisionType;
    
    // Flag indicating if simulation runs in "cart mode" (real-time physics) or frame mode (playback)
    private boolean useCartMode;
    
    // Dimensions of the panel in pixels
    private double panelWidth;
    private double panelHeight;
    
    // Objects representing the two carts, holding position, velocity, mass, etc.
    private Cart cart1X;
    private Cart cart2X;
    
    // Simulation time tracker
    private double time = 0;
    
    // Timer used to trigger updates and repainting regularly
    private Timer timer;
    
    // Current frame index used when playing back from data arrays
    private int frameIndex = 0;
    
    // Conversion constant: centimeters to meters
    private static final double conversion = 100;
    
    // Boolean to track whether simulation is paused
    private static boolean isPaused = false;
    
    /**
     * Constructor to set up simulation panel with data, collision type, mode, carts, and parent panel.
     * @param data Imported simulation data arrays
     * @param collisionType Type of collision ("pe"=perfectly elastic, "e"=inelastic, others=perfectly inelastic)
     * @param useCartMode Whether to run simulation in real-time cart mode or frame playback
     * @param cart1 The first Cart object
     * @param cart2 The second Cart object
     * @param panel The parent JPanel to get dimensions and set background
     */
    public SimulationPanel(double[][] data, String collisionType, boolean useCartMode, Cart cart1, Cart cart2, JPanel panel) {
        this.data = data;
        this.collisionType = collisionType;
        this.useCartMode = useCartMode;
        this.cart1X = cart1;
        this.cart2X = cart2;
        this.panelWidth = panel.getWidth();
        this.panelHeight = panel.getHeight();
        
        // Setup layout and background of the parent panel
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE);
    }
    
    /**
     * Starts the simulation by creating and starting a timer
     * with update frequency based on mode.
     */
    public void startSimulation() {
        if (useCartMode) {
            // In cart mode, update simulation at ~125 FPS (8 ms delay)
            timer = new Timer(8, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    updateSimulation();
                }
            });
        } else {
            // In frame mode, update simulation every 250 ms (4 FPS)
            timer = new Timer(250, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    updateSimulation();
                }
            });
        }
        timer.start();
    }
    
    /**
     * Stops the simulation timer if it exists.
     */
    public void stopSimulation() {
        if (timer != null) {
            timer.stop();
        }
    }
    
    /**
     * Updates the simulation state on each timer tick.
     * Moves carts by their velocities and handles frame indexing.
     */
    private void updateSimulation() {
        // Increment simulation time (seconds)
        time += 0.016;
        
        // Move carts based on current velocity
        cart1X.setPosition(cart1X.getPosition() + cart1X.getVelocity());
        cart2X.setPosition(cart2X.getPosition() + cart2X.getVelocity());
        
        if (!useCartMode && frameIndex < data[0].length - 1) {
            // Advance frame index in frame playback mode
            frameIndex++;
        } else if (frameIndex >= data[0].length - 1) {
            // End of data reached: reset time and stop simulation
            time = 0;
            stopSimulation();
        }
        
        // Request panel repaint to reflect new positions
        repaint();
    }
    
    /**
     * Paints the simulation panel with carts and text info.
     * Handles rendering differently for cart mode vs frame playback.
     * @param g Graphics context
     */
    @Override
    protected void paintComponent(Graphics g) {
        // Cast to Graphics2D for enhanced graphics features
        Graphics2D g2 = (Graphics2D) g;
        
        // Call superclass method to clear and prepare for drawing
        super.paintComponent(g);
        
        if (useCartMode) {
            // Cart mode: update velocities on collision and boundary bounce
            switch (collisionType) {
                case "pe" -> {
                    // Perfectly elastic collision handling
                    if (cart1X.getPosition() + 50 > cart2X.getPosition() && cart1X.getPosition() < cart2X.getPosition() + 50) {
                        double v1 = Physics.perfectlyElasticV1(cart1X.getMass(), cart1X.getVelocity(), cart2X.getMass(), cart2X.getVelocity());
                        double v2 = Physics.perfectlyElasticV2(cart1X.getMass(), cart1X.getVelocity(), cart2X.getMass(), cart2X.getVelocity());
                        cart1X.setVelocity(v1);
                        cart2X.setVelocity(v2);
                    }
                    // Boundary collision - reverse velocity when hitting edges
                    if (cart1X.getPosition() + 50 >= panelWidth) {
                        cart1X.setVelocity(-cart1X.getVelocity());
                    } else if (cart1X.getPosition() <= 0) {
                        cart1X.setVelocity(-cart1X.getVelocity());
                    }
                    if (cart2X.getPosition() + 50 >= panelWidth) {
                        cart2X.setVelocity(-cart2X.getVelocity());
                    } else if (cart2X.getPosition() <= 0) {
                        cart2X.setVelocity(-cart2X.getVelocity());
                    }
                }
                case "e" -> {
                    // Inelastic collision with coefficient 0.5
                    if (cart1X.getPosition() + 50 > cart2X.getPosition() && cart1X.getPosition() < cart2X.getPosition() + 50) {
                        double v1 = Physics.inElasticV1(0.5, cart1X.getMass(), cart1X.getVelocity(), cart2X.getMass(), cart2X.getVelocity());
                        double v2 = Physics.inElasticV2(0.5, cart1X.getMass(), cart1X.getVelocity(), cart2X.getMass(), cart2X.getVelocity());
                        cart1X.setVelocity(v1);
                        cart2X.setVelocity(v2);
                    }
                    // Boundary bounce
                    if (cart1X.getPosition() + 50 >= panelWidth) {
                        cart1X.setVelocity(-cart1X.getVelocity());
                    } else if (cart1X.getPosition() <= 0) {
                        cart1X.setVelocity(-cart1X.getVelocity());
                    }
                    if (cart2X.getPosition() + 50 >= panelWidth) {
                        cart2X.setVelocity(-cart2X.getVelocity());
                    } else if (cart2X.getPosition() <= 0) {
                        cart2X.setVelocity(-cart2X.getVelocity());
                    }
                }
                default -> {
                    // Perfectly inelastic collision (carts stick together)
                    if (cart1X.getPosition() + 50 > cart2X.getPosition() && cart1X.getPosition() < cart2X.getPosition() + 50) {
                        double vCombination = Physics.perfectlyinElastic(cart1X.getMass(), cart1X.getVelocity(), cart2X.getMass(), cart2X.getVelocity());
                        cart1X.setVelocity(vCombination);
                        cart2X.setVelocity(vCombination);
                    }
                    // Boundary bounce for both carts
                    if (cart1X.getPosition() + 50 >= panelWidth) {
                        cart1X.setVelocity(-cart1X.getVelocity());
                        cart2X.setVelocity(-cart2X.getVelocity());
                    } else if (cart1X.getPosition() <= 0) {
                        cart1X.setVelocity(-cart1X.getVelocity());
                        cart2X.setVelocity(-cart2X.getVelocity());
                    }
                    if (cart2X.getPosition() + 50 >= panelWidth) {
                        cart1X.setVelocity(-cart1X.getVelocity());
                        cart2X.setVelocity(-cart2X.getVelocity());
                    } else if (cart2X.getPosition() <= 0) {
                        cart1X.setVelocity(-cart1X.getVelocity());
                        cart2X.setVelocity(-cart2X.getVelocity());
                    }
                }
            }
            
            // Update positions after velocity changes
            cart1X.setPosition(cart1X.getPosition() + cart1X.getVelocity());
            cart2X.setPosition(cart2X.getPosition() + cart2X.getVelocity());
            
            // Draw cart 1 in red
            g2.setColor(Color.RED);
            g2.fillRect((int) cart1X.getPosition(), 50, 50, 50);
            
            // Draw cart 2 in blue
            g2.setColor(Color.BLUE);
            g2.fillRect((int) cart2X.getPosition(), 50, 50, 50);
        } else {
            // Frame playback mode: scale positions and draw from data
            
            double[] minMax = posMinMax();
            
            // Find overall min and max position for both carts
            double min = Math.min(minMax[0], minMax[2]);
            double max = Math.max(minMax[1], minMax[3]);
            
            // Calculate range in centimeters converted to meters, avoid zero
            double range = conversion * (max - min);
            if (range == 0) {
                range = 1; // Prevent division by zero
            }
            
            // Calculate horizontal scale factor to fit carts on panel width
            double xScale = Math.abs((getWidth()) / (2 * range));
            
            // Calculate pixel positions for each cart based on scaled data positions
            double pos1 = -10 * (data[1][frameIndex] - minMax[1]);
            double pos2 = 10 * (data[4][frameIndex] - minMax[3]);
            
            int pixelX1 = (int)(pos1 * xScale) + getWidth()/2 - 25;
            int pixelX2 = (int)(pos2 * xScale) + getWidth()/2 + 25;
            
            // Draw some useful info strings on the panel
            g2.drawString(String.format("Scale: %.2f pixels/meter", Math.abs(getWidth() / (2 * range))), 10, 60);
            g2.drawString(String.format("Collision at: %.2f m", (cart1X.getPosition() + cart2X.getPosition()) / 2 / conversion), 10, 80);
            g2.drawString("Cart 1 Velocity: " + String.format("%.2f", -1 * data[2][frameIndex]) + " m/s | Cart 2 Velocity: " + String.format("%.2f", data[5][frameIndex]) + " m/s", 10, 20);
            
            // Draw cart 1 rectangle in red
            g2.setColor(Color.RED);
            g2.fillRect(pixelX1, getHeight()/2, 50, 50);
            
            // Draw cart 2 rectangle in blue
            g2.setColor(Color.BLUE);
            g2.fillRect(pixelX2, getHeight()/2, 50, 50);
            
            // Optional: display the current simulation time
            g2.setColor(Color.BLACK);
            g2.drawString("t = " + String.format("%.2f", data[0][frameIndex]) + "s", 10, 40);
        }
    }
    
    /**
     * Helper method to calculate the max and min positions of both carts.
     * @return double array containing [max1, min1, max2, min2]
     */
    private double[] posMinMax() {
        double[] xyValues = new double[4];
        
        // Initialize max and min for cart 1 position
        double max1 = data[1][0];
        double min1 = data[1][0];
        
        // Initialize max and min for cart 2 position
        double max2 = data[4][0];
        double min2 = data[4][0];
        
        // Loop through all frames to find true min/max
        for (int i = 0; i < data[1].length; i++) {
            if (data[1][i] > max1) {
                max1 = data[1][i];
            } else if (data[1][i] < min1) {
                min1 = data[1][i];
            }
            if (data[4][i] > max2) {
                max2 = data[4][i];
            } else if (data[4][i] < min2) {
                min2 = data[4][i];
            }
        }
        
        xyValues[0] = max1;
        xyValues[1] = min1;
        xyValues[2] = max2;
        xyValues[3] = min2;
        return xyValues;
    }
    
    /**
     * Resets the simulation frame index to 0 and restarts the simulation.
     */
    public void resetFrameIndex() {
        frameIndex = 0;
        stopSimulation();
        startSimulation();
    }
    
    /**
     * Pauses or resumes the simulation timer depending on current pause state.
     */
    public void pauseFrameIndex() {
        if (!isPaused) {
            timer.stop();
        } else {
            timer.start();
        }
        isPaused = !isPaused;
    }
}
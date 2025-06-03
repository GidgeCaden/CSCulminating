/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csculminating.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author 1337
 */
public class SimulationPanel extends JPanel{
    
    private double data[][][];
    private boolean useCartMode;
    
    public SimulationPanel(double[][][] data, boolean useCartMode, JPanel panel)
    {
        this.data = data;
        this.useCartMode = useCartMode;
        panel.setBackground(Color.WHITE);
    }
    
    public void runSimulation(Cart cart1, Cart cart2)
    {
        
    }
    
    public void runSimulation(double[][][] data)
    {
        
    }
    
    @Override
    protected void paintComponent(Graphics g)
    {
        //Cast to Graphics2D For Better Rendering
        Graphics2D g2 = (Graphics2D) g;
        //Calls the Superclass to Ensure Proper Rendering
        super.paintComponent(g);
        
        if(useCartMode)
        {
            
        }
        else
        {
            
        }
    }
}

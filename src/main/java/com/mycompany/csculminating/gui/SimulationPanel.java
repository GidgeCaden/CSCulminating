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
    private String collisionType;
    private boolean useCartMode;
    
    public SimulationPanel(double[][][] data, String collisionType,boolean useCartMode, JPanel panel)
    {
        this.data = data;
        this.collisionType = collisionType;
        this.useCartMode = useCartMode;
        panel.setBackground(Color.WHITE);
    }
    
//    public void runSimulation(Cart cart1, Cart cart2)
//    {
//        
//    }
    
    public void runSimulationPerfectlyElastic(Cart cart1, Cart cart2)
    {
        Physics.perfectlyElasticV1(cart1.getMass(), cart1.getVelocity(), cart2.getMass(), cart2.getVelocity());
        Physics.perfectlyElasticV2(cart1.getMass(), cart1.getVelocity(), cart2.getMass(), cart2.getVelocity());
    }
    
    public void runSimulationInElastic(Cart cart1, Cart cart2)
    {
        
    }
    
    public void runSimulationPerfectlyInElastic(Cart cart1, Cart cart2)
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
            if(collisionType.equals("perfectly elastic"))
            {
                while(true)
                {
                    repaint();
                }
            }
            else if(collisionType.equals("ineleastic"))
            {
                while(true)
                {
                    repaint();
                }
            }
            else
            {
                while(true)
                {
                    repaint();
                }
            }
        }
        else
        {
            
        }
    }
}
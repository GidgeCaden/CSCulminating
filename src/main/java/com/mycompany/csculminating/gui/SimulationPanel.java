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
 *
 * @author 1337
 */
public class SimulationPanel extends JPanel{
    
    private double data[][][];
    private String collisionType;
    private boolean useCartMode;
    
    private double panelWidth;
    private double panelHeight;
    
    private Cart cart1X;
    private Cart cart2X;
    
    private double time = 0;
    private Timer timer;
    
    public SimulationPanel(double[][][] data, String collisionType, boolean useCartMode, Cart cart1, Cart cart2, JPanel panel)
    {
        this.data = data;
        this.collisionType = collisionType;
        this.useCartMode = useCartMode;
        this.cart1X = cart1;
        this.cart2X = cart2;
        this.panelWidth = panel.getWidth();
        this.panelHeight = panel.getHeight();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE);
    }
    
    public void startSimulation()
    {
        timer = new Timer(8, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                updateSimulation();
            }
        });
        timer.start();
    }
    
    public void stopSimulation()
    {
        if(timer != null)
        {
            timer.stop();
        }
    }
    
    private void updateSimulation()
    {
        time += 0.016;
        
        cart1X.setPosition(cart1X.getPosition() + cart1X.getVelocity());
        cart2X.setPosition(cart2X.getPosition() + cart2X.getVelocity());
        
        repaint();
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
            if(collisionType.equals("pe"))
            {
                if(cart1X.getPosition() + 50 > cart2X.getPosition() && cart1X.getPosition() < cart2X.getPosition() + 50)
                {
                    double v1 = Physics.perfectlyElasticV1(cart1X.getMass(), cart1X.getVelocity(), cart2X.getMass(), cart2X.getVelocity());
                    double v2 = Physics.perfectlyElasticV2(cart1X.getMass(), cart1X.getVelocity(), cart2X.getMass(), cart2X.getVelocity());
                    cart1X.setVelocity(v1);
                    cart2X.setVelocity(v2);
                }
                if(cart1X.getPosition() + 50 >= panelWidth)
                {
                    cart1X.setVelocity(-1 * cart1X.getVelocity());
                }
                else if(cart1X.getPosition() <= 0)
                {
                    cart1X.setVelocity(-1 * cart1X.getVelocity());;
                }
                if(cart2X.getPosition() + 50 >= panelWidth)
                {
                    cart2X.setVelocity(-1 * cart2X.getVelocity());
                }
                else if(cart2X.getPosition() <= 0)
                {
                    cart2X.setVelocity(-1 * cart2X.getVelocity());
                }
            }
            else if(collisionType.equals("e"))
            {
                if(cart1X.getPosition() + 50 > cart2X.getPosition() && cart1X.getPosition() < cart2X.getPosition() + 50)
                {
                    double v1 = Physics.inElasticV1(0.5, cart1X.getMass(), cart1X.getVelocity(), cart2X.getMass(), cart2X.getVelocity());
                    double v2 = Physics.inElasticV2(0.5, cart1X.getMass(), cart1X.getVelocity(), cart2X.getMass(), cart2X.getVelocity());
                    cart1X.setVelocity(v1);
                    cart2X.setVelocity(v2);
                }
                if(cart1X.getPosition() + 50 >= panelWidth)
                {
                    cart1X.setVelocity(-1 * cart1X.getVelocity());
                }
                else if(cart1X.getPosition() <= 0)
                {
                    cart1X.setVelocity(-1 * cart1X.getVelocity());
                }
                if(cart2X.getPosition() + 50 >= panelWidth)
                {
                    cart2X.setVelocity(-1 * cart2X.getVelocity());
                }
                else if(cart2X.getPosition() <= 0)
                {
                    cart2X.setVelocity(-1 * cart2X.getVelocity());
                }
                }
            else
            {
                if(cart1X.getPosition() + 50 > cart2X.getPosition() && cart1X.getPosition() < cart2X.getPosition() + 50)
                {
                    double vCombination = Physics.perfectlyinElastic(cart1X.getMass(), cart1X.getVelocity(), cart2X.getMass(), cart2X.getVelocity());
                    cart1X.setVelocity(vCombination);
                    cart2X.setVelocity(vCombination);
                }
                if(cart1X.getPosition() + 50 >= panelWidth)
                {
                    cart1X.setVelocity(-1 * cart1X.getVelocity());
                    cart2X.setVelocity(-1 * cart2X.getVelocity());
                }
                else if(cart1X.getPosition() <= 0)
                {
                    cart1X.setVelocity(-1 * cart1X.getVelocity());
                    cart2X.setVelocity(-1 * cart2X.getVelocity());
                }
                if(cart2X.getPosition() + 50 >= panelWidth)
                {
                    cart1X.setVelocity(-1 * cart1X.getVelocity());
                    cart2X.setVelocity(-1 * cart2X.getVelocity());
                }
                else if(cart2X.getPosition() <= 0)
                {
                    cart1X.setVelocity(-1 * cart1X.getVelocity());
                    cart2X.setVelocity(-1 * cart2X.getVelocity());
                }
            }
        }
        else
        {
            g2.setColor(Color.BLACK);
            g2.drawString("Graphing mode not implemented yet", 50, 50);
        }
        
        cart1X.setPosition(cart1X.getPosition() + cart1X.getVelocity());
        cart2X.setPosition(cart2X.getPosition() + cart2X.getVelocity());
        
        g2.setColor(Color.RED);
        g2.fillRect((int) cart1X.getPosition(), 50, 50, 50);
        g2.setColor(Color.BLUE);
        g2.fillRect((int) cart2X.getPosition(), 50, 50, 50);
    }
}
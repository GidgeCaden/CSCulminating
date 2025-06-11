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
import javax.swing.JPanel;

/**
 *
 * @author CoBra1341
 */
public class DataPanel extends JPanel{
    
    private String CSV;
    
    public DataPanel(JPanel panel, String CSV)
    {
        this.CSV = CSV;
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE);
    }
    
    @Override
    protected void paintComponent(Graphics g)
    {
        //Cast to Graphics2D For Better Rendering
        Graphics2D g2 = (Graphics2D) g;
        //Calls the Superclass to Ensure Proper Rendering
        super.paintComponent(g);
        //Sets the Font
        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Monospaced", Font.PLAIN, 12));
        // Column headers
        g2.drawString("CSV in Use: " + CSV, 10, 20);
        g2.drawString("Cart 1 Pos", 100, 30);
        g2.drawString("Cart 2 Pos", 220, 40);
    }
    
}

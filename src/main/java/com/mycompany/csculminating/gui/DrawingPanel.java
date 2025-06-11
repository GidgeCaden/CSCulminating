/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csculminating.gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
/**
 *
 * @author CoBra1341
 */
public class DrawingPanel extends JPanel{
    
    
    @Override
    protected void paintComponent(Graphics g) {
         super.paintComponent(g); // Always call this first

        // Example: Draw a red rectangle
        g.setColor(Color.RED);
        g.fillRect(50, 50, 100, 100);

        // Example: Draw a blue oval
        g.setColor(Color.BLUE);
        g.fillOval(200, 50, 100, 100);

        // Example: Draw text
        g.setColor(Color.BLACK);
        g.drawString("Hello, JPanel!", 150, 200);
    }
    
}

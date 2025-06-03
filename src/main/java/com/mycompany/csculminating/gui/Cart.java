/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csculminating.gui;

/**
 *
 * @author CoBra1341
 */
public class Cart {
    
    private double mass;
    private double velocity;
    
    public Cart(double mass, double velocity)
    {
        this.mass = Math.abs(mass);
        this.velocity = velocity;
    }
    
    //Accessor Method
    public double getVelocity()
    {
        return velocity;
    }
    
    public double getMass()
    {
        return mass;
    }
    
    //Mutator Methods
    public void setVelocity(double velocity)
    {
        this.velocity = velocity;
    }
    
    public void setMass(double velocity)
    {
        this.velocity = mass;
    }
    
}

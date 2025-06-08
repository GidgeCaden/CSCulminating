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
    private double position;
    
    public Cart(double mass, double velocity, double position)
    {
        this.mass = Math.abs(mass);
        this.velocity = velocity;
        this.position = position;
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
    
    public double getPosition()
    {
        return position;
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
    
    public void setPosition(double position)
    {
        this.position = position;
    }
    
}

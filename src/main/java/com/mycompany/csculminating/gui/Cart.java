/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csculminating.gui;

/**
 * Represents a physics cart with mass, velocity, and position.
 * This class can be used to simulate motion and collisions in a physics simulation.
 * 
 * @author CoBra1341
 */
public class Cart {

    private double mass;
    private double velocity;
    private double position;

    /**
     * Constructs a new Cart with the specified mass, velocity, and position.
     * Mass is converted to its absolute value to ensure non-negativity.
     *
     * @param mass the mass of the cart (kg)
     * @param velocity the velocity of the cart (m/s)
     * @param position the initial position of the cart (m)
     */
    public Cart(double mass, double velocity, double position) {
        this.mass = Math.abs(mass);
        this.velocity = velocity;
        this.position = position;
    }

    /**
     * Gets the current velocity of the cart.
     *
     * @return the velocity in meters per second
     */
    public double getVelocity() {
        return velocity;
    }

    /**
     * Gets the mass of the cart.
     *
     * @return the mass in kilograms
     */
    public double getMass() {
        return mass;
    }

    /**
     * Gets the current position of the cart.
     *
     * @return the position in meters
     */
    public double getPosition() {
        return position;
    }

    /**
     * Sets the velocity of the cart.
     *
     * @param velocity the new velocity in meters per second
     */
    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    /**
     * Sets the mass of the cart.
     *
     * @param mass the new mass in kilograms
     */
    public void setMass(double mass) {
        this.mass = Math.abs(mass);
    }

    /**
     * Sets the position of the cart.
     *
     * @param position the new position in meters
     */
    public void setPosition(double position) {
        this.position = position;
    }

}

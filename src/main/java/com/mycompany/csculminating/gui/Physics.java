/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csculminating.gui;

/**
 * Utility class that provides static methods for computing
 * post-collision velocities of two objects in one-dimensional space.
 * 
 * Supports:
 * - Perfectly elastic collisions
 * - Inelastic collisions with a coefficient of restitution
 * - Perfectly inelastic collisions (carts stick together)
 * 
 * All methods assume motion along a single axis and return the resulting velocities
 * for either object involved in the collision.
 * 
 * @author CoBra1341
 */
public class Physics {
    
    // Perfectly Elastic Velocity Calculations (1D)

    /**
     * Calculates the velocity of the first object after a perfectly elastic collision.
     *
     * @param m1 Mass of the first object
     * @param v1 Velocity of the first object before collision
     * @param m2 Mass of the second object
     * @param v2 Velocity of the second object before collision
     * @return Velocity of the first object after collision
     */
    public static double perfectlyElasticV1(double m1, double v1, double m2, double v2)
    {
        return ((m1 - m2) * v1 + 2 * m2 * v2) / (m1 + m2);
    }
    
    /**
     * Calculates the velocity of the second object after a perfectly elastic collision.
     *
     * @param m1 Mass of the first object
     * @param v1 Velocity of the first object before collision
     * @param m2 Mass of the second object
     * @param v2 Velocity of the second object before collision
     * @return Velocity of the second object after collision
     */
    public static double perfectlyElasticV2(double m1, double v1, double m2, double v2)
    {
        return ((m2 - m1) * v2 + 2 * m1 * v1) / (m1 + m2);
    }
    
    // Inelastic Velocity Calculations (1D)

    /**
     * Calculates the velocity of the first object after an inelastic collision,
     * given the coefficient of restitution.
     *
     * @param e Coefficient of restitution (0 = perfectly inelastic, 1 = perfectly elastic)
     * @param m1 Mass of the first object
     * @param v1 Velocity of the first object before collision
     * @param m2 Mass of the second object
     * @param v2 Velocity of the second object before collision
     * @return Velocity of the first object after collision
     */
    public static double inElasticV1(double e, double m1, double v1, double m2, double v2)
    {
        return (m1 * v1 + m2 * v2 + m2 * e * (v2 - v1)) / (m1 + m2);
    }
    
    /**
     * Calculates the velocity of the second object after an inelastic collision,
     * given the coefficient of restitution.
     *
     * @param e Coefficient of restitution (0 = perfectly inelastic, 1 = perfectly elastic)
     * @param m1 Mass of the first object
     * @param v1 Velocity of the first object before collision
     * @param m2 Mass of the second object
     * @param v2 Velocity of the second object before collision
     * @return Velocity of the second object after collision
     */
    public static double inElasticV2(double e, double m1, double v1, double m2, double v2)
    {
        return (m1 * v1 + m2 * v2 + m1 * e * (v1 - v2)) / (m1 + m2);
    }
    
    // Perfectly Inelastic Velocity Calculation (1D)

    /**
     * Calculates the velocity of the combined object after a perfectly inelastic collision,
     * where both objects stick together.
     *
     * @param m1 Mass of the first object
     * @param v1 Velocity of the first object before collision
     * @param m2 Mass of the second object
     * @param v2 Velocity of the second object before collision
     * @return Velocity of the combined object after collision
     */
    public static double perfectlyinElastic(double m1, double v1, double m2, double v2)
    {
        return (m1 * v1 + m2 * v2) / (m1 + m2);
    }
    
}
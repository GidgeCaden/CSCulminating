package com.mycompany.csculminating.gui;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author CoBra1341
 */
public class Physics {
    
    //Perfectly Elastic Velocity Calculations (1D)
    public static double perfectlyElasticV1(double m1, double v1, double m2, double v2)
    {
        return ((m1 - m2) * v1 + 2 * m2 * v2)/(m1 + m2);
    }
    
    public static double perfectlyElasticV2(double m1, double v1, double m2, double v2)
    {
        return ((m2 - m1) * v2 + 2 * m1 * v1)/(m1 + m2);
    }
    
    //Ineleastic Velocity Calculations (1D)
    public static double inElasticV1(double e, double m1, double v1, double m2, double v2)
    {
        return (m1 * v1 + m2 * v2 + m2 * e * (v2 - v1))/(m1 + m2);
    }
    
    public static double inElasticV2(double e, double m1, double v1, double m2, double v2)
    {
        return (m1 * v1 + m2 * v2 + m1 * e * (v1 - v2))/(m1 + m2);
    }
    
    //Perfectly Inelastic Velocity Calculation (1D)
    public static double perfectlyinElastic(double m1, double v1, double m2, double v2)
    {
        return (m1 * v1 + m2 * v2)/(m1 + m2);
    }
    
}

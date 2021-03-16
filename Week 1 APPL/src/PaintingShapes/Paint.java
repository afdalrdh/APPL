/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaintingShapes;

/**
 *
 * @author afdalrdh
 */

//****************************************************** 
// Paint.java 
// 
// Represents a type of paint that has a fixed area 
// covered by a gallon. All measurements are in feet. 
//****************************************************** 
public class Paint {
    private double coverage; 
    
    public Paint(double c) 
    { 
        this.coverage = c; 
    } 
    
    public double amount (Shape s){
        System.out.println("Computing amount for" + s);
        return s.area()/coverage;
    }
}

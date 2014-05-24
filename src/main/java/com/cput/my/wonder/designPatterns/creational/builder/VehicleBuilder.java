/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.my.wonder.designPatterns.creational.builder;

/**
 *
 * @author Khanya
 */
public interface VehicleBuilder {
    
    public void buildName();
    public void buildType();
    public void buildColor();
    public void buildYear();
    public Vehicle getVehicle();
           
    
}

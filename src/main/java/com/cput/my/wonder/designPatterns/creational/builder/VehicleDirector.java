/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.my.wonder.designPatterns.creational.builder;

import com.cput.my.wonder.designPatterns.creational.prototype.Prototype;

/**
 *
 * @author Khanya
 */
public class VehicleDirector implements Prototype{
    
    private VehicleBuilder vehicleBuilder = null;
    
    public VehicleDirector(VehicleBuilder vehicleBuilder)
    {
            this.vehicleBuilder = vehicleBuilder; 
    }
    
    public void constructVehicle()
    {
        vehicleBuilder.buildName();
        vehicleBuilder.buildColor();
        vehicleBuilder.buildType();
        vehicleBuilder.buildYear();
                
    }
    public Vehicle getVehicle()
    {
        return vehicleBuilder.getVehicle();
        
    }

    @Override
    public Prototype doClone() {
        return new VehicleDirector(vehicleBuilder);
    }
}

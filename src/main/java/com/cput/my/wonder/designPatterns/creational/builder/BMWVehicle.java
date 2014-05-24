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
public class BMWVehicle implements VehicleBuilder{
    
    private Vehicle vehicle;
    
    public BMWVehicle()
    {
        vehicle = new Vehicle();        
    }
    
    @Override
    public void buildName() {
      vehicle.setName("5 series");
    }

    @Override
    public void buildType() {
        vehicle.setType("Car");
    }

    @Override
    public void buildColor() {
        vehicle.setColor("black");
    }

    @Override
    public void buildYear() {
       vehicle.setYear("2011");
    }

    @Override
    public Vehicle getVehicle() {
        return vehicle;
    }
    
    
}

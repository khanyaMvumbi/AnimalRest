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
public class ToyotaVehicle implements VehicleBuilder{
    Vehicle vehicle;
    
    public ToyotaVehicle(){
        vehicle = new Vehicle();
    }
    
    @Override
    public void buildName() {
        vehicle.setName("corrola");
    }

    @Override
    public void buildType() {
        vehicle.setType("car");
    }

    @Override
    public void buildColor() {
        vehicle.setColor("white");
    }

    @Override
    public void buildYear() {
        vehicle.setYear("2010");
    }

    @Override
    public Vehicle getVehicle() {
        return vehicle;
    }
    
}

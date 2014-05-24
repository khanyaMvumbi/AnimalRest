/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.my.wonder.designPatterns.structual.bridge;

/**
 *
 * @author Khanya
 */
public class SmallCar extends Vehicle{
    
    public SmallCar(Engine engine){
       this.weightInKilos = 600;
        this.engine = engine;
     }

    @Override
    public void drive() {
       int horsepower = engine.go();
        reportOnSpeed(horsepower);}
    
}

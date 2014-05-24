/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.my.wonder.designPatterns.creational.singleton;

/**
 *
 * @author Khanya
 */
public class SingletonVehicles {
    
    private static SingletonVehicles singleVehicles = null;
    
    private SingletonVehicles()
    {               
    }
    
    public static SingletonVehicles getInstance()
    {
        if(singleVehicles == null)
            singleVehicles = new SingletonVehicles();
        return singleVehicles;
    }
        
    public String sayHi()
    {
        return "Hello";
    }    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.my.wonder.designPatterns.structual.flyweight;

/**
 *
 * @author Khanya
 */
public class FlyweightMultiplier implements Flyweight{
    
    String operation;
    public FlyweightMultiplier(){
        operation = "Multiplier";
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    
    @Override
    public String doMath(int a, int b) {
        return (operation + " " + a + " and " + b +  ":" + (a*b));
    }
}

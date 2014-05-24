/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.my.wonder.designPatterns.structual.proxy;

/**
 *
 * @author Khanya
 */
public class Proxy {
    
    SlowThing slowThing;
    
    public Proxy(){
        //proxy created at + new Date();
    }
    public void sayHello()
    {
        if (slowThing == null){
            slowThing = new SlowThing();
        }
        slowThing.sayHello();
    }
}

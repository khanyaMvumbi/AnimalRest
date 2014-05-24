/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.my.wonder.designPatterns.structual.facade;

/**
 *
 * @author Khanya
 */
public class Facade {
    
    public int cubeX(int x){
        Class1 class1 = new Class1();
        return class1.doSomething(x);
    }
    
    public int cubeXTimes2(int x){
        
        Class1 class1 = new Class1();
        Class2 class2 = new Class2();
        Class3 class3 = new Class3();
        return class2.doAnotherThing(class1,x);
    }
    
    public int xToSixPowerTimes2(int x){
        
        Class1 class1 = new Class1();
        Class2 class2 = new Class2();
        Class3 class3 = new Class3();
        return class3.doMoreStuff(class1,class2, x);
    }
    
    
}

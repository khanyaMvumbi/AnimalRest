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
public class Class3 {
    
    public int doMoreStuff(Class1 class1, Class2 class2, int x)
    {
        return class1.doSomething(x) * class2.doAnotherThing(class1, x);
    }
    
}

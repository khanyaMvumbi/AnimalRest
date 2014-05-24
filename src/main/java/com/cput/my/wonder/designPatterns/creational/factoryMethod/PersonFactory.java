/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.my.wonder.designPatterns.creational.factoryMethod;

/**
 *
 * @author Khanya
 */
public class PersonFactory {
    
    public Person getPerson(String type)
    {
        if (type.equals("Xhosa")){
            return new Xhosa();
        }
        else{ 
            return new Zulu();
        }
    }
       
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.my.wonder.designPatterns.creational.abstractFactory;

import com.cput.my.wonder.designPatterns.creational.factoryMethod.Person;

/**
 *
 * @author Khanya
 */
public abstract class RaceFactory {    
    
     public abstract Person getPerson(String type);
}

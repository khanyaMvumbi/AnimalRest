/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.my.wonder.designPatterns.creational.abstractFactory;

import com.cput.my.wonder.designPatterns.creational.factoryMethod.Person;
import com.cput.my.wonder.designPatterns.creational.factoryMethod.Xhosa;
import com.cput.my.wonder.designPatterns.creational.factoryMethod.Zulu;

/**
 *
 * @author Khanya
 */
public class BlackPersonFactory extends RaceFactory{

    @Override
    public Person getPerson(String type) {
      if( "Xhosa".equals(type) ) 
          return new Xhosa();
      else
          return new Zulu();
     }
    
}

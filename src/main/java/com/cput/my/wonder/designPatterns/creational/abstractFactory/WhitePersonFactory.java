/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.my.wonder.designPatterns.creational.abstractFactory;

import com.cput.my.wonder.designPatterns.creational.factoryMethod.Afrikaans;
import com.cput.my.wonder.designPatterns.creational.factoryMethod.English;
import com.cput.my.wonder.designPatterns.creational.factoryMethod.Person;

/**
 *
 * @author Khanya
 */
public class WhitePersonFactory extends RaceFactory{

    @Override
    public Person getPerson(String type) {
        if( "English".equals(type) ) 
          return new English();
      else
          return new Afrikaans(); }
    
}

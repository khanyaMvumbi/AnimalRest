/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.wonder.test.designPatterns.creational.AbstractFactory;

import com.cput.my.wonder.designPatterns.creational.abstractFactory.AbstractFactory;
import com.cput.my.wonder.designPatterns.creational.abstractFactory.RaceFactory;
import com.cput.my.wonder.designPatterns.creational.factoryMethod.Person;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Khanya
 */
public class AbstractFactoryTest {    
    AbstractFactory abstractFactory;
   
    Person person;
    RaceFactory race;
    public AbstractFactoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void BlackGreetings() {
         abstractFactory = new AbstractFactory();
         
         race = abstractFactory.getRaceFactory("Black");
         person = race.getPerson("Xhosa");
         Assert.assertEquals("Molweni", person.greetings());
         
         person = race.getPerson("Zulu");
         Assert.assertEquals("sanibonani", person.greetings());                
         
     }
     
     @Test
     public void WhiteGreetings() { 
         abstractFactory = new AbstractFactory();
         
         race = abstractFactory.getRaceFactory("White");
         person = race.getPerson("English");
         Assert.assertEquals("Hello", person.greetings());
         
         person = race.getPerson("Afrikaans");
         Assert.assertEquals("Groet", person.greetings());
     }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}

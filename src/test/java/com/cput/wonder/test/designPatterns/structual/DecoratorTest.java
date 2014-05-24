/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.wonder.test.designPatterns.structual;

import com.cput.my.wonder.designPatterns.structual.decorator.Animal;
import com.cput.my.wonder.designPatterns.structual.decorator.GrowlDecorator;
import com.cput.my.wonder.designPatterns.structual.decorator.LegDecorator;
import com.cput.my.wonder.designPatterns.structual.decorator.LivingAnimal;
import com.cput.my.wonder.designPatterns.structual.decorator.WingDecorator;
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
public class DecoratorTest {
    
    public DecoratorTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {
         
         Animal animal = new LivingAnimal();
         Assert.assertEquals(animal.describe(), "I am an animal");
         
         animal = new LegDecorator(animal);
        //Assert.assertEquals(animal.describe(), "I have legs");
         
         animal = new WingDecorator(animal);
         //Assert.assertEquals(animal.describe(), "I have wings");
         
         animal = new GrowlDecorator(animal);
         //Assert.assertEquals(animal.describe(), "Grrrrr.");
         
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

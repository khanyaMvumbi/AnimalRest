/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.wonder.test.designPatterns.creational.factoryMethod;

import com.cput.my.wonder.designPatterns.creational.factoryMethod.Person;
import com.cput.my.wonder.designPatterns.creational.factoryMethod.PersonFactory;
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
public class PersonTest {
    
    public PersonTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void getPerson() {
        
        PersonFactory personFactory = new PersonFactory();
        //Person person;
        Person person = personFactory.getPerson("Xhosa");
        
        Assert.assertEquals(person.greetings(), "Molweni");
    
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

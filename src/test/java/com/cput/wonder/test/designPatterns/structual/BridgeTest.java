/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.wonder.test.designPatterns.structual;

import com.cput.my.wonder.designPatterns.structual.bridge.BigBus;
import com.cput.my.wonder.designPatterns.structual.bridge.BigEngine;
import com.cput.my.wonder.designPatterns.structual.bridge.SmallCar;
import com.cput.my.wonder.designPatterns.structual.bridge.SmallEngine;
import com.cput.my.wonder.designPatterns.structual.bridge.Vehicle;
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
public class BridgeTest {
    
    public BridgeTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {
     
         Vehicle vehicle = new BigBus(new SmallEngine());
         vehicle.drive();
         
         vehicle.setEngine(new BigEngine());
         vehicle.drive();
         
         vehicle = new SmallCar(new SmallEngine());
         vehicle.drive();
         
         vehicle.setEngine(new BigEngine());
         vehicle.drive();
         
         //Assert.assertEquals(vehicle.drive(), "fast speed");
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

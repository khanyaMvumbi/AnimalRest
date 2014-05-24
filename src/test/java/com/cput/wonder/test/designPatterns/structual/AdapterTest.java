/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.wonder.test.designPatterns.structual;

import com.cput.my.wonder.designPatterns.structual.adapter.TempClassReporter;
import com.cput.my.wonder.designPatterns.structual.adapter.TempInfo;
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
public class AdapterTest {
    
    public AdapterTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testEmpInfoClass() {
     TempInfo tempInfo = new TempClassReporter();
     
     tempInfo.setTempInf(0);
     
     Assert.assertEquals(tempInfo.getTempInc(), -17.77777777777778 );
     Assert.assertEquals(tempInfo.getTempInf(), 0.0);
      
     
     }
     @Test
     public void testTempInfoObjectReporter()
     {         
        TempInfo tempInfo = new TempClassReporter();
     
        tempInfo.setTempInf(85);
     
        Assert.assertEquals(tempInfo.getTempInc(), 29.4444444444444443);
        Assert.assertEquals(tempInfo.getTempInf(), 85.0);
        
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

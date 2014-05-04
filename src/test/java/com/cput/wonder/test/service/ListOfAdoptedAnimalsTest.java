/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.wonder.test.service;

import com.cput.my.wonder.app.config.ConnectionConfig;
import com.cput.my.wonder.repository.AdoptAnimalRepository;
import com.cput.my.wonder.services.ListOfAdoptedAnimalService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
public class ListOfAdoptedAnimalsTest {
    
    private static ApplicationContext ctx;
    private ListOfAdoptedAnimalService service;
    private Long id;
    private AdoptAnimalRepository repo;
    
    public ListOfAdoptedAnimalsTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void listAdoptedAnimals() {
    
        service = ctx.getBean(ListOfAdoptedAnimalService.class);
        
        Assert.assertEquals(service.getAdoptedAnimals().size(), 0, "expected 0 list");
    
    }    

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public void tearDownClass() throws Exception {
        repo = ctx.getBean(AdoptAnimalRepository.class);
        repo.deleteAll();
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}

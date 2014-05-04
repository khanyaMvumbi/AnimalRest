/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.wonder.test.service;

import com.cput.my.wonder.app.config.ConnectionConfig;
import com.cput.my.wonder.domain.AnimalHealth;
import com.cput.my.wonder.repository.AnimalHealthRepository;
import com.cput.my.wonder.repository.AnimalRepository;
import com.cput.my.wonder.services.AnimalInfectionService;
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
public class AnimalHealthTest {
    
    private static ApplicationContext ctx;
    private AnimalInfectionService service;
    private Long id;
    private AnimalHealthRepository repo;
    
    public AnimalHealthTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void addInfection(){
        service = ctx.getBean(AnimalInfectionService.class);
        
        AnimalHealth infection = new AnimalHealth.Builder("dog flu").Description("iyabulala").build();
        id = infection.getHealthID();
        
        service.addInfection(infection);
        Assert.assertNotNull(id);
     }
    
     @Test (dependsOnMethods = "checkInfection")
     public void checkInfection(){
         service = ctx.getBean(AnimalInfectionService.class);
         
         AnimalHealth health = service.checkAnimalInfection(id);
         Assert.assertEquals(health.getCondition(), "dog flu");
         
     }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public void tearDownClass() throws Exception {
        repo = ctx.getBean(AnimalHealthRepository.class);
        repo.deleteAll();
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}

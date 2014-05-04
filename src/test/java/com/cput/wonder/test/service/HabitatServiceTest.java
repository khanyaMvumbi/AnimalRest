/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.wonder.test.service;

import com.cput.my.wonder.app.config.ConnectionConfig;
import com.cput.my.wonder.domain.Habitat;
import com.cput.my.wonder.repository.HabitatRepository;
import com.cput.my.wonder.services.HabitatService;
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
public class HabitatServiceTest {
    
    private static ApplicationContext ctx;
    private HabitatService service;
    private Long id;
    private HabitatRepository repo;
    
    public HabitatServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void availableHabitats() {
        service =  ctx.getBean(HabitatService.class);
         
        Assert.assertEquals(service.getAvailableHabitats().size(),0);
     }
     
     @Test   (dependsOnMethods = "availableHabitats")
     public void newHabitat() {
         service =  ctx.getBean(HabitatService.class);
         Habitat habi = new Habitat.Builder(23).block("c").unit("5").build();
         service.newHabitat(habi);
          Assert.assertEquals(service.getAvailableHabitats().size(), 1);
         
     }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public void tearDownClass() throws Exception {
        repo = ctx.getBean(HabitatRepository.class);
        repo.deleteAll();

    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}

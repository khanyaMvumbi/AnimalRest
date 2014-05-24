/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.wonder.test.service;

import com.cput.my.wonder.app.config.ConnectionConfig;
import com.cput.my.wonder.domain.Animal;
import com.cput.my.wonder.domain.AnimalOwner;
import com.cput.my.wonder.repository.AnimalOwnerRepository;
import com.cput.my.wonder.services.AnimalOwnerService;
import java.util.ArrayList;
import java.util.List;
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
public class AnimalOwnerServiceTest {
    
    private static ApplicationContext ctx;
    private AnimalOwnerService service;
    private Long id;
    private AnimalOwnerRepository repo;
    
    public AnimalOwnerServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void addOwner() {
       service = ctx.getBean(AnimalOwnerService.class);
       
       List <Animal> animalList = new ArrayList<>();
       
       Animal animal = new Animal.Builder(3).Name("papa").Species("Dog").Color("white").isAdopted(false).build();
       animalList.add(animal);
       
       animal = new Animal.Builder(3).Name("wolf").Species("Dog").Color("white").isAdopted(false).build();
       animalList.add(animal);
       
       AnimalOwner owner = new AnimalOwner.Builder("Khanya").Age(20).Surname("Mvumbi").animal(animalList).build();
       service.newAnimalOwner(owner);
       id = owner.getOwnerID();
       Assert.assertNull(id);
     }
     
     @Test  (dependsOnMethods = "addOwner")
     public void findOwner() {
       service = ctx.getBean(AnimalOwnerService.class);
     
       Assert.assertEquals(service.findAnimalOwner(id).getAge(), 20);
     }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public void tearDownClass() throws Exception {
        repo = ctx.getBean(AnimalOwnerRepository.class);
        repo.deleteAll();
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}

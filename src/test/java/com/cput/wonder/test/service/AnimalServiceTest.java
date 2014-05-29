/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.wonder.test.service;

import com.cput.my.wonder.app.config.ConnectionConfig;
import com.cput.my.wonder.domain.Animal;
import com.cput.my.wonder.repository.AnimalRepository;
import com.cput.my.wonder.services.AnimalService;
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
public class AnimalServiceTest {
    private static ApplicationContext ctx;
    private AnimalService service;
    private Long id;
    private AnimalRepository repo;
    
    public AnimalServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    @Test  
    public void getAnimals() {
        service = ctx.getBean(AnimalService.class);
         
        Assert.assertEquals(service.findAll().size(),0 );
    }
    
    @Test  (dependsOnMethods = "getAnimals")
    public void addAnimal() {
        service = ctx.getBean(AnimalService.class);        
        Animal animal = new Animal.Builder(3).Name("papa").Species("DOg").Color("white").isAdopted(false).build();
        service.persist(animal);        
        Assert.assertEquals(service.findAll().size(),1 );
        
    }
    
    @Test  (dependsOnMethods = "addAnimal")
    public void searchAnimal() {
        service = ctx.getBean(AnimalService.class);
        
        Animal animal = new Animal.Builder(7).Name("dada").Species("Dog").Color("black").isAdopted(false).build();
        service.persist(animal); 
        Animal animal2 = service.find(service.findAll().get(0).getId());
        
        Assert.assertEquals(animal2.getAge(), 3  );
    }
    
    @Test  (dependsOnMethods = "searchAnimal")
    public void deleteAnimal() {
        service = ctx.getBean(AnimalService.class);
        
        service.remove(service.findAll().get(0));
        
        Assert.assertEquals(service.findAll().size(), 1 );
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public void tearDownClass() throws Exception {
        repo = ctx.getBean(AnimalRepository.class);
        repo.deleteAll();
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}

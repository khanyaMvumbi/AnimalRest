/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.wonder.test.repository;

import com.cput.my.wonder.app.config.ConnectionConfig;
import com.cput.my.wonder.domain.Animal;
import com.cput.my.wonder.domain.ServiceAnimal;
import com.cput.my.wonder.domain.Supplier;
import com.cput.my.wonder.repository.ServiceAnimalRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Khanya
 */
public class ServiceAnimalRepositoryTest {
    
    public ServiceAnimalRepositoryTest() {
   }
    private static ApplicationContext ctx;
    private Long id;
    private ServiceAnimalRepository repo;
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
    public void createServiceAnimal() {
        repo = ctx.getBean(ServiceAnimalRepository.class);
        
//        Animal ani = new Animal.Builder(4).Name("nonjana").Species("Dog").build();
//         List<Animal> animal = new ArrayList<>();
//         animal.add(ani);
//        
        ServiceAnimal service = new ServiceAnimal.Builder("12/05/2014").build();
        repo.save(service);
        id = service.getID();
        
        Assert.assertEquals(service.getDate(), "12/05/2014");            
    }    
    @Test  (dependsOnMethods = "createServiceAnimal")
    public void readServiceAnimal()
    {
        repo = ctx.getBean(ServiceAnimalRepository.class);
        ServiceAnimal service = repo.findOne(id);
        
        Assert.assertEquals(service.getDate(), "12/05/2014");
    }
    
    @Test (dependsOnMethods = "readServiceAnimal")
    public void updateServiceAnimal()
    {
        repo = ctx.getBean(ServiceAnimalRepository.class);
        ServiceAnimal service = repo.findOne(id);
        
        Animal ani = new Animal.Builder(33).Name("popo").Species("elephant").build();
        List<Animal> animal = new ArrayList<>();
        animal.add(ani);
        
        ServiceAnimal updateService = new ServiceAnimal.Builder("12/05/2014").serviceAnimal(service).animal(animal).build();
        repo.save(updateService);
        
        ServiceAnimal updatedService = repo.findOne(id);
        
        Assert.assertEquals(updateService.getAnimal().get(0).getName(), "popo");
        
    }
    @Test  (dependsOnMethods = "updateServiceAnimal")
    public void deleteServiceAnimal()
    {
        repo = ctx.getBean(ServiceAnimalRepository.class);
        ServiceAnimal service = repo.findOne(id);
        
        repo.delete(service);
       
        ServiceAnimal deletedService = repo.findOne(id);
        Assert.assertNull(deletedService);
        
    }
    @BeforeClass
    public static void setUpClass() throws Exception {
        
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.wonder.test.repository;

import com.cput.my.wonder.app.config.ConnectionConfig;
import com.cput.my.wonder.domain.Animal;
import com.cput.my.wonder.domain.AnimalOwner;
import com.cput.my.wonder.domain.AnimalStatus;
import com.cput.my.wonder.repository.AnimalOwnerRepository;
import com.cput.my.wonder.repository.AnimalRepository;
import com.cput.my.wonder.repository.AnimalStatusRepository;
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
public class AnimalOwnerRepositoryTest {
    
    private static ApplicationContext ctx;
    private Long id;
    private AnimalOwnerRepository repo;
    public AnimalOwnerRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createAnimalOwner() {
     List<Animal>animals = new ArrayList<>();
     AnimalStatus statusObj = new AnimalStatus.Builder("Sick").date("12/04/2014").isActive(true).build();
     
     List<AnimalStatus> status = new ArrayList<>();
     status.add(statusObj);
      
     Animal animal = new Animal.Builder(4).Name("katalina").Species("Cat").isAdopted(false).Color("black").status(status).build();
     animals.add(animal);  
    
     
     animal = new Animal.Builder(4).Name("Faku").Species("Dog").isAdopted(false).Color("black").status(status).build();
     animals.add(animal);
     repo = ctx.getBean(AnimalOwnerRepository.class);
     AnimalOwner owner = new AnimalOwner.Builder("Jesus").Age(43).Surname("Christ").build();
     
     repo.save(owner);
     id = owner.getOwnerID();
     
     Assert.assertEquals(owner.getAge(), 43);
           
    }
    
    @Test  (dependsOnMethods = "createAnimalOwner")
    public void readAnimalOwner()
    {
        repo = ctx.getBean(AnimalOwnerRepository.class);
        AnimalOwner owner = repo.findOne(id);
        
        Assert.assertEquals(owner.getName(), "Jesus");
        
        
    }    
    @Test(dependsOnMethods = "readAnimalOwner")
    public void updateAnimalOwner()
    {
        repo = ctx.getBean(AnimalOwnerRepository.class);
        AnimalOwner owner = repo.findOne(id);
        
        AnimalOwner updateOwner = new AnimalOwner.Builder("Jesus").animalOwner(owner).Surname("Malema").build();
        
        repo.save(updateOwner);        
        AnimalOwner updatedOwner = repo.findOne(id);      
        
        Assert.assertEquals(updatedOwner.getSurname(), "Malema");
    }
    
    @Test   (dependsOnMethods = "updateAnimalOwner")
    public void deleteAnimalOwner()
    {
        repo = ctx.getBean(AnimalOwnerRepository.class);
        AnimalOwner owner = repo.findOne(id);
        
        repo.delete(owner);  
        AnimalOwner deleteOwner = repo.findOne(id);
        Assert.assertNull(deleteOwner);
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

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
    
    public static ApplicationContext ctx;
    private Long id;
    private AnimalOwnerRepository repo;
    
    public AnimalOwnerRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createAnimalOwner() {
     
     repo = ctx.getBean(AnimalOwnerRepository.class);
     
     List<Animal>animals = new ArrayList<>();
     AnimalStatus status = new AnimalStatus.Builder("Sick").date("12/04/2014").isActive(true).build();
     Animal animal = new Animal.Builder(4).Name("katalina").Species("Cat").adopted(false).Color("black").status(status).build();
     animals.add(animal);
     animal = new Animal.Builder(4).Name("Faku").Species("Dog").adopted(false).Color("black").status(status).build();
     animals.add(animal);
     AnimalOwner owner = new AnimalOwner.Builder("Jesus").Age(43).Surname("Christ").animal(animals).build();
     
     repo.save(owner);
     id = owner.getOwnerID();
     
     Assert.assertEquals(owner.getAge(), 43);
           
    }
    
    @Test
    public void readAnimalOwner()
    {
        repo = ctx.getBean(AnimalOwnerRepository.class);
        AnimalOwner owner = repo.findOne(id);
        
        Assert.assertEquals(owner.getName(), "Jesus");
        
        
    }    
    @Test
    public void updateAnimalOwner()
    {
        repo = ctx.getBean(AnimalOwnerRepository.class);
        AnimalOwner owner = repo.findOne(id);
        
        AnimalOwner updateOwner = new AnimalOwner.Builder("Jesus").animalOwner(owner).Surname("Malema").build();
        
        repo.save(updateOwner);        
        AnimalOwner updatedOwner = repo.findOne(id);      
        
        Assert.assertEquals(updatedOwner.getSurname(), "Malema");
    }
    
    @Test
    public void deleteAnimalOwner()
    {
        repo = ctx.getBean(AnimalOwnerRepository.class);
        AnimalOwner owner = repo.findOne(id);
        
        repo.delete(owner);        
        Assert.assertNull(owner);
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

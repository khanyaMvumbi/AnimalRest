/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.wonder.test.repository;

import com.cput.my.wonder.app.config.ConnectionConfig;
import com.cput.my.wonder.domain.Animal;
import com.cput.my.wonder.domain.AnimalHealth;
import com.cput.my.wonder.domain.MedicalHistory;
import com.cput.my.wonder.repository.AnimalHealthRepository;
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
public class AnimalHealthRepositoryTest {
    
    private static ApplicationContext ctx;
    private Long id;
    private AnimalHealthRepository repo;
    
    public AnimalHealthRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createAnimalHealth() {
        repo = ctx.getBean(AnimalHealthRepository.class);
        Animal ani = new Animal.Builder(33).Name("sunji").Species("elephant").build();
         List<Animal> animal = new ArrayList<>();
         animal.add(ani);
         MedicalHistory history = new MedicalHistory.Builder().description("dog flu").build();
         List<MedicalHistory> hist = new ArrayList<>();
         hist.add(history);
         AnimalHealth health = new AnimalHealth.Builder("Dog Cancer").history(hist).animals(animal).Description("If animal doesnt take treatment, this animal will die suddenly").build();
         
         repo.save(health);
         id = health.getHealthID();
         Assert.assertEquals(health.getAnimal().get(0).getName(), "sunji");
         Assert.assertEquals(health.getHistory().get(0).getDescription(), "dog flu");
    
    }
    
    @Test  (dependsOnMethods = "createAnimalHealth")
    public void readAnimalHealth()
    {
        repo = ctx.getBean(AnimalHealthRepository.class);
        AnimalHealth health = repo.findOne(id);
        
        
        Assert.assertEquals(health.getHealthID(),id );
        Assert.assertEquals(health.getCondition(),"Dog Cancer");
        Assert.assertNotNull(health);
        //Assert.assertEquals(health.getAnimal().get(0).getAge(), 33);
    }
    
    @Test (dependsOnMethods = "readAnimalHealth")
    public void updateAnimalHealth()
    {
        repo = ctx.getBean(AnimalHealthRepository.class);
        
        Animal ani = new Animal.Builder(13).Name("Bupi").Species("elephant").build();
        List<Animal> animal = new ArrayList<>();
              
        animal.add(ani);
        AnimalHealth health = repo.findOne(id);
        AnimalHealth updateHealth = new AnimalHealth.Builder("").animalHealth(health).animals(animal).Description("kills").build();
        repo.save(updateHealth);
        
        AnimalHealth updatedHealth = repo.findOne(id);
       Assert.assertEquals(updatedHealth.getDescription(),"kills");
    }
    
    @Test  (dependsOnMethods = "updateAnimalHealth")
    public void deleteAnimalHealth()
    {
        repo = ctx.getBean(AnimalHealthRepository.class);
        AnimalHealth health = repo.findOne(id);
        repo.delete(health);
        
        AnimalHealth deleteHealth = repo.findOne(id);
        Assert.assertNull(deleteHealth);
        
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

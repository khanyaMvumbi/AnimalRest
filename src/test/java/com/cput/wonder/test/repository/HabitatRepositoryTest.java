/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.wonder.test.repository;

import com.cput.my.wonder.app.config.ConnectionConfig;
import com.cput.my.wonder.domain.Habitat;
import com.cput.my.wonder.domain.TransportAnimal;
import com.cput.my.wonder.repository.HabitatRepository;
import com.cput.my.wonder.repository.TransportAnimalRepository;
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
public class HabitatRepositoryTest {
    
    private static ApplicationContext ctx;
    private Long id;
    private HabitatRepository repo;
    
    public HabitatRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    @Test
    public void createHabitat() {
        repo = ctx.getBean(HabitatRepository.class);        
        Habitat habitat = new Habitat.Builder(2).block("D").unit("A").build();        
        repo.save(habitat);
        
        id = habitat.getId();        
        Assert.assertEquals(habitat.getRoom(), 2);            
    }
    
    @Test  (dependsOnMethods = "createHabitat")
    public void readHabitat()
    {
        repo = ctx.getBean(HabitatRepository.class);
        Habitat habitat = repo.findOne(id);
        
        Assert.assertEquals(habitat.getBlock(), "D");
    }
    
    @Test (dependsOnMethods = "readHabitat")
    public void updateHabitat()
    {
        repo = ctx.getBean(HabitatRepository.class);
        Habitat habitat = repo.findOne(id);
        
        Habitat newHabitat = new Habitat.Builder(2).habitat(habitat).unit("A").build();   
        repo.save(newHabitat);
        
        Habitat updatedHabitat = repo.findOne(id);
        
        Assert.assertEquals(updatedHabitat.getUnit(), "A");
        
    }
    @Test  (dependsOnMethods = "updateHabitat")
    public void deleteHabitat()
    {
        repo = ctx.getBean(HabitatRepository.class);
        Habitat  deleteHabitat = repo.findOne(id);
        
        repo.delete(deleteHabitat);
       
        Habitat deletedHabitat = repo.findOne(id);
        Assert.assertNull(deletedHabitat);
        
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

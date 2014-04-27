/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.wonder.test.repository;

import com.cput.my.wonder.app.config.ConnectionConfig;
import com.cput.my.wonder.domain.TransportAnimal;
import com.cput.my.wonder.repository.TransportAnimalRepository;
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
public class TransportAnimalRepositoryTest {
    
    private static ApplicationContext ctx;
    private Long id;
    private TransportAnimalRepository repo;
    
    public TransportAnimalRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createTransport() {
        repo = ctx.getBean(TransportAnimalRepository.class);
        
        TransportAnimal trans = new TransportAnimal.Builder("7777").location("Port Elizabeth").Date("12/11/2014").build();
        
        repo.save(trans);
        id = trans.getId();        
        Assert.assertEquals(trans.getTransportNumber(),"7777");            
    }
    
    @Test  (dependsOnMethods = "createTransport")
    public void readTransport()
    {
        repo = ctx.getBean(TransportAnimalRepository.class);
        TransportAnimal trans = repo.findOne(id);
        
        Assert.assertEquals(trans.getTransportNumber(), "7777");
    }
    
    @Test (dependsOnMethods = "readTransport")
    public void updateTransport()
    {
        repo = ctx.getBean(TransportAnimalRepository.class);
        TransportAnimal trans = repo.findOne(id);
        
        TransportAnimal newTrans = new TransportAnimal.Builder("7777").transportAnimal(trans).Date("12/05/2014").build();
        repo.save(newTrans);
        
        TransportAnimal updatedTrans = repo.findOne(id);
        
        Assert.assertEquals(updatedTrans.getDate() , "12/05/2014");
        
    }
    @Test  (dependsOnMethods = "updateTransport")
    public void deleteTransport()
    {
        repo = ctx.getBean(TransportAnimalRepository.class);
        TransportAnimal trans = repo.findOne(id);
        
        repo.delete(trans);
       
        TransportAnimal deletedTrans = repo.findOne(id);
        Assert.assertNull(deletedTrans);
        
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public void tearDownClass() throws Exception {
        
        repo = ctx.getBean(TransportAnimalRepository.class);
        repo.deleteAll();
        
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}

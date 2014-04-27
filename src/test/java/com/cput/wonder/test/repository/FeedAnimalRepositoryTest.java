/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.wonder.test.repository;

import com.cput.my.wonder.app.config.ConnectionConfig;
import com.cput.my.wonder.domain.FeedAnimal;
import com.cput.my.wonder.domain.Food;
import com.cput.my.wonder.repository.FeedAnimalRepository;
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
public class FeedAnimalRepositoryTest {
    
    private static ApplicationContext ctx;
    private Long id;
    private FeedAnimalRepository repo;
    
    public FeedAnimalRepositoryTest() {
    }   

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
    public void createFeedAnimal() {
        repo = ctx.getBean(FeedAnimalRepository.class);
        
        Food food = new Food.Builder("dog Master").description("rice").build();
        FeedAnimal feed = new FeedAnimal.Builder(false).Food(food).build();
        repo.save(feed);
        id = feed.getId();
        
        Assert.assertEquals(feed.getFood().getName(),"dog Master");            
    }
    
    @Test  (dependsOnMethods = "createFeedAnimal")
    public void readFeedAnimal()
    {
        repo = ctx.getBean(FeedAnimalRepository.class);
        FeedAnimal feed = repo.findOne(id);
        
        Assert.assertEquals(feed.isFeed(), false);
    }
    
    @Test (dependsOnMethods = "readFeedAnimal")
    public void updateFeedAnimal()
    {
        repo = ctx.getBean(FeedAnimalRepository.class);
        FeedAnimal feed = repo.findOne(id);
        Food food = new Food.Builder("dog Master").description("meat").build();
        FeedAnimal newFeed = new FeedAnimal.Builder(true).feedAnimal(feed).Food(food).build();
        repo.save(newFeed);
        
        FeedAnimal updatedFeed = repo.findOne(id);
        
        Assert.assertEquals(updatedFeed.getFood().getDescription(), "meat");
        
    }
    @Test  (dependsOnMethods = "updateFeedAnimal")
    public void deleteFeedAnimal()
    {
        repo = ctx.getBean(FeedAnimalRepository.class);
        FeedAnimal feed = repo.findOne(id);
        
        repo.delete(feed);
       
        FeedAnimal deletedFeed = repo.findOne(id);
        Assert.assertNull(deletedFeed);
        
    }
    @BeforeClass
    public static void setUpClass() throws Exception {
        
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }
    @AfterClass
    public void tearDownClass() throws Exception {
        
        repo = ctx.getBean(FeedAnimalRepository.class);
        repo.deleteAll();
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}

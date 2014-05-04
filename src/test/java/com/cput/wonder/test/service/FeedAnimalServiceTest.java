/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.wonder.test.service;

import com.cput.my.wonder.app.config.ConnectionConfig;
import com.cput.my.wonder.domain.Animal;
import com.cput.my.wonder.domain.FeedAnimal;
import com.cput.my.wonder.domain.Food;
import com.cput.my.wonder.repository.AdoptAnimalRepository;
import com.cput.my.wonder.repository.FeedAnimalRepository;
import com.cput.my.wonder.services.FeedAnimalService;
import com.cput.my.wonder.services.InventoryService;
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
public class FeedAnimalServiceTest {
    
    private static ApplicationContext ctx;
    private FeedAnimalService service;
    private InventoryService InvService;
    private Long id;
    private FeedAnimalRepository repo;
    
    public FeedAnimalServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
     @Test
     public void AddFood() {
         
         InvService = ctx.getBean(InventoryService.class);
         service = ctx.getBean(FeedAnimalService.class);
             
         Food food = new Food.Builder("meat").description("Chicken thighs").build();
         InvService.addFood(food, 50);
         Assert.assertEquals(service.getFoodOnStock().size(), 1);
         
     }     
     
     @Test (dependsOnMethods = "AddFood")
     public void checkFoodOnStock()
     {
         service = ctx.getBean(FeedAnimalService.class);
         
         Assert.assertEquals(service.getFoodOnStock().get(0).getInventory().getQuantityStock(), 50);
     }
    
     @Test  (dependsOnMethods = "checkFoodOnStock")
     public void feedAnimal() {
         service = ctx.getBean(FeedAnimalService.class);
         Animal animal = new Animal.Builder(2).Name("sasa").Species("Dog").Color("white").isAdopted(false).build();
         List<Animal> ani = new ArrayList<>();
         ani.add(animal);
         service.FeedAnimal(ani);
         
         Assert.assertEquals(service.getFoodOnStock().get(0).getInventory().getQuantityStock(), 49);
         
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

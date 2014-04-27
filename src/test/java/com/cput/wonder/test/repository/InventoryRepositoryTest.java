/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.wonder.test.repository;

import com.cput.my.wonder.app.config.ConnectionConfig;
import com.cput.my.wonder.domain.Inventory;
import com.cput.my.wonder.repository.InventoryRepository;
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
public class InventoryRepositoryTest {
    
    public InventoryRepositoryTest() {
    }
    private static ApplicationContext ctx;
    private Long id;
    private InventoryRepository repo;
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
    public void createInventory() {
        repo = ctx.getBean(InventoryRepository.class);
        
        Inventory inv = new Inventory.Builder(5).date("23/06/2014").build();
        repo.save(inv);
        id = inv.getId();
        
        Assert.assertEquals(inv.getQuantityStock(),5);            
    }
    
    @Test  (dependsOnMethods = "createInventory")
    public void readInventory()
    {
        repo = ctx.getBean(InventoryRepository.class);
        Inventory inv = repo.findOne(id);
        
        Assert.assertEquals(inv.getQuantityStock(), 5);
    }
    
    @Test (dependsOnMethods = "readInventory")
    public void updateInventory()
    {
        repo = ctx.getBean(InventoryRepository.class);
        Inventory inv = repo.findOne(id);
        
        Inventory newInv = new Inventory.Builder(5).inventoryFood(inv).date("22/07/2014").build();
        repo.save(newInv);
        
        Inventory updatedInv = repo.findOne(id);
        
        Assert.assertEquals(updatedInv.getDate(), "22/07/2014");
        
    }
    @Test  (dependsOnMethods = "updateInventory")
    public void deleteInventory()
    {
        repo = ctx.getBean(InventoryRepository.class);
        Inventory inv = repo.findOne(id);
        
        repo.delete(inv);
       
        Inventory deletedInv = repo.findOne(id);
        Assert.assertNull(deletedInv);
        
    }
    @BeforeClass
    public static void setUpClass() throws Exception {
        
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public  void tearDownClass() throws Exception {
           repo = ctx.getBean(InventoryRepository.class);
        repo.deleteAll(); 
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.wonder.test.repository;

import com.cput.my.wonder.app.config.ConnectionConfig;
import com.cput.my.wonder.domain.Supplier;
import com.cput.my.wonder.repository.SupplierRepository;
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
public class SupplierRepositoryTest {
    
    private static ApplicationContext ctx;
    private Long id;
    private SupplierRepository repo;
    public SupplierRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
    public void createSupplier() {
        repo = ctx.getBean(SupplierRepository.class);
        
        Supplier supplier = new Supplier.Builder("John Carter").CompanyName("Food for animals").SupplyingType("Food").build();
        
        repo.save(supplier);
        id = supplier.getID();
        
        Assert.assertEquals(supplier.getSupplyingType(),"Food");            
    }
    
    @Test  (dependsOnMethods = "createSupplier")
    public void readSupplier()
    {
        repo = ctx.getBean(SupplierRepository.class);
        Supplier supplier = repo.findOne(id);
        
        Assert.assertEquals(supplier.getName(), "John Carter");
    }
    
    @Test (dependsOnMethods = "readSupplier")
    public void updateSupplier()
    {
        repo = ctx.getBean(SupplierRepository.class);
        Supplier supplier = repo.findOne(id);
        
        Supplier newSupplier = new Supplier.Builder("John Carter").Supplier(supplier).CompanyName("Food for Dogs").build();
        repo.save(newSupplier);
        
        Supplier updatedSupplier = repo.findOne(id);
        
        Assert.assertEquals(updatedSupplier.getCompanyName(), "Food for Dogs");
        
    }
    @Test  (dependsOnMethods = "updateSupplier")
    public void deleteSupplier()
    {
        repo = ctx.getBean(SupplierRepository.class);
        Supplier supplier = repo.findOne(id);
        
        repo.delete(supplier);
       
        Supplier deletedSupplier = repo.findOne(id);
        Assert.assertNull(deletedSupplier);
        
    }
    @BeforeClass
    public static void setUpClass() throws Exception {
        
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public void tearDownClass() throws Exception {
        
        repo = ctx.getBean(SupplierRepository.class);
        repo.deleteAll();
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}

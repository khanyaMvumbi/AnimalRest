/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.wonder.test.repository;

import com.cput.my.wonder.app.config.ConnectionConfig;
import com.cput.my.wonder.domain.EmployeePositions;
import com.cput.my.wonder.domain.Supplier;
import com.cput.my.wonder.repository.EmployeePositionsRepository;
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
public class EmployeePositionsRepositoryTest {
    
    private static ApplicationContext ctx;
    private Long id;
    private EmployeePositionsRepository repo;
    
    public EmployeePositionsRepositoryTest() {
    }   
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createEmployeePositions() {
        repo = ctx.getBean(EmployeePositionsRepository.class);
        
        EmployeePositions position = new EmployeePositions.Builder("Secretary").objectives("Do the filing").build();
        
        repo.save(position);
        id = position.getId();       
        Assert.assertEquals(position.getJobType(), "Secretary");            
    }
    
    @Test  (dependsOnMethods = "createEmployeePositions")
    public void readEmployeePositions()
    {
        repo = ctx.getBean(EmployeePositionsRepository.class);
        EmployeePositions position = repo.findOne(id);
        
        Assert.assertEquals(position.getObjectives(), "help Customer");
    }
    
    @Test (dependsOnMethods = "readSupplier")
    public void updateEmployeePositions()
    {
        repo = ctx.getBean(EmployeePositionsRepository.class);
        EmployeePositions Position = repo.findOne(id);
        
        EmployeePositions newPosition = new EmployeePositions.Builder("Secretary").EmployeePositions(Position).objectives("help customers").build();
        repo.save(newPosition);
        
        EmployeePositions updatedPosition = repo.findOne(id);
        
        Assert.assertEquals(updatedPosition.getObjectives(), "help Customers");
        
    }
    @Test  (dependsOnMethods = "updateSupplier")
    public void deleteEmployeePositions()
    {
        repo = ctx.getBean(EmployeePositionsRepository.class);
        EmployeePositions Position= repo.findOne(id);
        
        repo.delete(Position);
       
        EmployeePositions deletedPosition = repo.findOne(id);
        Assert.assertNull(deletedPosition);
        
    }
    @BeforeClass
    public static void setUpClass() throws Exception {        
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public void tearDownClass() throws Exception {
        repo = ctx.getBean(EmployeePositionsRepository.class);
        repo.deleteAll();
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}

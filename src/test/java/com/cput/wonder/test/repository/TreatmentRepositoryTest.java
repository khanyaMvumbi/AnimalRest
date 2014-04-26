/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.wonder.test.repository;

import com.cput.my.wonder.app.config.ConnectionConfig;
import com.cput.my.wonder.domain.Treatment;
import com.cput.my.wonder.repository.EmployeeRepository;
import com.cput.my.wonder.repository.TreatmentRepository;
import static com.cput.wonder.test.repository.EmployeeRepositoryTest.ctx;
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
public class TreatmentRepositoryTest {
    
    public static ApplicationContext ctx;
    private Long id;
    private TreatmentRepository repo;
    
    public TreatmentRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createTreatment() {
        repo = ctx.getBean(TreatmentRepository.class);
        
        Treatment treatment = new Treatment.Builder("4444").ExpiryDate("12/05/2014").Description("iyeza elinyanga inyongo").Instructions("Thatha icephe libe linye nge mini").build();
        repo.save(treatment);
        id = treatment.getId();
        Assert.assertEquals(treatment.getTreatmentNO(), "4444");
    }   
    
    @Test
    public void readTreatment()
    {
        repo = ctx.getBean(TreatmentRepository.class);
        Treatment treatment = repo.findOne(id);
        
        Assert.assertEquals(treatment.getTreatmentNO(), "4444");
               
    }
    
    @Test
    public void updateTreatment()
    {
        repo = ctx.getBean(TreatmentRepository.class);
        Treatment treatment = repo.findOne(id);
        
        Treatment updateTreatment = new Treatment.Builder("4444").treatment(treatment).ExpiryDate("12/11/2014").build();
        repo.save(updateTreatment);
        
        Treatment updatedTreatment = repo.findOne(id);
        Assert.assertEquals(updatedTreatment.getExpiryDate() , "12/11/2014");
        
    }
    
    @Test
    public void deleteTreatment()
    {
        repo = ctx.getBean(TreatmentRepository.class);
        Treatment treatment = repo.findOne(id);
        
        repo.delete(treatment);
        
        Assert.assertNull(treatment);
        
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

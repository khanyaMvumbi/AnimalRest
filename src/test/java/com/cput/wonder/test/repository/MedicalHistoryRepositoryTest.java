/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.wonder.test.repository;

import com.cput.my.wonder.app.config.ConnectionConfig;
import com.cput.my.wonder.domain.MedicalHistory;
import com.cput.my.wonder.repository.MedicalHistoryRepository;
import com.cput.my.wonder.repository.TreatmentRepository;
import static com.cput.wonder.test.repository.TreatmentRepositoryTest.ctx;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
public class MedicalHistoryRepositoryTest {
    
    public static ApplicationContext ctx;
    private Long id;
    private MedicalHistoryRepository repo;
    
    public MedicalHistoryRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    //@Test
    public void createMedicalHistory() {
         repo = ctx.getBean(MedicalHistoryRepository.class);
                  
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

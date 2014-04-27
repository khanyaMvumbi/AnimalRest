/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.wonder.test.repository;

import com.cput.my.wonder.app.config.ConnectionConfig;
import com.cput.my.wonder.domain.Habitat;
import com.cput.my.wonder.domain.ServiceHabitat;
import com.cput.my.wonder.repository.ServiceHabitatRepository;
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
public class ServiceHabitatRepositoryTest {

    private static ApplicationContext ctx;
    private Long id;
    private ServiceHabitatRepository repo;
   
    public ServiceHabitatRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createServiceHabitat() {
        repo = ctx.getBean(ServiceHabitatRepository.class);
       Habitat newHabitat = new Habitat.Builder(2).unit("A").block("D").build();
        List<Habitat> habitat = new ArrayList<>();
        habitat.add(newHabitat);
 
        ServiceHabitat service = new ServiceHabitat.Builder(false).habitat(habitat).build();
        repo.save(service);
        id = service.getId();

        Assert.assertEquals(service.getHabitat().get(0).getRoom(), 2);
    }

    @Test(dependsOnMethods = "createServiceHabitat")
    public void readServiceHabitat() {
        repo = ctx.getBean(ServiceHabitatRepository.class);
        ServiceHabitat service = repo.findOne(id);

        Assert.assertFalse(service.isClean());
    }

    @Test(dependsOnMethods = "readServiceHabitat")
    public void updateServiceHabitat() {
        repo = ctx.getBean(ServiceHabitatRepository.class);
        ServiceHabitat serv = repo.findOne(id);
        
        Habitat newHabitat = new Habitat.Builder(4).unit("A").block("E").build();
        List<Habitat> habitat = new ArrayList<>();
        habitat.add(newHabitat);
//        
        
        ServiceHabitat newServ = new ServiceHabitat.Builder(false).serviceHabitat(serv).habitat(habitat).build();
        repo.save(newServ);

        ServiceHabitat updatedServ = repo.findOne(id);

        Assert.assertEquals(newServ.getHabitat().get(0).getBlock(), "E");

    }

    @Test(dependsOnMethods = "updateServiceHabitat")
    public void deleteServiceHabitat() {
        repo = ctx.getBean(ServiceHabitatRepository.class);
        ServiceHabitat service = repo.findOne(id);

        repo.delete(service);

        ServiceHabitat deletedservice = repo.findOne(id);
        Assert.assertNull(deletedservice);

    }

    @BeforeClass
    public static void setUpClass() throws Exception {

        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public void tearDownClass() throws Exception {
        repo = ctx.getBean(ServiceHabitatRepository.class);
        repo.deleteAll();
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}

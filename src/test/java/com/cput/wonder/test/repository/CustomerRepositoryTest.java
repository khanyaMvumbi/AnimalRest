/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.wonder.test.repository;

import com.cput.my.wonder.app.config.ConnectionConfig;
import com.cput.my.wonder.domain.AdoptAnimal;
import com.cput.my.wonder.domain.Animal;
import com.cput.my.wonder.domain.Customer;
import com.cput.my.wonder.repository.AnimalRepository;
import com.cput.my.wonder.repository.CustomerRepository;
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
public class CustomerRepositoryTest {
    
    private static ApplicationContext ctx;
    private Long id;
    private CustomerRepository repo;
    
    public CustomerRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createCustomer() {
    
     repo = ctx.getBean(CustomerRepository.class);
     
     List<Animal> animals = new ArrayList<>();
     Animal ani = new Animal.Builder(12).build();
     animals.add(ani);
     ani = new Animal.Builder(17).build();
     animals.add(ani);
     
     AdoptAnimal adopt = new AdoptAnimal.Builder(animals).build();
     Customer cust = new Customer.Builder("12321").CustName("Khanya").CustSurname("Mvumbi").Adopt(adopt).build();
     
     repo.save(cust);
     id = cust.getID();
     Customer newCust = repo.findOne(id);
     Assert.assertEquals(newCust.getCustName(), "Khanya");
     }
    
    @Test (dependsOnMethods = "createCustomer")
    public void readCustomer()
    {
        repo = ctx.getBean(CustomerRepository.class);
        Customer customer = repo.findOne(id);        
        Assert.assertEquals(customer.getCustName(), "Khanya");
                
    }
    
    @Test (dependsOnMethods = "readCustomer")
    public void updateCustomer()
    {
        repo = ctx.getBean(CustomerRepository.class);
        Customer customer = repo.findOne(id); 
        
        Customer updateCustomer = new Customer.Builder("1221").customer(customer).CustName("Anele").build();
        repo.save(updateCustomer);
        
        Customer updatedCustomer = repo.findOne(id);
        Assert.assertEquals(updatedCustomer.getCustName(), "Anele");
    }
    @Test   (dependsOnMethods = "updateCustomer")
    public void deleteCustomer()
    {
        repo = ctx.getBean(CustomerRepository.class);
        Customer customer = repo.findOne(id);
        repo.delete(customer);
        Customer deletedCustomer = repo.findOne(id);
        Assert.assertNull(deletedCustomer);
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

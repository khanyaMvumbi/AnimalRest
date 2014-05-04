/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.wonder.test.service;

import com.cput.my.wonder.app.config.ConnectionConfig;
import com.cput.my.wonder.domain.Animal;
import com.cput.my.wonder.domain.Customer;
import com.cput.my.wonder.domain.Employee;
import com.cput.my.wonder.repository.CustomerRepository;
import com.cput.my.wonder.services.CustomerService;
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
public class CustomerServiceTest {
    
    private static ApplicationContext ctx;
    private CustomerService service;
    private Long id;
    private CustomerRepository repo;
    
    public CustomerServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void getCustomers() {
         service = ctx.getBean(CustomerService.class);
         
        Assert.assertEquals(service.getCustomers().size(),0 );
         
     }
     
     @Test (dependsOnMethods = "getCustomers")
     public void customerAdoptAnimal() {
         service = ctx.getBean(CustomerService.class);
         List<Animal> animals = new ArrayList<>();
         
         Employee emp = new Employee.Builder("3443").EmpName("Sigqibo").EmpSurname("Memani").build();
         
         Animal animal = new Animal.Builder(3).Name("papa").Species("DOg").Color("white").isAdopted(false).build();
         animals.add(animal);
         
         animal = new Animal.Builder(7).Name("dada").Species("Dog").Color("black").isAdopted(false).build();
         animals.add(animal);
         
         Customer cust = new Customer.Builder("3333").CustName("Sizwe").CustSurname("Ndodo").build();
         service.adoptAnimal(animals, cust, emp);
         id = service.getCustomers().get(0).getID();
         cust = service.searchCustomer(id);
         Assert.assertEquals(cust.getAdopt().getId(), service.getCustomers().get(0).getAdopt().getId());
             
     }
     
      @Test (dependsOnMethods = "customerAdoptAnimal")
     public void searchCustomers() {
         service = ctx.getBean(CustomerService.class);
         
         Customer cust = service.searchCustomer(id);
         Assert.assertEquals(cust.getCustName(), "Sizwe");
         
     }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public void tearDownClass() throws Exception {
        repo = ctx.getBean(CustomerRepository.class);
        repo.deleteAll();
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}

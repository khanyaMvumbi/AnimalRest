/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.wonder.test.repository;

import com.cput.my.wonder.app.config.ConnectionConfig;
import com.cput.my.wonder.domain.Animal;
import com.cput.my.wonder.domain.Employee;
import com.cput.my.wonder.domain.FeedAnimal;
import com.cput.my.wonder.repository.CustomerRepository;
import com.cput.my.wonder.repository.EmployeeRepository;
import java.util.ArrayList;
import java.util.List;
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
public class EmployeeRepositoryTest {
    
    public static ApplicationContext ctx;
    private Long id;
    private EmployeeRepository repo;
    
    public EmployeeRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void createEmployee() {
         repo = ctx.getBean(EmployeeRepository.class);
         
         Animal ani = new Animal.Builder(33).Name("sunji").Species("elephant").build();
         List<Animal> animal = new ArrayList<>();
         animal.add(ani);
         FeedAnimal feed = new FeedAnimal.Builder(true).animalList(animal).build();
         
         Employee emp = new Employee.Builder("1331").EmpName("Azola").EmpSurname("Nxanti").FeedAnimal(feed).build();
         
         repo.save(emp);
         id = emp.getEmpID();
         
         Assert.assertEquals(emp.getEmpNumber(), "1331");
     
     }
     
     @Test
     public void readEmployee()
     {
         repo = ctx.getBean(EmployeeRepository.class);
        Employee employee = repo.findOne(id);        
        Assert.assertEquals(employee.getEmpName(), "Azola");
     }
     
     @Test
     public void updateEmployee()
     {
        repo = ctx.getBean(EmployeeRepository.class);
        Employee employee = repo.findOne(id);
        
        Employee updateEmp = new Employee.Builder("1331").EmpSurname("Nako").build();
        Employee updatedEmp = repo.findOne(id);
        
        Assert.assertEquals(updatedEmp.getEmpSurname(), "Nako");
        
     }
     
     @Test
     public void deleteEmployee()
     {
        repo = ctx.getBean(EmployeeRepository.class);
        Employee employee = repo.findOne(id);
        
        repo.delete(employee);
        Assert.assertNull(employee);         
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

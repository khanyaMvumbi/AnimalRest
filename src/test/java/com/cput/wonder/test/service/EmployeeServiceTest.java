/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.wonder.test.service;

import com.cput.my.wonder.app.config.ConnectionConfig;
import com.cput.my.wonder.domain.Employee;
import com.cput.my.wonder.repository.CustomerRepository;
import com.cput.my.wonder.repository.EmployeeRepository;
import com.cput.my.wonder.services.CustomerService;
import com.cput.my.wonder.services.EmployeeService;
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
public class EmployeeServiceTest {
    
    private static ApplicationContext ctx;
    private EmployeeService service;
    private Long id;
    private EmployeeRepository repo;
    
    public EmployeeServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    @Test
     public void getEmployees() {
         service = ctx.getBean(EmployeeService.class);
         
         Assert.assertEquals(service.getEmployees().size(), 0);
         
     }
    
     @Test   (dependsOnMethods = "getEmployees")
     public void addEmployee() {
     
         service = ctx.getBean(EmployeeService.class);
         Employee emp = new Employee.Builder("4224").EmpName("qulequ").EmpSurname("mavazana").build();
         service.addNewEmployee(emp);
         id = emp.getEmpID();
         Assert.assertEquals(service.getEmployees().get(0).getEmpName(), "qulequ");
         
     }
     
     @Test (dependsOnMethods = "addEmployee")
     public void deleteEmployee() {
         service = ctx.getBean(EmployeeService.class);
         
         Assert.assertEquals(service.getEmployees().size(), 1);
         
         service.deleteEmployee(id);
         
         Assert.assertEquals(service.getEmployees().size(), 0);
     }
     

    @BeforeClass
    public static void setUpClass() throws Exception {
     ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public void tearDownClass() throws Exception {
        repo = ctx.getBean(EmployeeRepository.class);
        repo.deleteAll();
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}

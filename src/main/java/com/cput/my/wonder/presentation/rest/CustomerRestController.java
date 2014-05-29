/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.my.wonder.presentation.rest;

import com.cput.my.wonder.domain.Animal;
import com.cput.my.wonder.domain.Customer;
import com.cput.my.wonder.domain.Employee;
import com.cput.my.wonder.services.AnimalService;
import com.cput.my.wonder.services.CustomerService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Khanya
 */
@Controller
@RequestMapping (value = "rest/customer")
public class CustomerRestController {
   @Autowired
    private CustomerService customerService;
    
    @RequestMapping (value = "create", method = RequestMethod.POST)
    @ResponseBody
    public String createAnimal(@RequestBody Customer cust)
    {
        Employee emp = new Employee.Builder("2112").build();  
        List<Animal> animals = new ArrayList<>();
        customerService.adoptAnimal(animals, cust, emp);
        return "animal created";
    }
    
    @RequestMapping (value = "animals", method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> getCustomers()
    {
        return customerService.getCustomers();
     }
    
    @RequestMapping (value = "id/{id}",method = RequestMethod.GET )
    @ResponseBody
    public Customer getAnimal(@PathVariable Long id)
    {
        return customerService.searchCustomer(id);
    }
   
    
}
 


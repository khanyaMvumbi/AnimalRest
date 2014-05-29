/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.my.wonder.services.Impl;

import com.cput.my.wonder.domain.AdoptAnimal;
import com.cput.my.wonder.domain.Animal;
import com.cput.my.wonder.domain.Customer;
import com.cput.my.wonder.domain.Employee;
import com.cput.my.wonder.repository.CustomerRepository;
import com.cput.my.wonder.services.CustomerService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Khanya
 */
@Service
public class CustomerServicesImpl implements CustomerService{
    
    @Autowired
    private CustomerRepository animalRepo;
        
    @Override
    public List<Customer> getCustomers() {
        return animalRepo.findAll();
    }

    @Override
    public void adoptAnimal(List<Animal> animal, Customer cust, Employee employee) {
        
        AdoptAnimal adopt = new AdoptAnimal.Builder(animal).build();
        
        Customer newCust = new Customer.Builder("1212").customer(cust).Adopt(adopt).build();
        List<Customer>listCustomers = new ArrayList<>();
        listCustomers.add(cust);
       
        Employee emp  = new Employee.Builder("1344").employee(employee).ListOfCustomers(listCustomers).build();
        animalRepo.save(newCust);
    }

    @Override
    public Customer searchCustomer(Long id) {
       return animalRepo.findOne(id);
    }

    

    
}

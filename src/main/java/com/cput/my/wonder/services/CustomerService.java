/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.my.wonder.services;

import com.cput.my.wonder.domain.Animal;
import com.cput.my.wonder.domain.Customer;
import com.cput.my.wonder.domain.Employee;
import java.util.List;

/**
 *
 * @author Khanya
 */
public interface CustomerService{
    
   public List<Customer> getCustomers();
   public void adoptAnimal(List<Animal> animal, Customer cust, Employee employee);
   public Customer searchCustomer(Long id);
     
}

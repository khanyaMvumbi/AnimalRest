/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.my.wonder.presentation;

import com.cput.my.wonder.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Khanya
 */
@Service
public class CustomerController {
  
    @Autowired
    private CustomerService customerService;
    
    @RequestMapping (value = "customer", method = RequestMethod.GET)
    private String getCustomer()
    {
        
        return "customer";        
    }
    
}

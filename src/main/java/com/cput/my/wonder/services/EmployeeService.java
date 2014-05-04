/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.my.wonder.services;

import com.cput.my.wonder.domain.Employee;
import java.util.List;

/**
 *
 * @author Khanya
 */
public interface EmployeeService {
    
   public List<Employee> getEmployees();
   public void addNewEmployee(Employee employee);
   public void deleteEmployee(Long id);
  
     
}

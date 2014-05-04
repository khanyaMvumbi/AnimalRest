/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.my.wonder.services.Impl;

import com.cput.my.wonder.domain.Employee;
import com.cput.my.wonder.repository.EmployeeRepository;
import com.cput.my.wonder.services.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Khanya
 */
@Service
public class EmployeeServicesImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository repo;
    
    @Override
    public List<Employee> getEmployees() {
           return repo.findAll();
    }

    @Override
    public void addNewEmployee(Employee employee) {
         repo.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
         repo.delete(id);
    }
    
}

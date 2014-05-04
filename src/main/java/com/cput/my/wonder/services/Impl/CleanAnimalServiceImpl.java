/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.my.wonder.services.Impl;

import com.cput.my.wonder.domain.Animal;
import com.cput.my.wonder.domain.ServiceAnimal;
import com.cput.my.wonder.repository.ServiceAnimalRepository;
import com.cput.my.wonder.services.CleanAnimalService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Khanya
 */
@Service
public class CleanAnimalServiceImpl implements CleanAnimalService{

    @Autowired
    private ServiceAnimalRepository repo;
    
    @Override
    public List<ServiceAnimal> getServicedAnimals() {
       return repo.findAll();
    }

    @Override
    public void cleanAnimal(List<Animal> animal) {
        
    }
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.my.wonder.services.Impl;

import com.cput.my.wonder.services.ListOfAdoptedAnimalService;
import com.cput.my.wonder.domain.AdoptAnimal;
import com.cput.my.wonder.repository.AdoptAnimalRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Khanya
 */
@Service
public class ListOfAdoptedAnimalServicesImpl implements ListOfAdoptedAnimalService{
    
    @Autowired
    private AdoptAnimalRepository repo;
        
    @Override
    public List<AdoptAnimal> getAdoptedAnimals() {
        return repo.findAll();
    }    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.my.wonder.services.Impl;

import com.cput.my.wonder.domain.AnimalHealth;
import com.cput.my.wonder.repository.AnimalHealthRepository;
import com.cput.my.wonder.services.AnimalInfectionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Khanya
 */

@Service
public class AnimalInfectionServiceImpl implements AnimalInfectionService {
    
    @Autowired
    private AnimalHealthRepository repo;
    
    @Override
    public AnimalHealth checkAnimalInfection(Long id)
    {
        return repo.findOne(id);
        
    }

    @Override
    public void addInfection(AnimalHealth health) {
        repo.save(health);
    }
    
}

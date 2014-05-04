/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.my.wonder.services.Impl;

import com.cput.my.wonder.domain.Animal;
import com.cput.my.wonder.domain.AnimalOwner;
import com.cput.my.wonder.repository.AnimalOwnerRepository;
import com.cput.my.wonder.services.AnimalOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Khanya
 */
@Service
public class AnimalOwnerServiceImpl implements AnimalOwnerService{

    @Autowired
    private AnimalOwnerRepository repo;
    
    @Override
    public AnimalOwner findAnimalOwner(Long id) {
            return repo.findOne(id);
    }

    @Override
    public void newAnimalOwner(AnimalOwner owner) {
        repo.save(owner);   
    }
    
    
    
    
    
}

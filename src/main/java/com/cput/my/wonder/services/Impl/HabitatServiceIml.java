/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.my.wonder.services.Impl;

import com.cput.my.wonder.domain.Habitat;
import com.cput.my.wonder.repository.HabitatRepository;
import com.cput.my.wonder.services.HabitatService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Khanya
 */
@Service
public class HabitatServiceIml implements HabitatService{

    @Autowired
    private HabitatRepository repo;
    
    @Override
    public List<Habitat> getAvailableHabitats() {
        return repo.findAll();
    }

    @Override
    public void newHabitat(Habitat habi) {
        repo.save(habi);
        
    }
    
}

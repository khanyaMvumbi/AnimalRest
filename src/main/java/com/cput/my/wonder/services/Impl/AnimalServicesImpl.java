/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.my.wonder.services.Impl;

import com.cput.my.wonder.services.AnimalService;
import com.cput.my.wonder.domain.Animal;
import com.cput.my.wonder.repository.AnimalRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Khanya
 */
@Service
public class AnimalServicesImpl implements AnimalService{

    @Autowired
    private AnimalRepository animalRepo;
        
    @Override
    public List<Animal> getAnimals() {
        return animalRepo.findAll();
    }

    @Override
    public void addNewAnimal(Animal animal) {     
        animalRepo.save(animal);                
    }
    @Override
    public Animal searchAnimal(Long id) {
     return animalRepo.findOne(id);
    }

    @Override
    public void deleteAnimal(Long id) {
       if(animalRepo.exists(id)) 
           animalRepo.delete(id);
       else
           System.out.println("Id doesn't exist");
       
    }

}

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
    public Animal find(Long id) {
        return animalRepo.findOne(id);}

    @Override
    public Animal persist(Animal entity) {
        return animalRepo.save(entity);   }

    @Override
    public Animal merge(Animal entity) {
        
        if(entity.getId() != null)
        {
            return animalRepo.save(entity);  
        }
        else
            return null;
    }

    @Override
    public void remove(Animal entity) {
       if(animalRepo.exists(entity.getId())) 
           animalRepo.delete(entity);
       else
           System.out.println("Id doesn't exist");
    }

    @Override
    public List<Animal> findAll() {
        return animalRepo.findAll();
    }

    @Override
    public Animal getAnimalByName(String name) {
        List<Animal> animals = findAll();
        Animal foundAnimal = null;
        
        for (Animal animal : animals ){
            if(animal.getName().equalsIgnoreCase(name)) {
                foundAnimal = animal;            
            }
        }
        return foundAnimal;

    }
}

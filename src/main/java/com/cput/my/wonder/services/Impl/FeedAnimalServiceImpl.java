/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.my.wonder.services.Impl;

import com.cput.my.wonder.domain.Animal;
import com.cput.my.wonder.domain.FeedAnimal;
import com.cput.my.wonder.domain.Food;
import com.cput.my.wonder.domain.Inventory;
import com.cput.my.wonder.repository.FeedAnimalRepository;
import com.cput.my.wonder.services.FeedAnimalService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Khanya
 */
@Service
public class FeedAnimalServiceImpl implements FeedAnimalService{

    @Autowired
    private FeedAnimalRepository repo;
    
    @Override
    public List<FeedAnimal> getFoodOnStock() {
        return repo.findAll();
    }

    @Override
    public void FeedAnimal(List<Animal> animal) {
              
        if(getFoodOnStock().get(0).getInventory().getQuantityStock() >= animal.size())
        {
           int foodLeft = getFoodOnStock().get(0).getInventory().getQuantityStock() - animal.size();
                                 
           Inventory inv = new Inventory.Builder().inventoryFood(getFoodOnStock().get(0).getInventory()).quantity(foodLeft).build();
           
           FeedAnimal feed = new FeedAnimal.Builder(true).feedAnimal(getFoodOnStock().get(0)).animalList(animal).Inventory(inv).build();
           
           repo.save(feed);           
       }
       else
           System.out.println("no more food available");
       
    }
    
    
}

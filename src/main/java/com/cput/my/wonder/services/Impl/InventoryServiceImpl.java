/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.my.wonder.services.Impl;

import com.cput.my.wonder.domain.FeedAnimal;
import com.cput.my.wonder.domain.Food;
import com.cput.my.wonder.domain.Inventory;
import com.cput.my.wonder.repository.FeedAnimalRepository;
import com.cput.my.wonder.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Khanya
 */
@Service
public class InventoryServiceImpl implements InventoryService{

    @Autowired
    private FeedAnimalRepository repo;
    
    @Override
    public void addFood(Food food, int stock) {
        Inventory inv = new Inventory.Builder().quantity(stock).date("12/05/2014").build();
        FeedAnimal feed = new FeedAnimal.Builder(false).Food(food).Inventory(inv).build();        
        repo.save(feed);
        
    }
    
}

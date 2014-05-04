/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.my.wonder.services;

import com.cput.my.wonder.domain.Animal;
import com.cput.my.wonder.domain.FeedAnimal;
import java.util.List;

/**
 *
 * @author Khanya
 */
public interface FeedAnimalService {
    
    public List <FeedAnimal> getFoodOnStock();
    public void FeedAnimal(List<Animal> animal); 
    }

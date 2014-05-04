/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.my.wonder.services;

import com.cput.my.wonder.domain.Animal;
import com.cput.my.wonder.domain.AnimalOwner;

/**
 *
 * @author Khanya
 */
public interface AnimalOwnerService {
    
    public AnimalOwner findAnimalOwner(Long id);
    public void newAnimalOwner(AnimalOwner owner);
    
            
}

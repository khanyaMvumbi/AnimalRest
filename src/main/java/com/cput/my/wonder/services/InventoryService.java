/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.my.wonder.services;

import com.cput.my.wonder.domain.Food;

/**
 *
 * @author Khanya
 */
public interface InventoryService {
    
    public void addFood(Food food, int stock);
    
}

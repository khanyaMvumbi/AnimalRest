/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.my.wonder.repository;

import com.cput.my.wonder.domain.FeedAnimal;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Khanya
 */


public interface FeedAnimalRepository extends JpaRepository<FeedAnimal, Long>{
    
}

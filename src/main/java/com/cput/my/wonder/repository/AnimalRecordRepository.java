/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.my.wonder.repository;

import com.cput.my.wonder.domain.Animal;
import com.cput.my.wonder.domain.AnimalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Khanya
 */


public interface AnimalRecordRepository extends JpaRepository<AnimalRecord, Long>{
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.my.wonder.services.Impl;

import com.cput.my.wonder.domain.MedicalHistory;
import com.cput.my.wonder.repository.MedicalHistoryRepository;
import com.cput.my.wonder.services.MedicalHistoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Khanya
 */
@Service
public class MedicalHistoryServicesImpl implements MedicalHistoryService{

    @Autowired
    private MedicalHistoryRepository repo;
    
    @Override
    public MedicalHistory checkAnimalHistory(Long id) {
        return repo.findOne(id);
    }
    
}

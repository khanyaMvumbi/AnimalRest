/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.my.wonder.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author Khanya
 */

@Entity
public class MedicalHistory implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long medID;
    private String description;
    private String date;
    
    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "HistoryID")
   private List<AnimalHealth> infection;
    
    private MedicalHistory() {
    }

    private MedicalHistory(Builder build) {
        this.medID = build.medID;
        this.description = build.description;
        this.infection = build.infection;
    }
    
public static class Builder{
    private List<AnimalHealth> infection;
    private Long medID;
    private String description;
   
    public Builder Id(Long id)
        {
            this.medID = id;
            return this;
        }
        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder infection(List<AnimalHealth> infection) {
            this.infection = infection;
            return this;
        }
        public Builder medicalHistory(MedicalHistory hist)
        {
             description = hist.getDescription();
             medID = hist.getMedID();
             infection = hist.getInfection();
             return this;
        }
        public MedicalHistory build()
        {
            return new MedicalHistory(this);
        }      
    
}
    

    
    public Long getMedID() {
        return medID;
    }

    public String getDescription() {
        return description;
    }

    public List<AnimalHealth> getInfection() {
        return infection;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.medID != null ? this.medID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MedicalHistory other = (MedicalHistory) obj;
        if ((this.medID == null) ? (other.medID != null) : !this.medID.equals(other.medID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MedicalHistory{" + "medID=" + medID + '}';
    }
    
    
    
   
    
}

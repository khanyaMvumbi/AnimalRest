/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.my.wonder.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Khanya
 */

@Entity
public class Treatment implements Serializable{
    
    @Column(unique = true)
    private String treatmentNO;
    
    private String description;
    private String expiryDate;
    private String instructions;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Treatment() {
    }

    private Treatment(Builder build) {
        this.id = build.id;
        this.treatmentNO = build.treatmentNO;
        this.description = build.description;
        this.expiryDate = build.expiryDate;
        this.instructions = build.instructions;
    }

    public static class Builder{
        private Long id;
        private String treatmentNO;
        private String description;
        private String expiryDate;
        private String instructions;
        
        public Builder(String treatmentNO)
        {
               this.treatmentNO = treatmentNO;         
        }

        public Builder Id(Long Id) {
            this.id = Id;
            return this;
        }

        public Builder Description(String description) {
            this.description = description;
            return this;
        }

        public Builder ExpiryDate(String expiryDate) {
            this.expiryDate = expiryDate;
            return this;
        }

        public Builder Instructions(String instructions) {
            this.instructions = instructions;
            return this;
        }  
        
        public Builder treatment(Treatment treat)
        {
            description =  treat.getDescription();
            expiryDate =  treat.getExpiryDate();
            instructions = treat.getInstructions();
            treatmentNO =  treat.getTreatmentNO();
            id = treat.getId();
            return this;
        }
        
        public Treatment build()
        {
            return new Treatment(this);
        }
        
    }
    
    
    
    public String getTreatmentNO() {
        return treatmentNO;
    }

    public String getDescription() {
        return description;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public String getInstructions() {
        return instructions;
    }
    
    public Long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.treatmentNO != null ? this.treatmentNO.hashCode() : 0);
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
        final Treatment other = (Treatment) obj;
        if ((this.treatmentNO == null) ? (other.treatmentNO != null) : !this.treatmentNO.equals(other.treatmentNO)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "Treatment{" + "treatmentNO=" + treatmentNO + '}';
    }

    
    
    
}

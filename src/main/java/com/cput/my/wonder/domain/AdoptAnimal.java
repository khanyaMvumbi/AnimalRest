/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.my.wonder.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
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
public class AdoptAnimal implements Serializable {
    
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
       
    @OneToMany  (cascade = CascadeType.ALL)
    @JoinColumn(name = "adoptionID")
    private List<Animal> animal;

    public AdoptAnimal()
    {
        
    }
    private AdoptAnimal(Builder build) {
         this.id =  build.id;
        this.animal = build.animal;
     }

   
    public static class Builder{
        private Long id;
        private List<Animal> animal;

       public Builder id(Long value) {
            id = value;
            return this;
        }
        public Builder(List<Animal> animal) {
            this.animal = animal;         
        }
        
        public Builder adoptAnimal(AdoptAnimal adopt)
        {
            id = adopt.getId();
            animal = adopt.getAnimal();
            return this;
        }
        
        public AdoptAnimal build()
        {
            return new AdoptAnimal(this);
            
        }
                
    }   
   
     public Long getId() {
        return id;
    }
    
    public List<Animal> getAnimal() {
        return animal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final AdoptAnimal other = (AdoptAnimal) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AdoptAnimal{" + "id=" + id + '}';
    }
    
}

    

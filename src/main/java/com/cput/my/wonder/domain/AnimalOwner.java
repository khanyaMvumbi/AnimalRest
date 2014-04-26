/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.my.wonder.domain;

import java.io.Serializable;
import java.util.List;
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
public class AnimalOwner implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long OwnerID;
    
    private String name;
    private String surname;
    private int age;
    
    @OneToMany
    @JoinColumn(name = "animalID")     
    private List<Animal> animal;
    
    private AnimalOwner()
    {        
    }
    
    private AnimalOwner(Builder build)
    {
        this.OwnerID = build.OwnerID;
        this.age = build.age;
        this.name = build.name;
        this.animal = build.animal;
        this.surname = build.surname;
    }
    public static class Builder{
        private Long OwnerID;
        private String name;
        public String surname;
        private int age;        
          
        private List<Animal> animal;        
                
        public Builder(String name)
        {
            this.name = name;
        }        
        public Builder id(Long value) {
            OwnerID = value;
            return this;
        }
        public Builder Surname(String surname) {
            this.surname = surname;
            return this;
        }
        public Builder Age(int age) {
            this.age = age;
            return this;
        }
        
        public Builder animal(List<Animal> animal ) {
            this.animal = animal;
            return this;
        }

         public Builder animalOwner(AnimalOwner owner)
       {
        this.OwnerID = owner.OwnerID;
        this.age = owner.age;
        this.name = owner.name;
        this.animal = owner.animal;
        this.surname = owner.surname;
        return this;
       }
        public AnimalOwner build()
        {
            return new AnimalOwner(this);
        }   
        
    }

    public Long getOwnerID() {
        return OwnerID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public List<Animal> getAnimal() {
        return animal;
    }

    
    @Override
    public int hashCode(){
        return OwnerID.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AnimalOwner other = (AnimalOwner) obj;
        if ((this.OwnerID == null) ? (other.OwnerID != null) : !this.OwnerID.equals(other.OwnerID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AnimalOwner{" + "OwnerID=" + OwnerID + '}';
    }
    
    
    
    
    
    
    
    
}

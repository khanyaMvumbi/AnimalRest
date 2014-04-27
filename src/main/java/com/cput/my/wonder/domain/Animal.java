/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.my.wonder.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Khanya
 */
@Entity
public class Animal implements Serializable {
private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int age;
    private String species;
    private String color;
    private boolean adopted;

//    One to One Relationship
    @OneToOne  (cascade = CascadeType.ALL)
    @JoinColumn(name = "animalID")
    private Habitat habitat;

    @Embedded
    private AnimalRecord record;
    // One to one 
    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "animalID")
    private List<AnimalStatus> status;
     
    private Animal()
    {
        
    }
    public static class Builder {

        
        private String name;
        private int age;
        private Long id;
        private String species;
        private String color;
        private boolean adopted;
        private Habitat habitat;
        private List<AnimalStatus> status;
        private AnimalRecord record;
        
        public Builder(int age) {
            this.age = age;
        }
        public Builder Record(AnimalRecord record) {
            this.record = record;
            return this;
        }
        
       public Builder id(Long value) {
            id = value;
            return this;
        }
        public Builder Name(String name) {
            this.name = name;
            return this;
        }

        public Builder Species(String species) {
            this.species = species;
            return this;
        }

        public Builder Color(String color) {
            this.color = color;
            return this;
        }

        public Builder isAdopted(boolean adopt) {
            this.adopted = adopt;
            return this;
        }

        public Builder status(List<AnimalStatus> status) {
            this.status = status;
            return this;
        }

        public Builder habitat(Habitat habitat) {
            this.habitat = habitat;
            return this;
        }

        public Builder animal(Animal animal) {
            name = animal.getName();
            species = animal.getSpecies();
            color = animal.getColor();
            id = animal.getId();
            age = animal.getAge();
            adopted = animal.getAdopted();
            habitat = animal.getHabitat();
            status = animal.getStatus();
            record = animal.getRecord();
            return this;

        }

        public Animal build() {
            return new Animal(this);
        }

    }

    private Animal(Builder build) {
        this.id = build.id;
        this.color = build.color;
        this.name = build.name;
        this.species = build.species;
        this.age = build.age;
        this.status = build.status;
        this.adopted = build.adopted;
        this.habitat = build.habitat;
    }

    /**
     * @return the name
     */
    
    public boolean getAdopted()
    {
        return adopted;   
    }
    public AnimalRecord getRecord()
    {
        return record;
    }
    
    public String getName() {
        return name;
    }

    public boolean isAdopted() {
        return adopted;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public List<AnimalStatus> getStatus() {
        return status;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the species
     */
    public String getSpecies() {
        return species;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Animal other = (Animal) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Animal{" + "id=" + id + '}';
    }

}

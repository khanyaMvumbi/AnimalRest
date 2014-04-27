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
public class TransportAnimal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String location;    
    private String transportNumber;
    private String date;

    @OneToMany  (cascade = CascadeType.ALL)
    @JoinColumn(name = "transportID")
    private List<Animal> animals;
    

    private TransportAnimal(Builder build) {
        date = build.date;
        location = build.location;
        animals = build.animals;
        transportNumber = build.transportNumber;
        id = build.id;
    }
    private TransportAnimal()
    {
        
    }
    public static class Builder {

        private Long id;
        private String date;
        private String transportNumber;
        private List<Animal> animals;
        private String location;

        public Builder(String transportNO) {
            this.transportNumber = transportNO;
        }

        public Builder Date(String date) {
            this.date = date;
            return this;
        }
        public Builder Id(Long id)
        {
            this.id = id;
            return this;
        }
        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Builder animals(List<Animal> animals) {
            this.animals = animals;
            return this;
        }

        public Builder transportAnimal(TransportAnimal trans) {
            location = trans.getLocation();
            animals = trans.getAnimals();
            transportNumber = trans.getTransportNumber();
            date = trans.getDate();
            id = trans.getId();
            return this;
            
        }

        public TransportAnimal build() {
            return new TransportAnimal(this);
        }
    }

    public Long getId()
    {
        return id;
    }
    
    public String getDate()
    {
        return date;
    }
    public String getLocation() {
        return location;
    }

    public String getTransportNumber() {
        return transportNumber;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    

    @Override
    public String toString() {
        return "TransportAnimal{" + "id=" + id + ", transportNumber=" + transportNumber + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final TransportAnimal other = (TransportAnimal) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.my.wonder.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
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

    @Column(unique = true)
    private String transportNumber;
    private String date;

    @OneToMany
    @JoinColumn(name = "transportID")
    private List<Animal> animals;
    private String location;

    private TransportAnimal(Builder build) {
        date = build.date;
        location = build.location;
        animals = build.animals;
        location = build.transportNumber;
    }
    private TransportAnimal()
    {
        
    }
    public static class Builder {

        private String date;
        private String transportNumber;
        private List<Animal> animals;
        private String location;

        public Builder(String transport) {
            this.transportNumber = transport;
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
            return this;
        }

        public TransportAnimal build() {
            return new TransportAnimal(this);
        }
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
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.transportNumber != null ? this.transportNumber.hashCode() : 0);
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
        if ((this.transportNumber == null) ? (other.transportNumber != null) : !this.transportNumber.equals(other.transportNumber)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TransportAnimal{" + "id=" + id + ", transportNumber=" + transportNumber + '}';
    }

}

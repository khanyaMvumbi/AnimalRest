/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.my.wonder.domain;

import java.io.Serializable;
import java.util.Date;
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
public class ServiceAnimal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String date;

    @OneToMany  (cascade = CascadeType.ALL)
    @JoinColumn(name = "serviceID")
    private List<Animal> animal;

    private ServiceAnimal()
    {
        
    }
    private ServiceAnimal(Builder build) {
        ID = build.ID;
        date = build.date;
        animal = build.animal;
    }

    public static class Builder {

        private Long ID;
        private String date;
        private List<Animal> animal;
               
        public Builder ID(Long ID) {
          this.ID = ID;
          return this;
        }

        public Builder(String date) {
            this.date = date;           
        }
        public Builder animal(List<Animal> animal) {
            this.animal = animal;
            return this;
        }

        public Builder serviceAnimal(ServiceAnimal service) {
            ID = service.getID();
            date = service.getDate();
            animal = service.getAnimal();
            return this;
        }

        public ServiceAnimal build() {
            return new ServiceAnimal(this);
        }

    }

    public Long getID() {
        return ID;
    }

    public String getDate() {
        return date;
    }

    public List<Animal> getAnimal() {
        return animal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.ID != null ? this.ID.hashCode() : 0);
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
        final ServiceAnimal other = (ServiceAnimal) obj;
        if ((this.ID == null) ? (other.ID != null) : !this.ID.equals(other.ID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ServiceAnimal{" + "ID=" + ID + '}';
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.my.wonder.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Khanya
 */

@Entity
public class AnimalRecord implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String dateArrived;
    private String dateLeave;
    
    private AnimalRecord(Builder build) {
        this.id = build.id;
        this.dateArrived = build.dateArrived;
        this.dateLeave = build.dateLeave;
    }

    public static class Builder {

        private Long id;
        private String dateArrived;
        private String dateLeave;

        public Builder(String dateArrived) {
            this.dateArrived = dateArrived;
        }
         public Builder id(Long value) {
            id = value;
            return this;
        }
        public Builder AnimalRecord(AnimalRecord record) {
            this.dateArrived = record.dateArrived;
            this.dateLeave = record.dateLeave;
            this.id = record.id;
            return this;
        }
        
        public AnimalRecord build() {
            return new AnimalRecord(this);
        }

    }

    public Long getID() {
        return id;
    }
     public String getDateArrived() {
        return dateArrived;
    }
     
     public String getDateLeave() {
        return dateLeave;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
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
        final AnimalRecord other = (AnimalRecord) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AnimalRecord{" + "id=" + id + '}';
    }

}

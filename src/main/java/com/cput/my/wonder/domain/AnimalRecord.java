/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.my.wonder.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

/**
 *
 * @author Khanya
 */

@Embeddable
public class AnimalRecord implements Serializable{
    
    private String dateArrived;
    private String dateLeave;
    
    private AnimalRecord(Builder build) {
        this.dateArrived = build.dateArrived;
        this.dateLeave = build.dateLeave;
    }

    public static class Builder {

        private String dateArrived;
        private String dateLeave;

        public Builder(String dateArrived) {
            this.dateArrived = dateArrived;
        }
        public Builder dateLeave(String dateLeave) {
            this.dateLeave = dateLeave;
            return this;
        }
        
         public Builder id(Long value) {
            return this;
        }
        public Builder AnimalRecord(AnimalRecord record) {
            this.dateArrived = record.dateArrived;
            this.dateLeave = record.dateLeave;
            return this;
        }
        
        public AnimalRecord build() {
            return new AnimalRecord(this);
        }

    }
   public String getDateArrived() {
        return dateArrived;
    }
     
     public String getDateLeave() {
        return dateLeave;
    }

}

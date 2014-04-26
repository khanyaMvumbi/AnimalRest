/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.my.wonder.domain;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Khanya
 */

@Entity
public class AnimalStatus implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long statusID;
    
    private String statusMessage;
    private String date;
    private boolean active;
    
    
    public AnimalStatus()
    {
        
    }
    
    public static class Builder{
        private Long statusID;
        private String statusMessage;
        private String date;
        private boolean active;
        
        public Builder(String status)
        {
            this.statusMessage = status;
        }                
        
        public Builder isActive(boolean active)
        {
            this.active = active;
            return this;
        }
        public Builder date(String date){
            this.date = date;
            return this;
        }
         public Builder id(Long value) {
            statusID = value;
            return this;
        } 
        public Builder status(AnimalStatus status)
        {
            date = status.getDate();
            statusID = status.getStatusID();
            statusMessage = status.getStatusMessage();
            return this;
        }        
        public AnimalStatus build()
        {
           return new AnimalStatus(this);
        }
    }
    
    private AnimalStatus(Builder build) {
        this.statusID = build.statusID;
        this.statusMessage = build.statusMessage;
        this.date = build.date;
    }

    public Long getStatusID() {
        return statusID;
    }
    
    public String getStatusMessage() {
        return statusMessage;
    }

    public String getDate() {
        return date;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.statusID != null ? this.statusID.hashCode() : 0);
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
        final AnimalStatus other = (AnimalStatus) obj;
        if ((this.statusID == null) ? (other.statusID != null) : !this.statusID.equals(other.statusID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AnimalStatus{" + "statusID=" + statusID + '}';
    }
    
    
    
    
    
    
}

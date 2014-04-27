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
public class ServiceHabitat implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private boolean clean;
        
    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "serviceID")
    private List <Habitat> habitat;  
    
    private ServiceHabitat()
    {
         
    }
    private ServiceHabitat(Builder build) {
        this.Id = build.Id;
        this.clean = build.clean;
        this.habitat = build.habitat;
    }
    
    public static class Builder{
        private List <Habitat> habitat;
        private Long Id;
        private boolean clean;

        public Builder (boolean clean) {
            this.clean = clean;            
        }
        
        public Builder habitat(List <Habitat> habitat) {
            this.habitat = habitat; 
            return this;
        }

        public Builder Id(Long Id) {
            this.Id = Id;
            return this;
        }
        
        public Builder serviceHabitat(ServiceHabitat habitat)
        {
            this.clean = habitat.isClean();
            this.Id = habitat.getId();
            this.habitat = habitat.getHabitat();
            return this;
        }
        
        public ServiceHabitat build()
        {
            return new ServiceHabitat(this);
        }      
        
    }
    
    public boolean isClean() {
        return clean;
    }

    public Long getId() {
        return Id;
    }
    
    public List <Habitat> getHabitat()
    {
        return habitat;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.Id);
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
        final ServiceHabitat other = (ServiceHabitat) obj;
        if (!Objects.equals(this.Id, other.Id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ServiceHabitat{" + "Id=" + Id + '}';
    }

    
    
    
}

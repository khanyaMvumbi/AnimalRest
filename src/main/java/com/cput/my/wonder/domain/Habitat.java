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
public class Habitat implements Serializable{

    
    private String block;
    private String unit;
    private int room;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private Habitat()
    {        
    }
    
    private Habitat(Builder build) {
        unit = build.unit;
        block = build.block;
        room = build.room;
        id = build.id;
    }
    
    public static class Builder {

        private Long id;
        private String unit;
        private int room;
        private String block;
  
        public Builder(int room)
        {
            this.room = room;
        }
        
        public Builder Id(Long value)
        {
            this.id = value;        
            return this;
        }
        
        
        public Builder block(String block ) {
            this.block = block;
            return this;
        }
        
        public Builder unit(String unit)
        {
            this.unit = unit;
            return this;
        }
        
        public Builder habitat(Habitat habitat) {
            block = habitat.getBlock();
            unit = habitat.getUnit();
            room = habitat.getRoom();
            id = habitat.getId();
            return this;
        }

        public Habitat build() {

            return new Habitat(this);
        }
    }

    public String getUnit() {
        return unit;
    }

    public int getRoom() {
        return room;
    }

    
    public String getBlock() {
        return block;
    }

    public Long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.block);
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
        final Habitat other = (Habitat) obj;
        if (!Objects.equals(this.block, other.block)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Habitat{" + "block=" + block + '}';
    }

    
}

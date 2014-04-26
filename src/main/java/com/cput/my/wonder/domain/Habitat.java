/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.my.wonder.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Khanya
 */
@Embeddable
public class Habitat implements Serializable{

    private String block;
    private String unit;
    private String room;
    
    private Habitat()
    {        
    }
    
    private Habitat(Builder build) {
        unit = build.unit;
        block = build.block;
        room = build.room;
    }
    
    public static class Builder {

        private String unit;
        private String room;
        private String block;

        public Builder()
        {
            
        }
        
        public Builder(String string) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            return this;
        }

        public Habitat build() {

            return new Habitat(this);
        }
    }

    public String getUnit() {
        return unit;
    }

    public String getRoom() {
        return room;
    }

    
    public String getBlock() {
        return block;
    }
    
}

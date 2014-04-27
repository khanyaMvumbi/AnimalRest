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
public class Inventory implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int quantityStock;
    private String date;

    private Inventory()
    {
        
    }
    private Inventory(Builder build)
    {
        date = build.date;
        id = build.id;
        quantityStock = build.quantityStock;        
    }
    
    public static class Builder {

        private Long id;
        private int quantityStock;
        private String date;

        public Builder(int stock) {
            this.quantityStock = stock;            
        }
        
        public Builder date(String date)
        {
            this.date = date;
            return this;
        }

        public Builder id(Long value) {
            id = value;
            return this;
        }
        
        public Builder inventoryFood(Inventory inv)
        {
            date = inv.getDate();
            id = inv.getId();
            quantityStock = inv.getQuantityStock();
            return this;
        }        
        public Inventory build()
        {
            return new Inventory(this);
            
        }
    }

    public Long getId() {
        return id;
    }

    public int getQuantityStock() {
        return quantityStock;
    }

    public String getDate() {
        return date;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Inventory other = (Inventory) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Inventory{" + "id=" + id + '}';
    }

}

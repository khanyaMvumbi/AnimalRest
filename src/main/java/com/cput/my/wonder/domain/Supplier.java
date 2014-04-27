/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.my.wonder.domain;

import java.io.Serializable;
import java.util.List;
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
public class Supplier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String companyName;
    private String supplyingType;

    private Supplier() {

    }

    private Supplier(Builder build) {
        companyName = build.companyName;
        supplyingType = build.supplyingType;
        name = build.name;
        id = build.id;

    }

    public static class Builder {

        private Long id;
        private String name;
        private String companyName;
        private String supplyingType;

        public Builder(String name) {
            this.name = name;
        }

        public Builder Id(Long id) {
            this.id = id;
            return this;
        }

        public Builder SupplyingType(String supplyingType) {
            this.supplyingType = supplyingType;
            return this;
        }

        public Builder CompanyName(String companyName) {
            this.companyName = companyName;
            return this;
        }
        
        public Builder Supplier(Supplier sup)
        {
            this.companyName = sup.companyName;
            this.id = sup.id;
            this.supplyingType = sup.supplyingType;
            this.name = sup.name;
            return this;
        }
        
        public Supplier build()
        {            
            return new Supplier(this);
        }
        
    }

    public String getName() {
        return name;
    }

    public Long getID() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getSupplyingType() {
        return supplyingType;
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
        final Supplier other = (Supplier) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Supplier{" + "id=" + id + '}';
    }

}

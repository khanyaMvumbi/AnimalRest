/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.my.wonder.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Khanya
 */
@Entity
public class Customer implements Serializable{
private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long Id;

@Column(unique = true)
private String custNumber;

private String custName;
private String custSurname;

@OneToOne (cascade = CascadeType.ALL)
@JoinColumn(name = "custID")
private AdoptAnimal adopt;

@Embedded
private Address address;


    public Customer() {
    }


private Customer(Builder build)
{
    Id = build.Id;
    adopt = build.adopt;
    custName = build.custName;
    custSurname = build.custSurname;
    custNumber = build.custNumber;
    address = build.address;
    
}


public static class Builder{
    
    private Long Id;
    private String custName;
    private String custNumber;
    private String custSurname;    
    private AdoptAnimal adopt;
   private Address address;
    
     public Builder (String custNumber) {
            this.custNumber = custNumber;
      }
    
     public Builder Address (Address addr){
            this.address = addr;
            return this;
      }
      public Builder Id(Long id) {
            this.Id = id;
            return this;
      }
    
    public Builder CustName(String custName) {
            this.custName = custName;
            return this;
      }
    
     public Builder CustSurname(String custSurname) {
            this.custSurname = custSurname;
            return this;
        }
      public Builder id(Long value) {
            Id = value;
            return this;
        }
       
        public Builder Adopt(AdoptAnimal adopt) {
            this.adopt = adopt;
            return this;
        }      
        
        public Builder customer(Customer cust)
        {
            adopt = cust.getAdopt();
            custName = cust.getCustName();
            custNumber = cust.getCustNumber();
            custSurname = cust.getCustSurname();
            Id = cust.getID();
            address = cust.getAddress();
            return this;
        }
        
        public Customer build()
        {
            return new Customer(this);
        }
    }

public Address getAddress()
{
    return address;
}
    public Long getID()
    {
       return Id;
    }
    public String getCustName() {
        return custName;
    }

    public String getCustNumber() {
        return custNumber;
    }

    public String getCustSurname() {
        return custSurname;
    }
    
   
    public AdoptAnimal getAdopt() {
        return adopt;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (this.custName != null ? this.custName.hashCode() : 0);
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
        final Customer other = (Customer) obj;
        if ((this.custName == null) ? (other.custName != null) : !this.custName.equals(other.custName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Customer{" + "custNumber=" + custNumber + '}';
    }
    
}

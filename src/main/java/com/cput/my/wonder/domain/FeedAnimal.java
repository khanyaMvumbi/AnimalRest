/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.my.wonder.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
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
public class FeedAnimal implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private boolean feed;
//    private int quantity;

    @Embedded
    private Food food;
            
    @OneToOne  (cascade = CascadeType.ALL)
    private Inventory inventory;
    
    @OneToMany  (cascade = CascadeType.ALL)
    @JoinColumn(name = "feedID")
    private List<Animal> animal;
    
    private FeedAnimal(Builder build) {
        this.Id = build.Id;
        this.feed = build.feed;
        this.food = build.food;
//        quantity = build.quantity;
        inventory = build.inventory;
    }

    private FeedAnimal()
    {
        
    }
    public static class Builder {

        private Long Id;
        private boolean feed;
        private Food food;
        private List<Animal> animal;
//        private int quantity;
        private Inventory inventory;
        
        public Builder(boolean feed) {
            this.feed = feed;
        }
         public Builder id(Long value) {
            Id = value;
            return this;
        }
        public Builder Inventory(Inventory quantity) {
            this.inventory = quantity;
            return this;
        }      
         
         public Builder animalList(List<Animal> value) {
            animal = value;
            return this;
        }
        public Builder Food(Food food) {
            this.food = food;
            return this;
        }

        public Builder feedAnimal(FeedAnimal feeds) {
            food = feeds.getFood();
            Id = feeds.getId();
            feed = feeds.isFeed();
            animal = feeds.getAnimals();
//            quantity = feeds.getQuantity();
            inventory = feeds.getInventory();
            return this;
        }

        public FeedAnimal build() {
            return new FeedAnimal(this);
        }

    }
    
    
    public Inventory getInventory()
    {
        return inventory;
    }
    public List<Animal> getAnimals()
    {
        return animal;
    }

//    public int getQuantity()
//    {
//        return quantity;        
//    }
    
    public Long getId() {
        return Id;
    }

    public boolean isFeed() {
        return feed;
    }

    public Food getFood() {
        return food;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.Id);
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
        final FeedAnimal other = (FeedAnimal) obj;
        if (this.Id != other.Id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FeedAnimal{" + "Id=" + Id + '}';
    }

}

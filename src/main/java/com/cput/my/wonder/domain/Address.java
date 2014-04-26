/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.my.wonder.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 *
 * @author Khanya
 */
@Embeddable
public class Address implements Serializable {

    private String city;
    private String street;
    private String country;

    public Address() {

    }

    private Address(Builder build) {
        city = build.city;
        street = build.street;
        country = build.country;
      
    }

    public static class Builder {

        private String city;
        private String street;
        private String country;

        public Builder(String city) {
            this.city = city;

        }

        public Builder Street(String street) {
            this.street = street;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Builder address(Address address) {
            city = address.getCity();
            street = address.getCountry();
            country = address.getCountry();
            return this;

        }

        public Address build() {
            return new Address(this);
        }

    }

      public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getCountry() {
        return country;
    }

    
}

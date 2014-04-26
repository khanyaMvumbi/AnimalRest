/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.my.wonder.domain;

import java.io.Serializable;
import java.util.List;
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
public class Employee implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long empID;

    private String empName;
    private String empSurname;
    private String empNumber;
    @OneToMany
    @JoinColumn(name = "empID")
    private FeedAnimal feed;

    @OneToMany
    @JoinColumn(name = "empID")
    private List<TransportAnimal> transportAnimal;

    @OneToMany
    @JoinColumn(name = "empID")
    private List<ServiceHabitat> serviceHabitat;

    @OneToMany
    @JoinColumn(name = "empID")
    private List<ServiceAnimal> serviceAnimal;

    @OneToMany
    @JoinColumn(name = "empID")
    private List<AdoptAnimal> adopt;

    private Employee(Builder build) {
        this.empID = build.empID;
        this.empName = build.empName;
        this.empSurname = build.empSurname;
        this.transportAnimal = build.transportAnimal;
        this.feed = build.feed;
        this.serviceAnimal = build.serviceAnimal;
        this.serviceHabitat = build.serviceHabitat;
        this.adopt = build.adopt;
    }

    public static class Builder {

        private Long empID;
        private String empNumber;
        private String empName;
        private String empSurname;
       
        private FeedAnimal feed;
        private List<TransportAnimal> transportAnimal;
        private List<AdoptAnimal> adopt;
        private List<ServiceHabitat> serviceHabitat;
        private List<ServiceAnimal> serviceAnimal;

        public Builder(String empNumber) {
            this.empNumber = empNumber;
        }
        
        public Builder Id(Long empID) {
            this.empID = empID;
            return this;
        }
        
        public Builder EmpName(String empName) {
            this.empName = empName;
            return this;
        }

        public Builder EmpSurname(String empSurname) {
            this.empSurname = empSurname;
            return this;
        }

        public Builder FeedAnimal(FeedAnimal feedAnimal) {
            this.feed = feedAnimal;
            return this;
        }

        public Builder transportAnimal(List<TransportAnimal> transportAnimal) {
            this.transportAnimal = transportAnimal;
            return this;
        }

        public Builder ServiceHabitat(List<ServiceHabitat> serviceHabitat) {
            this.serviceHabitat = serviceHabitat;
            return this;
        }

        public Builder ServiceAnimal(List<ServiceAnimal> serviceAnimal) {
            this.serviceAnimal = serviceAnimal;
            return this;
        }

        public Builder Purchase(List<AdoptAnimal> adopt) {
            this.adopt = adopt;
            return this;
        }

        public Builder employee(Employee emp) {
            empName = emp.getEmpName();
            empID = emp.getEmpID();
            empNumber = emp.getEmpNumber();
            empSurname = emp.getEmpSurname();
            adopt = emp.getAdoption();
            serviceAnimal = emp.getServiceAnimal();
            transportAnimal = emp.getTransportAnimal();
            serviceHabitat = emp.getServiceHabitat();
            feed = emp.getFeedAnimal();
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
    
    public String getEmpNumber()
    {
        return empNumber;
    }

    public Long getEmpID() {
        return empID;
    }

    public String getEmpName() {
        return empName;
    }

    public String getEmpSurname() {
        return empSurname;
    }

    public List<AdoptAnimal> getAdoption() {
        return adopt;
    }

    public List<ServiceHabitat> getServiceHabitat() {
        return serviceHabitat;
    }

    public List<ServiceAnimal> getServiceAnimal() {
        return serviceAnimal;
    }

    public FeedAnimal getFeedAnimal() {
        return feed;
    }

    public List<TransportAnimal> getTransportAnimal() {
        return transportAnimal;
    }

    @Override
    public int hashCode() {
        return empID.hashCode();

    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        if ((this.empID == null) ? (other.empID != null) : !this.empID.equals(other.empID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Employee{" + "empID=" + empID + '}';
    }

    

}

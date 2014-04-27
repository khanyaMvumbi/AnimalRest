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
import javax.persistence.Column;
import javax.persistence.Embeddable;
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
public class EmployeePositions implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(unique = true)
    private String jobType;    
    private String objectives;
    
    @OneToMany  (cascade = CascadeType.ALL)
    @JoinColumn(name = "positionID")
    private List<Employee> employee;
       
    private EmployeePositions()
    {        
        
    }
    
    private EmployeePositions(Builder build)
    {
        id = build.id;
        jobType = build.jobType;
        objectives = build.objectives;
        
    }
    
    public static class Builder
    {            
        private Long id;
        private String jobType;
        private String objectives;
        private List<Employee> employee;
        
        public Builder(String jobType)
        {
            this.jobType = jobType;
        }
        
        public Builder Id(Long id)
        {
            this.id = id;
            return this;
        }
        
        public Builder objectives(String objectives)
        {
            this.objectives = objectives;
            return this;
        }
        
        public Builder EmployeePositions(EmployeePositions pos)
        {
            id = pos.getId();
            jobType = pos.getJobType();
            objectives  = pos.getObjectives();
            return this;
        }        
        
        public EmployeePositions build()
        {
            return new EmployeePositions(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getJobType() {
        return jobType;
    }

    public String getObjectives() {
        return objectives;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final EmployeePositions other = (EmployeePositions) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EmployeePositions{" + "id=" + id + '}';
    }
    
    
}  

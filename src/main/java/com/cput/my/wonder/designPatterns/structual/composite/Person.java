/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.my.wonder.designPatterns.structual.composite;

/**
 *
 * @author Khanya
 */
public class Person implements Component{
    
    private String name;
    
    public Person(String name)
    {
        this.name = name;
    }

    @Override
    public String greet() {
        return "Person says Hello";
    }

    @Override
    public String sayGoodbye() {
        return "Person says GoodBye";
    }
    
    
}

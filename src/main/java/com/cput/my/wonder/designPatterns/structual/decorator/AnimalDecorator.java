/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.my.wonder.designPatterns.structual.decorator;

/**
 *
 * @author Khanya
 */
public class AnimalDecorator implements Animal{

    Animal animal;

    public AnimalDecorator(Animal animal)
    {
        this.animal = animal;
    }

    @Override
    public String describe() {
        return "I am an Animal Decorator";
    }
   
}

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
public class WingDecorator extends AnimalDecorator{
    
    public WingDecorator(Animal animal){
        super(animal);
    }
    
    @Override
    public String describe() {
        return animal.describe() + ", I have wings, "+fly();
    }
    
    public String fly(){
        return "I can fly";
    }
}

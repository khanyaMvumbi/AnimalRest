/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.my.wonder.presentation;

import com.cput.my.wonder.domain.Animal;
import com.cput.my.wonder.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Khanya
 */
@Controller
public class AnimalHomeController {
    
    @Autowired
    private AnimalService animalService;
    
    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String getHome()
    {        
        return "home";
    }
    
    @RequestMapping(value = "home/animal", method = RequestMethod.GET)
    @ResponseBody
    public String getAnimal()
    {
        Animal animal = new Animal.Builder(3).Color("black").Name("allen").Species("Dog").build();
        animalService.addNewAnimal(animal);
        return animalService.getAnimals().toString();         
    }
}

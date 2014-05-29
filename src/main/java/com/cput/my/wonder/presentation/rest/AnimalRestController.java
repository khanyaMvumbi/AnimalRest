/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.my.wonder.presentation.rest;

import com.cput.my.wonder.domain.Animal;
import com.cput.my.wonder.services.AnimalService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Khanya
 */
@Controller
@RequestMapping(value = "rest/animal")
public class AnimalRestController {
    
    @Autowired
    private AnimalService animalService;
    
    @RequestMapping (value = "create", method = RequestMethod.POST)
    @ResponseBody
    public String createAnimal(@RequestBody Animal animal)
    {
        animalService.persist(animal);
        return "animal created";
    }
    
    @RequestMapping( value = "update", method = RequestMethod.POST)
    @ResponseBody
    public String updateAnimal(@RequestBody Animal animal)
    {
        animalService.merge(animal);
        return "animal updated";
    }
        
    @RequestMapping (value = "animals", method = RequestMethod.GET)
    @ResponseBody
    public List<Animal> getAnimals()
    {
        return animalService.findAll();
     }
    
    @RequestMapping (value = "id/{id}",method = RequestMethod.GET )
    @ResponseBody
    public Animal getAnimal(@PathVariable Long id)
    {
        return animalService.find(id);
    }
   
    @RequestMapping (value = "name/{name}", method = RequestMethod.GET)
    @ResponseBody
    public Animal getAnimalByName(@PathVariable String name)
    {
        Animal animal =  animalService.getAnimalByName(name);
        if(animal!=null){
            return animal;
        }
        return null;
    }
    
}

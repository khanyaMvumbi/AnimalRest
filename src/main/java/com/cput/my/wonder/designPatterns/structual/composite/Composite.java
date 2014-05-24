/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.my.wonder.designPatterns.structual.composite;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Khanya
 */
public class Composite implements Component{

    List<Component> components = new ArrayList<Component>();
    
    @Override
    public String greet() {
        String greetings = "";
        for (Component comp: components)
               greetings = comp.greet() + ", ";
        return greetings;
    }

    @Override
    public String sayGoodbye() {
        String goodbye = "";
        for (Component comp: components)
             goodbye = comp.sayGoodbye() + ", ";
        return goodbye;
    }
    
    public void add(Component comp)
    {
        components.add(comp);
    }
    
    public void remove(Component comp)
    {
        components.remove(comp);
    }
    
    public List<Component> getComponents()
    {
        return components;
    }
    
    public Component getComponent(int index)
    {
        return components.get(index);
    }
    
    
}

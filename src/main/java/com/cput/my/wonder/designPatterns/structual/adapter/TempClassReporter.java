/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.my.wonder.designPatterns.structual.adapter;

/**
 *
 * @author Khanya
 */
public class TempClassReporter extends CelciusReporter implements TempInfo{

    @Override
    public double getTempInf() {
        return cToF(tempInc);
    }

    @Override
    public void setTempInf(double tempInfo) {
               this.tempInc = fToC(tempInfo);
    }
    
    @Override
    public double getTempInc(){
        
        return tempInc;
    }
           
    @Override
    public void setTempInc(double tempInc)
    {
        this.tempInc = tempInc;
    }

    private double fToC(double tempInfo) {
       return ((tempInfo - 32) * 5/9);
    }

    private double cToF(double tempInc) {
        return ((tempInc * 9 / 5) + 32);
    }
    
}

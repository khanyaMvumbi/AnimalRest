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
public class TempObjectReporter implements TempInfo{

    
    CelciusReporter celciusReporter;
    
    public TempObjectReporter()
    {
      celciusReporter = new CelciusReporter();  
    }
    
        
    @Override
    public double getTempInf() {
        return cToF(celciusReporter.getTempInc());
    }

    @Override
    public void setTempInf(double tempInfo) {
         celciusReporter.setTempInc(fToC(tempInfo));  
    }

    @Override
    public double getTempInc() {
             return celciusReporter.getTempInc();
       }

    @Override
    public void setTempInc(double tempInc) {
    celciusReporter.setTempInc(tempInc);     
    }
    
     private double fToC(double tempInfo) {
       return ((tempInfo - 32) * 5/9);
    }

    private double cToF(double tempInc) {
        return ((tempInc * 9 / 5) + 32);
    }
}

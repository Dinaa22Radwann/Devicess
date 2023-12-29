/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devices;

/**
 *
 * @author Mariam Osama
 */
public class AC  extends Devices {
    private double horses;

    public void setHorses(double hs) {
        horses = hs;
    }

    public double power(double hs) {
        horses = hs;
        power = 2344 * hs;
        return power;
    }

    public double calculateConsumption(double hr) {
        hours = hr;
        consumption = power * hours ;
        return consumption;
    }

    public double totalConsumption(double total) {
        total = consumption * 30;
        return total;
    }
    
}

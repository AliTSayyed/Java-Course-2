/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ATS
 */
public class AverageSensor implements Sensor {

    private ArrayList<Sensor> sensors;
    
    private ArrayList<Integer> readings;
    
    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
    }

    public void addSensor(Sensor toAdd) {
        this.sensors.add(toAdd);
    }

    public boolean isOn() {
      for(Sensor sensor : this.sensors){
            if(sensor.isOn() == false){
                return false;            
            }
        }
      return true;
    }

    public void setOn() {
        for(Sensor sensor : this.sensors){
            sensor.setOn();
        }
    }

    public void setOff() {
        for(Sensor sensor : this.sensors){
            sensor.setOff();
        }
    }

    public int read() {
        if (this.isOn() == true){
            int total = 0;
            int average = 0;
            for(Sensor sensor : this.sensors){                
                total = total + sensor.read();
            }
            average = total / this.sensors.size();
            this.readings.add(average);
            return average;
        } else if (this.sensors.isEmpty()){
            throw new IllegalStateException();
        } else {
            throw new IllegalStateException();
        }
    }
    
    public List<Integer> readings(){
        return this.readings;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;
import java.util.Random;
/**
 *
 * @author ATS
 */
public class TemperatureSensor implements Sensor {
     
    private boolean on = false;
    
    public boolean isOn() {        
        if(this.on == true){
            return true;
        }
        return false;
    }

    public void setOn() {
        this.on = true;
    }

    public void setOff() {
        this.on = false;
    }

    public int read() {
        int value = 0;
        if (this.on = true){
           Random random = new Random();
           value = random.nextInt(61) - 30;
           return value;
        } else {
            throw new IllegalStateException();
        }
    }
}

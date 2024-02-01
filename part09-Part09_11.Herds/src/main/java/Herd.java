/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ATS
 */
import java.util.ArrayList;

public class Herd implements Movable{
    
    private ArrayList<Movable> herd;
    
    public Herd(){
        this.herd = new ArrayList<>();
    }
    
    public void addToHerd(Movable movable){
        this.herd.add(movable);
    }
    
    @Override
    public String toString(){
       String text = "";
        for(Movable organism : herd){
            text += organism.toString() + "\n";
        }
        return text;
    }
    
    @Override
    public void move(int dx, int dy){
        for(Movable organism : herd){
            organism.move(dx, dy);
        }
    }
    
}

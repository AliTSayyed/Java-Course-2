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

public class Box implements Packable{
    
    private double maxWeight;
    private ArrayList<Packable> items;   
    
    public Box(double maxWeight){
        this.maxWeight = maxWeight;
        this.items = new ArrayList<>();
    }
    
   public void add(Packable packable){                 
      
       if (weight() + packable.weight() <= maxWeight){
           items.add(packable);           
       }              
   }
   
   @Override
   public double weight(){
       double weight = 0;
       
       for(Packable packable : items){
           weight = weight + packable.weight();
       }
       return weight;
   }
   
   @Override
   public String toString(){
       return "Box: " + items.size() + " items, total weight " + weight() + " kg";
   }
    
    
}

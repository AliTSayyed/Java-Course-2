/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ATS
 */
import java.util.HashMap;
import java.util.ArrayList;

public class StorageFacility {
    
    private HashMap<String,ArrayList<String>> container;   

    public StorageFacility() {
        this.container = new HashMap();
    }
    
    public void add(String unit, String item){
        this.container.putIfAbsent(unit, new ArrayList<>());
        this.container.get(unit).add(item);
    }
    
    public ArrayList<String> contents(String storageUnit){
       return this.container.getOrDefault(storageUnit, new ArrayList<>());
    }

    public void remove(String storageUnit, String item){        
        ArrayList<String> items = new ArrayList<>();
        items = this.container.get(storageUnit);
        if(items != null){
            items.remove(item);
        }
        if(items.isEmpty()){
            this.container.remove(storageUnit);
        }        
    }
    
    public ArrayList<String> storageUnits(){
        ArrayList<String> units = new ArrayList<>();
        for(String items : this.container.keySet()){
            if(!this.container.values().isEmpty()){
                units.add(items);
            }           
        }
        return units;
    }
}

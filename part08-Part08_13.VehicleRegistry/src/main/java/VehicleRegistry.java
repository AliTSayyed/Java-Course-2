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
import java.util.Objects;
import java.util.ArrayList;
public class VehicleRegistry {
    private  HashMap<LicensePlate, String> owners; 
    
    public VehicleRegistry(){
        this.owners = new HashMap<>();        
    }
    
    public boolean add(LicensePlate licensePlate, String owner){       
        if (!this.owners.containsKey(licensePlate)){
             this.owners.put(licensePlate, owner);
             return true;
        }
        return false;
    }
    
    public String get(LicensePlate licensePlate){
        if (!this.owners.containsKey(licensePlate)){
            return null;
        }
        return this.owners.get(licensePlate);         
    }
    
    public boolean remove(LicensePlate licensePlate){
        if (this.owners.containsKey(licensePlate)){
            this.owners.remove(licensePlate);
            return true;
        }
        return false;
    }
    
    public void printLicensePlates(){
        for(LicensePlate licensePlate : this.owners.keySet()){
            System.out.println(licensePlate);
        }
    }
    
    public void printOwners(){
        ArrayList<String> names = new ArrayList<>();
       for(String owner : this.owners.values()){
           if(!names.contains(owner)){
               names.add(owner);
               System.out.println(owner);
           }           
        } 
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.owners);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VehicleRegistry other = (VehicleRegistry) obj;
        if (!Objects.equals(this.owners, other.owners)) {
            return false;
        }
        return true;
    }
    
}

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
public class Pipe <T> {
    
    private T element;
    private ArrayList<T> list;
    
    public Pipe(){
        this.list = new ArrayList<>();                
    }
    
    public void putIntoPipe(T value){
        this.list.add(value);
    }
    
    public T takeFromPipe(){
        if(this.list.isEmpty()){
            return null;
        } else {
            T value = this.list.get(0);
            this.list.remove(0);
            return value;
        }      
    }
    
    public boolean isInPipe(){
        if(!this.list.isEmpty()){
            return true;
        } else {
            return false;
        }
    }
}

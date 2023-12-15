/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ATS
 */
public class Teacher extends Person {
    
    private int wage;
    
    public Teacher(String name, String adress, int wage){
        super(name, adress);
        this.wage = wage;
    }
    
    @Override
    public String toString(){
        return super.toString() + "\n  salary " + this.wage + " euro/month";
    }
           
}

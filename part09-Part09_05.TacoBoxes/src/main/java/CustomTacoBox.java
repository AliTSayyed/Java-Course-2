/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ATS
 */
public class CustomTacoBox implements TacoBox {
    
    private int taco;
    
    public CustomTacoBox(int tacos){
        this.taco = tacos;
    }
    
      public int tacosRemaining(){
       return this.taco;
    }
    
    public void eat(){
        this.taco -= 1;
        if (this.taco < 0){
            this.taco = 0;
        }
    }
}

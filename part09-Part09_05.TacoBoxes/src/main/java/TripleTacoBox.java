/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ATS
 */
public class TripleTacoBox implements TacoBox {
    private int taco;
    
    public TripleTacoBox(){ 
        this.taco = 3;
        
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

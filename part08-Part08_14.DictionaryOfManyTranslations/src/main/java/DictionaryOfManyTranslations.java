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
public class DictionaryOfManyTranslations {
  
    private HashMap<String,ArrayList<String>> Dictionary;
    
    public DictionaryOfManyTranslations(){
        this.Dictionary = new HashMap();
    }
    
    public void add(String word, String translation){
        this.Dictionary.putIfAbsent(word, new ArrayList<>());
        this.Dictionary.get(word).add(translation);        
    }
    
    public ArrayList<String> translate(String word){               
        return this.Dictionary.getOrDefault(word, new ArrayList<>());
    }
    
    public void remove(String word){
        this.Dictionary.remove(word);
    }
}

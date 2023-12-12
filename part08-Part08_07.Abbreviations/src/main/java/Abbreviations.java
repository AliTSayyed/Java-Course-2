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
public class Abbreviations {
    private HashMap<String, String> term;

    public Abbreviations() {
        term = new HashMap<>();
    }
    
    public void addAbbreviation(String abbreviation, String explination){
        term.put(abbreviation, explination);
    }
    
    public boolean hasAbbreviation(String abbreviation){
        if (this.term.containsKey(abbreviation)){
            return true;
        } else {
            return false;
        }
    }
    
    public String findExplanationFor(String abbreviation){
        return term.get(abbreviation);
    }

}

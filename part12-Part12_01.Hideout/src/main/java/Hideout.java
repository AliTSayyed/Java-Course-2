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

public class Hideout<T> {

    private T element;
    private ArrayList<T> hidden;

    public Hideout() {
        this.hidden = new ArrayList<>();
    }

    public void putIntoHideout(T toHide) {
        if (this.hidden.isEmpty()) {
            this.hidden.add(toHide);
        } else {
            this.hidden.clear();
            this.hidden.add(toHide);
        }
    }

    public T takeFromHideout() {
        if(this.hidden.isEmpty()){
            return null;
        } else {
            T item = this.hidden.get(0);
            this.hidden.clear();
            return item;
        }
    }
    
    public boolean isInHideout() {
        if (!this.hidden.isEmpty()){
            return true;
        } else {
            return false;
        }
    }

}

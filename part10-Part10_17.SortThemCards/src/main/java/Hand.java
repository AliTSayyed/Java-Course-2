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
import java.util.Iterator;
import java.util.Comparator;
import java.util.Collections;
public class Hand implements Comparable<Hand> {
    
    private ArrayList<Card> hand;
    
    public Hand(){
        this.hand = new ArrayList<>();
    }        
    
    public void add(Card card) {
        hand.add(card);
    }
    
    public void print(){
        Iterator<Card> iterator = hand.iterator();
        
        while(iterator.hasNext()){
            Card card = iterator.next();
            System.out.println(card);
        }
    }
    public void sort(){
       this.hand.sort(Comparator.naturalOrder());
    }
    
    public int handValue(){
        int handValue = 0;
        Iterator<Card> iterator = this.hand.iterator();
        while(iterator.hasNext()){
            Card card = iterator.next();
            handValue = handValue + card.getValue();
        }        
        return handValue;
    }
    
    @Override
    public int compareTo(Hand otherHand){        
        
        if (this.handValue() != otherHand.handValue()) {            
            return this.handValue() - otherHand.handValue();
        } else {
            return 0;
        }
    }
    
    public void sortBySuit(){       
        Collections.sort(this.hand, new BySuitInValueOrder());

    }
            
}

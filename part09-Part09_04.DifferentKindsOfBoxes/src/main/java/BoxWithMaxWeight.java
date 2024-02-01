
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ATS
 */
public class BoxWithMaxWeight extends Box {

    private int capacity;

    private ArrayList<Item> items;

    public BoxWithMaxWeight(int capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        if (this.weightOfItems() + item.getWeight() > this.capacity) {
            return;
        }

        this.items.add(item);
    }
    
     private int weightOfItems() {
        int weight = 0;
        for (Item item : this.items) {
            weight = weight + item.getWeight();
        }
 
        return weight;
    }

    @Override
    public boolean isInBox(Item item) {
        return items.contains(item);
    }

}

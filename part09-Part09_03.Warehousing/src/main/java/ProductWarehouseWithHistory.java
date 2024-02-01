/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ATS
 */
public class ProductWarehouseWithHistory extends ProductWarehouse {

   
    private ChangeHistory History = new ChangeHistory();

    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
        //History.add(initialBalance);
        addToWarehouse(initialBalance);
    }

    @Override
    public void addToWarehouse(double amount) {
        if (amount < 0) {
            return;
        }
        if (amount <= howMuchSpaceLeft()) {
            this.balance = this.balance + amount;
        } else {
            this.balance = this.capacity;
        }

        History.add(this.balance);
    }

    @Override
    public double takeFromWarehouse(double amount) {
        if (amount < 0) {
            return 0.0;
        }
        if (amount > this.balance) {
            double allThatWeCan = this.balance;
            this.balance = 0.0;
            return allThatWeCan;
        }

        this.balance = this.balance - amount;
        History.add(this.balance);
        return amount;
    }

    public void printAnalysis(){
        System.out.println("Product: " + this.getName());
        System.out.println("History: " + history());
        System.out.println("Largest amount of product: " + History.maxValue());
        System.out.println("Smallest amount of product: " + History.minValue());
        System.out.println("Average: " + History.average());
    }

    public String history() {
        return History.toString();
    }

}

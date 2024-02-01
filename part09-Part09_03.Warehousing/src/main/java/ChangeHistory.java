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

public class ChangeHistory {

    private ArrayList<Double> historyList;    

    public ChangeHistory() {
        this.historyList = new ArrayList<>();
    }

    public void add(double status) {
        this.historyList.add(status);
    }

    public void clear() {
        this.historyList.clear();
    }

    public double maxValue() {
        if (this.historyList.isEmpty()) {
            return 0.0;
        }

        double value = historyList.get(0);
        for (int i = 0; i < historyList.size(); i++) {
            if (historyList.get(i) > value) {
                value = historyList.get(i);
            }
        }
        return value;
    }

    public double minValue() {
        if (this.historyList.isEmpty()) {
            return 0.0;
        }

        double value = historyList.get(0);
        for (int i = 0; i < historyList.size(); i++) {
            if (historyList.get(i) < value) {
                value = historyList.get(i);
            }
        }
        return value;
    }

    public double average() {
        if (this.historyList.isEmpty()) {
            return 0.0;
        }
        double sum = 0.0;

        for (double values : this.historyList) {
            sum += values;
        }

        double average = 1.0 * sum / this.historyList.size();
        return average;
    }

    public String toString() {
        return this.historyList.toString();
    }
}

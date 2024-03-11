/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ATS
 */
public class HashMap<K, V> {

    private List<Pair<K, V>>[] values;
    private int firstFreeIndex;

    public HashMap() {
        this.values = new List[32];
        firstFreeIndex = 0;
    }

    public V getKey(K key) {
        int hashValue = Math.abs(key.hashCode() % this.values.length);
        if (this.values[hashValue] == null) {
            return null;
        }
        List<Pair<K, V>> valuesAtIndex = this.values[hashValue];

        for (int i = 0; i < valuesAtIndex.size(); i++) {
            if (valuesAtIndex.element(i).getKey().equals(key)) {
                return valuesAtIndex.element(i).getValue();
            }
        }

        return null;
    }

    private List<Pair<K, V>> getListBasedOnKey(K key) {
        int hashValue = Math.abs(key.hashCode() % this.values.length);
        if (this.values[hashValue] == null) {
            this.values[hashValue] = new List<>();
        }
        return this.values[hashValue];
    }

    private int getIndexOfKey(List<Pair<K, V>> myList, K key) {
        for (int i = 0; i < myList.size(); i++) {
            if (myList.element(i).getKey().equals(key)) {
                return i;
            }
        }
        return -1;
    }

    public void add(K key, V value) {
        List<Pair<K, V>> valuesAtIndex = getListBasedOnKey(key);
        int index = getIndexOfKey(valuesAtIndex, key);

        if (index < 0) {
            valuesAtIndex.add(new Pair<>(key, value));
            this.firstFreeIndex++;
        } else {
            valuesAtIndex.element(index).setValue(value);
        }
        if (1.0 * this.firstFreeIndex / this.values.length > 0.75) {
            grow();
        }
    }

    private void copy(List<Pair<K, V>>[] newArray, int fromIndex) {
        for (int i = 0; i < this.values[fromIndex].size(); i++) {
            Pair<K, V> element = this.values[fromIndex].element(i);
            int hashValue = Math.abs(element.getKey().hashCode() % newArray.length);

            if (newArray[hashValue] == null) {
                newArray[hashValue] = new List<>();
            }

            newArray[hashValue].add(element);
        }
    }

    private void grow() {
        List<Pair<K, V>>[] newArray = new List[this.values.length * 2];

        for (int i = 0; i < this.values.length; i++) {
            copy(newArray, i);
        }

        this.values = newArray;
    }

    public V remove(K key) {
        List<Pair<K, V>> valuesAtIndex = getListBasedOnKey(key);
        if (valuesAtIndex.size() == 0) {
            return null;
        }

        int index = getIndexOfKey(valuesAtIndex, key);
        if (index < 0) {
            return null;
        }

        Pair<K, V> pair = valuesAtIndex.element(index);
        valuesAtIndex.remove(pair);
        return pair.getValue();
    }
}

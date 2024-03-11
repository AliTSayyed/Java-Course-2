/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ATS
 */
public class List<Type> {

    private Type[] elements;
    private int firstEmptyIndex;

    public List() {
        this.elements = (Type[]) new Object[10];
        this.firstEmptyIndex = 0;
    }

    public void add(Type element) {
        if (this.firstEmptyIndex == this.elements.length) {
            grow();
        }

        this.elements[this.firstEmptyIndex] = element;
        this.firstEmptyIndex++;
    }

    private void grow() {
        int newSize = this.elements.length + this.elements.length / 2;
        Type[] newElements = (Type[]) new Object[newSize];
        for (int i = 0; i < newSize; i++) {
            newElements[i] = this.elements[i];
        }
        this.elements = newElements; // sets the same object value
    }

    public boolean contains(Type value) {
        return indexFrom(value) >= 0;
    }

    public void remove(Type value) {
        int indexOfElement = indexFrom(value);
        if (indexOfElement < 0) {
            return;
        }

        moveToTheLeft(indexOfElement);
        this.firstEmptyIndex--;
    }

    public int indexFrom(Type value) {
        for (int i = 0; i < this.firstEmptyIndex; i++) {
            if (this.elements[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    private void moveToTheLeft(int fromWhere) {
        for (int i = fromWhere; i < this.firstEmptyIndex - 1; i++) {
            this.elements[i] = this.elements[i + 1];
        }
    }

    public Type element(int index) {
        if (index < 0 || index >= this.firstEmptyIndex) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " outside of [0, " + this.firstEmptyIndex + "]");
        }
        return this.elements[index];
    }

    public int size() {
        return this.firstEmptyIndex;
    }
}

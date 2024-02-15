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
import java.util.List;
import java.util.Iterator;
public class Employees {
    
    private ArrayList<Person> people;
    
    public Employees(){
        this.people = new ArrayList<>();
    }
    
    public void add(Person personToAdd){
        people.add(personToAdd);
    }
    
    public void add(List<Person> peopleToAdd){
        peopleToAdd.stream().forEach(person -> people.add(person));
    }
    
    public void print(){
        people.stream().forEach(person->System.out.println(person));
    }
    
    public void print(Education education){
        Iterator<Person> iterator = people.iterator();
        
        while (iterator.hasNext()){
            Person person = iterator.next();
            if(person.getEducation().equals(education)){
                System.out.println(person);
            }
        }
    }
    
    public void fire(Education education){
        Iterator<Person> iterator = people.iterator();
        
        while (iterator.hasNext()){
            Person person = iterator.next();
            if(person.getEducation().equals(education)){
                iterator.remove();
            }
        }
    }
}

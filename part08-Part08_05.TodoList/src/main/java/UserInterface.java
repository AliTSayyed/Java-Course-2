/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ATS
 */
import java.util.Scanner;
public class UserInterface {

    private TodoList tasks;
    private Scanner scanner;
    
    public UserInterface(TodoList tasks, Scanner scanner){
        this.tasks = tasks;
        this.scanner = scanner;
    }
    
    public void start(){
       System.out.print("Command: ");
        while(true){
            System.out.print("Command: ");
            String input = scanner.nextLine();
            
            if(input.equals("add")){
                System.out.print("To add: ");
                String task = scanner.nextLine();
                tasks.add(task);  
            }
            
            if(input.equals("list")){
                tasks.print();
            }
            
            if(input.equals("remove")){
                System.out.print("Which one is remove?");
                int number = Integer.valueOf(scanner.nextLine());
                tasks.remove(number);
            }
            
            if(input.equals("stop")){
                break;
            }
        }
    }
}

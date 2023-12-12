
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int first = 0;
        int second = 0;

        while (true) {            
            System.out.println("First: " + first + "/100" );
            System.out.println("Second: " + second + "/100" );

            String input = scan.nextLine();
            String[] parts = input.split(" ");
            
            if (input.equals("quit")) {
                break;
            }
            
            if (parts[0].equals("add")){
                int amount = Integer.valueOf(parts[1]);
                if (amount > 0){
                    first += amount;  
                }                            
                if (first > 100){
                    first = 100;
                }
            }
            
            if (parts[0].equals("move")){
                int amount = Integer.valueOf(parts[1]);  
                
                if (amount > 0 && amount <= first){
                    first -= amount;
                    second += amount;
                } else if (amount > 0 && amount > first){                                                  
                  second += first;
                  first =0;                   
                } 
                if (first < 0){
                    first = 0;                   
                }
                if (second < 0){
                    second = 0;
                }
                if (second > 100){
                    second = 100;
                }
            }
            
            if (parts[0].equals("remove")){
                int amount = Integer.valueOf(parts[1]);
                if (amount > 0){
                    second -= amount;                   
                }
                if (second < 0){
                    second = 0;
                }
            }
            
        }
    }

}

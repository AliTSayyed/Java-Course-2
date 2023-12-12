
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Container container_1 = new Container();
        Container container_2 = new Container();
        
        while (true) {
            System.out.println("First: " + container_1);
            System.out.println("Second: " + container_2);

            String input = scan.nextLine();
            String[] parts = input.split(" ");

            if (input.equals("quit")) {
                break;
            }

            if (parts[0].equals("add")) {
                int amount = Integer.valueOf(parts[1]);
                container_1.add(amount);
            }

            if (parts[0].equals("move")) {
                int amount = Integer.valueOf(parts[1]);
                if (amount > 0 && amount > container_1.contains()){                    
                    container_2.add(container_1.contains());
                    container_1.remove(amount);
                } else if (amount > 0 && amount <= container_1.contains()){
                    container_1.remove(amount);
                    container_2.add(amount);
                }                
            }

            if (parts[0].equals("remove")) {
                int amount = Integer.valueOf(parts[1]);
                container_2.remove(amount);
            }
        }

    }
}

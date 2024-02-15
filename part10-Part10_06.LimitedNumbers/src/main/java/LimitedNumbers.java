
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LimitedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> values = new ArrayList<>();

        while (true) {
            int input = Integer.valueOf(scanner.nextLine());
            if (input < 0) {
                break;
            }

            values.add(input);
        }

        System.out.println("Numbers between 1 and 5:");
        values.stream()
                .filter(n -> n > 1 && n < 5)
                .forEach(n -> System.out.println(n));
    }
}

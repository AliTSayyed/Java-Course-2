

public class MainProgram {

    public static void main(String[] args) {
        // you can create test code here. Call the methods that you'll implement
        // during the course of this exercise
        Checker checker = new Checker();
        String string = "24:41:16";
        System.out.println(string);
        if (checker.timeOfDay(string)){
            System.out.println("correct form");
        } else {
            System.out.println("incorrect form");
        }
    }
}

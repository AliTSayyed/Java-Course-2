package title;

import javafx.application.Application;
import javafx.application.Application.Parameters;
import javafx.stage.Stage;
import java.util.Scanner;

public class UserTitle extends Application {

    @Override
    public void start(Stage window) {
        
      // Prompt the user to enter a title
        System.out.println("Enter the title:");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();

        // Set the title of the window to the entered title
        window.setTitle(title);

        // Show the window
        window.show();

    }

}

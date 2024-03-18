package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GreeterApplication extends Application {

    @Override
    public void start(Stage window) {
        // create button and text fields
        Label instructionText = new Label("Enter your name and start");
        TextField name = new TextField("");
        Button startButton = new Button("Start");

        // create layout for start screen
        GridPane layout = new GridPane();

        layout.add(instructionText, 0, 0);
        layout.add(name, 0, 1);
        layout.add(startButton, 0, 2);

        // set prefered size
        layout.setPrefSize(300, 180);
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(20, 20, 20, 20));

        // create first scene
        Scene enterName = new Scene(layout);

        // Create second view for name entry  
        
        Label greet = new Label();

        StackPane welcomeLayout = new StackPane();
        welcomeLayout.setPrefSize(300, 180);
        welcomeLayout.getChildren().add(greet);
        welcomeLayout.setAlignment(Pos.CENTER);

        Scene greeting = new Scene(welcomeLayout);

        // add action event
        startButton.setOnAction((event) -> {
            String inputName = name.getText();
            greet.setText("Welcome " + inputName + "!");
            window.setScene(greeting);

        });

        window.setScene(enterName);
        window.show();

    }

    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }
}

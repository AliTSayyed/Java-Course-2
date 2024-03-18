package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JokeApplication extends Application {

    @Override
    public void start(Stage window) throws Exception {
        // create a main layout
        BorderPane layout = new BorderPane();

        Button Joke = new Button("Joke");
        Button Answer = new Button("Answer");
        Button Explanation = new Button("Explanation");
        
        HBox buttons = new HBox();
        buttons.getChildren().addAll(Joke, Answer, Explanation);
        buttons.setPadding(new Insets(20,20,20,20));
        buttons.setSpacing(10);
        
        layout.setTop(buttons);
        
        StackPane joke = createView("What do you call a bear with no teeth?");
        StackPane answer = createView("A gummy bear.");
        StackPane explanation = createView("Explanation is...");   
        
        Joke.setOnAction((event)-> layout.setCenter(joke));
        Answer.setOnAction((event)-> layout.setCenter(answer));
        Explanation.setOnAction((event)-> layout.setCenter(explanation));
        
        layout.setCenter(joke);
        
        Scene view = new Scene(layout);
        window.setScene(view);
        window.show();
    }    
    
    private StackPane createView(String text){
        StackPane layout = new StackPane();
        layout.setPrefSize(300, 180);
        layout.getChildren().add(new Label(text));
        layout.setAlignment(Pos.CENTER);
        return layout;
    }

    public static void main(String[] args) {
        launch(JokeApplication.class);
    }
}

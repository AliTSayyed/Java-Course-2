package notifier;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class NotifierApplication extends Application {

    @Override
    public void start(Stage window) {
        Button button = new Button("Update");
        TextField textField = new TextField("Hello world!");
        Label copyText = new Label("Hello world!");

        button.setOnAction((event)-> {
            copyText.setText(textField.getText());
        });
        
        VBox layout = new VBox();
        //layout.setSpacing(20);
        layout.getChildren().addAll(textField, button, copyText);

        Scene view = new Scene(layout);
        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(NotifierApplication.class);
    }

}

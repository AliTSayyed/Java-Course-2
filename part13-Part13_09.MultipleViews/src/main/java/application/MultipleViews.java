package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

public class MultipleViews extends Application {

    @Override
    public void start(Stage window) {
        //scene 1
        BorderPane layout_1 = new BorderPane();

        Label text_1 = new Label("First View!");
        Button button_1 = new Button("To the second view!");
        layout_1.setCenter(button_1);
        layout_1.setTop(text_1);

        //scene 2
        VBox layout_2 = new VBox();
        Button button_2 = new Button("To the third view!");
        Label text_2 = new Label("Second view!");
        layout_2.getChildren().addAll(button_2, text_2);

        //scene 3
        GridPane layout_3 = new GridPane();
        Label text_3 = new Label("Third view!");
        Button button_3 = new Button("To the first view!");
        layout_3.add(text_3, 0, 0);
        layout_3.add(button_3, 1, 1);

        Scene view_1 = new Scene(layout_1);
        Scene view_2 = new Scene(layout_2);
        Scene view_3 = new Scene(layout_3);

        window.setScene(view_1);
        window.show();

        //action steps
        button_1.setOnAction((event) -> {
            window.setScene(view_2);
        });
        button_2.setOnAction((event) -> {
            window.setScene(view_3);
        });
        button_3.setOnAction((event) -> {
            window.setScene(view_1);
        });
    }

    public static void main(String[] args) {
        launch(MultipleViews.class);
    }

}

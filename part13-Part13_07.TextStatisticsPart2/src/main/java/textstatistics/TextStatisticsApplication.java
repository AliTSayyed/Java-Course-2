package textstatistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.util.Arrays;

public class TextStatisticsApplication extends Application {

    @Override
    public void start(Stage window) {
        BorderPane layout = new BorderPane();

        TextArea textArea = new TextArea("");
        layout.setCenter(textArea);

        Label lettersText = new Label("Letters: 0");
        Label wordsText = new Label("Words: 0");
        Label longestText = new Label("The longest word is: "); 
        
        HBox texts = new HBox();
        texts.setSpacing(10);
        texts.getChildren().addAll(lettersText, wordsText, longestText);

        layout.setBottom(texts);

        textArea.textProperty().addListener((change, oldValue, newValue) -> {

            int characters = newValue.length();
            String[] parts = newValue.split(" ");
            int words = parts.length;
            String longest = Arrays.stream(parts)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();
            lettersText.setText("Letters: " + characters);
            wordsText.setText("Words: " + words);
            longestText.setText("The longest word is: " + longest);
        });
        
        

        Scene view = new Scene(layout);
        window.setScene(view);
        window.show();

    }

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

}

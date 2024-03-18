/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author ATS
 */
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PracitceView {

    private Dictionary dictionary;
    private String word;

    public PracitceView(Dictionary dictionary) {
        this.dictionary = dictionary;
        this.word = dictionary.getRandomWord();
    }

    public Parent getView() {
        GridPane layout = new GridPane();
        Label wordInstruction = new Label();

        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        layout.add(wordInstruction, 0, 0);

        if (this.word == null) {
            wordInstruction.setText("add words to the list");
            this.word = dictionary.getRandomWord();
        }

        if (this.word != null) {
            wordInstruction.setText("Translate the word '" + this.word + "'");
            TextField translationField = new TextField();

            Button addButton = new Button("Check");

            Label feedback = new Label("");
            layout.add(translationField, 0, 1);
            layout.add(addButton, 0, 2);
            layout.add(feedback, 0, 3);

            addButton.setOnMouseClicked((event) -> {
                String translation = translationField.getText();
                if (this.dictionary.getWord(word).equals(translation)) {
                    feedback.setText("Correct!");
                } else {
                    feedback.setText("Incorrect! The translation fo the word '" + word + "' is '" + dictionary.getWord(word) + "'.");
                    return;
                }

                this.word = this.dictionary.getRandomWord();
                wordInstruction.setText("Translate the word '" + this.word + "'");
                translationField.clear();
            });
        }
        return layout;
    }
}

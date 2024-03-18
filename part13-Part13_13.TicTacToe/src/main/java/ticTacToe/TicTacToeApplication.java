package ticTacToe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import java.util.Arrays;
import javafx.geometry.Pos;

public class TicTacToeApplication extends Application {

    @Override
    public void start(Stage window) {
        // create layout and format
        BorderPane layout = new BorderPane();
        Label text = new Label("Turn: X");
        text.setFont(Font.font("Monospaced", 40));
        GridPane tictactoe = new GridPane();
        layout.setTop(text);
        layout.setCenter(tictactoe);

        //loop to create 9 buttons
        Button[] buttons = new Button[9];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new Button();
            buttons[i].setFont(Font.font("Monospaced", 40));
            buttons[i].setMinSize(100, 100);
            buttons[i].setMaxSize(100, 100);
            buttons[i].setAlignment(Pos.CENTER);
            //buttons[i].setText(String.valueOf(i));
        }

        //loop to create 3x3 button grid
        int size = 3; // 3x3 grid
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                int index = row * size + col;
                tictactoe.add(buttons[index], col, row);
            }
        }

        // loop to set action events to each button
        for (int i = 0; i < buttons.length; i++) {
            Button turn = buttons[i];
            turn.setOnAction((event) -> {
                // determine whose turn it is
                if (text.getText().equals("Turn: X") && turn.getText().isEmpty()) {
                    turn.setText("X");
                    text.setText("Turn: O");
                }
                if (text.getText().equals("Turn: O") && turn.getText().isEmpty()) {
                    turn.setText("O");
                    text.setText("Turn: X");
                }

                // Define the winning combinations
                int[][] winningCombinations = {
                    {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Horizontal
                    {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Vertical
                    {0, 4, 8}, {2, 4, 6} // Diagonal
                };

                // Iterate through the winning combinations
                for (int[] combination : winningCombinations) {
                    String button1Text = buttons[combination[0]].getText();
                    String button2Text = buttons[combination[1]].getText();
                    String button3Text = buttons[combination[2]].getText();

                    // Check if the three buttons have the same non-empty text
                    if (!button1Text.isEmpty() && button1Text.equals(button2Text) && button2Text.equals(button3Text)) {
                        text.setText("The end!");
                        turn.setOnAction(null);
                        break; // Exit the loop if a winning combination is found
                    }
                }

            });
        }

        Scene view = new Scene(layout);
        window.setScene(view);
        window.show();
    }
        /* set conditions to finish the game;
        if (buttons[0].getText().equals("X") && buttons[1].getText().equals("X") && buttons[2].getText().equals("X")) {
            text.setText("The end!");
            for (int i = 0; i < buttons.length; i++) {
                Button turn = buttons[i];
                turn.setOnAction(null);
            }
        }
        
         if (buttons[0].getText().equals("X") && buttons[1].getText().equals("X") && buttons[2].getText().equals("X")) {
                    text.setText("The end!");
                    turn.setOnAction(null);
                }
                if (buttons[0].getText().equals("O") && buttons[1].getText().equals("O") && buttons[2].getText().equals("O")) {
                    text.setText("The end!");
                    turn.setOnAction(null);
                }
                if (buttons[3].getText().equals("X") && buttons[4].getText().equals("X") && buttons[5].getText().equals("X")) {
                    text.setText("The end!");
                    turn.setOnAction(null);
                }
                if (buttons[3].getText().equals("O") && buttons[4].getText().equals("O") && buttons[5].getText().equals("O")) {
                    text.setText("The end!");
                    turn.setOnAction(null);
                }
                if (buttons[6].getText().equals("X") && buttons[7].getText().equals("X") && buttons[8].getText().equals("X")) {
                    text.setText("The end!");
                    turn.setOnAction(null);
                }
                if (buttons[6].getText().equals("O") && buttons[7].getText().equals("O") && buttons[8].getText().equals("O")) {
                    text.setText("The end!");
                    turn.setOnAction(null);
                }
                if (buttons[0].getText().equals("X") && buttons[3].getText().equals("X") && buttons[6].getText().equals("X")) {
                    text.setText("The end!");
                    turn.setOnAction(null);
                }
                if (buttons[0].getText().equals("O") && buttons[3].getText().equals("O") && buttons[6].getText().equals("O")) {
                    text.setText("The end!");
                    turn.setOnAction(null);
                }
                if (buttons[1].getText().equals("X") && buttons[4].getText().equals("X") && buttons[7].getText().equals("X")) {
                    text.setText("The end!");
                    turn.setOnAction(null);
                }
                if (buttons[1].getText().equals("O") && buttons[4].getText().equals("O") && buttons[7].getText().equals("O")) {
                    text.setText("The end!");
                    turn.setOnAction(null);
                }
                if (buttons[2].getText().equals("X") && buttons[5].getText().equals("X") && buttons[8].getText().equals("X")) {
                    text.setText("The end!");
                    turn.setOnAction(null);
                }
                if (buttons[2].getText().equals("O") && buttons[5].getText().equals("O") && buttons[8].getText().equals("O")) {
                    text.setText("The end!");
                    turn.setOnAction(null);
                }
                if (buttons[0].getText().equals("X") && buttons[4].getText().equals("X") && buttons[8].getText().equals("X")) {
                    text.setText("The end!");
                    turn.setOnAction(null);
                }
                if (buttons[0].getText().equals("O") && buttons[4].getText().equals("O") && buttons[8].getText().equals("O")) {
                    text.setText("The end!");
                    turn.setOnAction(null);
                }
                if (buttons[2].getText().equals("X") && buttons[4].getText().equals("X") && buttons[6].getText().equals("X")) {
                    text.setText("The end!");
                    turn.setOnAction(null);
                }
                if (buttons[2].getText().equals("O") && buttons[4].getText().equals("O") && buttons[6].getText().equals("O")) {
                    text.setText("The end!");
                    turn.setOnAction(null);
                }
    
        Button b1 = new Button();
        Button b2 = new Button();
        Button b3 = new Button();
        Button b4 = new Button();
        Button b5 = new Button();
        Button b6 = new Button();
        Button b7 = new Button();
        Button b8 = new Button();
        Button b9 = new Button();
        
        b1.setFont(Font.font("Monospaced", 40));
        b2.setFont(Font.font("Monospaced", 40));
        b3.setFont(Font.font("Monospaced", 40));
        b4.setFont(Font.font("Monospaced", 40));
        b5.setFont(Font.font("Monospaced", 40));
        b6.setFont(Font.font("Monospaced", 40));
        b7.setFont(Font.font("Monospaced", 40));
        b8.setFont(Font.font("Monospaced", 40));
        b9.setFont(Font.font("Monospaced", 40));      
        
       
        tictactoe.add(buttons[0], 0, 0);
        tictactoe.add(buttons[1], 0, 1);
        tictactoe.add(buttons[2], 0, 2);
        tictactoe.add(buttons[3], 1, 0);
        tictactoe.add(buttons[4], 1, 1);
        tictactoe.add(buttons[5], 1, 2);
        tictactoe.add(buttons[6], 2, 0);
        tictactoe.add(buttons[7], 2, 1);
        tictactoe.add(buttons[8], 2, 2);
     */
    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

}

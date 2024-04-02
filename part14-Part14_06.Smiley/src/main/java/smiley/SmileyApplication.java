package smiley;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class SmileyApplication extends Application {

    @Override
    public void start(Stage window){
        Canvas paintingCanvas = new Canvas(640, 480);
        GraphicsContext painter = paintingCanvas.getGraphicsContext2D();
        
        BorderPane smiley = new BorderPane();
        smiley.setCenter(paintingCanvas);
        
        painter.setFill(Color.WHITE);
        painter.fillRect(0, 0, paintingCanvas.getWidth(), paintingCanvas.getHeight());
        
        
        painter.setFill(Color.BLACK);
        painter.fillRect(100, 50, 50, 50);
        painter.fillRect(250, 50, 50, 50);
 
        painter.fillRect(100, 250, 200, 50);
        painter.fillRect(50, 200, 50, 50);
        painter.fillRect(300, 200, 50, 50);
        
        Scene view = new Scene(smiley);
        window.setScene(view);
        window.show();
        
    }

    public static void main(String[] args) {
        launch(SmileyApplication.class);
        System.out.println("Hello world!");
    }

}

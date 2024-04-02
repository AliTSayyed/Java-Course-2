package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.stage.Stage;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;

public class PartiesApplication extends Application {

    @Override
    public void start(Stage stage) {
        String filePath = "partiesdata.tsv";
        Map<String, Map<Integer, Double>> dataMap = new HashMap<>();
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            String yearsLine = scanner.nextLine(); // Store the years line separately
            String[] years = yearsLine.split("\t");

            while (scanner.hasNextLine()) {
                String pieces[] = scanner.nextLine().split("\t");
                String party = pieces[0];
                Map<Integer, Double> partyData = new HashMap<>();

                for (int i = 1; i < pieces.length; i++) {
                    if(pieces[i].length() > 1){
                        partyData.put(Integer.valueOf(years[i]), Double.valueOf(pieces[i]));
                    }                                        
                }
                dataMap.put(party, partyData);
            }
        } catch (FileNotFoundException e) {
            e.getMessage();
        }

        // create the x and y axes that the chart is going to use
        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis(0, 30, 5);

        // set the titles for the axes
        xAxis.setLabel("Year");
        yAxis.setLabel("Relative support (%)");

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support of the parties");

        dataMap.keySet().stream().forEach(party -> {
            // a different data set for every party
            XYChart.Series data = new XYChart.Series();
            data.setName(party);

            // add the party's support numbers to the data set
            dataMap.get(party).entrySet().stream().forEach(pair -> {
                data.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
            });

            // and add the data set to the chart
            lineChart.getData().add(data);
        });

        Scene view = new Scene(lineChart, 640, 480);
        stage.setScene(view);
        stage.show();
    }

    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }

}

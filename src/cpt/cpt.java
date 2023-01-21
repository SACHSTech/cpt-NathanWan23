package cpt;

import java.util.*;
import java.io.*;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.stage.Stage;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class cpt extends Application{
    
/**
 * A chart that displays rectangular bars with heights indicating data values
 * for categories. Used for displaying information when at least one axis has
 * discontinuous or discrete data.
 */

    
    
  private BarChart chart;
  private CategoryAxis xAxis;
  private NumberAxis yAxis;

    /*private LineChart chart;
    private NumberAxis xAxis;
    private NumberAxis yAxis;*/

    public Parent createContent() {
        String[] years = {"2007", "2008", "2009"};
        int[] data = {567, 1292, 1292};

        DataCollection DataCollection = new DataCollection();

        xAxis = new CategoryAxis();
        // Need to change this years right
        xAxis.setCategories(FXCollections.<String>observableArrayList(years));
        yAxis = new NumberAxis("Alchohol Consumption", 0.0d, 30.0d, 100.0d); 
        
        ObservableList<BarChart.Series> barChartData = ObservableList<BarChart.Series>();


            FXCollections.observableArrayList(
              for(int i = 0; i< CountryList.size(); i += 3){
              new BarChart.Series(countryList.get(i).getName(), FXCollections.observableArrayList(
                new BarChart.Data(countryList.get(i).getYear(), countryList.get(i).getAlcConsumption()),
                new BarChart.Data(countryList.get(i+1).getYear(), countryList.get(i+1).getAlcConsumption()),
                new BarChart.Data(countryList.get(i+2).getYear(), countryList.get(i+2).getAlcConsumption()))),
              }
            );
        chart = new BarChart(xAxis, yAxis, barChartData, 25.0d);

        /*xAxis = new NumberAxis("Values for X-Axis", 0, 3, 1);
        yAxis = new NumberAxis("Values for Y-Axis", 0, 3, 1);
        ObservableList<XYChart.Series<Double,Double>> lineChartData =
            FXCollections.observableArrayList(
                new LineChart.Series<>("Series 1",
                                       FXCollections.observableArrayList(
                    new XYChart.Data<>(0.0, 1.0),
                    new XYChart.Data<>(1.2, 1.4),
                    new XYChart.Data<>(2.2, 1.9),
                    new XYChart.Data<>(2.7, 2.3),
                    new XYChart.Data<>(2.9, 0.5))),
                new LineChart.Series<>("Series 2",
                                       FXCollections.observableArrayList(
                    new XYChart.Data<>(0.0, 1.6),
                    new XYChart.Data<>(0.8, 0.4),
                    new XYChart.Data<>(1.4, 2.9),
                    new XYChart.Data<>(2.1, 1.3),
                    new XYChart.Data<>(2.6, 0.9)))
            );
        chart = new LineChart(xAxis, yAxis, lineChartData);
        return chart;*/
    //}

        return chart;
        
  }
 
    @Override public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }
 
    /**
     * Java main for when running without JavaFX launcher
     */
    public static void main(String[] args) {
        launch(args);
    }
}
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

import java.util.Arrays;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class cpt extends Application{
    
  /*private BarChart chart;
  private CategoryAxis xAxis;
  private NumberAxis yAxis;*/

    /*private LineChart chart;
    private NumberAxis xAxis;
    private NumberAxis yAxis;*/

    /*public Parent createContent() {
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

        
    //}

        return chart;
        
  } */

  //public class HorizontalBarChartApp extends Application {
 
    private BarChart<Number, String> chart;
    private NumberAxis xAxis;
    private CategoryAxis yAxis;
 
    public Parent createContent() {
        //final String[] years = {"2007", "2008", "2009"};
        
        final ObservableList<String> categories =
            FXCollections.<String>observableArrayList(Arrays.asList(years));
        xAxis = new NumberAxis();
        yAxis = new CategoryAxis();
        chart = new BarChart<>(xAxis, yAxis);
        chart.setTitle("Horizontal Bar Chart Example");
        yAxis.setLabel("Year");
        yAxis.setCategories(categories);
        xAxis.setLabel("Price");
 
        // add starting data
        XYChart.Series<Number, String> series1 = new XYChart.Series<>();
        series1.setName("Data Series 1");
        series1.getData().addAll(
                new XYChart.Data<Number, String>(567, years[0]),
                new XYChart.Data<Number, String>(1292, years[1]),
                new XYChart.Data<Number, String>(2180, years[2]));
 
        XYChart.Series<Number, String> series2 = new XYChart.Series<>();
        series2.setName("Data Series 2");
        series2.getData().addAll(
                new XYChart.Data<Number, String>(956, years[0]),
                new XYChart.Data<Number, String>(1665, years[1]),
                new XYChart.Data<Number, String>(2450, years[2]));
 
        XYChart.Series<Number, String> series3 = new XYChart.Series<>();
        series3.setName("Data Series 3");
        series3.getData().addAll(
                new XYChart.Data<Number, String>(800, years[0]),
                new XYChart.Data<Number, String>(1000, years[1]),
                new XYChart.Data<Number, String>(2800, years[2]));
 
        chart.getData().add(series1);
        chart.getData().add(series2);
        chart.getData().add(series3);
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
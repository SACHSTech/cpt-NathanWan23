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

public class Main extends Application{
    
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
 
    public Parent createContent() throws IOException{
        //final String[] years = {"2007", "2008", "2009"};
        DataCollection DataCollection = new DataCollection();
        ArrayList<String> listCountryName = new ArrayList<String>();
        
        ArrayList<Country> year1 = DataCollection.yearlyData(2000);
        ArrayList<Country> year2 = DataCollection.yearlyData(2010);
        ArrayList<Country> year3 = DataCollection.yearlyData(2015);

        //ArrayList<Country> test = DataCollection.getList();

        listCountryName = DataCollection.countryName();

        //final ObservableList<String> categories =
            FXCollections.<String>observableArrayList(listCountryName);
        xAxis = new NumberAxis();
        yAxis = new CategoryAxis();
        chart = new BarChart<>(xAxis, yAxis);
        chart.setTitle("Total Alcohol Consumption per Capita (Liters of Pure Alcohol, 15+ age)");
        yAxis.setLabel("Country");
        //yAxis.setCategories(categories);
        xAxis.setLabel("Total Pure Alcohol Consumption per Person over 15 years of age");
 
        // add starting data
        XYChart.Series<Number, String> series1 = new XYChart.Series<>();
        series1.setName("2000");
            for(int i = 0; i<year1.size();i++){
                series1.getData().add(
                new XYChart.Data<Number, String>(year1.get(i).getAlcConsumption(), year1.get(i).getName()));                
            }

        XYChart.Series<Number, String> series2 = new XYChart.Series<>();
        series2.setName("2010");
            for(int i = 0; i<year2.size();i++){
                series2.getData().add(
            new XYChart.Data<Number, String>(year2.get(i).getAlcConsumption(), year2.get(i).getName()));
                    
                }

        XYChart.Series<Number, String> series3 = new XYChart.Series<>();
        series3.setName("2015");
            for(int i = 0; i<year3.size();i++){
                series3.getData().add(
            new XYChart.Data<Number, String>(year3.get(i).getAlcConsumption(), year3.get(i).getName()));
                    
                }
    
        
        /*series1.setName("Data Series 1");
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
                new XYChart.Data<Number, String>(2800, years[2])); */
 
        chart.getData().add(series1);
        chart.getData().add(series2);
        chart.getData().add(series3);
        return chart;
    }
 
    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }
 
    /**
     * Java main for when running without JavaFX launcher
     */
    public static void main(String[] args) throws IOException{
        launch(args);
    }

    /*public static ArrayList<String> countryName(ArrayList<Country> test){
        
        ArrayList <String> customList = new ArrayList <String>();

        for(int i = 0; i < test.size();i++) customList.add((test).get(i).getName());
        
        return customList;

    }*/

    /*public static ArrayList<Country> yearlyData(int year){

        ArrayList <Country> customList = new ArrayList <Country>();

        for(int i = 0; i < countryList.size();i++){
            if(countryList.get(i).getYear() == year) customList.add(countryList.get(i));
        }
        
        return customList;
        
    }*/
}
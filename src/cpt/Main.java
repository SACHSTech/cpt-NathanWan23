package cpt;

import java.util.*;
import java.io.*;

import javafx.collections.ObservableList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.stage.Stage;

//Imports for Line Chart
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.NumberAxis;

//Imports for button
import javafx.scene.control.CheckBox;
import javafx.scene.control.Button;

//Imports for VBox and stacked layout
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;

public class Main extends Application{
    
    Stage window;
    Scene scene1;
    Scene scene2;
    CheckBox CheckBox;    
    Button button;
 
    //Bar Chart variables
    private BarChart<Number, String> chart;
    private NumberAxis xAxis;
    private CategoryAxis yAxis;

    //Line Chart variables
    private LineChart<Double, Double> chart2;
    private NumberAxis xAxis2;
    private NumberAxis yAxis2;

    private XYChart.Series<Number, String> series1 = new XYChart.Series<>();
    private XYChart.Series<Number, String> series2 = new XYChart.Series<>();
    private XYChart.Series<Number, String> series3 = new XYChart.Series<>();
    private XYChart.Series<Number, String> series4 = new XYChart.Series<>();
    
    public Parent horizontalBarChartApp() throws IOException {
        DataCollection DataCollection = new DataCollection();
        ArrayList<String> listCountryName = new ArrayList<String>();
        
        ArrayList<Country> year1 = DataCollection.yearlyData(2000);
        ArrayList<Country> year2 = DataCollection.yearlyData(2010);
        ArrayList<Country> year3 = DataCollection.yearlyData(2015);
        ArrayList<Country> year4 = DataCollection.yearlyData(2018);

        listCountryName = DataCollection.countryName();

            FXCollections.<String>observableArrayList(listCountryName);
        xAxis = new NumberAxis();
        yAxis = new CategoryAxis();
        chart = new BarChart<>(xAxis, yAxis);
        chart.setTitle("Total Alcohol Consumption per Capita (Liters of Pure Alcohol, 15+ age)");
        yAxis.setLabel("Country");
        xAxis.setLabel("Total Pure Alcohol Consumption per Person over 15 years of age");
 
        series1.setName("2000");
        for(int i = 0; i<year1.size();i++){
            series1.getData().add(
            new XYChart.Data<Number, String>(year1.get(i).getAlcConsumption(), year1.get(i).getName()));                
        }

        series2.setName("2010");
        for(int i = 0; i<year2.size();i++){
            series2.getData().add(
            new XYChart.Data<Number, String>(year2.get(i).getAlcConsumption(), year2.get(i).getName()));     
        }

        series3.setName("2015");
        for(int i = 0; i<year3.size();i++){
            series3.getData().add(
            new XYChart.Data<Number, String>(year3.get(i).getAlcConsumption(), year3.get(i).getName()));          
        }
    
            series4.setName("2018");
            for(int i = 0; i<year4.size();i++){
                series4.getData().add(
                new XYChart.Data<Number, String>(year4.get(i).getAlcConsumption(), year4.get(i).getName()));
            }
        
        chart.setPrefHeight(600);
        chart.setPrefWidth(500);
        return chart;
    }

    public Parent lineChartApp() throws IOException {

        DataCollection dataCollection = new DataCollection();
        ArrayList<String> listCountryName = dataCollection.countryName();
        ArrayList<Double> countryData = new ArrayList<Double>();


        xAxis2 = new NumberAxis("Total Alcohol Consumption per Capita (Liters of Pure Alcohol, 15+ age)", 0, 20, 0.5);
        yAxis2 = new NumberAxis("Years", 2000, 2020, 1);
        //ObservableList<XYChart.Series<Double,Double>> lineChartData =
        
        ObservableList<XYChart.Series<Double,Double>> lineChartData = FXCollections.observableArrayList();
        
        for(int i = 0; i< listCountryName.size();i++){
            ObservableList<XYChart.Data> seriesData = FXCollections.observableArrayList();

            countryData = dataCollection.countryData(listCountryName.get(i));

            for(int j = 0; j < 8; j+=2){

                seriesData.add( new XYChart.Data<>(countryData.get(j+1), countryData.get(j)));
                
                
            }
            XYChart.Series series = new XYChart.Series();
            series.setData(seriesData);
            series.setName(listCountryName.get(i));
            lineChartData.add(series);
        }

        ///////////
        //ObservableList<XYChart.Data> seriesData = FXCollections.observableArrayList();
        /*for(int i = 0; i< listCountryName.size();i++){
            ObservableList<XYChart.Data> seriesData = FXCollections.observableArrayList();

            countryData = dataCollection.countryData(listCountryName.get(i));

            
        //ObservableList<XYChart.Series<Double,Double>> series = FXCollections.observableArrayList();
        //ObservableList<XYChart.Series<Double,Double>> lineChartData = FXCollections.observableArrayList();
            //FXCollections.observableArrayList(
            //FXCollections.<Double>observableArrayList(countryData);
            
            ////////
            for(int j = 0; j < 8; j+=2){

                // this would be generated by a loop
                seriesData.add( new XYChart.Data<>(countryData.get(j+1), countryData.get(j)));
                //System.out.println(countryData.get(j) + ", " +countryData.get(j+1));
                //System.out.println(countryData.get(j) + " " + countryData.get(j+1));
                /*LineChart.Series<Double, Double> series = new LineChart.Series<Double, Double>();
                series.getData().addAll(
                    new XYChart.Data<Double, Double>(countryData.get(0), countryData.get(1)),
                    new XYChart.Data<Double,Double>(countryData.get(2), countryData.get(3)),
                    new XYChart.Data<Double,Double>(countryData.get(4), countryData.get(5)),
                    new XYChart.Data<Double,Double>(countryData.get(6), countryData.get(7)));

                chart2.getData().add(series);*/

                /*new LineChart.Series<Double,Double>(listCountryName.get(i),
                                                    FXCollections.observableArrayList(
                        new XYChart.Data<Double,Double>(countryData.get(0), countryData.get(1)),
                        new XYChart.Data<Double,Double>(countryData.get(2), countryData.get(3)),
                        new XYChart.Data<Double,Double>(countryData.get(4), countryData.get(5)),
                        new XYChart.Data<Double,Double>(countryData.get(6), countryData.get(7))));*/
                        //LineChart.Series series = new LineChart.Series<Double,Double>();
                                                    /*FXCollections.observableArrayList(
                        new XYChart.Data<Double,Double>(countryData.get(0), countryData.get(1)),
                        new XYChart.Data<Double,Double>(countryData.get(2), countryData.get(3)),
                        new XYChart.Data<Double,Double>(countryData.get(4), countryData.get(5)),
                        new XYChart.Data<Double,Double>(countryData.get(6), countryData.get(7)));
                        series.setName(listCountryName.get(i));*/
                
            //}
            //XYChart.Series series = new XYChart.Series();
            //series.setData(seriesData);
            //series.setName(listCountryName.get(i));
            //lineChartData.add(series);
        //}
           // );

           /*ObservableList<XYChart.Data> series1Dat = FXCollections.observableArrayList();

        // this would be generated by a loop
        series1Dat.add( new XYChart.Data<>(0.0, 2000.0));
        series1Dat.add( new XYChart.Data<>(1.2, 2140));
        series1Dat.add( new XYChart.Data<>(2.2, 190));
        series1Dat.add( new XYChart.Data<>(2.7, 2.3));
        series1Dat.add( new XYChart.Data<>(2.9, 0.5));

        XYChart.Series series1 = new XYChart.Series();
        series1.setData(series1Dat);

        lineChartData.add(series1);*/
            
        chart2 = new LineChart(xAxis2, yAxis2,lineChartData);
        return chart2;
    }

    private void handleOptions(CheckBox box1, CheckBox box2, CheckBox box3, CheckBox box4){

        if(box1.isSelected()) chart.getData().add(series1);
        else chart.getData().remove(series1);
        if(box2.isSelected()) chart.getData().add(series2);
        else chart.getData().remove(series2);
        if(box3.isSelected()) chart.getData().add(series3);
        else chart.getData().remove(series3);
        if(box4.isSelected()) chart.getData().add(series4);
        else chart.getData().remove(series4);
    }

 
    @Override
    public void start(Stage primaryStage) throws IOException {
        window = primaryStage;
        
        //Create CheckBox for year selection in graph 1
        CheckBox box1 = new CheckBox("2000");
        CheckBox box2 = new CheckBox("2010");
        CheckBox box3 = new CheckBox("2015");
        CheckBox box4 = new CheckBox("2018");

        //Create button for confirmation for CheckBoxes
        Button checkButton = new Button("Enter");
        checkButton.setOnAction(e -> handleOptions(box1,box2,box3,box4));

        //Create buttons to switch scenes
        Button buttonScene1 = new Button("Horizontal Bar Chart");
        buttonScene1.setOnAction(e -> window.setScene(scene1));
        Button buttonScene2 = new Button("Line Chart");
        buttonScene2.setOnAction(e -> window.setScene(scene2));

        //Layout 1
        VBox layout1 = new VBox(10);
        layout1.setPadding(new Insets(20,20,20,20));
        layout1.getChildren().addAll(box1, box2, box3, box4, checkButton, lineChartApp(), buttonScene2);
        scene1 = new Scene(layout1, 600, 600);

        //Layout 2
        VBox layout2 = new VBox(10);
        //StackPane layout2 = new StackPane();
        layout2.setPadding(new Insets(20,20,20,20));
        layout2.getChildren().addAll(lineChartApp(),buttonScene1);
        scene2 = new Scene(layout2, 600, 600);         
        
        window.setScene(scene1);
        window.show();
    }
 
    /**
     * Java main for when running without JavaFX launcher
     */
    public static void main(String[] args) throws IOException{
        launch(args);
    }

}
package cpt;

import java.util.*;
import java.io.*;

//Imports for JavaFx and Bar Chart
import javafx.collections.ObservableList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.stage.Stage;

//Imports for Scatter Chart
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;

//Imports for button
import javafx.scene.control.CheckBox;
import javafx.scene.control.Button;

//Imports for VBox and stacked layout
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;

/**
 * Data integration with graphs and visualization
 * @author: N. Wan
 * 
 */
public class Main extends Application{
    
    Stage window;
    Scene scene1;
    Scene scene2;
    CheckBox CheckBox;    
    Button button;
 
    //Bar chart variables
    private BarChart<Number, String> chart;
    private NumberAxis xAxis;
    private CategoryAxis yAxis;
    
    //Bar chart options to help stop double data
    private boolean box1Graph1Option, box2Graph1Option, box3Graph1Option, box4Graph1Option;

    //Scatter chart variables
    private ScatterChart<String, Number> scatterChart;
    private CategoryAxis xAxisScatter;
    private NumberAxis yAxisScatter;
    private XYChart.Series<String, Number> series1Scatter = new XYChart.Series<>();
    private XYChart.Series<String, Number> series2Scatter = new XYChart.Series<>();
    private XYChart.Series<String, Number> series3Scatter = new XYChart.Series<>();
    private XYChart.Series<String, Number> series4Scatter = new XYChart.Series<>();

    //Bar chart series
    private XYChart.Series<Number, String> series1 = new XYChart.Series<>();
    private XYChart.Series<Number, String> series2 = new XYChart.Series<>();
    private XYChart.Series<Number, String> series3 = new XYChart.Series<>();
    private XYChart.Series<Number, String> series4 = new XYChart.Series<>();

    //Line chart options to help stop double data
    private boolean box1Graph2Option, box2Graph2Option, box3Graph2Option, box4Graph2Option;

    /**
     * Makes a horizontal bar chart with data 
     * @return Returns horizontal bar chart 
     */
    public Parent horizontalBarChartApp() throws IOException {

        // Get all countries
        DataCollection dataCollection = new DataCollection();
        ArrayList<String> listCountryName = dataCollection.countryName();
        
        //Get all data in a specific year
        ArrayList<Country> year1 = dataCollection.yearlyData(2000);
        ArrayList<Country> year2 = dataCollection.yearlyData(2010);
        ArrayList<Country> year3 = dataCollection.yearlyData(2015);
        ArrayList<Country> year4 = dataCollection.yearlyData(2018);

        FXCollections.<String>observableArrayList(listCountryName);

        //Define and label axis and title
        xAxis = new NumberAxis();
        yAxis = new CategoryAxis();
        chart = new BarChart<>(xAxis, yAxis);
        chart.setTitle("Total Alcohol Consumption per Capita (Liters of Pure Alcohol, 15+ age)");
        yAxis.setLabel("Country");
        xAxis.setLabel("Total Pure Alcohol Consumption per Person over 15 years of age");
 
        //Add data to series
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
        
        //Set chart size and return
        chart.setPrefHeight(600);
        chart.setPrefWidth(500);
        return chart;
    }

    /**
     * Makes a scatteer chart with data 
     * @return Returns scatter chart 
     */
    public Parent scatterChartApp() throws IOException{ 

        DataCollection dataCollection = new DataCollection();

        //Get all data in a specific year
        ArrayList<Country> year1 = dataCollection.yearlyData(2000);
        ArrayList<Country> year2 = dataCollection.yearlyData(2010);
        ArrayList<Country> year3 = dataCollection.yearlyData(2015);
        ArrayList<Country> year4 = dataCollection.yearlyData(2018);

        //Define axis and set label
        xAxisScatter = new CategoryAxis();
        yAxisScatter = new NumberAxis();
        xAxisScatter.setLabel("Country");
        yAxisScatter.setLabel("Total Alcohol Consumption per Capita (Liters of Pure Alcohol, 15+ age)");
        
        //Add data to series
        series1Scatter.setName("2000");
        for(int i = 0; i<year1.size();i++){
            series1Scatter.getData().add(
            new XYChart.Data<String, Number>(year1.get(i).getName(), year1.get(i).getAlcConsumption()));                
        }

        series2Scatter.setName("2010");
        for(int i = 0; i<year2.size();i++){
            series2Scatter.getData().add( new XYChart.Data<String, Number>(year2.get(i).getName(),year2.get(i).getAlcConsumption()));     
        }

        series3Scatter.setName("2015");
        for(int i = 0; i<year3.size();i++){
            series3Scatter.getData().add(
            new XYChart.Data<String, Number>(year3.get(i).getName(),year3.get(i).getAlcConsumption()));          
        }
    
        series4Scatter.setName("2018");
        for(int i = 0; i<year4.size();i++){
            series4Scatter.getData().add(
            new XYChart.Data<String, Number>(year4.get(i).getName(),year4.get(i).getAlcConsumption()));
        }

    //Create the scatter chart
    scatterChart = new ScatterChart(xAxisScatter, yAxisScatter);

    //Set title and return
    scatterChart.setTitle("Total Alcohol Consumption per Capita (Liters of Pure Alcohol, 15+ age)");
    return scatterChart;
    }

    /**
    * Button handle option for horizontal bar chart
    * @param box1 Button to display 2000 data 
    * @param box2 Button to display 2010 data 
    * @param box3 Button to display 2015 data
    * @param box4 Button to display 2020 data
    */
    private void handleOptions(CheckBox box1, CheckBox box2, CheckBox box3, CheckBox box4){

        if(box1Graph1Option == false && box1.isSelected()){ 
            chart.getData().add(series1);
            box1Graph1Option = true;
        } else if(box1.isSelected() == false){
            chart.getData().remove(series1);
            box2Graph1Option = false; 
        }

        if(box2.isSelected() && box2Graph1Option == false) {
            chart.getData().add(series2);
            box2Graph1Option = true;
        }else if(box2.isSelected() == false){
            chart.getData().remove(series2);
            box2Graph1Option = false;
        }

        if(box3.isSelected() && box3Graph1Option == false) {
            chart.getData().add(series3);
            box3Graph1Option = true;
        }else if (box3.isSelected() == false) {
            chart.getData().remove(series3);
            box3Graph1Option = false;
        }

        if(box4.isSelected() && box4Graph1Option == false) { 
            chart.getData().add(series4);
            box4Graph1Option = true;
        } else if (box4.isSelected() == false) { 
            chart.getData().remove(series4);
            box4Graph1Option = false;
        }
    }

    /**
    * Button handle option for scatter chart
    * @param box1 Button to display 2000 data 
    * @param box2 Button to display 2010 data 
    * @param box3 Button to display 2015 data
    * @param box4 Button to display 2020 data
    */
    private void handleScatterOptions(CheckBox box1, CheckBox box2, CheckBox box3, CheckBox box4){

        if(box1.isSelected() && box1Graph2Option == false) {
            scatterChart.getData().add(series1Scatter);
            box1Graph2Option = true;
        }else if (box1.isSelected() == false) {
            scatterChart.getData().remove(series1Scatter);
            box1Graph2Option = false;
        }

        if(box2.isSelected() && box2Graph2Option == false) {
            scatterChart.getData().add(series2Scatter);
            box2Graph2Option = true;
        } else if (box2.isSelected() == false){
            scatterChart.getData().remove(series2Scatter);
            box2Graph2Option = false;
        }

        if(box3.isSelected() && box3Graph2Option == false) {
            scatterChart.getData().add(series3Scatter);
            box3Graph2Option = true;
        } else if (box3.isSelected() == false){
            scatterChart.getData().remove(series3Scatter);
            box3Graph2Option = false;
        }

        if(box4.isSelected() && box4Graph2Option == false) {
            scatterChart.getData().add(series4Scatter);
            box4Graph2Option = true;
        } else if (box4.isSelected() == false){
            scatterChart.getData().remove(series4Scatter);
            box4Graph2Option = false; 
        }
    }

    /**
    * start window
    * @param primaryStage starting page 
    */
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
        layout1.getChildren().addAll(box1, box2, box3, box4, checkButton, horizontalBarChartApp(), buttonScene2);
        scene1 = new Scene(layout1, 600, 600);
        
        //Checkboxes for graph 2 
        CheckBox box1Graph2 = new CheckBox("2000");
        CheckBox box2Graph2 = new CheckBox("2010");
        CheckBox box3Graph2 = new CheckBox("2015");
        CheckBox box4Graph2 = new CheckBox("2018");

        //Create button the confirm scatter chart data
        Button buttonScatter = new Button("Enter");
        buttonScatter.setOnAction(e -> handleScatterOptions(box1Graph2,box2Graph2,box3Graph2,box4Graph2));

        //Layout 2
        VBox layout2 = new VBox(10);
        layout2.setPadding(new Insets(20,20,20,20));
        layout2.getChildren().addAll(box1Graph2,box2Graph2,box3Graph2,box4Graph2, buttonScatter, scatterChartApp(), buttonScene1);
        scene2 = new Scene(layout2, 1920, 1080);         
        
        //Set scene 1 as base scene and show
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
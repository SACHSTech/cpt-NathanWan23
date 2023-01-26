package cpt;

//Imports
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.*;
import java.util.*;

/**
 * Data collection from csv file and methods to return specific parts of the data
 * @author: N. Wan
 * 
 */
public class DataCollection{
    
    private static ArrayList <Country> countryList = new ArrayList <Country>();

    /**
    * Taking data from csv file and putting into an array
    */
    public DataCollection() throws IOException{

        //Read it 
        BufferedReader Br = new BufferedReader(new FileReader("src\\total-alcohol-consumption-per-capita-litres-of-pure-alcohol.csv"));
        String str = Br.readLine();

        //Put everything into the array
        while(str != null) {
            String[] holder = str.split(",");
            Country Country = new Country(holder[0], Integer.parseInt(holder[2]), Double.parseDouble(holder[3]));
            countryList.add(Country);
            str = Br.readLine();
        }
        Br.close();
    }

    /**
    * A method that takes in a year and returns all data with that year
    * @param year takes in the year that wants to be shown all the data
    * @return ArrarList<Country> customList a list with only data from that year
    */
    public ArrayList<Country> yearlyData(int year){

        ArrayList <Country> customList = new ArrayList <Country>();

        for(int i = 0; i < countryList.size();i++){
            if(countryList.get(i).getYear() == year) customList.add(countryList.get(i));
        }
        
        return customList;
        
    }

    /**
    * A method that returns all country names
    * @return ArrarList<String> customList a list with only country names
    */
    public ArrayList<String> countryName(){
        
        ArrayList <String> customList = new ArrayList <String>();
        customList.add(countryList.get(0).getName());

        for(int i = 1; i < countryList.size();i++) {
            if(countryList.get(i).getName().equals(countryList.get(i-1).getName()) == false) customList.add(countryList.get(i).getName()); 
        }
        return customList;

    }

    /**
    * A method that takes in a country and returns all data associated with that data
    * @param country the country
    * @return ArrarList<Double> customList a list with only data from that country
    */
    public ArrayList<Double> countryData(String country){

        ArrayList <Double> customList = new ArrayList <Double>();

        for(int i = 0; i < countryList.size();i++){
            if(countryList.get(i).getName().equals(country)) {
                customList.add((double)countryList.get(i).getYear());
                customList.add(countryList.get(i).getAlcConsumption());
        
            }
        }
        return customList;
        
    }

}

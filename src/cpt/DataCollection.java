package cpt;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class DataCollection{
    
    private static ArrayList <Country> countryList = new ArrayList <Country>();
    
    //static StringTokenizer st;
    
    public static void main(String[] args) throws IOException{
    
        DataCollection DataCollection = new DataCollection();
         
        /*for(int i = 0; i<countryList.size();i++){
            System.out.println(countryList.get(i).getName());
            System.out.println(countryList.get(i).getYear());
            System.out.println(countryList.get(i).getAlcConsumption());
        }*/

        ArrayList <Double> Lis = new ArrayList <Double>();
        Lis = DataCollection.countryData("Canada");

        for(int i =0;i<Lis.size();i++){
            System.out.println(Lis.get(i));
        }

        ArrayList <String> List = new ArrayList <String>();
        List = DataCollection.countryName();

        for(int i = 0; i<List.size();i++){
            System.out.println(List.get(i));
        } 

        

    }

    public DataCollection() throws IOException{
        BufferedReader Br = new BufferedReader(new FileReader("src\\total-alcohol-consumption-per-capita-litres-of-pure-alcohol.csv"));
        String str = Br.readLine();

        while(str != null) {
            
            String[] holder = str.split(",");
            Country Country = new Country(holder[0], Integer.parseInt(holder[2]), Double.parseDouble(holder[3]));
            countryList.add(Country);
            str = Br.readLine();
        }
        Br.close();
    }

    /*public void addCountry() throws IOException{
        BufferedReader Br = new BufferedReader(new FileReader("total-alcohol-consumption-per-capita-litres-of-pure-alcohol.csv"));
        //StringTokenizer st;
        String str = Br.readLine();
        //String[] holder;

        while(str != null) {
            
            String[] holder = str.split(",");
            Country Country = new Country(holder[0], Integer.parseInt(holder[2]), Double.parseDouble(holder[3]));
            countryList.add(Country);
            str = Br.readLine();
        }

        System.out.println(countryList);
        Br.close();

    }*/

    /*public ArrayList<Country> deleteCountry(ArrayList<Country> country){

        ArrayList <Country> customList = new ArrayList <Country>();
        int counter = country.size();
        customList = countryList; 

        while(country.size() > 0){
            if(country.get(0) == customList.get(counter)){
                customList.remove(counter);
                counter--;
                country.remove(0);   
            } else counter++;
        }
        
        return customList;
        
    } */

    public ArrayList<Country> yearlyData(int year){

        ArrayList <Country> customList = new ArrayList <Country>();

        for(int i = 0; i < countryList.size();i++){
            if(countryList.get(i).getYear() == year) customList.add(countryList.get(i));
        }
        
        return customList;
        
    }

    public ArrayList<String> countryName(){
        
        ArrayList <String> customList = new ArrayList <String>();
        customList.add(countryList.get(0).getName());

        for(int i = 1; i < countryList.size();i++) {
            if(countryList.get(i).getName().equals(countryList.get(i-1).getName()) == false) customList.add(countryList.get(i).getName()); 
        }
        return customList;

    }

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

    public static ArrayList<String> hi(){
        ArrayList <String> customList = new ArrayList <String>();
        String lastCountry = countryList.get(0).getName(); 
        //boolean done = true;
        int i = 1, counter = 0;
        while(i<countryList.size()){
            if(countryList.get(i).getName().equals(lastCountry)){
                counter++;
            } 
            else {
                if(counter < 4) customList.add(countryList.get(i-1).getName());
                lastCountry = countryList.get(i).getName();
                counter = 0;
            }
            i++;
        }
        return customList;
    }

}

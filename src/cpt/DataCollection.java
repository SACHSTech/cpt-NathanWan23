package cpt;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class DataCollection{
    
    static ArrayList <Country> countryList = new ArrayList <Country>();
    
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException{
    
        DataCollection DataCollection = new DataCollection();
         
        /*for(int i = 0; i<countryList.size();i++){
            System.out.println(countryList.get(i).getName());
            System.out.println(countryList.get(i).getYear());
            System.out.println(countryList.get(i).getAlcConsumption());
        }*/

        ArrayList <Country> List = new ArrayList <Country>();
        List = addCountry(2000);

        for(int i = 0; i<List.size();i++){
            System.out.println(List.get(i).getName());
            System.out.println(List.get(i).getYear());
            System.out.println(List.get(i).getAlcConsumption());
        }

    }

    public DataCollection() throws IOException{
        BufferedReader Br = new BufferedReader(new FileReader("total-alcohol-consumption-per-capita-litres-of-pure-alcohol.csv"));
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

    public static ArrayList<Country> addCountry(int year){

        ArrayList <Country> customList = new ArrayList <Country>();

        for(int i = 0; i < countryList.size();i++){
            if(countryList.get(i).getYear() == year) customList.add(countryList.get(i));
        }
        
        return customList;
        
    }

    public static ArrayList<String> countryName(){
        
        ArrayList <String> customList = new ArrayList <String>();

        for(int i = 0; i < countryList.size();i++) customList.add(countryList.get(i).getName());
        
        return customList;

    }


}

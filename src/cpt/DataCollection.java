package cpt;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class DataCollection{
    
    private ArrayList <Country> countryList = new ArrayList <Country>();

    
    static StringTokenizer st;
    
    public DataCollection(){
    }

    public void addCountry() throws IOException{
        BufferedReader Br = new BufferedReader(new FileReader("total-alcohol-consumption-per-capita-litres-of-pure-alcohol.csv"));
        //StringTokenizer st;
        String str = Br.readLine();
        //String[] holder;

        while(str != null) {
            
            String[] holder = str.split(",");
            Country Country = new Country(holder[0], Integer.parseInt(holder[1]), Integer.parseInt(holder[2]));
            countryList.add(Country);
            str = Br.readLine();
        }
    
        Br.close();

        //countryList.add(country);
    }

    public Country[] deleteCountry(Country country){

        
    }


}

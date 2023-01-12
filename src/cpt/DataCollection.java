package cpt;
import java.util.*;
import java.io.*;

public class DataCollection {
    
    private ArrayList <Country> countryList = new ArrayList <Country>();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public DataCollection(){
    }

    public void addCountry(Country country){
                countryList.add(country);
    }


}

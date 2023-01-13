package cpt;

public class Country {
    
    private String name;
    private int year;
    private int alcConsumption;

    public Country(String countryName, int countryYear, int countryAlcConsum){
        this.name = countryName;
        this.year = countryYear;
        this.alcConsumption = countryAlcConsum;
    }

    public String getName(){
        return name;
    }

    public int getYear(){
        return year;
    }

}

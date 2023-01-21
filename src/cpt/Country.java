package cpt;

public class Country {
    
    private String name;
    private int year;
    private double alcConsumption;

    public Country(String countryName, int countryYear, double countryAlcConsum){
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

    public double getAlcConsumption(){
        return alcConsumption;
    }
}

package cpt;

/**
 * Creating coutry objects (data objects)
 * @author: N. Wan
 * 
 */
public class Country {
    
    //Initialize variables
    private String name;
    private int year;
    private double alcConsumption;

    /**
    * data point constructor
    * @param countryName country's name
    * @param countryYear data point's year
    * @param countryAlcConsum data for that country from that year
    */
    public Country(String countryName, int countryYear, double countryAlcConsum){
        this.name = countryName;
        this.year = countryYear;
        this.alcConsumption = countryAlcConsum;
    }

    /**
    * getter name method
    @return name returns the name of the country
    */
    public String getName(){
        return name;
    }

    /**
    * getter year method
    * @return year that this data point is 
    */
    public int getYear(){
        return year;
    }

    /**
    * getter alcohol consumption method
    * @return alcConsumption returns the alcohol consumption for that country in a specific data point year
    */
    public double getAlcConsumption(){
        return alcConsumption;
    }
}

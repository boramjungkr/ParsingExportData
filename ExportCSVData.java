
/**
 * Coursera 
 * Java Programming: Solving Problems with Software
 * Programming Exercise: Parsing Export Data
 * 
 * @author (Boram Jung) 
 * @version (March 1, 2019)
 */

import edu.duke.*;
import org.apache.commons.csv.*;

public class ExportCSVData {
    public void countryInfo(CSVParser parser, String country){
        boolean found = false;
        for(CSVRecord record : parser){
            //look at the "Country" column
            String getCountry = record.get("Country");
            //check if it contains country info
            if(getCountry.contains(country)){
                System.out.println(getCountry + " : " 
                +record.get("Exports")+" : "+record.get("Value (dollars)"));
                found = true;
            } 
        }if (!found) System.out.println("NOT FOUND");
    }
    
    
    
    
    
    
    //tester
    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        countryInfo(parser,"Germany");
    }
}


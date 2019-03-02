
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
                System.out.println(getCountry + ": " 
                +record.get("Exports")+": "+record.get("Value (dollars)"));
                found = true;
            } 
        }
        if(!found) System.out.println("NOT FOUND");
    }
    
    //print exporting 2 items
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
            for(CSVRecord record : parser){
            //look at the "Exports" column
            String export = record.get("Exports");
            if(export.contains(exportItem1) && export.contains(exportItem2)){
                System.out.println(record.get("Country"));
            }
        }
    }
    
    //print the number of countries that export certain item
    public void numberOfExporters(CSVParser parser, String exportItem){
        int num = 0;    
        for(CSVRecord record : parser){
            //look at the "Exports" column
            String export = record.get("Exports");
            if(export.contains(exportItem)) {
               num++;
              }
	}
	System.out.println("How many countries export " + exportItem + ": " + num);
    }
    
    //print countries exporting total amount over $999,999,999
    public void bigExporters(CSVParser parser, String amount){
        String totalAmount = "$999,999,999";   
        for(CSVRecord record : parser){
            //look at the "Value (dollars)" column
            String value = record.get("Value (dollars)");
            if(value.length() > totalAmount.length()) {
               System.out.println(record.get("Country")+" "+value);
              }
	}
	
    }
    
    //tester
    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        countryInfo(parser,"Germany");
        parser = fr.getCSVParser();
        listExportersTwoProducts(parser, "gold", "diamonds");
        parser = fr.getCSVParser();
        numberOfExporters(parser, "gold");
        parser = fr.getCSVParser();
        bigExporters(parser, "$999,999,999");
        parser = fr.getCSVParser();
    }
}


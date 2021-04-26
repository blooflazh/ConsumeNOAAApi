package JSON;


/**
 * 
 * IST 411 
 * Locations.java 
 * Purpose: Creates an array of the 'results' class, establishing the structure of the final GSON
 *  
 * 
 * @author Kameron Dangleben 2/14/2021
 */


import java.util.Arrays;


public class Stations {
        private Results[] results;
	
        public Results[] getResult() {
            return results;
        }
	
	@Override
	public String toString(){
		String s;//Create string 
                s = "Results inserted into array.";//Print each member of array
		return s;
	}
	
}

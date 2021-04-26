package JSON;


/**
 * 
 * IST 411 
 * grabFromURL.java
 * Purpose: Requests connection with URL, and grabs the JSON content. The JSON
 * is converted to GSON so it may be compiled through java. It fills the Results array
 * with the results json class.
 *  
 * 
 * @author Kameron Dangleben 3/4/2021
 */
import JSON.Stations;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.*;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class grabFromURL {
    private Results[] r;
	public void run() throws MalformedURLException, IOException{	
            URL url = new URL("https://www.ncdc.noaa.gov/cdo-web/api/v2/data?datasetid=GHCND&locationid=ZIP:28801&startdate=2020-06-01&enddate=2020-07-01");//Grab URL
                HttpURLConnection webPage = (HttpURLConnection) url.openConnection();
                webPage.setRequestProperty("token", "idiOlDSXtpJrsRsxSwGmsqihykqihnVX");//Request Token
                System.out.println("Requesting connection to " + url.toString() );//Prompt user
                webPage.setConnectTimeout(15000);
                webPage.setReadTimeout(15000);
                
                try (InputStream is = webPage.getInputStream();//Get the input from the website
                Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8)) {


                Gson gson = new Gson();//Create a gson

		//gson data will be grabbed from json
		Stations st = gson.fromJson(reader, Stations.class);
		System.out.println("Connection Established.\n\n" + st);//Prompt
                setR(st.getResult());
            }
        }

    /**
     * @return the r
     */
    public Results[] getR() {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(Results[] r) {
        this.r = r;
    }
}

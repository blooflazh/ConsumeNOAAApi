package DATABASE;




/**
 * 
 * IST 411 
 * AddToTable.java 
 * Purpose: Adds an entry to a Derby table, using the 'INSERT' SQL command. Grabs
 * GSON data from grabFromURL.java. Update 3/13/21: Selects data from the table to insert into the GUI0.java file.
 *  
 * 
 * @author Kameron Dangleben 3/4/2021
 */



import java.util.*;
import java.io.*;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import JSON.*;
import JSON.Results;



public class AddToTable  
{
    

    private ArrayList<String> results = new ArrayList<>();//Results and cbox will be grabbed by the GUI
    private ArrayList<String> cbox = new ArrayList<>();
    
    public AddToTable()
    {
        results = this.results;
    }
    
    public void init() throws IOException
    {
        grabFromURL l = new grabFromURL();//Grab data from the url
        l.run();//'l' must be ran before data can be added to the table
        AddToTable a = new AddToTable();
        a.start(l.getR());//Start the database, and insert using the data from the url
 
    }
    
    
    public ArrayList<String> grabFromDB()
     {
       
         try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        }
        catch (Exception e)
        {
            System.out.println(" driver failed to load.");
            System.exit(-1);
        }

        try
        {
            Connection con =
                    DriverManager.getConnection("jdbc:derby://localhost:1527/GSONdb", "app", "app");//Replace with your database

            Statement stmt = con.createStatement();
              con.setAutoCommit(false);
            ResultSet rs = stmt.executeQuery("SELECT ID ,DATATYPE, STATION, ATTRIBUTES,VALUE, DATE FROM RESULTS");//Selects a product name depending on what product id 'm' is equal to
           
            ResultSetMetaData rsmd = rs.getMetaData();
            
            
          
            //this.clearLm();
            int size =0;
           //ArrayList<String>cbox = new ArrayList<String>();

            while (rs.next())
            {
                       // cbox.add(String.valueOf(i));
        
                       
                        //this.updateLm(String.valueOf(rs.getInt(1)), rs.getString(2),rs.getString(6), rs.getString(4), rs.getString(3), rs.getString(5));
                        getResults().add(String.valueOf(rs.getInt(1)));
                        getResults().add(rs.getString(2));
                        getResults().add(rs.getString(6));
                        getResults().add(rs.getString(4));
                        getResults().add(rs.getString(3));
                        getResults().add(rs.getString(5));
                        getCbox().add(String.valueOf(rs.getInt(1)));
                        
            }
            
            //getjComboBox1().setModel(new DefaultComboBoxModel<>(cbox.toArray(new String[0])));
            //dbComplete= true;
           
            stmt.close();

            con.close();
             return getResults();
        }
        catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
     }
 
    public void start(Results[] r) {
        
        
        
        // access non-static fields
        String className=null;
        String url=null;
        String user = null;
        String password = null;
         
        try
        {
            ResourceBundle resources;
            InputStream in = null;
            ResourceBundle newResources;

            in = ClassLoader.getSystemResourceAsStream("db.properties");

            resources = new PropertyResourceBundle(in);

            in.close();

            className = resources.getString("jdbc.driver");
            url = resources.getString("jdbc.url");
            System.out.println(url);
            user = resources.getString("jdbc.user");
            password = resources.getString("jdbc.password");
        }
        catch (Exception exp)
        {
            System.out.println("Couldn't load resources." + exp);
            System.exit(-1);
        }
        
        try
        {
            Class.forName(className);
        }
        catch (Exception e) 
        {
            System.out.println("Failed to load  driver.");
            return;
        }
        
        try
        {
           System.out.println("Trying connection.");
            Connection con = DriverManager.getConnection(url,user,password);     
            Statement stmt = con.createStatement();
            System.out.println("Created connection.");
            
            for(int i = 0; i < r.length; i++)//Insert into the table for each array member
            {
             
            stmt.execute("INSERT INTO APP.RESULTS (ID, DATATYPE, STATION, ATTRIBUTES, VALUE, DATE) \n" +
            "	VALUES (" + i + ",'" + r[i].getDatatype() + "','" + r[i].getStation() + "','" + r[i].getAttributes() + "'," + r[i].getValue()+ ",'" + r[i].getDate() + "')");//Insert into test table
            
            
               System.out.println("Inserted into table.");
            }
        
            System.out.println("Table build successful.");
        
            stmt.close();
        
            con.close();
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }
    }

    /**
     * @return the results
     */
    public ArrayList<String> getResults() {
        return results;
    }

    /**
     * @param results the results to set
     */
    public void setResults(ArrayList<String> results) {
        this.setResults(results);
    }

    /**
     * @return the cbox
     */
    public ArrayList<String> getCbox() {
        return cbox;
    }

    /**
     * @param cbox the cbox to set
     */
    public void setCbox(ArrayList<String> cbox) {
        this.cbox = cbox;
    }


}


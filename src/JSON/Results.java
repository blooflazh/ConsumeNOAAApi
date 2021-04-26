package JSON;


/**
 * 
 * IST 411 
 * Results.java 
 * Purpose: Converts the 'results' json class into a Java format.
 *  
 * 
 * @author Kameron Dangleben 3/4/21
 */



public class Results {
    
 
    private String date;
    private String datatype;
    private String station;
    private String attributes;
    private int value;

    
    @Override
    public String toString(){
	return "\n" + getDate() + "\n***********************\n" + "Data Type: " + getDatatype() +"\tStation: "
                + getStation() + "\tAttributes: " + getAttributes() + "\nValue: "
                + getValue() +"\n";//Print in a user-friendly format.
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the datatype
     */
    public String getDatatype() {
        return datatype;
    }

    /**
     * @param datatype the datatype to set
     */
    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    /**
     * @return the station
     */
    public String getStation() {
        return station;
    }

    /**
     * @param station the station to set
     */
    public void setStation(String station) {
        this.station = station;
    }

    /**
     * @return the attributes
     */
    public String getAttributes() {
        return attributes;
    }

    /**
     * @param attributes the attributes to set
     */
    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }

  
    
}

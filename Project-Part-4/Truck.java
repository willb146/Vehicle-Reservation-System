import java.util.ArrayList;
import java.util.*;

/**
 * Write a description of class Truck here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Truck extends Commercial
{
    // instance variables - replace the example below with your own
    private double payLoad;
    private ArrayList<String> attributes;

    /**
     * Constructor for objects of class Truck
     */
    public Truck()
    {
        // initialise instance variables
        payLoad = 0.0;
        attributes = new ArrayList<String>();
    }
    
    public void printDetails()
    {
        super.printDetails();
        System.out.println("Payload: " + payLoad);
        System.out.println("Attributes:");
        for (String attribute : this.attributes)
        {
            System.out.println(attribute);
        }
    }
    
    public void readData(Scanner scanner)
    {
        super.readData(scanner);
        payLoad = Double.parseDouble(scanner.next().trim());
        while (scanner.hasNext())
        {
            this.attributes.add(scanner.next().trim());
        }
    }


}

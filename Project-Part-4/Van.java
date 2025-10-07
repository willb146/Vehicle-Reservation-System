import java.util.*;

/**
 * Write a description of class Van here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Van extends Commercial
{
    // instance variables - replace the example below with your own
    private double payLoad;
    private double loadVolume;
    private boolean slidingSideDoor;

    /**
     * Constructor for objects of class Van
     */
    public Van()
    {
        // initialise instance variables
        payLoad = 0.0;
        loadVolume = 0.0;
        slidingSideDoor = false;
    }
    
    public void printDetails()
    {
        super.printDetails();
        System.out.println("Payload: " + payLoad);
        System.out.println("Load Volume " + loadVolume);
        System.out.println("Sliding door: " + slidingSideDoor);
    }
    
    public void readData(Scanner scanner)
    {
        super.readData(scanner);
        payLoad = Double.parseDouble(scanner.next().trim());
        loadVolume = Double.parseDouble(scanner.next().trim());
        slidingSideDoor = Boolean.parseBoolean(scanner.next().trim());
    }

}

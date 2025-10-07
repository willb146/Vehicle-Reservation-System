import java.util.*;

/**
 * Write a description of class Car here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Car extends Vehicle
{
    // instance variables - replace the example below with your own
    private String bodyType;
    private int noOfDoors;
    private int noOfSeats;

    /**
     * Constructor for objects of class Car
     */
    public Car()
    {
        // initialise instance variables
        this.bodyType = "";
        this.noOfDoors = 0;
        this.noOfSeats = 0;
    }
    
    public void printDetails()
    {
        super.printDetails();
        System.out.println("Body Type: " + bodyType);
        System.out.println("Number of doors " + noOfDoors);
        System.out.println("Number of seats " + noOfSeats);
    }
    
    public void readData(Scanner scanner)
    {
        super.readData(scanner);
        bodyType = scanner.next().trim();
        noOfDoors = Integer.parseInt(scanner.next().trim());
        noOfSeats = Integer.parseInt(scanner.next().trim());
    }

}

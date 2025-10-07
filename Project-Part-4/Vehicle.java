import java.util.*;
import java.io.*;
import java.awt.*;

/**
 * Write a description of class Test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Vehicle
{
    // instance variables - replace the example below with your own
    private String group;
    private String vehID;
    private String regNo;
    private String make;
    private String model;
    private boolean aircon;
    private double engineSize;
    private String fuelType;
    private String gearbox;
    private String transmission;
    private int mileage;
    private String dateFirstRegistered;
    
    public void readData(Scanner scanner)
    {
        group = scanner.next().trim();
        vehID = scanner.next().trim();
        regNo = scanner.next().trim();
        make = scanner.next().trim();
        model = scanner.next().trim();
        aircon = Boolean.parseBoolean(scanner.next().trim());
        engineSize = Double.parseDouble(scanner.next().trim());
        fuelType = scanner.next().trim();
        gearbox = scanner.next().trim();
        transmission = scanner.next().trim();
        mileage = Integer.parseInt(scanner.next().trim());
        dateFirstRegistered = scanner.next().trim();
    }
    
    public String getGroup()
    {
        return group;
    }
    
    public String getVehID()
    {
        return vehID;
    }
    
    public String getRegNo()
    {
        return regNo;
    }
    
    public String getMake()
    {
        return make;
    }
    
    public void printDetails()
    {
        System.out.println("Make: " + make + " Model: " + model + " " + " Group: " + group + " " + "Vehicle Id: " + vehID);
        if(aircon)
        {
            System.out.println("Air conditioning/Climate Control: Yes");
        }
        else
        {
            System.out.println("Air conditioning/Climate Control: No");
        }
        System.out.println("Engine Size: " + engineSize + " Fuel: " + fuelType);
        System.out.println("Gearbox: " + gearbox + " Transmission: " + transmission);
        System.out.println("Mileage: " + mileage + " Date first registered: " + dateFirstRegistered);
        
    }

}

import java.util.Date;
import java.util.Map;
import java.util.Scanner;

/**
 * Write a description of class VehicleReservation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class VehicleReservation
{
    // instance variables - replace the example below with your own
    private String reservationNo;
    private String vehID;
    private String customerID;
    private Date startDate;
    private int noOfDays;
    private DateUtil dateUtil;


    /**
     * Constructor for objects of class VehicleReservation
     */
    public VehicleReservation(String initResNo, String initVehID, String initCustID, String initStartDate, int initNoOfDays)
    {
        // initialise instance variables
        this.reservationNo = initResNo;
        this.vehID = initVehID;
        this.customerID = initCustID;
        this.startDate = dateUtil.convertStringToDate(initStartDate);
        this.noOfDays = initNoOfDays;
        
    }
    
    public VehicleReservation()
    {
    
    }
    
    public String getReservationNo()
    {
        return reservationNo;
    }
    
    public String getVehID()
    {
        return vehID;
    }
    
    public String getCustomerID()
    {
        return customerID;
    }
    
    public Date getStartDate()
    {
        return startDate;
    }
    
    public String getStringStartDate()
    {
        return dateUtil.convertDateToShortString(startDate);
    }
    
    public int getNoOfDays()
    {
        return noOfDays;
    }
    
    public void printDetails()
    {
        System.out.println("Reservation Number: " + reservationNo + " Vehicle ID: " + vehID + " Customer ID: " + customerID + " Start Date: " + dateUtil.convertDateToShortString(startDate) + " Number of days: " + noOfDays);
    }
    
    public void readData(Scanner scanner)
    {
        reservationNo = scanner.next().trim();
        vehID = scanner.next().trim();
        customerID = scanner.next().trim();
        startDate = dateUtil.convertStringToDate(scanner.next().trim());
        noOfDays = Integer.parseInt(scanner.next().trim());
    }
    
    

    
}

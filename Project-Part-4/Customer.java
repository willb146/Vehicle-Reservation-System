import java.util.*;
/**
 * Write a description of class Customer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Customer
{
    // instance variables - replace the example below with your own
    private String customerID;
    private String firstName;
    private String surname;
    private String otherInitials;
    private String title;

    /**
     * Constructor for objects of class Customer
     */
    public Customer(String initFirstName, String initSurname, String initOtherInitials, String initTitle)
    {
        // initialise instance variables
        customerID = "unknown";
        firstName = initFirstName;
        surname = initSurname;
        otherInitials = initOtherInitials;
        title = initTitle;
    }
    
    public Customer()
    {
    
    }
    
    public void setCustomerID(String newID)
    {
        this.customerID = newID;  
    }
    
    public String getCustomerID()
    {
        return customerID;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public String getSurname()
    {
        return surname;
    }
    
    public String getOtherInitials()
    {
        return otherInitials;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public void readData(Scanner scanner)
    {
        customerID = scanner.next().trim();
        surname = scanner.next().trim();
        firstName = scanner.next().trim();
        otherInitials = scanner.next().trim();
        title = scanner.next().trim();
    }
    
    public void printDetails()
    {
        System.out.println("Customer ID: " + customerID + " Title: " + title + " First Name: " + firstName + " Surname: " + surname + " OtherInitials " + otherInitials);
    }
}

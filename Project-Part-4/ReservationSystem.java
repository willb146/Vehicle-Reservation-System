import java.util.*;
import java.io.*;
import java.awt.*;
import java.util.List;
import java.text.SimpleDateFormat;

/**
 * Write a description of class ReservationSystem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ReservationSystem
{
    // instance variables - replace the example below with your own
    
    //Original statements
    //private ArrayList<Vehicle> vehicleList;
    //private ArrayList<Customer> customerList;
    
    //private List<Vehicle> vehicleList; 
    //private List<Customer> customerList;
    
    //private List<Vehicle> vehicleMap; 
    //private List<Customer> customerMap; 
    
    private Map<String, Vehicle> vehicleMap; 
    private Map<String, Customer> customerMap;
    private Map<String, VehicleReservation> reserveMap;
    private HashSet<String> IDHash;
    private String storedFilePath;
    private String currentReservationNo;
    private Diary diary;

    /**
     * Constructor for objects of class ReservationSystem
     */
    public ReservationSystem()
    {
        // initialise instance variables
        
        //Original statements
        //vehicleMap = new ArrayList<Vehicle>();
        //customerMap = new ArrayList<Customer>();
        
        vehicleMap = new HashMap<String, Vehicle>();
        customerMap = new HashMap<String, Customer>();
        reserveMap = new HashMap<String, VehicleReservation>();
        storedFilePath = null;
        IDHash = new HashSet<String>();
        diary = new Diary();
        this.readCurrentReservation();
    }

    public void storeVehicle(Vehicle vehicle)
    {
        vehicleMap.put(vehicle.getVehID(), vehicle);
    }
    
    public void printAllVehicles()
    {
        for (Vehicle vehicle : vehicleMap.values())
        {
            vehicle.printDetails();
        }
    }
    
    public void readVehicleData()
    {
       String typeOfData = "";
       Frame frame = null;
       FileDialog fileBox = new FileDialog(frame, "Open", FileDialog.LOAD);
       fileBox.setVisible(true);
       String fullFilePath = fileBox.getDirectory() + fileBox.getFile();
       try
       {
           File file = new File(fullFilePath);
           Scanner scanner = new Scanner(file);
           scanner.useDelimiter("\n");
           while(scanner.hasNext())
           {
               String lineOfText = scanner.next().trim();
               if (lineOfText.startsWith("["))
               {
                   typeOfData = lineOfText;
               }
               else if (!lineOfText.isEmpty() && !lineOfText.startsWith("//"))
               {
                   Scanner textScanner = new Scanner(lineOfText);
                   textScanner.useDelimiter(","); 
                   if (typeOfData.equals("[Car data]"))
                   {
                       Car theCar = new Car();
                       theCar.readData(textScanner);
                       this.storeVehicle(theCar);
                   }
                   if (typeOfData.equals("[van data]"))
                   {
                       Van theVan = new Van();
                       theVan.readData(textScanner);
                       this.storeVehicle(theVan);
                   }
                   if (typeOfData.equals("[Truck data]"))
                   {
                       Truck theTruck = new Truck();
                       theTruck.readData(textScanner);
                       this.storeVehicle(theTruck);
                   }
               }
           }
           scanner.close();
       }
        
       catch(FileNotFoundException e)
       {
           System.out.println("FileNotFoundException" + e.getMessage());
       }
       
    }
    
    public void storeCustomer(Customer customer)
    {
        if (customer.getCustomerID().equals("unknown"))
        {
            customer.setCustomerID(generateCustomerID("AB-",6));    
        }
        customerMap.put(customer.getCustomerID(), customer);
    }
    
    
    public void printAllCustomers()
    {
        for (Customer customer : customerMap.values())
        {
            customer.printDetails();
        }
    }
    
    public void readCustomerData()
    {
       Frame frame = null;
       FileDialog fileBox = new FileDialog(frame, "Open", FileDialog.LOAD);
       fileBox.setVisible(true);
       String fullFilePath = fileBox.getDirectory() + fileBox.getFile();
       try
       {
           File file = new File(fullFilePath);
           Scanner scanner = new Scanner(file);
           scanner.useDelimiter("\n");
           while(scanner.hasNext())
           {
               String lineOfText = scanner.next().trim();
               if (!lineOfText.isEmpty() && !lineOfText.startsWith("//"))
               {
                   Scanner textScanner = new Scanner(lineOfText);
                   textScanner.useDelimiter(","); 
                   Customer newCustomer = new Customer();
                   newCustomer.readData(textScanner);
                   this.storeCustomer(newCustomer);
               }
           }
           scanner.close();
           this.writeCustomerData(file.getName());
       }
        
       catch(FileNotFoundException e)
       {
           System.out.println("FileNotFoundException" + e.getMessage());
       }
    }
    
    public void writeCustomerData(String fileName) throws FileNotFoundException
    {
        PrintWriter pWriter = new PrintWriter(fileName);
        for (Customer c: customerMap.values())
        {
            String lineOfOutput = c.getCustomerID() + ", " + c.getSurname() + ", " + c.getFirstName() + ", " + c.getOtherInitials() + ", " + c.getTitle();
            pWriter.println(lineOfOutput);
        }
        pWriter.close();
    }
    
    public String getFilePath()
    {
        Frame frame = null;
        FileDialog fileBox = new FileDialog(frame, "Open", FileDialog.LOAD);
        fileBox.setVisible(true);
        String fullFilePath = fileBox.getDirectory() + fileBox.getFile();
        return fullFilePath;
    }
    
    public String generateCustomerID(String ID, int number)
    {
        Random rand = new Random();
        String numberString = "";
        String fullID = "";
        while (IDHash.contains(fullID) || fullID.isEmpty())
        {
            for (int i = 0; i < number; i++)
            {
                int digit = rand.nextInt(10);
                numberString += Integer.toString(digit);
            }
            fullID = ID + numberString;
        }
        IDHash.add(fullID);
        if(storedFilePath == null)
        {
            storedFilePath = getFilePath();
        }
        File file = new File(storedFilePath);
        try
        {
            this.writeIDData(file, fullID);
            return fullID;
        }
        catch(FileNotFoundException e)
       {
           System.out.println("FileNotFoundException" + e.getMessage());
       }
        return fullID;
    }
    
    public void writeIDData(File IDFile, String custID) throws FileNotFoundException
    {
        PrintWriter writerID = new PrintWriter(new FileOutputStream(IDFile.getName(),true));
        writerID.println(custID);
        writerID.close();
    }
        
    public void readIDData(String customerIDFile)
    {
       Frame frame = null;
       FileDialog fileBox = new FileDialog(frame, "Open", FileDialog.LOAD);
       fileBox.setVisible(true);
       String fullFilePath = fileBox.getDirectory() + fileBox.getFile();
       try
       {
           File file = new File(fullFilePath);
           Scanner scanner = new Scanner(file);
           scanner.useDelimiter("\n");
           while(scanner.hasNext())
           {
               String lineOfText = scanner.next().trim();
               if (!lineOfText.isEmpty())
               {
                   IDHash.add(lineOfText); 
               }
           }
           scanner.close();
       }
        
       catch(FileNotFoundException e)
       {
           System.out.println("FileNotFoundException" + e.getMessage());
       }    
    }
    
    public Vehicle getVehicle(String vehicleIdentity)
    {
        return vehicleMap.get(vehicleIdentity);
    }
    
    public Customer getCustomer(String customerIdentity)
    {
        return customerMap.get(customerIdentity);
    }
    
    public void storeVehicleReservation(VehicleReservation reserve)
    {
        diary.addReservation(reserve);
        reserveMap.put(reserve.getReservationNo(), reserve);
    }
    
    public VehicleReservation getVehicleReservation(String reservationNo)
    {
        return reserveMap.get(reservationNo);
    }
    
    public void readCurrentReservation()
    {
        String reserveNoLocation = getFilePath();
        File reserveFile = new File(reserveNoLocation);
        try
        {
            Scanner noScanner = new Scanner(reserveFile);
            currentReservationNo = noScanner.next().trim();
        }
        
        catch(FileNotFoundException e)
        {
            System.err.println("FileNotFoundException" + e.getMessage());
        }
    }
    
    public String generateReservationNo()
    {
        int tempNum = Integer.parseInt(currentReservationNo);
        tempNum += 1;
        currentReservationNo = Integer.toString(tempNum);
        while (currentReservationNo.length() <= 5)
        {
            currentReservationNo = "0" + currentReservationNo;
        }
        return currentReservationNo;
    }
    
    public boolean makeVehicleReservation(String customerID, String vehID, String startDate, int noOfDays)
    {
        if(customerMap.containsKey(customerID) && vehicleMap.containsKey(vehID) && noOfDays > 0)
        {
            Date date = DateUtil.convertStringToDate(startDate);
            for(int i = 0; i <= noOfDays; i++)
            {
                date = DateUtil.incrementDate(date,i);
                if(diary.getReservations(date) != null)
                {
                    for(VehicleReservation reserve : diary.getReservations(date))
                    {
                        if(reserve.getVehID().equals(vehID))
                        {
                            return false;
                        }
                    }
                }   
            }
            String tempReservationNo = this.generateReservationNo();
            VehicleReservation aVehRes = new VehicleReservation(tempReservationNo,vehID,customerID,startDate,noOfDays);
            this.storeVehicleReservation(aVehRes);
            return true;
        }
        else
        {
            return false;
        }
    }

    
    public void printAllVehicleReservation()
    {
        for (VehicleReservation vehicleRes : reserveMap.values())
        {
            vehicleRes.printDetails();
        }
    }
    
    public void writeVehicleReservationData(String fileName) throws FileNotFoundException
    {
        PrintWriter aWriter = new PrintWriter(fileName);
        for(VehicleReservation reserve : reserveMap.values())
        {
            String lineOfOutput = reserve.getReservationNo() + ", " + reserve.getVehID() + ", " + reserve.getCustomerID() + ", " + reserve.getStringStartDate() + ", " + reserve.getNoOfDays();
            aWriter.println(lineOfOutput);
        }
        aWriter.close();
    }
    
    public void readVehicleReservationData()
    {
       Frame frame = null;
       FileDialog fileBox = new FileDialog(frame, "Open", FileDialog.LOAD);
       fileBox.setVisible(true);
       String fullFilePath = fileBox.getDirectory() + fileBox.getFile();
       try
       {
           File file = new File(fullFilePath);
           Scanner scanner = new Scanner(file);
           scanner.useDelimiter("\n");
           while(scanner.hasNext())
           {
               String lineOfText = scanner.next().trim();
               if (!lineOfText.isEmpty() && !lineOfText.startsWith("//"))
               {
                   Scanner textScanner = new Scanner(lineOfText);
                   textScanner.useDelimiter(","); 
                   VehicleReservation aVehRes = new VehicleReservation();
                   aVehRes.readData(textScanner);
                   this.storeVehicleReservation(aVehRes);
               }
           }
           scanner.close();
       }
        
       catch(FileNotFoundException e)
       {
           System.out.println("FileNotFoundException" + e.getMessage());
       }
    }
    
    public void printDiaryEntries(String startDate, String endDate)
    {
        diary.printEntries(DateUtil.convertStringToDate(startDate), DateUtil.convertStringToDate(endDate));
    }
    
    public void deleteVehicleReservation(String resNo)
    {
        VehicleReservation delReservation = reserveMap.get(resNo);
        diary.deleteReservation(delReservation);
        reserveMap.remove(resNo);
    }
    
    
    
      
}

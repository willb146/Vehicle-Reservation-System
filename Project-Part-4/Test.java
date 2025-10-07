import java.util.Date;
import java.io.*;

/**
 * Write a description of class Test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Test
{
    // instance variables - replace the example below with your own
    
    public Test() throws FileNotFoundException
    {
        
        ReservationSystem resSystem = new ReservationSystem();
        DateUtil date = new DateUtil();
        
        /// Step 1 Testing ///
        
        //// Step 1 testing ////
        
        //resSystem.storeVehicle(new Vehicle("A1", "AA1", "iou()&", "fORD"));
        //resSystem.storeVehicle(new Vehicle("A2", "AA2", "iou()&", "fORD"));
        //resSystem.storeVehicle(new Vehicle("A3", "AA3", "iou*()&", "fORD"));

        //resSystem.printAllVehicles();

        //// Step 2 & Step 3 & Step 4 testing ////

        //resSystem.readVehicleData();
        //resSystem.printAllVehicles();
        
        /// Step 2 Testing ///
        
        //// part 2 step 1 Testing ////
        
        //resSystem.readVehicleData();
        //resSystem.printAllVehicles();
        
        //// part 2 step 4 Testing ////
        
        //resSystem.readVehicleData();
        //resSystem.printAllVehicles();
        
        //// part 2 step 5 Testing ////
        
        //resSystem.readVehicleData();
        //resSystem.printAllVehicles();        
        
        /// Step 3 Testing ///
        
        //// part 3 step 1 Testing ////
        
        //[1]
        // Customer customer = new Customer();
        // customer.printDetails();
        // resSystem.storeCustomer(customer);
        // resSystem.printAllCustomers();
        
        //[2]
        // resSystem.readCustomerData();
        // resSystem.printAllCustomers();
        
        ////Part 3 step 2 Testing////
        
        //[1]
        // Customer customer = new Customer();
        // resSystem.writeCustomerData("customer_data.txt");
        // resSystem.readCustomerData();
        
        ////Part 3 step 3 and 4 Testing////
        
        // resSystem.readCustomerData();
        // resSystem.printAllCustomers();
        
        ////Part 3 step 5 Testing////
        
        // resSystem.getVehicle("TF-67358")
        // resSystem.getCustomer("AB-939744")
        
        /// Step 4 testing ///
        //system.readVehicleData();
        //system.printAllVehicles();
        
        ////part 4 step 1 Testing////
        
        //[1]
        // String firstDate = "12-10-2006";
        // String secondDate = "15-10-2006";
        // Date initDate = date.convertStringToDate(firstDate);
        // Date finalDate = date.convertStringToDate(secondDate);
        
        // int dayNum = date.daysBetween(initDate, finalDate);
        // System.out.println(dayNum);
        
        ////Part 4 step 2 Testing////
        
        //[1]
        // VehicleReservation reservation = new VehicleReservation("000146","TF-765432","AB-239084","12-10-2006",8);
        // resSystem.storeVehicleReservation(reservation);
        // resSystem.printAllVehicleReservation();
        
        // System.out.println(resSystem.generateReservationNo());
        // resSystem.getVehicleReservation("000146").printDetails();
        
        //[2]
        // resSystem.readCustomerData();
        // resSystem.readVehicleData();
        // resSystem.makeVehicleReservation("AB-196730", "TF-63403","12-10-2006",8);
        
        // resSystem.writeVehicleReservationData("Reservation_Data.txt");
        // resSystem.readVehicleReservationData();
        // resSystem.printAllVehicleReservation();
        
        // VehicleReservation reservation = new VehicleReservation("000146","TF-765432","AB-239084","12-10-2006",8);
        // resSystem.storeVehicleReservation(reservation);
        // resSystem.printDiaryEntries("10-10-2006", "20-10-2006");
        // resSystem.deleteVehicleReservation("000146");
        // resSystem.printDiaryEntries("10-10-2006", "20-10-2006");
        
        ////Part 4 step 3 Testing////
        
        //[1]
        // resSystem.readCustomerData();
        // resSystem.readVehicleData();
        // resSystem.makeVehicleReservation("AB-196730", "TF-63403","12-10-2006",8);
        // //Should give true
        // resSystem.makeVehicleReservation("AB-819960", "TF-63403","10-10-2006",8);
        // //Should give false
        // resSystem.printDiaryEntries("05-10-2006", "15-10-2006");
        // resSystem.deleteVehicleReservation("000001");
        
        // resSystem.makeVehicleReservation("AB-819960", "TF-63403","10-10-2006",8);
        // resSystem.printDiaryEntries("05-10-2006", "15-10-2006");
    }
    
}

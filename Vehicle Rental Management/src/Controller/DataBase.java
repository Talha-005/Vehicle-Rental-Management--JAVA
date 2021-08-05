/**
 Project name : Vehicle Rental System
 Student name : Muhammad Talha Sohail
 Roll no.     : 0005-BSCS-2019 (Section-B)
 Description  : Class-DataBase. Here I have Designed a class. In this class there is Data/record of all classes. Only
                Admin has access to Data of his/her company, Customer/Mechanic/Vehicle/Booking/Bill details.
                When user enter data, then data will store in DataBase file. When program will run then all data from
                files will be loaded to program's attributes/fields.
 Used classes : All classes are used in this class. Bcz, company wants to store data for later use/view.
 **/

//============================================ Import-Libraries/Classes ==============================================||
package Controller;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//========================================== Class DataBase ==========================================================||
public class DataBase
{
    //========================================== Load-AdminFiles =====================================================||
    /**
     * loadAdminFile method means that when user store his/her
     * information which are asked then All that information/Data
     * will store. So, we have to reload all data in arraylist
     * from File bcz we want to use this stored data in our program.
     */
    public static void loadAdminFile()
    {
        try                                                              //Exception handling
        {
            File fileObj    = new File("DataBase\\AdminDataBase.txt");     // create A object of file and set path
            Scanner fileReader = new Scanner(fileObj);                   // read file using Scanner class
            while(fileReader.hasNextLine())                              // Check whether nextLine is exist or not
            {
                String Line    = fileReader.next();                      // Store File's line in Line variable
                String []array = Line.split(",");                  // Split Line using delimiter, then store each word in array

                // store Elements of array in variables
                String email    = array[0];
                String password = array[1];

                Administration adminObject = new Administration(email, password);//Creating Object of Class-type
                Administration.adminArraylist.add(adminObject);                         // Store all data from file to Arraylist
            }
            fileReader.close();                                          // then close file (data will not leak)
        }
        catch (FileNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null,
                    "Admin DataBase-File not found".toUpperCase(),
                    "LOAD DATABASE FILES",
                    JOptionPane.ERROR_MESSAGE);
        }
        catch (Exception ex){}
    }

    //======================================== loadBillFile() ========================================================||
    /**
     * loadBillFile method means that when user store his/her
     * information which are asked then All that information/Data
     * will store. So, we have to reload all data in arraylist
     * from File bcz we want to use this stored data in our program.
     */
    public static void loadBillFile()
    {
        try                                                       //Exception handling
        {
            File fileObj = new File("DataBase\\BillDataBase.txt");     // create A object of file and set path
            Scanner fileReader = new Scanner(fileObj);            // read file using Scanner class
            while (fileReader.hasNextLine())                      // Check whether nextLine is exist or not
            {
                String Line    = fileReader.nextLine();           // Store File's line in Line variable
                String []array = Line.split("!");           // Split Line using delimiter, then store each word in array

                // store Elements of array in variables
                int    billNo      = Integer.parseInt(array[0]);  // typeCasting through wrapper classes into Integer-type
                double billAmount  = Double.parseDouble(array[1]);// typeCasting through wrapper classes into Double-type
                String email       = array[2];
                BillPayment payment= new BillPayment(billNo,billAmount,email);  //Creating Object of Class-type
                BillPayment.paymentList.add(payment);                                 // Store all data from file to Arraylist
            }
            fileReader.close();                                           // then close file (data will not leak)
        }
        catch (FileNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null,
                    "Bill DataBase-File not found".toUpperCase(),
                    "LOAD DATABASE FILES",
                    JOptionPane.ERROR_MESSAGE);
        }
        catch (Exception ex)                                              // catch error if found
        {
            JOptionPane.showMessageDialog(null,
                                    "Bill DataBase Not loading....".toUpperCase(),
                                       "LOAD DATABASE FILES",JOptionPane.ERROR_MESSAGE);             // display error message
        }
    }

    //========================================= LoadFeedBackFile =====================================================||
    /**
     * loadFeedBackFile method means that when user store his/her
     * information which are asked then All that information/Data
     * will store. So, we have to reload all data in HashMap
     * from File bcz we want to use this stored data in our program.
     */
    public static void loadFeedbackFile()
    {
        try                                                        //Exception handling
        {
            File    fileObj    = new File("DataBase\\FeedbackDataBase.txt"); // create A object of file and set path
            Scanner fileReader = new Scanner(fileObj);       // read file using Scanner class
            while(fileReader.hasNextLine())                  // Check whether nextLine is exist or not
            {
                String Line    = fileReader.nextLine();      // Store File's line in Line variable
                String []array = Line.split("!");      // Split Line using delimiter, then store each word in array

                // store Elements of array in variables
                String email    = array[0];
                String message  = array[1];
                // Store all data from file to hashMap */
                FeedbackOrganizer feedbackOrganizer = new FeedbackOrganizer(email,message);
                FeedbackOrganizer.feedbackList.add(feedbackOrganizer);
            }
            fileReader.close();                             // then close file (data will not leak)
        }
        catch (FileNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null,
                    "Feedback DataBase-File not found".toUpperCase(),
                    "LOAD DATABASE FILES",
                    JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception ex)                                 // catch error if found
        {
            JOptionPane.showMessageDialog(null,
                    "Feedback DataBase Not loading.... ".toUpperCase(),
                    "LOAD DATABASE FILE",
                    JOptionPane.ERROR_MESSAGE);   // display error message
        }
    }

    //========================================== Load-Booking-Files =========================================================||
    /**
     * loadBookingFile method means that when user store his/her
     * information which are asked about reservation then All that
     * information/Data will store. So, we have to reload all data
     * in arraylist from File bcz we want to use this stored data
     * in our program.
     */
    public static void loadBookingFile()
    {
        try                                                      //Exception handling
        {
            File fileObj = new File("DataBase\\BookingDataBase.txt"); // create A object of file and set path
            Scanner fileReader = new Scanner(fileObj);           // read file using Scanner class
            while(fileReader.hasNextLine())                      // Check whether nextLine is exist or not
            {

                String Line = fileReader.nextLine();             // Store File's line in Line variable
                String []array = Line.split("!");          // Split Line using delimiter, then store each word in array

                // store Elements of array in variables
                String email    = array[0];
                String name     = array[1];
                String date     = array[2];
                String location = array[3];
                int time        = Integer.parseInt(array[4]);
                String number   = array[5];

                vehicleBooking bookingObject = new vehicleBooking(email,name,date,location,time,number); //Creating Object of Class-type
                vehicleBooking.bookingArrayList.add(bookingObject);             // Store all data from file to Arraylist
            }
            fileReader.close();                                  // then close file (data will not leak)
        }
        catch (FileNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null,
                    "Booking DataBase-File not found".toUpperCase(),
                    "LOAD DATABASE FILES",
                    JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception ex)                                      // catch error if found
        {
            JOptionPane.showMessageDialog(null,
                    "Booking Database Not loading....".toUpperCase(),
                    "LOAD DATABASE FILES",
                    JOptionPane.ERROR_MESSAGE);       // display error message
        }
    }

    //========================================= LoadMechanicFile =====================================================||
    /**
     * loadMechanicFile method means that when user store his/her
     * information which are asked then All that information/Data
     * will store. So, we have to reload all data in arraylist
     * from File bcz we want to use this stored data in our program.
     */
    public static void loadMechanicFile()
    {
        try                                                             //Exception handling
        {
            File    fileObj    = new File("DataBase\\MechanicDataBase.txt"); // create A object of file and set path
            Scanner fileReader = new Scanner(fileObj);                  // read file using Scanner class
            while(fileReader.hasNextLine())                             // Check whether nextLine is exist or not
            {
                String Line    = fileReader.nextLine();                 // Store File's line in Line variable
                String []array = Line.split("!");                 // Split Line using delimiter, then store each word in array

                // store Elements of array in variables
                String email       = array[0];
                String name        = array[1];
                String password    = array[2];
                int    age         = Integer.parseInt(array[3]);
                int    experience  = Integer.parseInt(array[4]);

                /* Creating Object of Class-type */
                VehicleMechanic mechanicObject = new VehicleMechanic(email,name,password,age,experience);
                VehicleMechanic.mechanicArrayList.add(mechanicObject);                  // Store all data from file to Arraylist
            }
            fileReader.close();                                         // then close file (data will not leak)
        }
        catch (FileNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null,
                    "Mechanic DataBase-File not found".toUpperCase(),
                    "LOAD DATABASE FILES",
                    JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception ex)                                             // catch error if found
        {
            JOptionPane.showMessageDialog(null,
                    "Mechanic database not loading....".toUpperCase(),
                    "LOAD DATABASE FILES",
                    JOptionPane.ERROR_MESSAGE);       // display error message
        }
    }

    //========================================= LoadVehicleFile =====================================================||
    /**
     * loadVehicleFile method means that when user store his/her
     * information which are asked then All that information/Data
     * will store. So, we have to reload all data in arraylist
     * from File bcz we want to use this stored data in our program.
     */public static void loadVehicleFile()
    {
        try
        {
            File    fileObj    = new File("DataBase\\VehicleDataBase.txt");   // create A object of file and set path
            Scanner fileReader = new Scanner(fileObj);                   // read file using Scanner class
            while(fileReader.hasNextLine())                              // Check whether nextLine is exist or not
            {
                String Line    = fileReader.nextLine();                  // Store File's line in Line variable
                String []array = Line.split("!");                  // Split Line using delimiter, then store each word in array

                /* Creating Object of Class-type */
                String  name      = array[0];
                String  number    = array[1];
                String  type      = array[2];
                int     model     = Integer.parseInt(array[3]);
                int     seats     = Integer.parseInt(array[4]);
                double  rate      = Double.parseDouble(array[5]);
                String  color     = array[6];
                boolean condition = Boolean.parseBoolean(array[7]);

                Vehicle vehicleObject = new Vehicle(name,number,type,model,seats,rate,color,condition);
                VehicleOrganizer.vehicleArrayList.add(vehicleObject);       // Store all data from file to Arraylist
            }
            fileReader.close();                              // then close file (data will not leak)
        }
        catch (FileNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null,
                    "Vehicle DataBase-File not found".toUpperCase(),
                    "LOAD DATABASE FILES",
                    JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception ex)                                  // catch error if found
        {

            JOptionPane.showMessageDialog(null,
                    "Vehicle DATABASE not loading.... ".toUpperCase(),
                    "LOAD DATABASE FILES",
                    JOptionPane.ERROR_MESSAGE);   // display error message file not found
        }
    }

    //========================================= LoadCustomerFile =====================================================||
    /**
     * loadCustomerFile method means that when user store his/her
     * information which are asked then All that information/Data
     * will store. So, we have to reload all data in arraylist
     * from File bcz we want to use this stored data in our program.
     */
    public static void loadCustomerFile()
    {
        try                                                         //Exception handling
        {
            File fileObj = new File("DataBase\\CustomerDataBase.txt");   // create A object of file and set path
            Scanner fileReader = new Scanner(fileObj);              // read file using Scanner class
            while(fileReader.hasNextLine())                         // Check whether nextLine is exist or not
            {
                String Line = fileReader.nextLine();                // Store File's line in Line variable
                String []array = Line.split("!");             // Split Line using delimiter, then store each word in array

                // store Elements of array in variables
                String email    = array[0];
                String name     = array[1];
                String password = array[2];
                String gender   = array[3];
                String phoneNo  = array[4];
                String address  = array[5];
                String CNIC     = array[6];
                int age         = Integer.parseInt(array[7]);

                /* Creating Object of Class-type */
                Customer customerObject = new Customer(email,name,password,gender,phoneNo,address,CNIC,age);
               Customer.customerArrayList.add(customerObject);             // Store all data from file to Arraylist
            }
            fileReader.close();                                    // then close file (data will not leak)
        }
        catch (FileNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null,
                    "Customer DataBase-File not found".toUpperCase(),
                    "LOAD DATABASE FILES",
                    JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception ex)                                        // catch error if found
        {
            JOptionPane.showMessageDialog(null,
                    "Customer database Not loading....".toUpperCase(),
                    "LOAD DATABASE FILES",
                    JOptionPane.INFORMATION_MESSAGE);       // display error message
        }
    }

//====================================================================================================================||
}
//==============================================End_of_class==========================================================||
/**
 Project name : Vehicle Rental System
 Student name : Muhammad Talha Sohail
 Roll no.     : 0005-BSCS-2019 (Section-B)
 Description  : Class-vehicleOrganizer extends vehicle. Here I have designed a class. In this class there are attributes
                and behaviours of Vehicle. Admin has access to add add/remove/update info of vehicle. Then Customer can
                view only details. Then mechanic will check out Vehicle Condition to repair.
 Used classes : Class Vehicle is used in class
 **/

//============================================ Import-Libraries/Classes ==============================================||

package Controller;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

//============================================ VehicleOrganizer Class ==============================================||
public class VehicleOrganizer
{
    //======================================== Fields/Attributes =====================================================||
    /* Arraylist is Class type(vehicleOrganizer),
        which will hold Vehicle's details only */
    public static ArrayList<Vehicle> vehicleArrayList = new ArrayList<Vehicle>();

    //======================================== Parameterized-Constructor =============================================||
    /**
     * @param carName    Vehicle Name
     * @param vehicleNo  Vehicle Number
     * @param type       Vehicle Type (Car/Truck/Coach etc...)
     * @param model      Vehicle ModelNo.
     * @param seats      Vehicle seats
     * @param rate       Vehicle Rental Rate per hour
     * @param color      Vehicle color
     * @param condition  Vehicle Condition (true/false)
     * Add vehicles By admin in file text.
     *
     */
    public void addVehicle(String carName, String vehicleNo, String type, int model, int seats,
                                double rate, String color, boolean condition)
    {
        try
        {
            File       fileObj = new File("DataBase\\VehicleDataBase.txt");  // make object of File and set Path
            FileWriter pen     = new FileWriter(fileObj,true);  // Make object of FileWriter and pass File object in append mode
            /* Write Data in File using delimiter */
            pen.write(carName.toUpperCase()+"!"+vehicleNo.toUpperCase()+"!"+type.toUpperCase()+
                      "!"+model+"!"+seats+"!"+rate+"!"+color.toUpperCase()+"!"+condition+"\n");
            pen.close();         //close file
            JOptionPane.showMessageDialog(null,
                    carName+" <"+vehicleNo+"> "+"is registered successfully".toUpperCase(),
                    "VEHICLE ORGANIZER",
                    JOptionPane.INFORMATION_MESSAGE);
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
                    "vehicle DATABASE not writing.... ".toUpperCase(),
                    "LOAD DATABASE FILES",
                    JOptionPane.ERROR_MESSAGE);   // display error message file not found
        }
    }


    //==================================== totalVehicle ==============================================================||
    /**
     * @return size of arraylist
     * that how many Vehicle available
     * in company
     */
    public int totalVehicle()
    {
        return vehicleArrayList.size();
    }

    //============================================= displayAll Vehicle record=========================================||
    public static void displayAll()
    {
        String temp="";
        for (Vehicle v : vehicleArrayList)
        {
            temp = temp+v.displayVehicle()+"\n--------------\n";
        }
        JOptionPane.showMessageDialog(null,temp,
                                 "VEHICLE DETAILS",JOptionPane.PLAIN_MESSAGE);
    }

    //========================================== displaySpecific Vehicle =============================================||
    public void displaySpecific(String name)
    {
        String name1 = name.toUpperCase();
        boolean check = false;
        for(Vehicle v : vehicleArrayList)
        {
            if(v.getVehicleName().contains(name1))
            {
                check = true;
                JOptionPane.showMessageDialog(null,
                        v.displayVehicle(),
                        "SEARCH VEHICLE",JOptionPane.PLAIN_MESSAGE);
            }
        }
        if(check!=true)
        {
            JOptionPane.showMessageDialog(null,
                                   name1+" is not Exists is Record ".toUpperCase(),
                                      "SEARCH VEHICLE",JOptionPane.WARNING_MESSAGE);
        }
    }
    //================================================================================================================||
}
//================================================= Class end ========================================================||

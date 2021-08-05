/**
 Project name : Vehicle Rental System
 Student name : Muhammad Talha Sohail
 Roll no.     : 0005-BSCS-2019 (Section-B)
 Description  : Class-VehicleBooking. Here I have designed a class. In this class there are attributes and behaviours
                of reservation Vehicle. Customer has access to manage his/her Booking/reservation's Details. Customer
                will select a Vehicle for Rent then Booked vehicle will be stored in DATA for admin.
 Used classes : Vehicle and vehicle-Organizer classes are used in this class.
 **/

//============================================ Import-Libraries/Classes ==============================================||
package Controller;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;


//============================================ vehicleBooking Class ==================================================||
public class vehicleBooking
{

    //======================================== Fields/Attributes =====================================================||
    /* declare variables to hold values */
    private String email,name,reservedDate,boardingLocation,selectVehicleNo;
    private  int rentalTime;
    /* Arraylist is Class type(vehicleBooking), which will
     *  hold Booking details only that will be store by user*/
    public static ArrayList<vehicleBooking> bookingArrayList = new ArrayList<vehicleBooking>();

    //======================================== Parameterized-Constructor =============================================||
    /**
     * @param email             Customer Email for Booking
     * @param name              Customer Name for Booking
     * @param reservedDate      Reservation date
     * @param boardingLocation  Boarding Location
     * @param rentalTime        Rental time for booking
     * @param selectVehicleNo   Selection of vehicle for rent
     */
    public vehicleBooking(String email,String name,String reservedDate, String boardingLocation,
                                                            int rentalTime,String selectVehicleNo)
    {
        this.email            = email;
        this.name             = name;
        this.boardingLocation = boardingLocation;
        this.reservedDate     = reservedDate;
        this.rentalTime       = rentalTime;
        this.selectVehicleNo  = selectVehicleNo;
    }

    //======================================== Non-Parameterized-Constructor =========================================||
    public vehicleBooking()
    { }

    //======================================== Setter-Methods ========================================================||
    /* setEmail method will set value of the Customer's Email for booking */
    public void setEmail(String email)
    {
        this.email = email;
    }
    /* setName method will set value of the Customer's Name for booking */
    public void setName(String name)
    {
        this.name = name;
    }
    /* setReservationDate method will set value of the Reservation date for booking */
    public void setReservedDate(String reservedDate)
    {
        this.reservedDate = reservedDate;
    }
    /* setBoardingLocation method will set value of the boarding location for booking */
    public void setBoardingLocation(String boardingLocation)
    {
        this.boardingLocation = boardingLocation;
    }
    /* setRentalTime method will set value of the Rental time/hour for booking */
    public void setRentalTime(int rentalTime)
    {
        this.rentalTime = rentalTime;
    }

    //======================================== Getter-Methods ========================================================||
    /**
     * @return  Email
     * getAge method will return Email
     */
    public String getEmail()
    {
        return email;
    }
    /**
     * @return  Name
     * getAge method will return Name
     */
    public String getName()
    {
        return name;
    }
    /**
     * @return  reservationDate
     * getAge method will return reservation date for booking
     */
    public String getReservedDate()
    {
        return reservedDate;
    }
    /**
     * @return  boardingLocation
     * getAge method will return boarding location for vehicle-booking
     */
    public String getBoardingLocation()
    {
        return boardingLocation;
    }
    /**
     * @return  rentalTime
     * getAge method will return rental time/hour
     */
    public int getRentalTime()
    {
        return rentalTime;
    }
    /**
     * @return  selectVehicleNo.
     * getAge method will return selected vehicle for rent
     */
    public String getSelectVehicleNo()
    {
        return selectVehicleNo;
    }

    //======================================== Reserved-Vehicle ======================================================||
    /**
     * @param email
     * @param name
     * @param date
     * @param location
     * @param time
     * @param number
     * @return true/false
     */
    public Boolean reserveVehicle(String email,String name,String date,String location,int time,String number)
    {
        String vehicleNm = number;  // store number for temporary use
        boolean boolCheck = false;  // declare boolean type variable

        for (Vehicle v : VehicleOrganizer.vehicleArrayList) // for-loop for traverse Vehicle type Arraylist
        {
            if(v.getVehicleNo().equals(vehicleNm))         // check condition for vehicleNumber
            {
                boolCheck = true;
                try
                {
                    File fileObj = new File("DataBase\\BookingDataBase.txt");  // make object of File and set Path
                    FileWriter pen = new FileWriter(fileObj,true); // Make object of FileWriter and pass File object in append mode
                    /* Write Data in File using delimiter */
                    pen.write(email+"!"+name.toUpperCase()+"!"+date+"!"+location.toUpperCase()+"!"+time+"!"+number.toUpperCase()+"\n");
                    pen.close();                                    // close file


                    JOptionPane.showMessageDialog(null,
                                          "Reservation is Done successfully.......".toUpperCase(),
                                             "VEHICLE BOOKING",
                                                   JOptionPane.INFORMATION_MESSAGE); //print message for successfully Reservation
                    return true;
                }
                catch (FileNotFoundException ex)
                {
                    JOptionPane.showMessageDialog(null,
                            "Booking DataBase-File not found".toUpperCase(),
                            "LOAD DATABASE FILES",
                            JOptionPane.ERROR_MESSAGE);
                }
                catch(Exception ex)                                  // catch error if found
                {
                    JOptionPane.showMessageDialog(null,
                            "Booking DATABASE not writing.... ".toUpperCase(),
                            "LOAD DATABASE FILES",
                            JOptionPane.ERROR_MESSAGE);   // display error message file not found
                }
            }
        }
        if(boolCheck!=true)
        {
            // else print message if vehicleNum not found!!
            JOptionPane.showMessageDialog(null,
                                  number+" not found, Enter valid Number".toUpperCase(),
                                     "VEHICLE BOOKING",
                                          JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }


    //======================================== DisplayInfo for Reservation ===========================================||
    /**
     *  DisplayInfo for reservation will show
     *  details of reservation.
     */public String displayInfo()
    {
        return "EMAIL                : "+getEmail()+
             "\nNAME                 : "+getName()+
             "\nRESERVED DATE           : "+getReservedDate()+
             "\nBOARDING LOCATION  : "+getBoardingLocation()+
             "\nRENTAL TIME                 : "+getRentalTime()+"-HOURS";
    }

    //======================================== DisplayBookedVehicle =====================================================||
    /**
     *  displayBookedVehicle Method will display
     *  reserved vehicle's record.
     */
    public static void displayBookedVehicle()
    {
        String temp="";
        for(Vehicle vehicleObject : VehicleOrganizer.vehicleArrayList)     // for-each loop will traverse vehicle arraylist
        {
            String num = vehicleObject.getVehicleNo();                     // temporary variable for vehicle number
            for(vehicleBooking bookedVehicle : bookingArrayList)           // for-each loop will traverse vehicleBooking arraylist
            {
                if (vehicleObject.getVehicleNo().equals(num) && bookedVehicle.getSelectVehicleNo().equals(num))
                {
                    temp=temp+bookedVehicle.displayInfo()+"\n"+"VEHICLE NAME    : " + vehicleObject.getVehicleName()+
                                  "\nVEHICLE NO.        : " + vehicleObject.getVehicleNo()+"\nRATE/HOUR          : "
                                  +vehicleObject.getVehicleRate()+ "\n--------------\n";             // display Vehicle information
                }
            }
        }
        JOptionPane.showMessageDialog(null,temp,
                                  "CUSTOMER BOOKING DETAILS",
                                        JOptionPane.PLAIN_MESSAGE);
    }
    //================================================================================================================||
}

//===================================================Class End========================================================||
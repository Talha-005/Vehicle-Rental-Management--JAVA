/**
 Project name : Vehicle Rental System
 Student name : Muhammad Talha Sohail
 Roll no.     : 0005-BSCS-2019 (Section-B)
 Description  : Class-Administration extends User. Here I have Designed a class. In this class there are attributes and behaviours
 of Admin. Admin has access to manage his/her company. So, Admin can manage his/her company data.
 Admin can view Detail of Customer, Vehicles, Reservation, Bill and Mechanic. This class has main
 role in project. Bcz Admin is company owner. And admin has to run company.
 Used classes : Admin has access to View Customers Detail, View Vehicle detail, Add/remove/update Vehicle, View
 Reservation details, View Bill details ANd at last also has access to view Mechanic details
 **/

//============================================ Import-Libraries/Classes ==============================================||
package Controller;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;


//============================================ Class Administration ==================================================||
public class Administration extends User
{
    //======================================== Fields/Attributes =====================================================||

    /* Arraylist is Class type(Administration), which will
     *  hold Email,Password only that will be store by User*/
    public static ArrayList<Administration> adminArraylist = new ArrayList<Administration>();

    //======================================== Parameterized-Constructor =============================================||
    /**
     * @param email         Admin's Email
     * @param password      Password of account
     */
    public Administration(String email, String password)
    {
        super(email,password);         // super method will call Parent type Constructor
    }
    public Administration(){}

    //========================================== Register-Admin ======================================================||
    /**
     * @param email ..
     * @param password ..
     * registerAdmin method will be used, when admin email and
     * Password is not present in Data and will not match with
     * Existing. So, admin will request and Add asked details.
     * Then he/she will be allowed to Access all data after
     * login.
     * If given email for Registration is already stored, then
     * message will print for use a different email. Otherwise
     * new Registration will be done
     */
    public void addAdmin(String email, String password)
    {
        boolean boolCheck = true;                   // boolCheck Variable will hold boolean value

        try
        {
            File       fileObj          = new File("DataBase\\AdminDataBase.txt");
            FileWriter fileWriterObject = new FileWriter(fileObj);
            fileWriterObject.write(email+"!"+password);
            fileWriterObject.close();
        }
        catch (FileNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null,
                    "admin DataBase-File not found".toUpperCase(),
                    "LOAD DATABASE FILES",
                    JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception ex)                                  // catch error if found
        {
            JOptionPane.showMessageDialog(null,
                    "admin DATABASE not writing.... ".toUpperCase(),
                    "LOAD DATABASE FILES",
                    JOptionPane.ERROR_MESSAGE);   // display error message file not found
        }
    }

    //========================================== Login-Admin =========================================================||
    /**
     * @return boolean
     * LogIn method will be used, when admin wants to Login his/her Account.
     * If given email and password will correct then Admin will have access
     * to manage All stored Data. Else admin will have to re-Login (in case
     * of Invalid password and email).
     */
    public Boolean logIn()
    {
        boolean boolCheck = false;                      // boolCheck Variable will hold boolean value

        /* condition is applied(if given email & password is given in data then true)*/
        if(getEmail().equals("talha@gmail.com") && getPassword().equals("1234"))
        {
            boolCheck = true;
            loginAccount(getEmail(),getPassword());           // logIn method of parent class will be called
            addAdmin(getEmail(),getPassword());
            JOptionPane.showMessageDialog(null,
                                  "Congratulation <"+getEmail()+"> LogIN successfully..",
                                     "ADMIN LOGIN",
                                          JOptionPane.INFORMATION_MESSAGE);
            return true;                                     // return true, if Email and password will match
        }

        if(boolCheck!=true)
        {
            //System.out.println("Invalid Email or password !!!\n----------\n");
            JOptionPane.showMessageDialog(null,
                                  "Invalid Email or password",
                                     "ADMIN LOGIN",
                                          JOptionPane.WARNING_MESSAGE);
        }
        return false;                                   // Return false, if email and password is incorrect
    }


    //================================================================================================================||
}

//========================================== End of Class ============================================================||
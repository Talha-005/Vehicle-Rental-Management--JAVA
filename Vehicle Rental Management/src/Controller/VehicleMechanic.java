/**
 Project name : Vehicle Rental System
 Student name : Muhammad Talha Sohail
 Roll no.     : 0005-BSCS-2019 (Section-B)
 Description  : Class-Mechanic extends User. Here I have designed a class. In this class there are attributes and behaviours
                of Mechanic. Mechanic has access to manage his/her Account. So, Mechanic can manage condition of Vehicle.
                Mechanic will select a Vehicle repairing and then repaired Vehicle.
 Used classes : Class User is used and VehicleOrganizer also used FOr check Vehicle Condition
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


//============================================ VehicleMechanic Class =================================================||
public class VehicleMechanic extends User
{
    //======================================== Fields/Attributes =====================================================||
    /* declare variables to hold values */
    private int age, experience;

    /* Arraylist is Class type(vehicleMechanic),
        which will hold Mechanic's details only */
    public static ArrayList<VehicleMechanic> mechanicArrayList = new ArrayList<VehicleMechanic>();

    //======================================== Parameterized-Constructor =============================================||
    /**
     * @param email      Mechanic Email
     * @param name       Mechanic Name
     * @param password   Mechanic Password for account
     * @param age        Mechanic age
     * @param experience Mechanic Experience of field
     */
    public VehicleMechanic(String email,String name, String password, int age, int experience )
    {
        super(email,name,password);
        this.age = age;
        this.experience = experience;
    }

    /**
     * @param email     Mechanic Email
     * @param password  Mechanic password
     */
    public VehicleMechanic(String email,String password)
    {
        super(email,password);
    }

    //======================================== Non-Parameterized-Constructor =========================================||
    public VehicleMechanic()
    { }

    //================================================ Setter-Methods ================================================||
    /* setAge method will set Age of the Mechanic */
    public void setAge(int age)
    {
        this.age = age;
    }
    /* setExperience method will set Experience of the Mechanic */
    public void setExperience(int experience)
    {
        this.experience = experience;
    }

    //================================================ Getter-Methods ================================================||
    /**
     * @return  Age
     * getAge method will return Age of the Mechanic
     */
    public int getAge()
    {
        return age;
    }
    /**
     * @return  Experience
     * getExperience method will return Experience of the Mechanic
     */
    public int getExperience()
    {
        return experience;
    }

    //================================================ DisplayInfo ===================================================||
    /**
     * displayInfo method will show just age
     * and Experience of mechanic. Rest of
     * Information will be access by Parent's
     * class Display-Method.
     */
    @Override
    public String DisplayInfo()
    {
        return super.DisplayInfo()+
               "AGE        : "+getAge()+
               "\nEXPERIENCE : "+getExperience()+"/YEAR"+"\n";
    }

    //================================================ DisplayAllProfile ===================================================||
    /**
     * displayProfile method will show Detials
     * of All company mechanic.
     */
    public String displayProfile()
    {
        String display="";
        for(VehicleMechanic mechanicObject: mechanicArrayList)
        {
            display = display + mechanicObject.DisplayInfo()+"-----------------\n";
        }
        return display;
    }

    //========================================== Register-Admin ======================================================||
    /**
     * @param email
     * @param name
     * @param password
     * @param age
     * @param experience
     * registerMechanic method will be used, when mechanic email and
     * Password is not present in Data and will not match with
     * Existing. So, mechanic will request and Add asked details.
     * Then he/she will be allowed to Access to manage account after
     * login.
     * If given email for Registration is already stored, then
     * message will print for use a different email. Otherwise
     * new Registration will be done
     */public void registerMechanic(String email, String name, String password,int age, int experience)
    {
        boolean boolToCheck = true;
        String email1 = email;                          // declare a temporary variable
        for (VehicleMechanic vm : mechanicArrayList)    // traverse Mechanic Arraylist
        {
            if (vm.getEmail().equals(email1))           // check condition for email
            {
                boolToCheck = false;
                JOptionPane.showMessageDialog(null,
                                       "Please use a unique Email !!!".toUpperCase(),
                                          "MECHANIC REGISTRATION",
                                               JOptionPane.WARNING_MESSAGE);  // print message for use a unique email
            }
        }
        if (boolToCheck != false)
        {
            try
            {
                File fileObj = new File("DataBase\\MechanicDataBase.txt");    // create object of File and set path
                FileWriter pen = new FileWriter(fileObj,true);    // File is in append mode to write
                pen.write(email+"!"+name.toUpperCase()+"!"+password+"!"+age+"!"+experience+"\n");
                pen.close();
                JOptionPane.showMessageDialog(null,
                        email+"  SIGNUP SUCCESSFULLY",
                        "MECHANIC REGISTRATION",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            catch (FileNotFoundException ex)
            {
                JOptionPane.showMessageDialog(null,
                        "Mechanic DataBase-File not found".toUpperCase(),
                        "LOAD DATABASE FILES",
                        JOptionPane.ERROR_MESSAGE);
            }
            catch(Exception ex)                                  // catch error if found
            {
                JOptionPane.showMessageDialog(null,
                        "Mechanic DATABASE not writing.... ".toUpperCase(),
                        "LOAD DATABASE FILES",
                        JOptionPane.ERROR_MESSAGE);   // display error message file not found
            }
        }
    }

    //========================================= LogIn-Mechanic =======================================================||
    /**
     * @param email  ..
     * @param password  ..
     * @return boolean
     * LogIn method will be used, when mechanic wants to Login his/her Account.
     * If given email and password will correct then mechanic will have access
     * to manage Account. Else mechanic will have to re-Login (in case
     * of Invalid password and email).
     */public Boolean logIn(String email, String password)
    {
        Iterator<VehicleMechanic> mechanicIterator = mechanicArrayList.iterator();  // iterator of class type
        boolean boolToCheck = false;
        while (mechanicIterator.hasNext())
        {
            VehicleMechanic vehicleMechanic = mechanicIterator.next();
            if(vehicleMechanic.getEmail().equals(email) && vehicleMechanic.getPassword().equals(password))
            {
                boolToCheck = true;
                loginAccount(email,password);       // logIn method of parent class will be called
                JOptionPane.showMessageDialog(null,
                        "CONGRATULATIONS <"+getEmail()+"> LOGIN SUCCESSFULLY",
                        "MECHANIC LOGIN",JOptionPane.INFORMATION_MESSAGE);
                return true;                        // return true, if Email and password will match
            }
        }
        if(boolToCheck !=true)
        {
            boolean found = false;
            for (VehicleMechanic vm : mechanicArrayList)
            {
                if(vm.getEmail().equals(email))
                {
                    found = true;
                    JOptionPane.showMessageDialog(null,
                                         "Invalid password!".toUpperCase(),
                                            "MECHANIC LOGIN",
                                                JOptionPane.WARNING_MESSAGE);
                }
            }
            if(found!=true)
            {
                JOptionPane.showMessageDialog(null,
                        email+" IS NOT REGISTERED",
                          "MECHANIC LOGIN",
                               JOptionPane.WARNING_MESSAGE);
            }
        }
        return false;                               // Return false, if email and password is incorrect
    }

    //=========================================== checkVehicleCondition ==============================================||
    /**
     * @return true
     * checkVehicleCondition method will be used when
     * mechanic will figure out which vehicle needs to
     * be repairing.
     */
    public Boolean checkVehicleCondition()
    {
        String temp="";
        for(Vehicle vc : VehicleOrganizer.vehicleArrayList)
        {
            temp = temp +  "VEHICLE CONDITION  OF "+vc.getVehicleName()+" <"+vc.getVehicleNo()+">is "
                         +vc.getVehicleCondition()+"\n--------------\n";
        }
        JOptionPane.showMessageDialog(null,
                                     temp,
                                "VEHICLE CONDITION",
                                     JOptionPane.PLAIN_MESSAGE);
        return true;
    }

    //=========================================== confirmCondition ===================================================||
    /**
     * @return true
     * confirmCondition method will be accessed by mechanic.
     * It will repair all vehicle.
     */
    public Boolean confirmCondition()
    {
        String temp="";
        boolean isCeheck = false;
        for(Vehicle vc : VehicleOrganizer.vehicleArrayList)
        {
            if(vc.getVehicleCondition()== false)
            {
                vc.setVehicleCondition(true);
                        isCeheck = true;
                        temp = temp +  "AFTER REPAIRING, VEHICLE CONDITION  OF "+vc.getVehicleName()+" <"
                          +vc.getVehicleNo()+">is "+vc.getVehicleCondition()+"\n--------------\n";
            }
        }
        if (isCeheck!=true)
        {
            JOptionPane.showMessageDialog(null,
                    "Vehicle Not available for Repairing".toUpperCase() ,
                    "VEHICLE CONDITION",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        else
            {
                JOptionPane.showMessageDialog(null,
                        temp,
                        "VEHICLE CONDITION",
                        JOptionPane.PLAIN_MESSAGE);
        }
        return true;
    }
}
//================================================== End of class ====================================================||

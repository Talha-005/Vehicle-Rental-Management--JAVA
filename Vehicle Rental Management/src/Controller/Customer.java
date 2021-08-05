/**
 Project name : Vehicle Rental System
 Student name : Muhammad Talha Sohail
 Roll no.     : 0005-BSCS-2019 (Section-B)
 Description  : Class-Customer extends User. Here I have designed a class. In this class there are attributes and behaviours
                of Customer. Customer has access to manage his/her Account. So, customer can manage his/her Booking/reservation's
                Details. Customer will select a Vehicle for Rent then Bill will display and he/she will enter feedback.
 Used classes : Admin has access to View Vehicles Detail,, Add/remove/update Account, confirm Reservation details,
                View Bill After booking And at last also give feedback.
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

//============================================ Class Customer=========================================================||
public class Customer extends User
{
    //======================================== Fields/Attributes =====================================================||
    private String address,gender,CNIC,phoneNo;  // hold string Type variables
    private int age;                                    // hold age of int type

    /* Arraylist is Class type(Customer), which will
     *  hold Email,Password only that will be store by User*/
    public static ArrayList<Customer> customerArrayList = new ArrayList<Customer>();

    //======================================== Parameterized-Constructor =============================================||
    /**
     * @param email             Customer will enter email
     * @param name              Customer Name
     * @param password          Password of Account
     * @param gender            Customer gender
     * @param phoneNo           Customer PhoneNo.
     * @param address           Customer Address
     * @param CNIC              Customer CNIC
     * @param age               Customer Age
     */
    public Customer(String email, String name, String password,String gender, String phoneNo, String address,
                    String CNIC, int age)
    {
        super(email,name,password);             // super method will call Parent type Constructor
        this.gender         = gender;
        this.phoneNo        = phoneNo;
        this.CNIC           = CNIC;
        this.address        = address;
        this.age            = age;
    }
    /**
     * @param email
     * @param password
     */
    public Customer(String email,String password)
    {
        super(email,password);                  // super method will call Parent type Constructor
    }

    //======================================== Non_Parameterized-Constructor =========================================||
    public Customer()
    {  }

    //======================================== Setter-Methods ========================================================||
    /* setGender method will set value of the Customer's gender */
    public void setGender(String gender)
    {
        this.gender = gender;
    }
    /* setPhoneNo. method will set value of the  Customer's phone-Number */
    public void setPhoneNo(String phoneNo)
    {
        this.phoneNo = phoneNo;
    }
    /* setCustomerBill method will set value of the customer's Address */
    public void setAddress(String address)
    {
        this.address = address;
    }
    /* setCNIC method will set value of the customer's CNIC */
    public void setCNIC(String CNIC)
    {
        this.CNIC = CNIC;
    }
    /* setAge method will set value of the customer's Age */
    public void setAge(int age)
    {
        this.age = age;
    }

    //======================================== Getter-Methods ========================================================||
    /**
     * @return  age
     * getAge method will return value of the Age
     */
    public int getAge()
    {
        return age;
    }
    /**
     * @return    Address
     * getAddress method will return value of the Address
     */
    public String getAddress()
    {
        return address;
    }
    /**
     * @return   Gender
     * getGender method will return value of the Gender
     */
    public String getGender()
    {
        return gender;
    }
    /**
     * @return  CNIC
     * getCustomerBill method will return value of the CNIC
     */
    public String getCNIC()
    {
        return CNIC;
    }
    /**
     * @return  PhoneNo.
     * getPhoneNo. method will return value of the Phone-number
     */
    public String getPhoneNo()
    {
        return phoneNo;
    }

    //======================================== DisplayInfo ===========================================================||
    @Override
    /**
     * displayCustomerInfo method is Overridden by its
     * parent class.In this method, Detail will be displayed.
     */
    public String DisplayInfo()
    {

        return   super.DisplayInfo()+
                "Gender        : "+getGender()+
                "\nAge              : "+getAge()+
                "\nCNIC            : "+getCNIC()+
                "\nPhone No.  : "+getPhoneNo()+
                "\nAddress     : "+getAddress();
    }

    //======================================== DisplayAllProfile =====================================================||
    /**
     *  DisplayAllMethod always called by Admin
     *  who has access to check out Details of
     *  all Customers
     */
    public String DisplayAllProfile()
    {
        String display = "";
        for(Customer c: customerArrayList)      // for-each Loop traverse Arraylist
        {
            display = display+c.DisplayInfo()+"\n----------------------\n";                    // call display method for each Object
        }
        return display;
    }

    //======================================== Register-Customer =====================================================||
    /**
     * @param email             Customer wil enter email
     * @param name              Customer Name
     * @param password          Password of Account
     * @param gender            Customer gender
     * @param phone             Customer PhoneNo.
     * @param address           Customer Address
     * @param CNIC              Customer CNIC
     * @param age               Customer Age
     * registerCustomer method will be used, when customer's email and
     * Password is not present in Data and will not match with
     * Existing. So, customer will request and Add asked details.
     * Then he/she will be allowed Access to use account.
     * If given email for Registration is already stored, then
     * message will print for use a different email. Otherwise
     * new Registration will be done
     */
    public void registerCustomer(String email,String name,String password,String gender
                                ,String phone,String address,String CNIC,int age)
    {
        boolean boolToCheck = true;                     // boolCheck Variable will hold boolean value
        String email1 = email;                          // email variable hold email given by Customer
        for(Customer c : customerArrayList)             // for loop will traverse arrayList
        {
            if(c.getEmail().contains(email1))           // check condition either Email contains or not
            {
                boolToCheck = false;                    // update value of bool
               JOptionPane.showMessageDialog(null,
                                     "Please use a unique Email !!",
                                        "CUSTOMER REGISTRATION",
                                             JOptionPane.WARNING_MESSAGE); // print message
            }
        }
        if(boolToCheck != false)                        // if condition false then write file
        {
            try                                         // Exception Handling
            {
                File       fileObj = new File("DataBase\\CustomerDataBase.txt"); // make object of File and set Path
                FileWriter pen     = new FileWriter(fileObj,true);   // Make object of FileWriter and pass File object in append mode
                /* Write Data in File using delimiter */
                pen.write(email+"!"+name+"!"+password+"!"+gender+"!"
                                +phone+"!"+address+"!"+CNIC+"!"+age+"\n");
                pen.close();                             //close file
                JOptionPane.showMessageDialog(null,
                        email+" is sign-up successfully !!",
                          "CUSTOMER REGISTRATION",
                               JOptionPane.INFORMATION_MESSAGE);
            }
            catch (FileNotFoundException ex)
            {
                JOptionPane.showMessageDialog(null,
                        "Customer DataBase-File not found".toUpperCase(),
                        "LOAD DATABASE FILES",
                        JOptionPane.ERROR_MESSAGE);
            }
            catch(Exception ex)                                  // catch error if found
            {
                JOptionPane.showMessageDialog(null,
                        "customer DATABASE not writing.... ".toUpperCase(),
                        "LOAD DATABASE FILES",
                        JOptionPane.ERROR_MESSAGE);   // display error message file not found
            }
        }
    }


    //========================================= Search-Customer ======================================================||
    /**
     * @param email Pass param to search specific customer's detail.
     *  searchCustomer Method will be used, when admin wants to
     *  search desire object from Data. So, this working will be
     *  proceed.
     */
    public void searchCustomer(String email)
    {
        Iterator<Customer> customerIterator = customerArrayList.iterator();// declare an Iterator of Class-type
        boolean boolToCheck = false;
        while (customerIterator.hasNext())                      // while loop check out hasNextLine exists?
        {
            Customer customer = customerIterator.next();
            if(customer.getEmail().equals(email))               // check condition either email exists in list or Not
            {
                boolToCheck = true;
                JOptionPane.showMessageDialog(null,customer.DisplayInfo(),"SEARCH CUSTOMER",JOptionPane.PLAIN_MESSAGE);                         //show Detail if desire email is found
            }
        }
        if(boolToCheck !=true)
        {
            JOptionPane.showMessageDialog(null,
                                   email+" is not Exists in Record",
                                      "SEARCH CUSTOMER",
                                           JOptionPane.WARNING_MESSAGE);    // else print message that desire email not found
        }
    }

    //========================================= LogIn-Customer =======================================================||
    /**
     * @param email  ..
     * @param password  ..
     * @return boolean
     * LogIn method will be used, when customer wants to Login his/her Account.
     * If given email and password will correct then customer will have access
     * to manage vehicle Booking. Else customer will have to re-Login (in case
     * of Invalid password and email).
     */
    public Boolean logIn(String email, String password)
    {
        boolean boolToCheck = false;                                        // boolCheck Variable will hold boolean value
        Iterator<Customer> customerIterator = customerArrayList.iterator(); // declare iterator of Class-type
        while (customerIterator.hasNext())
        {
            Customer customer = customerIterator.next();
            /* condition is applied(if given email & password is given in data then true)*/
            if(customer.getEmail().equals(email) && customer.getPassword().equals(password))
            {
                boolToCheck = true;
                loginAccount(email,password);                             // logIn method of parent class will be called
                JOptionPane.showMessageDialog(null,
                                       "Congratulation <"+email+"> LogIn successfully..",
                                          "CUSTOMER LOGIN",
                                               JOptionPane.INFORMATION_MESSAGE);
                return true;                                            // return true, if Email and password will match
            }
        }
        if(boolToCheck !=true)
        {
            boolean found = false;
            for (Customer cm : customerArrayList)
            {
                if(cm.getEmail().equals(email))
                {
                    found = true;
                    JOptionPane.showMessageDialog(null,
                            "Invalid password!",
                            "CUSTOMER LOGIN",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
            if(found!=true)
            {
                JOptionPane.showMessageDialog(null,
                        email+" is not registered",
                        "CUSTOMER LOGIN",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
        return false;                                          // Return false, if email and password is incorrect
    }

    //========================================= TotalCustomer =======================================================||

    /**
     * @return  size of arraylist
     */
    public int totalCustomers()
    {
        return customerArrayList.size();
    }
    //================================================================================================================||

}

//================================================ End Class =========================================================||

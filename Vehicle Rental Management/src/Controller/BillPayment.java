/**
 Project name : Vehicle Rental System
 Student name : Muhammad Talha Sohail
 Roll no.     : 0005-BSCS-2019 (Section-B)
 Description  : Class-BillPayment. Here I have designed a class. In this class there are attributes and behaviours of Bill.
 Admin has access to manage Billing method. Admin will generate bill for customer when customer booked a
 vehicle for rent . This class has main role in project. Bcz Bill will be generated after Vehicle booking
 and then all record of Bill transaction will be stored for Admin.
 Used classes : Vehicle and Vehicle Organizer classes are used in this class. Bcz bill will be generated on basis of
 Vehicle's prices/hour. Implements Bill Class.
 **/

//============================================ Import-Libraries/Classes ==============================================||
package Controller;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//============================================ class BillPayment implements Bill =====================================||
public class BillPayment implements Bill
{
    //======================================== Fields/Attributes =====================================================||
    private double customerBill,totalTransaction;   // variables hold Bill and Transactions
    private final double discount = 20;            // variable hold constant value of discount
    private int billNo;          // static type of billNo.
    private String temp;
    /* Arraylist is Class type(BillPayment), which will
     *  hold billNo. and Bill amount only that will be stored */
    public static ArrayList<BillPayment> paymentList = new ArrayList<>();

    //======================================== Parameterized-Constructor =============================================||
    /**
     * @param billNo
     * @param customerBill
     */
    public BillPayment(int billNo, double customerBill,String temp)
    {
        this.billNo       = billNo;
        this.customerBill = customerBill;
        this.temp         = temp;
    }
    //======================================== Non-Parameterized-Constructor =========================================||
    public BillPayment()
    {}

    //======================================== Setter-Method =========================================================||
    /* setCustomerBill method will set value of the customerBill */
    public void setCustomerBill(double customerBill)
    {
        this.customerBill = customerBill;
    }

    /* setBillNo method will set value of the BilNo */
    public void setBillNo(int billNo)
    {
        this.billNo = billNo;
    }
    public void setTemp(String temp)
    {
        this.temp = temp;
    }
    //======================================== Getter-Method =========================================================||
    /**
     * @return  CustomerBill
     * getCustomerBill method will return value of the CustomerBill
     */
    public double getCustomerBill()
    {
        return customerBill;
    }

    /**
     * @return   BillNo
     * getBillNo method will return value of the BillNo
     */
    public int getBillNo()
    {
        return billNo;
    }

    /**
     * @return  discount
     * getDiscount method will return value of the Discount
     */
    public double getDiscount()
    {
        return discount;
    }
    public String getTemp()
    {
        return temp;
    }

    //======================================== DisplayBill() =========================================================||
    /**
     * displayBill method is Overridden by its parent class.
     * In this method, Bill of customer will display and when
     * displayBill method will be called, then All data related
     * to bill will be stored in file for later use. To handle
     * Exception, Exception handling has Applied to catch errors.
     */
    @Override
    public void displayBill()
    {
        /* Display BillNo and customerBill on console*/
        JOptionPane.showMessageDialog(null,
                               "Bill Number : "+getBillNo()+
                                       "\nEmail       : "+getTemp()+
                                       "\nTotal Bill : "+getCustomerBill(),
                                   "CUSTOMER BILL",
                                         JOptionPane.PLAIN_MESSAGE);

        /* try catch is used to manage Exception handling*/
        try
        {
            File       fileObj  = new File("DataBase\\BillDataBase.txt");   // make object of File and set Path
            FileWriter pen      = new FileWriter(fileObj,true);// Make object of FileWriter and pass File object in append mode
            pen.write(getBillNo()+"!"+getCustomerBill()+"!"+getTemp()+"\n");    // Write Data in File using delimiter
            pen.close();                                             //  Close File After writing file
        }
        catch (FileNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null,
                    "Bill DataBase-File not found".toUpperCase(),
                    "LOAD DATABASE FILES",
                    JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception ex)                                  // catch error if found
        {
            JOptionPane.showMessageDialog(null,
                    "Vehicle DATABASE not writing.... ".toUpperCase(),
                    "LOAD DATABASE FILES",
                    JOptionPane.ERROR_MESSAGE);   // display error message file not found
        }
    }

    //======================================== displayBillForAdmin() =================================================||
    public String displayBillForAdmin()
    {
        /* Display BillNo and customerBill on console*/
        return   "Bill No      : "+getBillNo()+
                 "\nEmail       : "+getTemp()+
                 "\nTotal Bill  : "+getCustomerBill()+"\n";
    }

    //======================================== DisplayBill() =========================================================||
    /**
     * displayBill method will be used when admin wants to
     * view detail of all customers Bill.
     */
    public String displayAllInfo()
    {
        String display="";
        for(BillPayment payment : paymentList)  // for-each loop is used to traverse Arraylist
        {
            display = display+payment.displayBillForAdmin()+"------------\n";              // display Bill info using Class type object
        }
        return display;
    }

    //======================================== calBill() =============================================================||
    @Override
    /**
     * displayBill method is Overridden by its parent class.
     * In this method, bill will be calculated and this will
     * be called in Vehicle booking class. Paas two parameters
     * like time and vehicle number then, bill will be calculated
     * after that it will set bill value , and call display method
     * where customer can view his/her bill.
     */
    public void calBill(int time, String vehicleNumber,String email)
    {

        for(Vehicle vc: VehicleOrganizer.vehicleArrayList)  // for-each loop will traverse Arraylist
        {
            if(vc.getVehicleNo().equals(vehicleNumber))     //check condition either vehicle-Number equals or not
            {
                int rate = (int) vc.getVehicleRate();       // store vehicle rate in Int type variable
                customerBill = (rate * time) * ((100-getDiscount())/100);   //calculation of bill
                temp = email;
            }
        }
       // billNo++;                                          // increment billNo.
        int limit = 100000000;
        Random rand = new Random();
        int random = rand.nextInt(limit);
        setBillNo(random);                                  // set BillNo.
        setTemp(temp);
        displayBill();                                      // call display method for Bill
    }
}

//======================================== Class End =================================================================||
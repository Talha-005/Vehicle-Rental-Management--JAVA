/**
 Project name : Vehicle Rental System
 Student name : Muhammad Talha Sohail
 Roll no.     : 0005-BSCS-2019 (Section-B)
 Description  : Class Main will be used for run the program. All Attributes/behaviors of each class is used. When user
                will run the program, then menu will display for user. There will be options ; 1.Admin, 2.Customer, 3.Mechanic
                and 4.Exit.
 =======================================================================================================================
                If user will select option 1. Then Admin will logIn his/her account.
 -----------------------------------------------------------------------------------------------------------------------
           ``   After that, Again Menu will display for Admin like; 1.Customer Details, 2.Mechanic Details, 3.Vehicle Organizer,
                4.Booking Details, 5.Feedback Detail and 6.Exit.
 -----------------------------------------------------------------------------------------------------------------------
           ``   If admin will select option 1, then Menu will be displayed that; 1.search customer, 2.Display All customer,
                3.Display All total Customer.
 -----------------------------------------------------------------------------------------------------------------------
           ``   If option 2 will be  selected, then Admin will can view details of Mechanic.
 -----------------------------------------------------------------------------------------------------------------------
           ``   If option 3 will be selected, then Menu will be displayed for Vehicle Management; 1.Add Vehicle, 2.Remove
                Vehicle, 3.Display Vehicle Info, 4.Display Total Vehicle, 5.Search Vehicle, 6.Exit.
 -----------------------------------------------------------------------------------------------------------------------
           ``   If option 4 will be  selected, then menu will be displayed; 1.Reserved Vehicle, 2.Reserved Vehicle Bill, 3.Exit
 -----------------------------------------------------------------------------------------------------------------------
           ``   If option 5 will be selected, then menu will be displayed; 1.Search Customer Feedback, 2.View Customers Feedback
 -----------------------------------------------------------------------------------------------------------------------
           ``   If option 6 will be displayed, then Admin will logOut.
 =======================================================================================================================
                If user will select option 2. Then Customer will logIn his/her account. If customer has not account then
                he/she has to register the account. After that menu will be displayed,
                1.Vehicle Booking, 2.Exit
 =======================================================================================================================
                If user will select option 3, then he/she has to login or Register account (in case of No account).
                Then user will check out which car needs to be repaired. Then mechanic will repair Vehicle.

 Used classes : All classes of project is used in this class.
 **/

//============================================= Import-Libraries/Classes =============================================||

import Controller.*;
import View.GUI;
import javax.swing.*;
import java.util.Scanner;


//============================================= Main Class ===========================================================||
public class MainClass
{
    //========================================= Main-Method ==========================================================||
    public static void main(String []args)
    {

        //===================================== Load DataBase-File in Program ========================================||
        DataBase.loadAdminFile();
        DataBase.loadCustomerFile();
        DataBase.loadVehicleFile();
        DataBase.loadMechanicFile();
        DataBase.loadBookingFile();
        DataBase.loadFeedbackFile();
        DataBase.loadBillFile();

        /* Create Scanner class object for inputs */
        Scanner scannerObject = new Scanner(System.in);

        //welcome message
        GUI.showWelcomeMessage();

        /* Initialize Integer-type Variable  */
        int bool = 2;

        /**
         * Here, when user Run program then, Menu will display. After that user will choose only his/her desire option.
         * Then account will be selected for login.
         */

            try
            {
                /* Menu for selection of Account */
                int select = Integer.parseInt(JOptionPane.showInputDialog(null,
                                                                  "1.Admin\n2.Customer\n3.Mechanic\n4.Exit\n\nEnter Option",
                                                                     "LogIn Selection",JOptionPane.QUESTION_MESSAGE));

//================================================== Admin-Account ===================================================||
            if(select==1)
            {
                        try
                        {
                            /* Here Admin will enter his/her Email and Password */
                            String email = JOptionPane.showInputDialog(null,"ENTER EMAIL","talha@gmail.com");
                            String password = JOptionPane.showInputDialog(null,"ENTER PASSWORD","1234");
                            /* Create object of Administration class */
                            Administration adminObject = new Administration(email,password);
                            /* Check Condition for LogIn */
                            
                            if (adminObject.logIn() == true)
                            {
//==================================================== MENU ==========================================================||
                                while(bool!=1)
                                {
                                    try
                                    {
                                        /* Admin will choose option to investigate information of his company */
                                        select = Integer.parseInt(JOptionPane.showInputDialog(null,
                                                "1. Customer Details" +
                                                        "\n2. Mechanic Details" +
                                                        "\n3. Vehicle Details" +
                                                        "\n4. Booking Details" +
                                                        "\n5. Feedback Detail" +
                                                        "\n6. Exit" +
                                                        "\n\nEnter Option ",
                                                "MENU FOR ADMIN",
                                                JOptionPane.QUESTION_MESSAGE));

//--------------------------------------------Switch Body Start-------------------------------------------------------||
                                        switch (select)
                                        {
                                            /*---------------------------Case:1 Body Start----------------------------------*/
                                            /*----------------------------------*/  case 1:
                                        {
                                            try
                                            {
                                                /* If Admin chose option for Customer's Detail, Then again there will be Sub-Menu */
                                                Customer customerObject = new Customer();
                                                select = Integer.parseInt(JOptionPane.showInputDialog(null,
                                                        "1. Search Customer" +
                                                                "\n2. Display All Customers" +
                                                                "\n3. Total No. of Customer" +
                                                                "\n\nEnter Option ","CUSTOMERS DETAILS"
                                                        ,JOptionPane.QUESTION_MESSAGE));

                                                /*-------------------------Start If-else chain-------------------------*/
                                                if(select == 1)
                                                {
                                                    String temp="";
                                                    for(Customer c : Customer.customerArrayList )
                                                    {
                                                        temp=temp+ c.getEmail()+"\n";
                                                    }
                                                    /* Search FeedBack of Customer */
                                                    String email1 = JOptionPane.showInputDialog(null,
                                                            temp+"\nEnter email",
                                                            "SEARCH CUSTOMER",
                                                            JOptionPane.QUESTION_MESSAGE);

                                                    customerObject.searchCustomer(email1); // call method
                                                }
                                                else if(select == 2)
                                                {
                                                    JOptionPane.showMessageDialog(null,
                                                            customerObject.DisplayAllProfile(),
                                                            "CUSTOMER DETAIL",
                                                            JOptionPane.PLAIN_MESSAGE); //call method for display Customer
                                                }
                                                else if (select == 3)
                                                {
                                                    JOptionPane.showMessageDialog(null,
                                                            "Total Customers : "
                                                                    +customerObject.totalCustomers(),
                                                            "CUSTOMER DETAILS",
                                                            JOptionPane.INFORMATION_MESSAGE); //call method to check total customer
                                                }
                                                /*---------------------------End If-else chain-------------------------*/
                                            }
                                            catch (Exception ex)
                                            {
                                                JOptionPane.showMessageDialog(null,
                                                        "Enter Valid Option!!",
                                                        "CUSTOMER DETAILS",
                                                        JOptionPane.WARNING_MESSAGE);
                                            }
                                            break;
                                        }
                                        /*-----------------------------------End C1  case:1 Body-------------------------------*/

                                        /*-----------------------------Start Case:2 Body-----------------------------------*/
                                        /*-------------------------------------*/case 2:
                                        {
                                            /* Create object of Mechanic and display All profile */
                                            VehicleMechanic mechanicObject = new VehicleMechanic();
                                            JOptionPane.showMessageDialog(null,
                                                    mechanicObject.displayProfile(),
                                                    "MECHANIC DETAILS",
                                                    JOptionPane.PLAIN_MESSAGE);
                                            break;
                                        }
                                        /*---------------------------------------End Case:2 Body---------------------------*/

                                        /*---------------------------------------Start Case:3 Body-------------------------*/
                                        /*-------------------------------------*/case 3:
                                        {
                                            try
                                            {
                                                /* Admin will choose option for Vehicle-Organizer*/
                                                select = Integer.parseInt(JOptionPane.showInputDialog(null,
                                                        "1. Add Vehicle" +
                                                                "\n2. Display Vehicle Info" +
                                                                "\n3. Total No. of Vehicles" +
                                                                "\n4. Search Vehicle" +
                                                                "\n5. Exit" +
                                                                "\n\nEnter option",
                                                        "VEHICLE ORGANIZER",
                                                        JOptionPane.QUESTION_MESSAGE));

                                                VehicleOrganizer organizerObject = new VehicleOrganizer();
                                                /*-----------------------------Start If-else Chain---------------------*/
                                                if(select==1)
                                                {
                                                    try
                                                    {
                                                        /* Enter Vehicle Details */
                                                        if (GUI.GUIAddVehicle() == JOptionPane.OK_OPTION)
                                                        {
                                                            String vehicleNumber = GUI.number.getText();
                                                            String VehicleName   = GUI.name.getText();
                                                            String vehicleType   = GUI.type.getText();
                                                            boolean Condition    = Boolean.parseBoolean(GUI.condition.getText());
                                                            int vehicleModel     = Integer.parseInt(GUI.model.getText());
                                                            int vehicleSeat      = Integer.parseInt(GUI.seats.getText());
                                                            double Rates         = Double.parseDouble(GUI.rate.getText());
                                                            String Color         = GUI.color.getText();

                                                            organizerObject.addVehicle(VehicleName,vehicleNumber,vehicleType,vehicleModel,vehicleSeat,Rates,Color,Condition);
                                                            DataBase.loadVehicleFile();
                                                        }
                                                        else
                                                        {
                                                            JOptionPane.showMessageDialog(null,
                                                                    " ADMIN CANCELED REGISTRATION",
                                                                    "ADD VEHICLE INFO",
                                                                    JOptionPane.WARNING_MESSAGE);
                                                        }
                                                    }
                                                    catch (Exception ex)
                                                    {
                                                        JOptionPane.showMessageDialog(null,
                                                                "Enter Valid INFO !!!",
                                                                "ADD VEHICLE INFO",
                                                                JOptionPane.WARNING_MESSAGE);
                                                    }
                                                }
                                                else if (select==2)
                                                {
                                                    /* Display all details of All Vehicle */
                                                    VehicleOrganizer.displayAll();
                                                }
                                                else if (select==3)
                                                {
                                                    /* Display Total vehicle in company */
                                                    JOptionPane.showMessageDialog(null,
                                                            "Total Vehicles : "+
                                                                    organizerObject.totalVehicle(),
                                                            "VEHICLE DETAILS",
                                                            JOptionPane.INFORMATION_MESSAGE);
                                                }
                                                else if (select==4)
                                                {
                                                    /* Search Specific Vehicle and check details */
                                                    String name = JOptionPane.showInputDialog(null,
                                                            "Enter Vehicle Name",
                                                            "SEARCH VEHICLE",
                                                            JOptionPane.QUESTION_MESSAGE);
                                                    organizerObject.displaySpecific(name);
                                                    break;
                                                }
                                                else if(select==5)
                                                {
                                                    break;
                                                }
                                                /*-----------------------------End If-else Chain-----------------------*/
                                            }
                                            catch (Exception ex)
                                            {
                                                JOptionPane.showMessageDialog(null,
                                                        "Enter Valid Option",
                                                        "VEHICLE ORGANIZER",
                                                        JOptionPane.WARNING_MESSAGE);
                                            }
                                            break;
                                        }
                                        /*---------------------------------------End Case:3 Body-------------------------*/

                                        /*---------------------------------------Start Case:4 Body-------------------------*/
                                        /*---------------------------------*/case 4:
                                        {
                                            try
                                            {
                                                /* Admin can check Reservation details and Bill */
                                                BillPayment payment = new BillPayment();
                                                select = Integer.parseInt(JOptionPane.showInputDialog(null,
                                                        "1. Reserved Vehicle" +
                                                                "\n2. Booking's Bill" +
                                                                "\n3. Total Bookings" +
                                                                "\n4. Exit"+
                                                                "\n\nEnter option",
                                                        "VEHICLE BOOKING DETAIL",
                                                        JOptionPane.QUESTION_MESSAGE));
                                                if(select == 1)
                                                {
                                                    /* Display Booked vehicle */
                                                    vehicleBooking.displayBookedVehicle();
                                                }
                                                else if (select == 2)
                                                {
                                                    /* Display Details of Payments */
                                                    JOptionPane.showMessageDialog(null,
                                                            payment.displayAllInfo(),
                                                            "BILL DETAILS",
                                                            JOptionPane.PLAIN_MESSAGE);
                                                }
                                                else if(select==3)
                                                {
                                                    JOptionPane.showMessageDialog(null,
                                                            "Total Bookings : "+
                                                                    vehicleBooking.bookingArrayList.size(),
                                                            "VEHICLE BOOKING DETAIL",
                                                            JOptionPane.INFORMATION_MESSAGE);
                                                }
                                                else if (select == 4)
                                                {
                                                    break;
                                                }
                                            }
                                            catch (Exception ex)
                                            {
                                                JOptionPane.showMessageDialog(null,
                                                        "Enter Valid Option !!!",
                                                        "VEHICLE BOOKING DETAIL",
                                                        JOptionPane.WARNING_MESSAGE);
                                            }
                                            break;
                                        }
                                        /*---------------------------------------End Case:4 Body---------------------------*/

                                        /*-------------------------------------Start Case:5 Body---------------------------*/
                                        /*---------------------------------*/case 5:
                                        {
                                            try
                                            {
                                                /* Admin can view FeedBack details Of customer */
                                                select = Integer.parseInt(JOptionPane.showInputDialog(null,
                                                        "1. Search Customer Feedback" +
                                                                "\n2. View Customers Feedback" +
                                                                "\n\nEnter Option",
                                                        "FEEDBACK DETAIL",
                                                        JOptionPane.QUESTION_MESSAGE));
                                                Feedback feedbackObject = new FeedbackOrganizer();

                                                if (select==1)
                                                {
                                                    String temp="";
                                                    for(Customer c : Customer.customerArrayList )
                                                    {
                                                        temp=temp+ c.getEmail()+"\n";
                                                    }
                                                    /* Search FeedBack of Customer */
                                                    String feed = JOptionPane.showInputDialog(null,
                                                            temp+"\nEnter email",
                                                            "SEACRCH FEEDBACK",
                                                            JOptionPane.QUESTION_MESSAGE);
                                                    feedbackObject.searchFeedback(feed);
                                                }
                                                else if(select==2)
                                                {
                                                    /* Admin can view All feedbacks */
                                                    feedbackObject.displayFeedback();
                                                }
                                            }
                                            catch (Exception ex)
                                            {
                                                JOptionPane.showMessageDialog(null,
                                                        "Enter Valid Option!!",
                                                        "FEEDBACK DETAIL",
                                                        JOptionPane.WARNING_MESSAGE);
                                            }
                                            break;
                                        }
                                        /*-------------------------------------End Case:5 Body---------------------------*/

                                        /*-------------------------------------*/case 6:
                                            bool = 1;
                                            break;
                                        }
                                        bool = JOptionPane.showConfirmDialog(null,
                                                "Do Admin want to continue ?",
                                                "ADMIN ACCOUNT",
                                                JOptionPane.YES_NO_OPTION);
//----------------------------------------------------- End Switch Body ----------------------------------------------||
                                    } catch (Exception ex)
                                    {
                                        JOptionPane.showMessageDialog(null,
                                                "Enter Valid Option!!",
                                                "MENU FOR ADMIN",
                                                JOptionPane.WARNING_MESSAGE);
                                    }
                                }
                            }
//--------------------------------------------------------------------------------------------------------------------||
                        }
/*---------------------*/ catch (Exception ex)
                        {
                            JOptionPane.showMessageDialog(null,
                                    "Enter Valid Option!!",
                                    "USER ACCOUNT",
                                    JOptionPane.WARNING_MESSAGE);
                        }


            }
//==================================================End-Admin-Account================================================//

//==================================================Customer-Account================================================//

            else if(select==2)
            {
                while (bool!=1)
                {
                /* Customer will enter email and password */
                JOptionPane.showConfirmDialog(null,GUI.GUIUserLogIn(), "USER LOGIN", JOptionPane.OK_CANCEL_OPTION);
                String email = GUI.email.getText();
                String password = new String(GUI.password.getPassword());
               // String email = JOptionPane.showInputDialog(null,"ENTER EMAIL","talha@.com");
                //String password = JOptionPane.showInputDialog(null,"ENTER PASSWORD","11");


                Customer customerObject = new Customer(email, password);
                /*-------------------------------------------Start If block-------------------------------------------*/
/*-------------*/if (customerObject.logIn(email, password) == false)
                {
                    try
                    {
                        select = Integer.parseInt(JOptionPane.showInputDialog(null,
                                                                      "1. Re-LogIn or Exit" +
                                                                              "\n2. Register Account" +
                                                                              "\n\nEnter Option",
                                                                         "CUSTOMER ACCOUNT",
                                                                              JOptionPane.QUESTION_MESSAGE));
                        switch (select)
                        {
                            case 1:
                                {
                                     break;
                                }
                            case 2:
                                {
                                    try
                                    {
                                        if (GUI.GUIAddCustomerDetail() == JOptionPane.OK_OPTION)
                                        {
                                            email          = GUI.email.getText();
                                            password       = String.valueOf(GUI.password.getPassword());
                                            String name    = GUI.name.getText();
                                            String gender  = GUI.gender.getText();
                                            String address = GUI.address.getText();
                                            String phone   = GUI.number.getText();
                                            String CNIC    = GUI.cnic.getText();
                                            int age        = Integer.parseInt(GUI.age.getText());

                                            Customer customerObject1 = new Customer(email, name, password, gender, phone, address, CNIC, age);
                                            customerObject1.registerCustomer(email, name, password, gender, phone, address, CNIC, age);
                                            DataBase.loadCustomerFile();

                                            break;
                                        }
                                        else
                                        {
                                            JOptionPane.showMessageDialog(null,
                                                                  " USER CANCELED REGISTRATION",
                                                                     "CUSTOMER REGISTRATION",
                                                                           JOptionPane.WARNING_MESSAGE);
                                        }

                                    }
                                    catch (Exception ex)
                                    {
                                        JOptionPane.showMessageDialog(null,
                                                              "Enter Valid Data",
                                                                 "CUSTOMER REGISTRATION",
                                                                       JOptionPane.WARNING_MESSAGE);
                                    }
                                }
                        }
                    } catch (Exception ex)
                    {
                        JOptionPane.showMessageDialog(null,
                                               "Enter Valid Option",
                                                  "CUSTOMER ACCOUNT",
                                                   JOptionPane.WARNING_MESSAGE);
                    }

                }
/*-----------------
                /*-------------------------------------------------End IF-block---------------------------------------*/

/*----------------*---------------------------------------Start IF-block---------------------------------------*/
                        /* Customer will have access for booking if Email and password would correct  */
                else if (customerObject.loginAccount(email, password))
                {
                     try
                     {
                         VehicleOrganizer vehicleObject = new VehicleOrganizer();
                         select = Integer.parseInt(JOptionPane.showInputDialog(null,
                                                                       "Press '1' to Vehicle Details",
                                                                          "VEHICLE DETAILS",
                                                                               JOptionPane.QUESTION_MESSAGE));
                         /*-----------------------------------Start IF-block---------------------------------------*/
/*----------------------*/if(select==1)
                            {
                                /* Customer can reserve vehicle */
                                VehicleOrganizer.displayAll();
                                select = Integer.parseInt(JOptionPane.showInputDialog(null,
                                                                              "1. Vehicle Booking" +
                                                                                      "\n2. Exit" +
                                                                                      "\n\nEnter Option",
                                                                                  "VEHICLE BOOKING",
                                                                                      JOptionPane.QUESTION_MESSAGE));
                                /*-------------------------------Start-Switch-block-----------------------------------*/
/*------------------------------*/switch (select)
                                  {
                                /*-----------------------------------Start CASE 1---------------------------------*/
/*---------------------------------*/case 1:
                                     {
/*------------------------------------*/try
                                       {
                                          /* here customer can enter Booking details */
                                           String temp="";
                                           for(Vehicle vc : VehicleOrganizer.vehicleArrayList )
                                           {
                                               temp=temp+ "Vehicle Name     : "+vc.getVehicleName()+
                                                       "\nVehicle No.          : "+vc.getVehicleNo()+
                                                       "\nRental Rate/Hour : "+vc.getVehicleRate()+"\n----------------\n";
                                           }
                                           boolean isFound = false;
                                           String number = JOptionPane.showInputDialog(null,
                                                   temp+"\nEnter Vehicle Number",
                                                   "VEHICLE BOOKING",
                                                   JOptionPane.QUESTION_MESSAGE);;
                                           for (Vehicle vc : VehicleOrganizer.vehicleArrayList)
                                           {
                                               if(vc.getVehicleNo().equals(number))
                                               {
                                                   isFound = true;

                                               }
                                           }
                                           if(isFound==true)
                                           {
                                               if(GUI.GUIAddBooking()==JOptionPane.OK_OPTION)
                                               {
                                                   String name     = GUI.name.getText();
                                                   String date     = GUI.date.getText();
                                                   String location = GUI.location.getText();
                                                   int time        = Integer.parseInt(GUI.time.getText());

                                                   vehicleBooking bookingObject = new vehicleBooking(GUI.email.getText(), name,date,location,time,number);

/*---------------------------------------*/   if(bookingObject.reserveVehicle(GUI.email.getText(), name,date,location,time,number)== true)
                                                 {
                                                   DataBase.loadBookingFile();
                                                   //Bill
                                                   BillPayment payment = new BillPayment();
                                                   payment.calBill(time,number,GUI.email.getText());
                                                   DataBase.loadBillFile();

                                                   //feedback
                                                   FeedbackOrganizer feedbackObject = new FeedbackOrganizer();
                                                   String feedBack = JOptionPane.showInputDialog(null,
                                                           "Enter Feedback",
                                                           "CUSTOMER FEEDBACK",
                                                           JOptionPane.QUESTION_MESSAGE);
                                                   feedbackObject.addFeedback(GUI.email.getText(), feedBack);
                                                   DataBase.loadFeedbackFile();
                                                  }
                                               }
                                               else
                                               {
                                                   JOptionPane.showMessageDialog(null,
                                                                         "CUSTOMER CANCELLED BOOKING",
                                                                             "VEHICLE BOOKING ",JOptionPane.WARNING_MESSAGE);
                                               }
                                           }
                                           else if (isFound!=true)
                                           {
                                               JOptionPane.showMessageDialog(null,
                                                      "Enter Valid Vehicle-Number".toUpperCase(),
                                                       "VEHICLE BOOKING",
                                                       JOptionPane.WARNING_MESSAGE);;
                                           }
                                       }
                                       catch (Exception ex)
                                        {
                                            JOptionPane.showMessageDialog(null,
                                                                  "Enter Valid INFO ",
                                                                     "VEHICLE BOOKING",
                                                                          JOptionPane.WARNING_MESSAGE);
                                        }
                                       break;
                                  }
                            /*-----------------------------------END case1-block------------------------------*/

                            /*---------------------------------Start case2-block------------------------------*/
/*--------------------------------*/case 2:
                                   {
                                        JOptionPane.showMessageDialog(null,
                                                               "Exiting from Booking...... ",
                                                                  "VEHICLE BOOKING",
                                                                       JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                  }
                            /*---------------------------------END case2-block--------------------------------*/
                               }//switch
                                /*-----------------------------------End switch-block---------------------------------*/
                            }//if-statement for detail

                     }
                     catch (Exception ex)
                     {
                         JOptionPane.showMessageDialog(null,
                                               "Enter Valid Info",
                                                  "CUSTOMER ACCOUNT",
                                                       JOptionPane.WARNING_MESSAGE);
                     }
                }// if-statement for login
                        /*-----------------------------------END IF-block---------------------------------------------*/
                    bool = JOptionPane.showConfirmDialog(null,
                            "Do Customer want to continue ?",
                            "CUSTOMER ACCOUNT",
                            JOptionPane.YES_NO_OPTION);
                }//end of while
            }//end of customer if block


//===========================================END-Customer account=====================================================||


//===================================================Start Mechanic account===========================================||


            else if(select == 3)
            {
                while (bool != 1)
                {
                    /* Here, Mechanic will LOgIn his/her Account */
                    String email = JOptionPane.showInputDialog(null,
                            "Enter Email",
                            "MECHANIC LOGIN",
                            JOptionPane.QUESTION_MESSAGE);
                    String password = JOptionPane.showInputDialog(null,
                            "Enter Password",
                            "MECHANIC LOGIN",
                            JOptionPane.QUESTION_MESSAGE);
                    VehicleMechanic mechanicObject = new VehicleMechanic(email, password);
                    //----------------------------------------END If-Block------------------------------------------------||
                    /*------------*/
                    if (mechanicObject.logIn(email, password) == false) {

                        try {
                            select = Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "1. Re-LogIn or Exit" +
                                            "\n2. Register Account" +
                                            "\n\nEnter Option",
                                    "MECHANIC ACCOUNT",
                                    JOptionPane.QUESTION_MESSAGE));
                            switch (select) {
                                case 1: {
                                    break;
                                }
                                case 2: {
                                    if (GUI.GUIAddMechanicDetail() == JOptionPane.OK_OPTION) {
                                        /* Mechanic will Register His/Her account in case of Invalid */
                                        email = GUI.email.getText();
                                        password = String.valueOf(GUI.password.getPassword());
                                        String name = GUI.name.getText();
                                        int age = Integer.parseInt(GUI.age.getText());
                                        int experience = Integer.parseInt(GUI.number.getText());

                                        VehicleMechanic mechanicObject1 = new VehicleMechanic();
                                        mechanicObject1.registerMechanic(email, name, password, age, experience);
                                        DataBase.loadMechanicFile();
                                        break;
                                    } else {
                                        JOptionPane.showMessageDialog(null,
                                                "MECHANIC CANCELED REGISTRATION",
                                                "MECHANIC REGISTRATION", JOptionPane.WARNING_MESSAGE);
                                    }
                                }
                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null,
                                    "Enter Valid INFO !!",
                                    "MEHCANIC ACCOUNT",
                                    JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    //----------------------------------------END If-Block------------------------------------------------||
                    /*---------------------------------START IF BLOCK---------------------------------------------*/
                    /*------------*/
                    else if (mechanicObject.loginAccount(email, password) == true) {
                        try {
                            VehicleOrganizer vehicleObject = new VehicleOrganizer();
                            select = Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "Press '1' to view Vehicle Condtion",
                                    "VEHICLE CONDITION",
                                    JOptionPane.QUESTION_MESSAGE));
                            if (select == 1) {
                                mechanicObject.checkVehicleCondition();
                                select = Integer.parseInt(JOptionPane.showInputDialog(null,
                                        "1. Repair Vehicle" +
                                                "\n2. Exit" +
                                                "\n\nEnter Option",
                                        "MECHANIC ACCOUNT",
                                        JOptionPane.QUESTION_MESSAGE));
                                /*----------------------------------START SWITCH BLOCK--------------------------------*/
                                /*--------------------*/
                                switch (select) {
                                    case 1: {
                                        mechanicObject.confirmCondition();
                                        break;
                                    }
                                    case 2: {
                                        System.out.println();
                                        JOptionPane.showMessageDialog(null,
                                                "Exiting.....!!",
                                                "MECHANIC ACCOUNT"
                                                , JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    }
                                }//switch
                                /*------------------------------------END SWITCH BLOCK--------------------------------*/
                            }//if-statement for detail
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null,
                                    "Enter Valid INFO !",
                                    "MECHANIC LOGIN",
                                    JOptionPane.WARNING_MESSAGE);
                        }

                    }// if-statement for login

                    bool = JOptionPane.showConfirmDialog(null,
                            "Do Mechanic want to continue ?",
                            "MECHANIC ACCOUNT",
                            JOptionPane.YES_NO_OPTION);
                }//end of while
            }// end of else if
//============================================End Mechanic Account====================================================||

            /* This block will be used when user want to logout */
            else if (select==4)
            {
               // break;
            }
          else
            {
                JOptionPane.showMessageDialog(null,
                        "Enter valid option!!",
                        "USER ACCOUNT",
                        JOptionPane.WARNING_MESSAGE);
            }
        }///End Try
            catch (Exception ex)
            {
                JOptionPane.showMessageDialog(null,
                                       "Select Valid Option !!",
                                          "USER ACCOUNT",
                                               JOptionPane.WARNING_MESSAGE);

            }

    }//End-main Method
}
//=========================================END MAIN CLASS=============================================================||
/**
 Project name : Vehicle Rental System
 Student name : Muhammad Talha Sohail
 Roll no.     : 0005-BSCS-2019 (Section-B)
 Description  : Class-FeedBack-Organizer extends FeedBack. Here I have designed a class. In this class there are
                attributes and behaviours of Feedback. Admin can view Detail of feedback of Customer and customer
                will give feedBack.
 Used classes : Just parent class is used.

 **/


//============================================ Import-Libraries/Classes ==============================================||

package Controller;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.*;

//===================================== Feedback-Organizer class Extends Feedback ====================================||
public class FeedbackOrganizer extends Feedback
{
    //======================================== Fields/Attributes =====================================================||

    boolean aBoolean = false;   //set bool-type variable

    /* HashMap is String type, which will
     *  hold Email and customer's feedback
     * only that will be store by User*/
    //static HashMap<String,String> hashMap = new HashMap<>();
    public static ArrayList <FeedbackOrganizer> feedbackList = new ArrayList<>();

    public FeedbackOrganizer(String email, String message)
    {
        this.email   = email;
        this.message = message;
    }
    public FeedbackOrganizer()
    {}

    //========================================= Setter/Getter ========================================================||
    /* setMessage will set Feedback which will be given by Customer */
    public void setMessage(String message)
    {
        this.message = message;
    }

    /*
     * @return message as a feedback
     */
    public String getMessage()
    {
        return message;
    }
    public String getEmail()
    {
        return email;
    }

    //=========================================== addFeedBack ========================================================||

    /**
     * @param email    Customer's Email
     * @param message  Customer's Feedback
     * addFeedback method will used when Customer booked his/her
     * rental vehicle after enjoy that services Customers must
     * have to give a feedback. Then that feedback along email
     * will write on file for admin's use.
     */
    public void addFeedback(String email,String message)
    {
        try                         // Exception Handling
        {
            File       fileObj = new File("DataBase\\FeedbackDataBase.txt"); // make object of File and set Path
            FileWriter pen     = new FileWriter(fileObj,true);  // Make object of FileWriter and pass File object in append mode
            /* Write Data in File using delimiter */
            pen.write(email+"!"+message+"\n");
            pen.close();                    //close file
        }
        catch (FileNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null,
                    "Feedback DataBase-File not found".toUpperCase(),
                    "LOAD DATABASE FILES",
                    JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception ex)                                  // catch error if found
        {
            JOptionPane.showMessageDialog(null,
                    "feedback DATABASE not writing.... ".toUpperCase(),
                    "LOAD DATABASE FILES",
                    JOptionPane.ERROR_MESSAGE);   // display error message file not found
        }
    }


    //========================================= Search-Customer ======================================================||
    /**
     * @param email Pass param to search specific customer's
     *              feedback. searchFeedback Method will be
     *              used, when admin wants to search desire
     *              feedback of customer from Data. So, this
     *              working will be proceed.
     */
    public void searchFeedback(String email)
    {
        boolean aFound = false;
        String temp="";
        for(FeedbackOrganizer organizer: feedbackList)
        {
            if(organizer.getEmail().equals(email))          // check condition that hashmap contains email ?
            {
                aFound   = true;
                aBoolean = true;
                temp=temp+"FEEDBACK OF "+email+" : "+organizer.getMessage()+"\n";
            }
        }
        if(aFound==true)
        {
            JOptionPane.showMessageDialog(null, temp,
                    "SEARCH FEEDBACK",JOptionPane.INFORMATION_MESSAGE);

        }

        if(aBoolean!=true)           // if false
        {
            JOptionPane.showMessageDialog(null,
                                  "FEEDBACK OF "+email+" NOT EXISTS",
                                     "SEARCH FEEDBACK",JOptionPane.WARNING_MESSAGE);
              // print message that email not found
        }
    }

    //========================================= Display-FeedBack =====================================================||

    /**
     * displayFeedback role's is that it will display
     * feedback of customer against his/her email by
     * iterating HashMap.
     */
    public void displayFeedback()
    {

        String temp="";
        for(FeedbackOrganizer organizer: feedbackList)
        {
                temp = temp+"Email         : "+organizer.getEmail()+"\nFeedback : "+
                        organizer.getMessage()+"\n------------------\n";

        }
        JOptionPane.showMessageDialog(null,temp,
                                 "FEEDBACK DETAILS",JOptionPane.PLAIN_MESSAGE);
    }
    //================================================================================================================||

}
//====================================================== End of class ================================================||
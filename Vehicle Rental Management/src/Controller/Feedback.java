/**
 Project name : Vehicle Rental System
 Student name : Muhammad Talha Sohail
 Roll no.     : 0005-BSCS-2019 (Section-B)
 Description  : Class-abstract-FeedBack. Here I have designed a class. In this class there are attributes and behaviours
                of Feedback. Admin can view Detail of feedback of Customer and customer will give feedBack.
 Used classes : No class is used in this class.😊😊
 **/
package Controller;
//============================================ Abstract feedback Class ===============================================||
public abstract class Feedback
{

    //======================================== Fields/Attributes =====================================================||
    /* variable will hold feedback Given by Customer after service*/
    public String  message,email;

    //================================================================================================================||
    /* abstract setMessage */
    public abstract void setMessage(String message);

    //================================================================================================================||
    /* abstract addFeedback */
    public abstract void addFeedback(String email,String message);

    //================================================================================================================||
    /* abstract getMessage */
    public abstract String getMessage();

    //================================================================================================================||
    /* abstract displayFeedback */
    public abstract void displayFeedback();

    //================================================================================================================||
    /* abstract searchFeedback */
    public abstract void searchFeedback(String email);
}

//======================================================== End class =================================================||
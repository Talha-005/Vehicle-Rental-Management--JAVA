package Controller;
import javax.swing.*;

/**
 Project name : Vehicle Rental System
 Student name : Muhammad Talha Sohail
 Roll no.     : 0005-BSCS-2019 (Section-B)
 Description  : Class User is Parent class of Admin , customer, mechanic. All attributes+behaviours of this will extend
                in its child classes.
 Used classes : No other class is used in this class.

 **/

//================================================= User Class =======================================================||
public class User
{
    /* String type variables hold values */
    private String email,name,password;


    //============================================ Parameterized-constructor =========================================||
    /**
     * @param email    User's email
     * @param name     User's name
     * @param password User's password
     */
    public User(String email,String name,String password)
    {
        this.email    = email;
        this.name     = name;
        this.password = password;
    }
    /**
     * @param email    User's email
     * @param password User's password
     */
    public User(String email,String password)
    {
        this.email    = email;
        this.password = password;
    }
    //======================================== NON-Parameterized-constructor =========================================||
    public User()
    { }

    //=============================================== SETTER-Methods =================================================||
    /* setEmail method will set value of the User's email */
    public void setEmail(String email)
    {
        this.email = email;
    }
    /* setName method will set value of the User's Name */
    public void setName(String name)
    {
        this.name = name;
    }
    /* setPassword method will set value of the User's password */
    public void setPassword(String password)
    {
        this.password = password;
    }

    //=============================================== Getter-Methods =================================================||
    /**
     * @return  email
     * getEmail method will return value of the Email
     */
    public String getEmail()
    {
        return email;
    }
    /**
     * @return  password
     * getPassword method will return value of the password
     */
    public String getPassword()
    {
        return password;
    }
    /**
     * @return  Name
     * getName method will return value of the name
     */
    public String getName()
    {
        return name;
    }

    //============================================= DisplayInfo-Method ===============================================||
    /**
     * displayInfo method will show just Name
     * and Email which will be used in child
     * classes.
     */
    public String DisplayInfo()
    {
        return "NAME    : "+getName()+
               "\nEMAIL    : "+getEmail()+"\n";
    }

    //================================================= LogInAccount =================================================||
    /**
     * @param Email  ..
     * @param Password  ..
     * @return boolean
     * LogInAccount method will be used, in child class's LogIn method,
     * when user wants to Login his/her Account. If given email and
     * password will correct then user will have access to his/her
     * account. Else customer will have to re-Login (in case of
     * Invalid password and email).
     */
    public Boolean loginAccount(String Email,String Password)
    {
        if(Password==getPassword() && Email==getEmail())    // check condition for email & password
        {
            return true;
        }
        return false;
    }
}
//=================================================== End of Class ===================================================||
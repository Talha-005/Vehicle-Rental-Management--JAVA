/**
 Project name : Vehicle Rental System
 Student name : Muhammad Talha Sohail
 Roll no.     : 0005-BSCS-2019 (Section-B)
 Description  : Class-GUI. Here I have Designed a class. In this class there are attributes and behaviours.
                These attributes and  methods will used for GUI. When user run this project then all kinds of
                Graphical interfaces will display like; welcome message, login account, registration, booking
                view all data etc.
 Used classes : Admin, Customer, Mechanic, Vehicle classes are used here.
 **/

//============================================ Import-Libraries/Classes ==============================================||
package View;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
//================================================= Class GUI ========================================================||
public class GUI
{
    //================================== static fields for GUI ==============================================================||
    public static JPasswordField password = new JPasswordField();
    public static JTextField email        = new JTextField();
    public static JTextField name         = new JTextField();
    public static JTextField number       = new JTextField();
    public static JTextField type         = new JTextField();
    public static JTextField model        = new JTextField();
    public static JTextField seats        = new JTextField();
    public static JTextField rate         = new JTextField();
    public static JTextField color        = new JTextField();
    public static JTextField condition    = new JTextField();
    public static JTextField age          = new JTextField();
    public static JTextField cnic         = new JTextField();
    public static JTextField gender       = new JTextField();
    public static JTextField address      = new JTextField();
    public static JTextField time         = new JTextField();
    public static JTextField date         = new JTextField();
    public static JTextField location     = new JTextField();

    //========================================= showWelcomeMessage() =================================================||
    public static void showWelcomeMessage()
    {
        // create an icon object to show image on Panel.
        ImageIcon imageIcon = new ImageIcon("Picture\\pic.jpg");
        JLabel imageLabel = new JLabel(imageIcon);
        JPanel imagePanel = new JPanel();
        imagePanel.setBackground(new Color(119, 96, 220));
        imagePanel.setSize(new Dimension(200, 64));
        imagePanel.add(imageLabel);

        // create a label object to Show text on Panel.
        JLabel textLabel = new JLabel("***** Welcome to MTS Vehicle Rental Company *****");
        textLabel.setBounds(0, 0, 200, 64);
        textLabel.setFont(new Font("Times New Romans", Font.BOLD, 16));
        textLabel.setHorizontalAlignment(SwingConstants.CENTER);
        textLabel.setForeground(new Color(40, 1, 215));

        // set layout of panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(imagePanel,BorderLayout.PAGE_START);
        mainPanel.add(textLabel);

        /* print Welcome message for User */
        JOptionPane.showMessageDialog(null,mainPanel,
                                 "WELCOME MESSAGE OF COMPANY",JOptionPane.DEFAULT_OPTION);

    }
//============================================ GUIUserLogIn() ========================================================||
    public static Object GUIUserLogIn()
    {
        // set layout of pane;.
        JPanel panel = new JPanel(new BorderLayout(8, 8));

        // create a label object to Show text with box on Panel.
        JPanel label = new JPanel(new GridLayout(0, 1, 3, 3));
        label.add(new JLabel("EMAIL", SwingConstants.RIGHT));
        label.add(new JLabel("PASSWORD", SwingConstants.RIGHT));
        panel.add(label, BorderLayout.WEST);

        // create a  Panel.
        JPanel mainControl = new JPanel(new GridLayout(0, 1, 3, 3));
        mainControl.add(email);
        mainControl.add(password);
        panel.add(mainControl, BorderLayout.CENTER);

        return panel;
    }

//================================================ GUIAddVehicle() ===================================================||
    public static int GUIAddVehicle()
    {
        int inputs= 0;
        try
        {
            Object[] labels = {
                                    "VEHICLE_NAME", name,
                                    "VEHICLE_NUMBER", number,
                                    "VEHICLE_TYPE", type,
                                    "VEHICLE_MODEL", model,
                                    "VEHICLE_SEATS", seats,
                                    "VEHICLE_RATE /HOUR", rate,
                                    "VEHICLE_COLOR", color,
                                    "VEHICLE_CONDITION (true/false)", condition,
                               };
         inputs = JOptionPane.showConfirmDialog(name, labels, "ADD VEHICLE INFORMATION", JOptionPane.OK_CANCEL_OPTION);

       }
    catch (Exception e){}

        return inputs;
    }

//=========================================== GUIAddCustomerDetail() =================================================||
    public static int GUIAddCustomerDetail()
    {
        int inputs= 0;
        try
        {
            Object[] labels = {
                                    "CUSTOMER_NAME", name,
                                    "CUSTOMER_EMAIL", email,
                                    "CUSTOMER_PASSWORD", password,
                                    "CUSTOMER_AGE", age,
                                    "CUSTOMER_PHONE_NO.", number,
                                    "CUSTOMER_GENDER", gender,
                                    "CUSTOMER_ADDRESS", address,
                                    "CUSTOMER_CNIC", cnic,
                            };
            inputs = JOptionPane.showConfirmDialog(name, labels, "CUSTOMER REGISTRATION", JOptionPane.OK_CANCEL_OPTION);
        }
        catch (Exception e){}

        return inputs;
    }

//========================================= GUIAddMechanicDetail() ===================================================||
public static int GUIAddMechanicDetail()
    {
        int inputs= 0;
        try
        {
            Object[] labels = {
                                    "MECHANIC_NAME", name,
                                    "MECHANIC_EMAIL", email,
                                    "MECHANIC_PASSWORD", password,
                                    "MECHANIC_AGE", age,
                                    "MECHANIC_EXPERIENCE /YEAR", number,

                            };
            inputs = JOptionPane.showConfirmDialog(name, labels, "CUSTOMER REGISTRATION", JOptionPane.OK_CANCEL_OPTION);
        }
        catch (Exception e){}

        return inputs;
    }

//============================================== GUIAddBooking() =====================================================||
    public static int GUIAddBooking()
    {
        int inputs= 0;
        try
        {
            Object[] labels = {
                    "CUSTOMER_NAME", name,
                    "BOOKING_DATE", date,
                    "BOARDING_LOCATION", location,
                    "RENTAL_TIME /HOUR", time,

            };
            inputs = JOptionPane.showConfirmDialog(name, labels,
                                             "VEHICLE BOOKING", JOptionPane.OK_CANCEL_OPTION);
        }
        catch (Exception e){}

        return inputs;
    }
//====================================================================================================================||

}
//======================================== END CLASS =================================================================||

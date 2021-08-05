/**
 Project name : Vehicle Rental System
 Student name : Muhammad Talha Sohail
 Roll no.     : 0005-BSCS-2019 (Section-B)
 Description  : Class-vehicle. Here I have designed a class. In this class there are attributes and behaviours
                of Vehicle. Admin has access to add add/remove/update info of vehicle. Then Customer can view only details
 Used classes : NO other class is used in ths class
 **/
package Controller;
public class Vehicle
{
    //======================================== Fields/Attributes =====================================================||
    /* declare variables to hold values */
    private String vehicleName,vehicleNo,vehicleType,color;
    private int vehicleModelNo, seats;
    private double vehicleRate;
    boolean vehicleCondition;

    //======================================== Parameterized-Constructor =============================================||
    /**
     * @param vehicleName       Vehicle Name
     * @param vehicleNo         Vehicle Number
     * @param vehicleType       Vehicle Type (Car/Truck/Coach etc...)
     * @param vehicleModelNo    Vehicle ModelNo.
     * @param seats             Vehicle seats
     * @param vehicleRate       Vehicle Rental Rate per hour
     * @param color             Vehicle color
     * @param vehicleCondition  Vehicle Condition (true/false)
     */
    public Vehicle(String vehicleName, String vehicleNo, String vehicleType, int vehicleModelNo, int seats,
                         double vehicleRate,String color, boolean vehicleCondition)
    {
        this.vehicleName      = vehicleName;
        this.vehicleNo        = vehicleNo;
        this.vehicleType      = vehicleType;
        this.vehicleModelNo   = vehicleModelNo;
        this.seats            = seats;
        this.vehicleRate      = vehicleRate;
        this.color            = color;
        this.vehicleCondition = vehicleCondition;
    }

    //======================================== Non-Parameterized-Constructor =========================================||
    public Vehicle()
    { }

    //================================================= Setter-Methods ===============================================||
    /* setVehicleName method will set value of the vehicle's Name */
    public void setVehicleName(String vehicleName)
    {
        this.vehicleName = vehicleName;
    }
    /* setVehicleNo. method will set value of the vehicle's number */
    public void setVehicleNo(String vehicleNo)
    {
        this.vehicleNo = vehicleNo;
    }
    /* setVehicleType method will set value of the vehicle's Type */
    public void setVehicleType(String vehicleType)
    {
        this.vehicleType = vehicleType;
    }
    /* setVehicleModelNo. method will set value of the vehicle's ModelNo. */
    public void setVehicleModelNo(int vehicleModelNo)
    {
        this.vehicleModelNo = vehicleModelNo;
    }
    /* setVehicleSeats method will set value of the vehicle's Seats */
    public void setSeats(int seats)
    {
        this.seats = seats;
    }
    /* setVehicleHour method will set value of the vehicle's rate/hour */
    public void setVehicleRate(double vehicleRate)
    {
        this.vehicleRate = vehicleRate;
    }
    /* setVehicleColor method will set value of the vehicle's Color */
    public void setColor(String color)
    {
        this.color = color;
    }
    /* setVehicleCondition method will set value of the vehicle's condition */
    public void setVehicleCondition(boolean vehicleCondition)
    {
        this.vehicleCondition = vehicleCondition;
    }

    //================================================= Getter-Methods ===============================================||
    /**
     * @return  vehicleName
     * getAge method will return Name
     */
    public String getVehicleName()
    {
        return vehicleName;
    }
    /**
     * @return  vehicleType
     * getAge method will return type of vehicle(car/truck/coach etc....)
     */
    public String getVehicleType()
    {
        return vehicleType;
    }
    /**
     * @return  VehicleModel
     * getAge method will return Model of vehicle
     */
    public int getVehicleModelNo()
    {
        return vehicleModelNo;
    }
    /**
     * @return  seats
     * getAge method will return seats of Vehicle
     */
    public int getSeats()
    {
        return seats;
    }
    /**
     * @return  vehicleNo
     * getAge method will return number of Vehicle
     */
    public String getVehicleNo()
    {
        return vehicleNo;
    }
    /**
     * @return  vehicleRate
     * getAge method will return rate of vehicle
     */
    public double getVehicleRate()
    {
        return vehicleRate;
    }
    /**
     * @return  color
     * getAge method will return Color of vehicle
     */
    public String getColor()
    {
        return color;
    }
    /**
     * @return  true/false
     * getAge method will return condition of vehicle
     */
    public boolean getVehicleCondition()
    {
        return vehicleCondition;
    }

    //================================================= DisplayVehicle ===============================================||
    /**
     * displayVehicle Method will be called by its Organizer
     * class. Then All information will be displayed of
     * vehicle on console.
     */
    public String displayVehicle()
    {
        return  "VEHICLE NAME  : " + getVehicleName() +
                "\nMODEL-NO.        : " + getVehicleModelNo() +
                "\nTYPE                    : " + getVehicleType() +
                "\nVEHICLE NO.      : " + getVehicleNo()+
                "\nSEATS                : " + getSeats()+
                "\nRATE/HOUR       : "+getVehicleRate()+
                "\nCOLOR               : "+getColor();
    }

}
//================================================= End of class =====================================================||

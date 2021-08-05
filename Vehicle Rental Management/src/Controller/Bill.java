/**
   Project name : Vehicle Rental System
   Student name : Muhammad Talha Sohail
   Roll no.     : 0005-BSCS-2019 (Section-B)
   Description  : Interface-Bill. Here I have designed a class. In this class there are behaviours
                  of Bill like Display Bill of booking hours and then Calculate Bill for Rent.
   Used classes : There is no class used in this class.
 **/
package Controller;
//============================================ Interface Bill ========================================================||
public interface Bill
{
    // declare an abstract method of void type displayBill()
    abstract void displayBill();
    // declare an abstract method of void type calBill(parameters)
    abstract void calBill(int time, String number,String email);
}

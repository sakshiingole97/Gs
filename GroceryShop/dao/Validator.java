package GroceryShop.dao;

import Project4.pojo.Customer;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validator
{
    Scanner sc=new Scanner(System.in);
    private static Pattern Customer_Username=Pattern.compile("^[a-zA-Z ]+$");
    private static Pattern Customer_Email=Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
    private static Pattern Customer_Contact=Pattern.compile("^\\d{10}$");
    private static Pattern Customer_Password=Pattern.compile("^(?=.*[0-9])" +
            "(?=.*[a-z])" + "(?=.*[A-Z])" + "(?=.*[@#$%^&-+=()])" + "(?=\\S+$).{8,20}$");
    Customer c1 = null;
    public String validateEmail(){
        String Email;
        while(true) {
            System.out.print("Enter Email Id=>");
            Email = sc.nextLine();
            if (!Customer_Email.matcher(Email).matches()) {
                System.out.println( "Please Enter Valid Email" );
                c1.setEmail(Email);

            } else {
                break;
            }
        }
        return Email;
    }
    //---------------------------------------------------------------------------------------------
    public  Long  validateContact() {
        String Contact;
        while (true) {
            System.out.print("Enter Contact Number=> ");
            Contact = sc.nextLine();
            if (!Customer_Contact.matcher(Contact).matches()) {
                System.out.println("SORRY ! PLEASE ENTER VALID CONTACT NUMBER ");

            } else {
                break;
            }
        }
        return Long.valueOf(Contact);
    }
    //---------------------------------------------------------------------------------------------
    public String validatePassWord(){
        String Password;
        while(true) {
            System.out.print("Enter your password=>");
            Password = sc.nextLine();
            if (!Customer_Password.matcher(Password).matches()) {
                System.out.println( "SORRY! PLEASE ENTER VALID PASSWORD" );
            } else {
                break;
            }
        }
        return Password;
    }
    //---------------------------------------------------------------------------------------------
    public String validateUserName(){
        String UserName;
        while (true){
            System.out.print("Enter UserName=>");
            UserName=sc.nextLine();
            if(!Customer_Username.matcher(UserName).matches()){
                System.out.println("PLEASE ENTER VAILD USERNAME ");
            }
            else{
                break;
            }

        }
        return UserName;
    }
}


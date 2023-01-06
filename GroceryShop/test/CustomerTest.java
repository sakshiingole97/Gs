package GroceryShop.test;

import GroceryShop.dao.CustomerDAOimpl;
import GroceryShop.dao.ProductDAOimpl;
import GroceryShop.dao.SerializationDeserialization;
import GroceryShop.dao.Validator;
import GroceryShop.pojo.Customer;
import GroceryShop.pojo.Item;
import GroceryShop.pojo.Shopitems;

import java.util.ArrayList;
import java.util.Scanner;
public class CustomerTest
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Item s=null;
        Shopitems p = null;
        Customer c = null;
        ArrayList<Item> items;
        ArrayList<Shopitems> product;
        ArrayList<Customer> clist = null;
        CustomerDAOimpl cimpl=new CustomerDAOimpl();
        ProductDAOimpl pimpl=new ProductDAOimpl();
        int option,id,qty;
        String Username,name,Email,password,pname;
        double price,price1,totalPrice,overAllPrice=0.0;
        long Contact;
        char choice;
        boolean flag,exit=false;
        Validator v=new Validator();
        SerializationDeserialization sd=new SerializationDeserialization();

        System.out.println("Welcome to our Grocery Shop");
        do{
            System.out.println("please enter the option given below");
            System.out.println("1.Shopkeeper\n2.Customer");
            option=sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1: {
                    do {
                        System.out.println("1.Add product to list\n" +
                                "2.Update list\n" +
                                "3.Delete product from list\n" +
                                "4.Show product list\n" +
                                "5.Exit\n");
                        int ch = sc.nextInt();
                        sc.nextLine();
                        switch (ch) {
                            case 1: {
                                do {
                                    System.out.print("Enter Product name=>");
                                    pname = sc.nextLine();
                                    System.out.print("Enter Product Price=>");
                                    price1 = sc.nextDouble();
                                    sc.nextLine();
                                    p = new Shopitems();
                                    p.setPname(pname);
                                    p.setPrice(price1);
                                    flag = pimpl.addProduct(p);
                                    if (flag) {
                                        System.out.println("Added to the list");
                                    } else {
                                        System.out.println("Error while Adding");
                                    }
                                    System.out.print("Want to add more items? (y or n): ");
                                    choice = sc.next().charAt(0);
                                    sc.nextLine();
                                } while (choice == 'y' || choice == 'Y');
                                product = pimpl.showAllProduct();
                                sd.serialization(product);
                                break;
                            }
                            case 2: {
                                System.out.println("Enter Product name to update list");
                                pname = sc.nextLine();
                                p = pimpl.ShowbyProductName(pname);
                                if (p == null) {
                                    System.out.println("No such product available");
                                } else {
                                    product = pimpl.showAllProduct();
                                    sd.deserialization(product);
                                    System.out.println("\nDo you really what to update Your List?" +
                                            "Enter y or n");
                                    choice = sc.next().charAt(0);
                                    sc.nextLine();
                                    if (choice == 'n') {
                                        System.out.println("thank You");
                                    } else if (choice == 'y') {
                                        System.out.println("enter Product name:");
                                        pname = sc.nextLine();
                                        System.out.println("Enter Product Price=>");
                                        price = sc.nextDouble();
                                        sc.nextLine();
                                        p = new Shopitems();
                                        p.setPname(pname);
                                        p.setPrice(price);
                                        flag = pimpl.addProduct(p);
                                        if (flag) {
                                            System.out.println("Updated Successfully");
                                        } else {
                                            System.out.println("Error updating");
                                        }
                                    }
                                }
                                break;
                            }
                            case 3: {
                                product = pimpl.showAllProduct();
                                sd.deserialization(product);
                                System.out.println("plz enter product id to delete");
                                id = sc.nextInt();
                                sc.nextLine();
                                flag = pimpl.deleteProduct(id);
                                if (flag) {
                                    System.out.println("Product is deleted from database");
                                } else {
                                    System.out.println("error while deleting");
                                }
                                break;
                            }
                            case 4: {
                                product = pimpl.showAllProduct();
                                sd.deserialization(product);
                                break;
                            }
                            case 5: {
                                System.exit(0);
                            }
                        }
                    }while(exit=false);
                    break;
                }
                case 2: {
                    do {
                        System.out.println("1. Customer Registration\n" +
                                "2.Login\n" +
                                "3.Update Your Profile\n" +
                                "4.Show profile\n" +
                                "5.Delete profile\n" +
                                "6.exit");
                        int ch = sc.nextInt();
                        sc.nextLine();
                        switch (ch) {
                            case 1: {

                                Username = v.validateUserName();
                                Email = v.validateEmail();
                                Contact = v.validateContact();
                                password = v.validatePassWord();
                                c = new Customer();
                                c.setEmail(Email);
                                c.setUsername(Username);
                                c.setContact(Contact);
                                c.setPassword(password);
                                flag = cimpl.addCustomer(c);
                                if (flag) {
                                    System.out.println("Registration Done Successfully");
                                } else {
                                    System.out.println("Registration error");
                                }
                                break;
                            }
                            case 2: {
                                try {
                                    Username = v.validateUserName();
                                    password = v.validatePassWord();
                                    if ((c.getUsername().equals(Username)) && (c.getPassword().equals(password))) {
                                        System.out.println("User Successfully Logged-in");
                                        do {
                                            System.out.println("1.Show list of product\n" +
                                                    "2.Add product in cart\n" +
                                                    "3.Show Cart\n" +
                                                    "4.Billing \n" +
                                                    "5.Exit");

                                            int o = sc.nextInt();
                                            sc.nextLine();
                                            switch (o) {
                                                case 1: {
                                                    product=pimpl.showAllProduct();
                                                    sd.deserialization(product);
                                                    break;
                                                }
                                                case 2: {
                                                    do {
                                                        System.out.println("Enter the product details: ");
                                                        System.out.print("Product Name: ");
                                                        name = sc.nextLine();
                                                        System.out.print("Quantity: ");
                                                        qty = sc.nextInt();
                                                        System.out.print("Price: ");
                                                        price = sc.nextDouble();
                                                        totalPrice = price * qty;
                                                        overAllPrice = overAllPrice + totalPrice;
                                                        s = new Item();
                                                        s.setName(name);
                                                        s.setPrice(price);
                                                        s.setQty(qty);
                                                        s.setTotal(totalPrice);
                                                        pimpl.additem(s);
                                                        System.out.print("Want to add more items? (y or n): ");
                                                        choice = sc.next().charAt(0);
                                                        sc.nextLine();
                                                    } while (choice == 'y' || choice == 'Y');

                                                }
                                                case 3: {
                                                    items=pimpl.showAllItem();
                                                    Item.display1();
                                                    for (Item p1 : items) {
                                                        p1.display();
                                                        System.out.format("-----------------------------------------------------------------------------------------------------------------------------------\n");
                                                    }
                                                    break;
                                                }
                                                case 4: {
                                                    System.out.println("\n\t\t\t\t\t\t\t\t\t\tTotal Amount (Rs.) " + overAllPrice);
                                                    double discount = overAllPrice * 2 / 100;
                                                    System.out.println("\n\t\t\t\t\t\t\t\t\t\t    Discount (Rs.) " + discount);
                                                    double subtotal = overAllPrice - discount;
                                                    System.out.println("\n\t\t\t\t\t\t\t\t\t\t          Subtotal " + subtotal);
                                                    double sgst = overAllPrice * 12 / 100;
                                                    System.out.println("\n\t\t\t\t\t\t\t\t\t\t          SGST (%) " + sgst);
                                                    double cgst = overAllPrice * 12 / 100;
                                                    System.out.println("\n\t\t\t\t\t\t\t\t\t\t          CGST (%) " + cgst);
                                                    System.out.println("\n\t\t\t\t\t\t\t\t\t\t     Invoice Total " + (subtotal + cgst + sgst));
                                                    System.out.println("\t\t\t\t----------------Thank You for Shopping!!-----------------");
                                                    break;
                                                }
                                                case 5: {
                                                    System.exit(0);
                                                }
                                            }
                                        } while (true);
                                    } else {
                                        System.out.println("Invaild username or password");
                                    }
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                                break;
                            }
                            case 3: {
                                System.out.println("Enter Username to update your profile");
                                Username = sc.nextLine();
                                c = cimpl.ShoebyUsername(Username);
                                if (c == null) {
                                    System.out.println("no such User avaliable");
                                } else {
                                    Customer.displayFormat();
                                    for (Customer c1 : clist) {
                                        c1.display();
                                        System.out.format("-----------------------------------------------------------------------------------------------------------------------------------\n");
                                    }
                                    System.out.println("\nDo you really what to update Your profile?" +
                                            "Enter y or n");
                                    choice = sc.next().charAt(0);
                                    sc.nextLine();
                                    if (choice == 'n') {
                                        System.out.println("thank You");
                                    } else if (choice == 'y') {
                                        System.out.println("enter Username:");
                                        Username = sc.nextLine();
                                        System.out.println("enter Email");
                                        Email = sc.nextLine();
                                        System.out.println("enter phone no=>");
                                        Contact = sc.nextLong();
                                        System.out.println("enter your password");
                                        password = sc.next();
                                        sc.nextLine();
                                        c = new Customer();
                                        c.setEmail(Email);
                                        c.setUsername(Username);
                                        c.setContact(Contact);
                                        c.setPassword(password);
                                        flag = cimpl.addCustomer(c);
                                        if (flag) {
                                            System.out.println("done");
                                        } else {
                                            System.out.println("error");
                                        }
                                        break;

                                    }
                                }
                            }
                            case 4: {
                                Username = v.validateUserName();
                                c = cimpl.ShoebyUsername(Username);
                                if (c == null) {
                                    System.out.println("No such user found");
                                } else {
                                    Customer.displayFormat();
                                    for (Customer c1 : clist) {
                                        c1.display();
                                        System.out.format("-----------------------------------------------------------------------------------------------------------------------------------\n");
                                    }
                                }
                                break;

                            }
                            case 5: {
                                clist = cimpl.showAllCustomer();
                                Customer.displayFormat();
                                for (Customer c1 : clist) {
                                    c1.display();
                                    System.out.format("-----------------------------------------------------------------------------------------------------------------------------------\n");
                                }
                                System.out.println("plz enter your Customer id delete");
                                id = sc.nextInt();
                                sc.nextLine();
                                flag = cimpl.deleteCustomer(id);
                                if (flag) {
                                    System.out.println("Profile is deleted from database");
                                } else {
                                    System.out.println("error while deleting");
                                }
                                break;
                            }
                            case 6: {
                                System.exit(0);
                            }
                        }
                    }while(exit=false);
                    break;
                }
            }
        }while(exit==false);
    }
}
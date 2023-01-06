package GroceryShop.dao;

import GroceryShop.pojo.Shopitems;

import java.io.*;
import java.util.ArrayList;

public class SerializationDeserialization
{
    public void serialization(ArrayList<Shopitems> product)
    {
    try
    {
        FileOutputStream fos = new FileOutputStream("E:\\python\\New folder\\employeeData.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(product);
        oos.close();
        fos.close();
    }
    catch (IOException ioe)
    {
        ioe.printStackTrace();
    }
    }
    public void deserialization(ArrayList<Shopitems> product) {
        try {
            FileInputStream fis = new FileInputStream("E:\\python\\New folder\\employeeData.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            product = (ArrayList) ois.readObject();

            ois.close();
            fis.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }

        Shopitems.displayFormat();
        for (Shopitems p1 : product) {
            p1.display();
            System.out.format("-----------------------------------------------------------------------------------------------------------------------------------\n");
        }
    }
}

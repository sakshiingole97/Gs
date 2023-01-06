package GroceryShop.pojo;

import java.io.Serializable;

public class Item implements Serializable
{
    int id,qty;
    String name;
    double price,total;

    public Item()
    {
        super();
    }

    public Item(int id, int qty, String name, double price, double total) {
        this.id = id;
        this.qty = qty;
        this.name = name;
        this.price = price;
        this.total = total;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static void display1() {
        System.out.format("-----------------------------------------------------------------------------------------------------------------------------------");
        System.out.print("\nProduct ID \t\tProductName\t\t\t\t Price\t\t\tQuantity\t\t\tTotalPrice\n");
        System.out.format("-----------------------------------------------------------------------------------------------------------------------------------\n");
    }
    public void display() {
        System.out.format("   %-9s             %-9s      %5f %5f\n", id, name, price,qty,total);

    }

}

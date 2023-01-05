package GroceryShop.pojo;

public class Shopitems {

    private int id1, qty;
    private String pname;
    private double price, totalPrice;

    public Shopitems() {
        super();
    }


    // constructor
    Shopitems(int id1, String pname, int qty, double price, double totalPrice) {
        this.id1 = id1;
        this.pname = pname;
        this.qty = qty;
        this.price = price;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Shopitems{" +
                "id1=" + id1 +
                ", qty=" + qty +
                ", pname='" + pname + '\'' +
                ", price=" + price +
                ", totalPrice=" + totalPrice +
                '}';
    }

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }


    public static void displayFormat() {
        System.out.format("-----------------------------------------------------------------------------------------------------------------------------------");
        System.out.print("\nProduct ID \t\tProductName\t\t\t\t Price\n");
        System.out.format("-----------------------------------------------------------------------------------------------------------------------------------\n");
    }


    public void display() {
        System.out.format("   %-9s             %-9s      %5f\n", id1, pname, price);

    }
}


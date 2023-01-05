package GroceryShop.pojo;

public class Customer
{
    int id;
    String username,Email,password;
    long contact;

    public Customer()
    {
        super();
    }
    public Customer(int id, String username, String email, String password, long contact)
    {
        this.id = id;
        this.username = username;
        Email = email;
        this.password = password;
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", Email='" + Email + '\'' +
                ", password='" + password + '\'' +
                ", contact=" + contact +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public static void displayFormat() {
        System.out.format("-----------------------------------------------------------------------------------------------------------------------------------");
        System.out.print("\nCustomer ID \t\tUserName\t\t\t\t Email\t\t\t\tContact\n");
        System.out.format("-----------------------------------------------------------------------------------------------------------------------------------\n");
    }


    public void display() {
        System.out.format("   %-9s             %-9s      %-9s       %5f\n", id, username, Email,contact);

    }
}

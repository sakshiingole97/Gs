package GroceryShop.dao;
import GroceryShop.pojo.Customer;

import java.util.ArrayList;

public interface CustomerDAO
{
    public boolean addCustomer(Customer b);
    public boolean updateCustomer(Customer b);
    public boolean deleteCustomer(int id);
    public Customer ShowByCustomerId(int id);
    public Customer ShoebyUsername(String name);
    public ArrayList<Customer> showAllCustomer();
}


package GroceryShop.dao;

import GroceryShop.pojo.Customer;

import java.util.ArrayList;
import java.util.Iterator;

public class CustomerDAOimpl implements CustomerDAO
{
    ArrayList<Customer> list =new ArrayList<>();
    int id=1;
    @Override
    public boolean addCustomer(Customer b)
    {
        if(b!=null)
        {
            b.setId(id);
            list.add(b);
            id=id+1;
            return true;
        }
        return false;
    }

    @Override
    public boolean updateCustomer(Customer b)
    {
        for(int i = 0; i< list.size(); i++)
        {
            Customer b1= list.get(i);
            if(b1.getId()==b.getId())
            {
                list.set(i,b);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteCustomer(int id)
    {
        Iterator<Customer>i= list.iterator();
        while(i.hasNext())
        {
            Customer b1=i.next();
            if(b1.getId()==id)
            {
                i.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public Customer ShowByCustomerId(int id)
    {
        for(int i = 0; i< list.size(); i++)
        {
            Customer b1= list.get(i);
            if(b1.getId()==id)
            {
                return b1;
            }
        }
        return null;
    }

    @Override
    public Customer ShoebyUsername(String username)
    {
        for(int i = 0; i< list.size(); i++)
        {
            Customer b1= list.get(i);
            if(b1.getUsername().equals(username))
            {
                return b1;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Customer> showAllCustomer()
    {
        if(list.isEmpty())
        return null;
        else
            return list;
    }
}

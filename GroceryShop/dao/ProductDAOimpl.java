package GroceryShop.dao;
import GroceryShop.pojo.Item;
import GroceryShop.pojo.Shopitems;
import java.util.ArrayList;
import java.util.Iterator;

public class ProductDAOimpl implements productDAO
{   ArrayList<Item> Item =new ArrayList<>();
    ArrayList<Shopitems> product =new ArrayList<>();
    int id1=1;
    private String pname;

    @Override
    public boolean additem(Item i)
    {
        if(i!=null)
        {
            i.setId(id1);
            Item.add(i);
            id1=id1+1;
            return true;
        }
        return false;
    }

    @Override
    public boolean addProduct(Shopitems p)
    {
        if(p!=null)
        {
            p.setId1(id1);
            product.add(p);
            id1=id1+1;
            return true;
        }
        return false;
    }

    @Override
    public boolean updateProduct(Shopitems p)
    {
        for(int i = 0; i< product.size(); i++)
        {
            Shopitems p1= product.get(i);
            if(p1.getId1()==p.getId1())
            {
                product.set(i,p);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteProduct(int id1)
    {
        Iterator<Shopitems> i= product.iterator();
        while(i.hasNext())
        {
            Shopitems p1=i.next();
            if(p1.getId1()==id1)
            {
                i.remove();
                return true;
            }
        }
        return false;
    }


    @Override
    public Shopitems ShowbyProductName(String name)
    {
        for(int i = 0; i< product.size(); i++)
        {
            Shopitems p1= product.get(i);
            if(p1.getPname().equals(pname))
            {
                return p1;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Shopitems> showAllProduct()
    {
        if(product.isEmpty())
        {  return null;}
        else
        { return product;}

    }

    @Override
    public ArrayList<Item> showAllItem()
    {
        if(Item.isEmpty())
        {  return null;}
        else
        { return Item;}
    }
}

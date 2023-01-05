package GroceryShop.dao;

import java.util.ArrayList;
import GroceryShop.pojo.*;
public interface productDAO
{
    public boolean additem(Item i);
    public boolean addProduct(Shopitems p);
    public boolean updateProduct(Shopitems p);
    public boolean deleteProduct(int id1);
    public Shopitems ShowbyProductName(String name);
    public ArrayList<Shopitems> showAllProduct();
    public ArrayList<Item> showAllItem();

}

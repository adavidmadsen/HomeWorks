package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ShoppingListItem
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int listId;
    private int shoppingListId;
    private String item;
    private int locationId;
    private int userId;

    public int getListId()
    {
        return listId;
    }

    public void setListId(int listId)
    {
        this.listId = listId;
    }

    public int getShoppingListId()
    {
        return shoppingListId;
    }

    public void setShoppingListId(int shoppingListId)
    {
        this.shoppingListId = shoppingListId;
    }

    public String getItem()
    {
        return item;
    }

    public void setItem(String item)
    {
        this.item = item;
    }

    public int getLocationId()
    {
        return locationId;
    }

    public void setLocationId(int locationId)
    {
        this.locationId = locationId;
    }

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }
}

package models;

import akka.stream.TLSProtocol;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ShoppingListItemDetail
{
    @Id
    private String shoppingListName;
    private int shoppingListId;
    private String item;
    private int userId;

    public ShoppingListItemDetail(String shoppingListName, int shoppingListId, String item, int userId)
    {
        this.shoppingListName = shoppingListName;
        this.shoppingListId = shoppingListId;
        this.item = item;
        this.userId = userId;
    }

    public String getShoppingListName()
    {
        return shoppingListName;
    }

    public void setShoppingListName(String shoppingListName)
    {
        this.shoppingListName = shoppingListName;
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

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }
}

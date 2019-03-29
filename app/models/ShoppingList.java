package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ShoppingList
{
    @Id
    private int shoppingListId;
    private String shoppingListName;

    public int getShoppingListId()
    {
        return shoppingListId;
    }

    public void setShoppingListId(int shoppingListId)
    {
        this.shoppingListId = shoppingListId;
    }

    public String getShoppingListName()
    {
        return shoppingListName;
    }

    public void setShoppingListName(String shoppingListName)
    {
        this.shoppingListName = shoppingListName;
    }
}

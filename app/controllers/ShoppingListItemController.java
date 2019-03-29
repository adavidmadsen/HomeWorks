package controllers;


import models.ShoppingList;
import models.ShoppingListItem;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.util.List;


public class ShoppingListItemController extends Controller
{
    private JPAApi db;
    private FormFactory formFactory;

    @Inject
    public ShoppingListItemController(JPAApi db, FormFactory formFactory)
    {
        this.db = db;
        this.formFactory = formFactory;
    }

    @Transactional(readOnly = true)
    public Result getShoppingListItem()
    {
        TypedQuery<ShoppingListItem> query = db.em().createQuery("Select s FROM ShoppingListItem s", ShoppingListItem.class);
        List<ShoppingListItem> shoppingListItem = query.getResultList();

        return ok(views.html.shoppinglistitem.render(shoppingListItem));

    }

    @Transactional
    public Result getShoppingListItemAdd()
    {
        TypedQuery<ShoppingList> query = db.em().createQuery("SELECT s FROM ShoppingList s", ShoppingList.class);
        List<ShoppingList> shoppingList = query.getResultList();


        return ok(views.html.shoppinglistitemadd.render(shoppingList));
    }

    @Transactional
    public Result postShoppingListItemAdd()
    {
        ShoppingListItem shoppingListItem = new ShoppingListItem();

        DynamicForm form = formFactory.form().bindFromRequest();


        int shoppingListId = Integer.parseInt(form.get("shoppingListId"));
        String  item = form.get("item");
//        int locationId = Integer.parseInt(form.get("locationId"));
//        int userId = Integer.parseInt(form.get("userId"));




       shoppingListItem.setShoppingListId(shoppingListId);
        shoppingListItem.setItem(item);
//       shoppingListItem.setLocationId(1);
       shoppingListItem.setUserId(1);
//        shoppingListItem.setLocationId(locationId);

        db.em().persist(shoppingListItem);

        return redirect("shoppinglistitemadd");

    }








}

package controllers;

import models.EventCalendar;
import models.ShoppingListItem;
import models.User;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class HomePageController extends Controller
{
    private JPAApi db;
    private FormFactory formFactory;


    @Inject
    public HomePageController(JPAApi db, FormFactory formFactory)
    {
        this.db = db;
        this.formFactory = formFactory;
    }

    @Transactional
    public Result getHomePage()
    {
        TypedQuery<User> query = db.em().createQuery("Select u FROM User u", User.class);
        List<User> user = query.getResultList();
        LocalDate date = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M-dd-yyyy");
        String displayDate = date.format(dateTimeFormatter);



        TypedQuery<EventCalendar> eventquery = db.em().createQuery("Select e From EventCalendar e",
                EventCalendar.class);

        List<EventCalendar> eventCalendar = eventquery.getResultList();

        TypedQuery<ShoppingListItem> shoppingquery = db.em().createQuery("Select s FROM ShoppingListItem s", ShoppingListItem.class);
        List<ShoppingListItem> shoppingListItems = shoppingquery.getResultList();

        return ok(views.html.homepage.render(user, displayDate, eventCalendar, shoppingListItems));
    }

}

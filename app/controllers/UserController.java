package controllers;

import models.EventCalendar;
import models.User;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.useredit;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserController extends Controller
{
    private JPAApi db;
    private FormFactory formFactory;

    @Inject
    public UserController(JPAApi db, FormFactory formFactory)
    {
        this.db = db;
        this.formFactory = formFactory;

    }

    @Transactional(readOnly = true)
    public Result getUser()
    {
        TypedQuery<User> query = db.em().createQuery("Select u FROM User u", User.class);
        List<User> user = query.getResultList();

        return ok(views.html.user.render(user));

    }

    public Result getUserAdd()
    {
        return ok(views.html.useradd.render());
    }

    @Transactional
    public Result postUserAdd()
    {
        User user = new User();

        DynamicForm form = formFactory.form().bindFromRequest();
        String userName = form.get("userName");


        user.setUserName(userName);

        db.em().persist(user);

        return redirect("/user");
    }

    @Transactional(readOnly = true)
    public Result getUserEdit(int userId)

    {

        TypedQuery<User> query = db.em().createQuery("SELECT u FROM User u Where userId = :userId",
                User.class);
        query.setParameter("userId", userId);
       User user = query.getSingleResult();

        return ok(views.html.useredit.render(user));
    }


    @Transactional
    public Result postUserEdit(int userId)

    {

        TypedQuery<User> query = db.em().createQuery("SELECT u FROM User u Where userId = :userId",
                User.class);
        query.setParameter("userId", userId);
        User user = query.getSingleResult();

        DynamicForm form = formFactory.form().bindFromRequest();


        String userName = form.get("userName");

        user.setUserId(userId);
        user.setUserName(userName);



        db.em().persist(user);


        return redirect("/user");
    }

    @Transactional(readOnly = true)
    public Result getUserFile(int userId)
    {
        TypedQuery<User> query = db.em().createQuery("Select u From User u Where userId = :userId", User.class);
        query.setParameter("userId", userId);
        User user = query.getSingleResult();

        TypedQuery<EventCalendar>eventquery = db.em().createQuery("Select e From EventCalendar e Where userId = :userId order by date", EventCalendar.class);
        eventquery.setParameter("userId", user.getUserId());
        List<EventCalendar> eventCalendar = eventquery.getResultList();

        return ok(views.html.userfile.render(user, eventCalendar));
    }

    @Transactional
    public Result getUserDelete(int userId)
    {
        User user = db.em().find(User.class, userId);
        db.em().remove(user);

        TypedQuery<User> query = db.em().createQuery("Select u FROM User u", User.class);
        List<User> users = query.getResultList();


        return ok(views.html.user.render(users));
    }




}

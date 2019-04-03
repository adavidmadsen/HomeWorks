package controllers;

import models.User;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class HomePageController extends Controller
{
    private JPAApi db;
    private FormFactory formFactory;


    @Inject
    public HomePageController(JPAApi db, FormFactory formFactory)
    {
        this.db=db;
        this.formFactory = formFactory;
    }
@Transactional
    public Result getHomePage()
    {
        TypedQuery<User> query = db.em().createQuery("Select u FROM User u", User.class);
        List<User> user = query.getResultList();
        LocalDate date = LocalDate.now();

        return ok(views.html.homepage.render(user,date));
    }

}

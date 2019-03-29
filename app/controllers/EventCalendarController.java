package controllers;

import models.EventCalendar;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.util.List;

public class EventCalendarController extends Controller
{
    private JPAApi db;
    private FormFactory formFactory;

    @Inject
    public EventCalendarController(JPAApi db, FormFactory formFactory)
    {
        this.db=db;
        this.formFactory = formFactory;
    }

    @Transactional(readOnly = true)
    public Result getEventCalendar()
    {
        TypedQuery<EventCalendar> query = db.em().createQuery("Select e FROM EventCalendar e", EventCalendar.class);
        List<EventCalendar> eventcalendar = query.getResultList();

        return ok(views.html.eventcalendar.render(eventcalendar));


    }




}

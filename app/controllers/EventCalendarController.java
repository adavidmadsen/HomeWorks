package controllers;

import models.EventCalendar;
import models.User;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.user;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import java.awt.*;
import java.time.LocalDate;
import java.util.List;

public class EventCalendarController extends Controller
{
    private JPAApi db;
    private FormFactory formFactory;

    @Inject
    public EventCalendarController(JPAApi db, FormFactory formFactory)
    {
        this.db = db;
        this.formFactory = formFactory;
    }

    @Transactional(readOnly = true)
    public Result getEventCalendar()
    {
        TypedQuery<EventCalendar> query = db.em().createQuery("Select e FROM EventCalendar e Order by Date", EventCalendar.class);
        List<EventCalendar> eventcalendar = query.getResultList();

        return ok(views.html.eventcalendar.render(eventcalendar));

    }

    @Transactional
    public Result getEventCalendarAdd()
    {
        TypedQuery<User> query = db.em().createQuery("SELECT u FROM User u", User.class);
        List<User> user = query.getResultList();


        return ok(views.html.eventcalendaradd.render(user));
    }


    @Transactional
    public Result postEventCalendarAdd()
    {
        EventCalendar eventCalendar = new EventCalendar();

        DynamicForm form = formFactory.form().bindFromRequest();

//        int calendarId = Integer.parseInt(form.get("calendarId"));
        String description = form.get("Description");
        int userId = Integer.parseInt(form.get("UserId"));
        String reminder = form.get("Reminder");
        String specialEvents = form.get("SpecialEvents");
//        int locationId = Integer.parseInt(form.get("locationId"));
//        int calendarTypeId = Integer.parseInt(form.get("calendarTypeId"));
        LocalDate date = LocalDate.parse(form.get("Date"));

//        eventCalendar.setCalendarId(calendarId);
        eventCalendar.setDescription(description);
        eventCalendar.setUserId(userId);
        eventCalendar.setReminder(reminder);
        eventCalendar.setSpecialEvents(specialEvents);
        eventCalendar.setLocationId(1);
        eventCalendar.setCalendarTypeId(1);
        eventCalendar.setDate(date);


        db.em().persist(eventCalendar);

        return redirect("/eventcalendar");
    }


    @Transactional(readOnly = true)
    public Result getEventFile(int calendarId)
    {
        TypedQuery<EventCalendar> query = db.em().createQuery("Select e From EventCalendar e Where calendarId = " +
                ":calendarId", EventCalendar.class);
        query.setParameter("calendarId", calendarId);
        EventCalendar eventCalendar = query.getSingleResult();

        TypedQuery<User> userquery = db.em().createQuery("Select u From User u Where userId = :userId", User.class);
        userquery.setParameter("userId", eventCalendar.getUserId());
        List<User> user = userquery.getResultList();

        return ok(views.html.eventfile.render(eventCalendar, user));
    }

    @Transactional
    public Result getEventCalendarDelete(int calendarId)
    {
        EventCalendar eventCalendar = db.em().find(EventCalendar.class, calendarId);
        db.em().remove(eventCalendar);

        TypedQuery<EventCalendar> query = db.em().createQuery("Select e FROM EventCalendar e", EventCalendar.class);
        List<EventCalendar> eventcalendar = query.getResultList();


        return ok(views.html.eventcalendar.render(eventcalendar));
    }

    @Transactional(readOnly = true)
    public Result getEventCalendarEdit(int calendarId)

    {

        TypedQuery<EventCalendar> query = db.em().createQuery("SELECT e FROM EventCalendar e Where calendarId = :calendarId",
                EventCalendar.class);
        query.setParameter("calendarId", calendarId);
        EventCalendar eventCalendar = query.getSingleResult();

        TypedQuery<User> userquery = db.em().createQuery("Select u From User u", User.class);
       List<User> user = userquery.getResultList();


        return ok(views.html.eventcalendaredit.render(eventCalendar, user));
    }

    @Transactional
    public Result postEventCalendarEdit(int calendarId)

    {

        TypedQuery<EventCalendar> query = db.em().createQuery("SELECT e FROM EventCalendar e Where calendarId = :calendarId",
                EventCalendar.class);
        query.setParameter("calendarId", calendarId);
        EventCalendar eventCalendar = query.getSingleResult();

        DynamicForm form = formFactory.form().bindFromRequest();


        String description= form.get("Description");
        String reminder = form.get("Reminder");
        String specialEvents = form.get("SpecialEvents");
        LocalDate date = LocalDate.parse(form.get("Date"));
        String userId = form.get("UserId");
        int user = Integer.parseInt(userId);


        eventCalendar.setDescription(description);
        eventCalendar.setReminder(reminder);
        eventCalendar.setSpecialEvents(specialEvents);
        eventCalendar.setDate(date);
        eventCalendar.setUserId(user);


        db.em().persist(eventCalendar);


        return redirect("/eventcalendar");
    }

}




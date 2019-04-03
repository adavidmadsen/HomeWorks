package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class EventCalendar
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int calendarId;
    private String description;
    private int userId;
    private String reminder;
    private  String specialEvents;
    private int locationId;
    private int calendarTypeId;
    private LocalDate date;

    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }

    public int getCalendarId()
    {
        return calendarId;
    }

    public void setCalendarId(int calendarId)
    {
        this.calendarId = calendarId;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public String getReminder()
    {
        return reminder;
    }

    public void setReminder(String reminder)
    {
        this.reminder = reminder;
    }

    public String getSpecialEvents()
    {
        return specialEvents;
    }

    public void setSpecialEvents(String specialEvents)
    {
        this.specialEvents = specialEvents;
    }

    public int getLocationId()
    {
        return locationId;
    }

    public void setLocationId(int locationId)
    {
        this.locationId = locationId;
    }

    public int getCalendarTypeId()
    {
        return calendarTypeId;
    }

    public void setCalendarTypeId(int calendarTypeId)
    {
        this.calendarTypeId = calendarTypeId;
    }
}




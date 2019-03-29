package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EventCalendar
{
    @Id
    private int calendarId;
    private String description;
    private int userId;
    private String reminder;
    private  String specialEvents;
    private int locationId;
    private int calendarTypeId;

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

    public String getSpecialEvent()
    {
        return specialEvents;
    }

    public void setSpecialEvent(String specialEvent)
    {
        this.specialEvents = specialEvent;
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




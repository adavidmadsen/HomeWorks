package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserFile
{
    @Id
    private int userId;
    private String userName;


    public UserFile(int userId, String userName)
    {
        this.userId = userId;
        this.userName = userName;
    }

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }
}

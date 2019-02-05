package android.course.edmodo_203898309_305186108.Fmessages;


import java.sql.Date;

public class ObjMeesage {
    private int id;
    private String textMessage;
    private Date date;
    private int idProfileFrom;
    private int idProfileTo;

    public ObjMeesage() {
    }

    public ObjMeesage(String textMessage, Date date, int idProfileFrom, int idProfileTo) {

        this.textMessage = textMessage;
        this.date = date;
        this.idProfileFrom = idProfileFrom;
        this.idProfileTo = idProfileTo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdProfileFrom() {
        return idProfileFrom;
    }

    public void setIdProfileFrom(int idProfileFrom) {
        this.idProfileFrom = idProfileFrom;
    }

    public int getIdProfileTo() {
        return idProfileTo;
    }

    public void setIdProfileTo(int idProfileTo) {
        this.idProfileTo = idProfileTo;
    }
}


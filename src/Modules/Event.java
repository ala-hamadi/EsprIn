package Modules;

import Utils.Enums.State;

import java.sql.Timestamp;

public class Event {
    private int idEvent;
    private  String TitleEvent;
    private String Description;
    private Timestamp DateEvent;
    private String ImgURL;
    private long idOrganizer;
    private State state;

    public long getIdOrganizer() {
        return idOrganizer;
    }

    public void setIdOrganizer(long idOrganizer) {
        this.idOrganizer = idOrganizer;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public String getTitleEvent() {
        return TitleEvent;
    }

    public void setTitleEvent(String titleEvent) {
        TitleEvent = titleEvent;
    }

    public String getDescription() { return Description; }

    public void setDescription(String description) {
        Description = description;
    }

    public Timestamp getDateEvent() {
        return DateEvent;
    }

    public void setDateEvent(Timestamp dateEvent) {
        DateEvent = dateEvent;
    }

    public String getImgURL() {
        return ImgURL;
    }

    public void setImgURL(String imgURL) {
        ImgURL = imgURL;
    }

    public State getState() { return state; }

    public Event(String TitleEvent, String Description, String ImgURL, Timestamp DateEvent, long idOrganizer){
       this.TitleEvent=TitleEvent;
        this.Description=Description;
        this.ImgURL=ImgURL;
        this.DateEvent=DateEvent;
        this.idOrganizer= idOrganizer;
    }


    public Event(int idEvent, String TitleEvent, String Description,String ImgURL,Timestamp DateEvent, long idOrganizer, State state){
        this.idEvent=idEvent;
        this.TitleEvent=TitleEvent;
        this.Description=Description;
        this.ImgURL=ImgURL;
        this.DateEvent=DateEvent;
        this.idOrganizer= idOrganizer;
        this.state=state;
    }


    @Override
    public String toString() {
        return "idEvent=" + idEvent +
                ", TitleEvent= " + TitleEvent +
                ", Description= " + Description +
                ", DateEvent=" + DateEvent +
                ", ImgURL= " + ImgURL +
                ", idOrganizer= " + idOrganizer +
                ", State " + state +
                '\n';
    }
}

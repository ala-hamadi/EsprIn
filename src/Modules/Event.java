package Modules;

import java.sql.Date;

import Utils.Enums.State;

public class Event {

    private int idEvent;
    private  String TitleEvent;
    private String Description;
    private Date DateDebut;
    private Date DateFin;
    private String EventLocal;
    private String ImgURL;
    private long idOrganizer;
    private State state;
    private int nbrParticipant;



    public int getNbrParticipant() { return nbrParticipant; }

    public void setNbrParticipant(int nbrParticipant) { this.nbrParticipant = nbrParticipant; }

    public Date getDateDebut() { return DateDebut; }

    public void setDateDebut(Date dateDebut) { DateDebut = dateDebut; }

    public Date getDateFin() { return DateFin; }

    public void setDateFin(Date dateFin) { DateFin = dateFin; }

    public String getEventLocal() { return EventLocal; }

    public void setEventLocal(String eventLocal) { EventLocal = eventLocal; }

    public void setState(State state) { this.state = state; }

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


    public String getImgURL() {
        return ImgURL;
    }

    public void setImgURL(String imgURL) {
        ImgURL = imgURL;
    }

    public State getState() { return state; }

    public Event(String TitleEvent, String Description){
        this.TitleEvent=TitleEvent;
        this.Description=Description;
    }

    public Event(String TitleEvent, String Description,Date DateDebut, Date DateFin, String EventLocal, long idOrganizer){
        this.TitleEvent=TitleEvent;
        this.Description=Description;
        this.DateDebut=DateDebut;
        this.DateFin=DateFin;
        this.EventLocal= EventLocal;
        this.idOrganizer= idOrganizer;
    }


    public Event(String TitleEvent, String Description, String ImgURL, Date DateDebut, Date DateFin,String EventLocal, long idOrganizer){
        this.TitleEvent=TitleEvent;
        this.Description=Description;
        this.ImgURL=ImgURL;
        this.DateDebut=DateDebut;
        this.DateFin=DateFin;
        this.EventLocal=EventLocal;
        this.idOrganizer= idOrganizer;
    }

    public Event(int idEvent, String TitleEvent, String Description, String ImgURL, Date DateDebut, Date DateFin,String EventLocal, long idOrganizer, State state, int nbrParticipant){
        this.idEvent=idEvent;
        this.TitleEvent=TitleEvent;
        this.Description=Description;
        this.ImgURL=ImgURL;
        this.DateDebut=DateDebut;
        this.DateFin=DateFin;
        this.EventLocal=EventLocal;
        this.idOrganizer= idOrganizer;
        this.nbrParticipant= nbrParticipant;
    }


    @Override
    public String toString() {
        return "idEvent=" + idEvent +
                ",  TitleEvent=" + TitleEvent +
                ",  Description=" + Description +
                ",  DateDebut=" + DateDebut +
                ",  DateFin=" + DateFin +
                ",  Localisation=" + EventLocal +
                ",  ImgURL=" + ImgURL +
                ",  idOrganizer=" + idOrganizer +
                ",  State" + state +
                '\n';
    }
}

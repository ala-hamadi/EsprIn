package Modules;

import Utils.Enums.State;
import Utils.Structure.Classe;

import java.util.Date;

public class AlertProf {
    private int idAlert;
    private String contentAlert;
    private Classe destClass;
    private long idSender;
    private State state;
    private Date createdAt=new Date();

    public AlertProf(int idAlert, String contentAlert, Classe destClass, long idSender, Date createdAt) {
        this.idAlert = idAlert;
        this.contentAlert = contentAlert;
        this.destClass = destClass;
        this.idSender= idSender;
        this.state=State.Active;
        this.createdAt=createdAt;

    }

    public int getIdAlert() {
        return idAlert;
    }

    public void setIdAlert(int idAlert) {
        this.idAlert = idAlert;
    }

    public String getContentAlert() {
        return contentAlert;
    }

    public void setContentAlert(String contentAlert) {
        this.contentAlert = contentAlert;
    }

    public Classe getDestClass() {
        return destClass;
    }

    public void setDestClass(Classe destClass) {
        this.destClass = destClass;
    }

    public long getIdSender() {
        return idSender;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Alert{" +
                "idAlert=" + idAlert +
                ", contentAlert='" + contentAlert + '\'' +
                ", destClass=" + destClass +
                ", idSender=" + idSender +
                ", state=" + state +
                ", createdAt=" + createdAt +
                '}';
    }

}


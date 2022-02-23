package Modules;

import Utils.Enums.Roles;
import Utils.Enums.State;

public class Annoucement {
    private int idAnn;
    private String subjectAnn;
    private String contentAnn;
    private Roles destAnn;
    private int idSender;
    private State state;

    public Annoucement(int idAnn, String subjectAnn, String contentAnn, Roles destAnn,int idSender) {
        this.idAnn = idAnn;
        this.subjectAnn = subjectAnn;
        this.contentAnn = contentAnn;
        this.destAnn = destAnn;
        this.idSender=idSender;
        this.state=State.Active;
    }



    public int getIdAnn() {
        return idAnn;
    }

    public void setIdAnn(int idAnn) {
        this.idAnn = idAnn;
    }

    public String getSubjectAnn() {
        return subjectAnn;
    }

    public void setSubjectAnn(String subjectAnn) {
        this.subjectAnn = subjectAnn;
    }

    public String getContentAnn() {
        return contentAnn;
    }

    public void setContentAnn(String contentAnn) {
        this.contentAnn = contentAnn;
    }

    public Roles getDestAnn() {
        return destAnn;
    }

    public void setDestAnn(Roles destAnn) {
        this.destAnn = destAnn;
    }

    public int getIdSender() {
        return idSender;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Annoucement{" +
                "idAnn=" + idAnn +
                ", subjectAnn='" + subjectAnn + '\'' +
                ", contentAnn='" + contentAnn + '\'' +
                ", destAnn=" + destAnn +
                '}';
    }
}

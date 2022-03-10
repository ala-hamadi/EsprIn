package Modules;

public class Participate {
    private int cinUser;
    private int idEvent;

    public int getCinUser() {
        return cinUser;
    }

    public void setCinUser(int cinUser) {
        this.cinUser = cinUser;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public Participate(){

    }
    public Participate (int cinUser, int idEvent){
        this.cinUser=cinUser;
        this.idEvent=idEvent;
    }

    @Override
    public String toString() {
        return "cinUser=" + cinUser +
                ", idEvent=" + idEvent +
                '\n';
    }
}

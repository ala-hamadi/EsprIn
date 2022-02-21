package Modules;

public class Interest {

    private int IdOffer, cinInterested;


    public Interest(int IdOffer, int cinIntrested) {
        this.IdOffer = IdOffer;
        this.cinInterested = cinIntrested;

    }

    public int getIdOffer() {
        return IdOffer;
    }

    public void setIdOffer(int idOffer) {
        IdOffer = idOffer;
    }


    public int getCinInterested() {
        return cinInterested;
    }

    public void setCinInterested(int cinInterested) {
        this.cinInterested = cinInterested;
    }

    @Override
    public String toString() {
        return "Interest {" + "IdOffre=" + IdOffer + ",cinInterested=" + cinInterested + "\n";
    }

}

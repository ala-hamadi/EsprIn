package Modules.Users;

import Modules.Users.User;
import Utils.Enums.Roles;

public class Extern extends User {
    private String entrepriseName;
    private String adresse;

    public Extern(long cinUser, String email, String passwd, String imgUrl, Roles role,String entrepriseName,String adresse) {
        super(cinUser, email, passwd, imgUrl, role);
        this.adresse=adresse;
        this.entrepriseName=entrepriseName;
    }

    public String getEntrepriseName() {
        return entrepriseName;
    }

    public void setEntrepriseName(String entrepriseName) {
        this.entrepriseName = entrepriseName;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}

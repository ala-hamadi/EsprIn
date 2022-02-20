package Modules.Users;

import Utils.Enums.Domaine;
import Utils.Enums.Roles;

public class Professor extends Espritien {
    private Domaine domaine;

    public Professor(long cinUser, String email, String passwd, String imgUrl, Roles role, String firstName, String lastName,Domaine domaine) {
        super(cinUser, email, passwd, imgUrl, role, firstName, lastName);
        this.domaine=domaine;
    }

    public Domaine getDomaine() {
        return domaine;
    }

    public void setDomaine(Domaine domaine) {
        this.domaine = domaine;
    }

}

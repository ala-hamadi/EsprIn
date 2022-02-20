package Modules;

import Utils.Enums.Domaine;
import Utils.Enums.Roles;

public class Professor extends Espritien {
    private Domaine ProfDomaine;

    public Professor(long cinUser, String email, String passwd, String imgUrl, Roles role, String firstName, String lastName, Domaine ProfDomaine) {
        super(cinUser, email, passwd, imgUrl, role, firstName, lastName);
        this.ProfDomaine=ProfDomaine;
    }

    public Domaine getProfDomaine() { return ProfDomaine; }

    public void setProfDomaine(Domaine profDomaine) { ProfDomaine = profDomaine; }

    @Override
    public String toString() { return super.toString()+"ProfDomaine=" + ProfDomaine;}

}

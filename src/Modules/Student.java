package Modules;

import Utils.Enums.Domaine;
import Utils.Enums.Roles;
import Utils.Structure.Classe;

public class Student extends Espritien{
    private Classe classe;
    private Domaine domaine;

    public Student(long cinUser, String email, String passwd, String imgUrl, Roles role, String firstName, String lastName, Classe classe, Domaine domaine){
        super(cinUser,email,passwd,imgUrl,role,firstName,lastName);
        this.classe=classe;
        this.domaine=domaine;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Domaine getDomaine() {
        return domaine;
    }

    public void setDomaine(Domaine domaine) {
        this.domaine = domaine;
    }
}

package Modules;

import Utils.Enums.Roles;
import Utils.Enums.TypeClub;

public class Club extends Espritien{
    private TypeClub type;

    public Club(long cinUser, String email, String passwd, String imgUrl, Roles role, String firstName, String lastName, TypeClub type) {
        super(cinUser, email, passwd, imgUrl, role, firstName, lastName);
        this.type=type;
    }

    public TypeClub getType() {
        return type;
    }

    public void setType(TypeClub type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString()+ "type= " + type +
                '\n';
    }
}

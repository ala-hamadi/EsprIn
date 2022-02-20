package Modules.Users;

import Utils.Enums.Roles;
import Utils.Enums.TypeClub;

public class Club extends Espritien{
    private TypeClub typeClub;

    public Club(long cinUser, String email, String passwd, String imgUrl, Roles role, String firstName, String lastName,TypeClub typeClub) {
        super(cinUser, email, passwd, imgUrl, role, firstName, lastName);
        this.typeClub=typeClub;
    }

    public TypeClub getTypeClub() {
        return typeClub;
    }

    public void setTypeClub(TypeClub typeClub) {
        this.typeClub = typeClub;
    }
}

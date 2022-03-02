package Modules;

import Utils.Enums.Roles;

public class Espritien extends User {
    private String firstName;
    private String lastName;

    protected Espritien(long cinUser, String email, String passwd, String imgUrl, Roles role,String firstName,String lastName) {
        super(cinUser, email, passwd, imgUrl, role);
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return super.toString()+"firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '\n';
    }
}

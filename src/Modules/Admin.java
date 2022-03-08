package Modules;

import Utils.Enums.AdminDepartments;
import Utils.Enums.Roles;

public class Admin extends Espritien {
    private AdminDepartments department;


    public Admin(long cinUser, String email, String passwd, String imgUrl, Roles role, String firstName, String lastName,AdminDepartments department) {
        super(cinUser, email, passwd, imgUrl, role, firstName, lastName);
        this.department=department;
    }

    public AdminDepartments getDepartment() {
        return department;
    }

    public void setDepartment(AdminDepartments department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return super.toString()+"department=" + department +
                '\n';
    }
}

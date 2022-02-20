package Utils;

import Modules.Post;
import Modules.Users.Admin;
import Modules.Users.Student;
import Services.UserServices;
import Utils.Enums.AdminDepartments;
import Utils.Enums.Domaine;
import Utils.Enums.Roles;
import Utils.Structure.Classe;

import java.sql.Date;
import java.sql.Timestamp;

public class TestMain {
    public static void main(String[] args) {
        Admin admin = new Admin(44444444, "student.test@test.tn", "helloworld", "", Roles.Admin, "testname", "testlastame", AdminDepartments.Financier);
        Student student = new Student(55555555, "student.student@test.tn", "helloworld", null, Roles.Etudiant, "testname", "testlastame", new Classe(3,"A",25), Domaine.Business);
        UserServices service = UserServices.getInstance();
        service.login("bairem.khedhri@esprit.tn","bairem1111");
        CurrentUser currentUser=CurrentUser.getInstance();
        System.out.println(currentUser);
        service.disconnect();
        System.out.println(currentUser);
    }
}

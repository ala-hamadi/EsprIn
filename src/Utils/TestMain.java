package Utils;


import APIs.CaptchaGenerator;
import Modules.Admin;
import Utils.Enums.AdminDepartments;
import Utils.Enums.Roles;

public class TestMain {
    public static void main(String[] args) {
        System.out.println("bairem.khedhri@esprit.tn".matches("[a-z A-Z]+[/.][a-z]+(@esprit.tn)"));
        try {

            System.out.println(CaptchaGenerator.getCaptcha());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

    }
}

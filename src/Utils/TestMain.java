package Utils;


import APIs.Mailing;
import Modules.Admin;
import Modules.Espritien;
import Modules.Extern;
import Utils.Enums.AdminDepartments;
import Utils.Enums.Roles;

import java.util.Properties;

public class TestMain {
    public static void main(String[] args) {
        System.out.println("bairem.khedhri@esprit.tn".matches("[a-z A-Z]+[/.][a-z]+(@esprit.tn)"));
        try {
            Admin admin=new Admin(10020855
                    ,"bairem.khedhri@esprit.tn"
                    ,"password123"
                    ,""
                    , Roles.Admin
                    ,"bairem"
                    ,"khedhri"
                    , AdminDepartments.Examen);
            Mailing.sendMail("bairemkh@gmail.com",Mailing.generateText(admin),"Inscription");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

    }
}

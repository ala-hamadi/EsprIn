package Utils;

import Modules.Alert;
import Modules.Annoucement;
import Services.AlertServices;
import Services.AnnouncementService;
import Utils.Enums.Roles;
import Utils.Structure.Classe;

public class TestMain {
    public static void main(String[] args) {
        /*Admin admin=new Admin(22222211,"test.test@test.tn","helloworld","",Roles.Admin,"testname","testlastame",AdminDepartments.Service_éléve);
        UserServices service=UserServices.getInstance();
        System.out.println(service.getList());

        System.out.println("\n "+service.retrive(10020855));*/

        //AlertServices service=AlertServices.getInstance();
       // Classe destclass=new Classe(3,"A",25);
       // Alert alert1=new Alert(2,"emploitemps",destclass,10020855);
       // Alert alert2=new Alert(1,"mo5",destclass,11111111);
       //service.add(alert2);
       //service.delete(alert2);
        //service.update(alert2);
        //System.out.println(service.getList());
        //System.out.println(service.retrive(52));

        AnnouncementService service1=AnnouncementService.getInstance();

        Annoucement annoucement=new Annoucement(9,"Rappel 5lass","no 5lass no result",Roles.Etudiant,10020855);
        Annoucement annoucement1=new Annoucement(2,"aaaaaaaa","no 5lass no result",Roles.Club,10020855);
        //service1.add(annoucement);
        //service1.add(annoucement1);
        //service1.delete(annoucement);
        //service1.update(annoucement);
        //System.out.println(service1.getList());
        //System.out.println(service1.retrive(7));
    }
}

package Utils;

import Modules.*;
import services.*;
import Utils.Enums.*;
import Utils.Structure.Classe;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class TestMain {
    public static void main(String[] args) {

        OffreServices offreServices = null;
        try {
            offreServices = OffreServices.getInstance();
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        Offre offre = new Offre(1,"titre","desc",OffreCategorie.Alternance,10020855,State.Active,"img");
        Offre offre1 = new Offre(2,"titre1","description",OffreCategorie.Stage,10020855,State.Active,"image");
        Offre offre2 = new Offre(3,"titre2","descktop",OffreCategorie.Offre_De_Travail,10020855,State.Active,"http");
        Offre offre3 = new Offre(4,"titre3","desique dur",OffreCategorie.Stage,10020855,State.Active,"oh no oh no");
        Offre offre4 = new Offre(OffreCategorie.Stage,"titre55","des",10020855,"immmmmg");

        InterestServices interestServices = null;
        try {
            interestServices = InterestServices.getInstance();
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }

        Interest interest = new Interest(17,55555555);


        //offreServices.add(offre4);



       // System.out.println(forumService.sortForumByid(forumService.getList()));

       System.out.println(interestServices.getList());
        System.out.println(offreServices.getList());
        //System.out.println(offreServices.retrive(1));


        /*  ForumService forumService = ForumService.getInstance();
        ReactedForumServices reactedForumServices = ReactedForumServices.getInstance();
        Forum forum = new Forum(12,"test","un peu de texte ici",11111111, State.Active);
        System.out.println(forumService.getList().toString());;
        reactedForumServices.putLikeToPost(11111111,2);
        reactedForumServices.putUnLikeToPost(11111111,2);
        System.out.println(forumService.sortForumByid(forumService.getList()));
        AlertServices service=AlertServices.getInstance();
        Classe destclass=new Classe(3,"A",24);
        Alert alert1=new Alert(2,"emploitemps",destclass,10020855, Timestamp.valueOf(LocalDateTime.now()));
        Alert alert2=new Alert(6,"mo5",destclass,11111111, Timestamp.valueOf(LocalDateTime.now()));
        //service.add(alert2);
        //service.delete(alert2);
        //service.update(alert2);
        //System.out.println(service.getList());
        //System.out.println(service.retrive(4));
        //System.out.println(service.filterAlertByClass(destclass.toString(),service.getList()));
        // System.out.println(service.sortAlertByDate(service.getList()));
        // System.out.println(service.sortAlertById());
        AnnouncementService service1=AnnouncementService.getInstance();
        Annoucement annoucement=new Annoucement(9,"Rappel 5lass","no 5lass no result",Roles.Etudiant,10020855,Timestamp.valueOf(LocalDateTime.now()));
        Annoucement annoucement1=new Annoucement(2,"aaaaaaaa","no 5lass no result",Roles.Club,10020855,Timestamp.valueOf(LocalDateTime.now()));
        //service1.add(annoucement);
        service1.add(annoucement1);
        //service1.delete(annoucement);
        //service1.update(annoucement);
        //System.out.println(service1.getList());
        //System.out.println(service1.retrive(7));
        System.out.println(service1.filterAlertByDestination(Roles.Professeur,service1.getList()));
        System.out.println(service1.filterAlertBySubject("aaaaaaaa",service1.getList()));
        System.out.println(service1.sortAnnoucementById());
        System.out.println(service1.sortAnnoucementByDate(service1.getList()));
*/
        AlertProfServices service= null;
        try {
            service = AlertProfServices.getInstance();
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        Classe destclass=new Classe(3,"A",24);

        AlertProf alertProf1 =new AlertProf(2,"emploitemps",destclass,10020855, Timestamp.valueOf(LocalDateTime.now()));
        AlertProf alertProf2 =new AlertProf(6,"mo5",destclass,11111111, Timestamp.valueOf(LocalDateTime.now()));

        service.add(alertProf1);
        //service.delete(alert2);
        //service.update(alert2);
        System.out.println(service.getList());
        //System.out.println(service.retrive(4));
        //System.out.println(service.filterAlertByClass(destclass.toString(),service.getList()));
        // System.out.println(service.sortAlertByDate(service.getList()));
        // System.out.println(service.sortAlertById());

        AnnouncementService service1= null;
        try {
            service1 = AnnouncementService.getInstance();
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }

        Annoucement annoucement1=new Annoucement(2,"aaaaaaaa","no 5lass no result",AnnounceDestination.Clubs,10020855,Timestamp.valueOf(LocalDateTime.now()));
        //service1.add(annoucement);
        //service1.add(annoucement1);
        //service1.delete(annoucement);
        //service1.update(annoucement);
        //System.out.println(service1.getList());
        //System.out.println(service1.retrive(7));
        /*System.out.println(service1.filterAlertByDestination(Roles.Professeur,service1.getList()));
        System.out.println(service1.filterAlertBySubject("aaaaaaaa",service1.getList()));
        System.out.println(service1.sortAnnoucementById());*/
        System.out.println(service1.getList());
        try {
            UserServices userServices=UserServices.getInstance();
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }


    }
}

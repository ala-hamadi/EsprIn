package Utils;

import Modules.*;
import Services.*;
import Utils.Enums.*;
import Utils.Enums.Roles;
import Utils.Structure.Classe;

import java.util.List;

public class TestMain {
    public static void main(String[] args) {

        OffreServices offreServices = OffreServices.getInstance();
        Offre offre = new Offre(1,"titre","desc",OffreCategorie.Alternance,10020855,State.Active,"img");
        Offre offre1 = new Offre(2,"titre1","description",OffreCategorie.Stage,10020855,State.Active,"image");
        Offre offre2 = new Offre(3,"titre2","descktop",OffreCategorie.Offre_De_Travail,10020855,State.Active,"http");
        Offre offre3 = new Offre(4,"titre3","desique dur",OffreCategorie.Stage,10020855,State.Active,"oh no oh no");
        Offre offre4 = new Offre(OffreCategorie.Stage,"titre55","des",10020855,"immmmmg");

        InterestServices interestServices = InterestServices.getInstance();

        Interest interest = new Interest(17,55555555);


        //offreServices.add(offre4);



       // System.out.println(forumService.sortForumByid(forumService.getList()));

       System.out.println(offreServices.recherche_title_id_categorie("titre55",27,OffreCategorie.Stage));
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



    }
}

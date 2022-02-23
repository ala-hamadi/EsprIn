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

       System.out.println(offreServices.recherche_title_id("titre55",27,OffreCategorie.Stage));
        //System.out.println(offreServices.retrive(1));



    }
}

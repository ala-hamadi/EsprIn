package Utils;

import Modules.Extern;
import Modules.Interest;
import Modules.Offre;
import Services.InterestServices;
import Services.OffreServices;
import Utils.Enums.AdminDepartments;
import Utils.Enums.OffreCategorie;
import Utils.Enums.Roles;

import java.util.List;

public class TestMain {
    public static void main(String[] args) {


        OffreServices serviceOffre = OffreServices.getInstance();
        InterestServices serviceIntrest = InterestServices.getInstance();

        Interest interest = new Interest(1, 10020855);
        Interest interest2 = new Interest(1, 10020855);
        serviceIntrest.add(interest);
        serviceIntrest.add(interest2);
        Offre offre = new Offre("mohsen", "lll", OffreCategorie.Alternance, 10020855);
        serviceOffre.add(offre);
        List<Offre>offres=serviceOffre.getList();
        System.out.println(offres);
        Offre offre2=offres.get(0);
        offre2.setCategory(OffreCategorie.Offre_De_Travail);
        serviceOffre.update(offre2);
        serviceOffre.delete(offre2);
        System.out.println(serviceOffre.retrive(offre2.getIdOffer()));

    }
}

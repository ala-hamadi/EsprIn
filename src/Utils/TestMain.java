package Utils;

import Modules.Extern;
import Modules.Interest;
import Modules.Offre;
import Services.InterestServices;
import Services.OffreServices;
import Utils.Enums.AdminDepartments;
import Utils.Enums.OffreCategorie;
import Utils.Enums.Roles;
import Modules.Alert;
import Modules.Annoucement;
import Services.AlertServices;
import Services.AnnouncementService;
import Utils.Enums.Roles;
import Utils.Structure.Classe;

import java.util.List;

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



        Post post=new Post(3,"test post","wwwxxxx.",0,new Date(),"10000000", Categories.Covoiturage);
        LikePost likePost=new LikePost("10020855",3,new Date(2022,10,30));
        CommentPost commentPost=new CommentPost("10000000",4,"new comment",new Date());
        PostServices postServices=new PostServices();
        LikeServices likeServices=new LikeServices();
        CommentServices commentServices=new CommentServices();
        //System.out.println( postServices.addPost(post));
        //postServices.deletePost(2);
        List<Post>posts= postServices.getListPosts();

        posts.get(0).setContent("adb el slem");
        postServices.updatePost(posts.get(0));
        System.out.println(posts);
        //System.out.println(postServices.getPost(3));
        //postServices.deletePost(3);
        //System.out.println(postServices.filterPostByCategory("Covoiturage",postServices.getListPosts()));
        //System.out.println(postServices.sortPostByDate(postServices.getListPosts()));
         likeServices.putLikeToPost(10020855,5);
         likeServices.putLikeToPost(10000000,5);
         likeServices.putLikeToPost(15542230,5);

        System.out.println(posts);
        likeServices.putUnLikeToPost(10000000,5);
        System.out.println(posts);
postServices.deletePost(5);

        //likeServices.putUnLikeToPost(likePost);
        //System.out.println(likeServices.numberOfLikesByPost(4));;
        //commentServices.addCommentToPost(commentPost);
        //commentServices.deleteCommentByPost(commentPost);
       //System.out.println(commentServices.getListCommentByPost(4));

        services.ForumService forumService = services.ForumService.getInstance();
        services.RespondedService respondedService = services.RespondedService.getInstance();
        models.Forum forum = new models.Forum(1,"hi","ok ok ",11111111, State.Active);
        models.Responded responde = new models.Responded(11111111,1,"ok ok");
        //forum.setContent("salah");
        //forumService.add(forum);
        //forumService.update(forum);
        //forumService.delete(forum);
        //respondedService.add(responde);
        System.out.println(forumService.read().toString());
        responde.setContent("i dont no !");
        List<models.Responded> respondeds = respondedService.read();
        models.Responded res = respondeds.get(0);
        res.setContent("yes yes ! ");
        //respondedService.update(res);
        System.out.println(respondeds.toString());


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

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
    }
}

package Utils;

import java.util.Date;
import java.util.List;

import Modules.CommentPost;
import Modules.LikePost;
import Modules.Post;
import Services.CommentServices;
import Services.LikeServices;
import Services.PostServices;
import Utils.Enums.Categories;

public class TestMain {
    public static void main(String[] args) {
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

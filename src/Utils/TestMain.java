package Utils;

import Modules.*;
import Services.*;
import Utils.Enums.*;
import Utils.Enums.Roles;
import Utils.Structure.Classe;

import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        ForumService forumService = ForumService.getInstance();
        ReactedForumServices reactedForumServices = ReactedForumServices.getInstance();
        Forum forum = new Forum(12,"test","un peu de texte ici",11111111, State.Active);
        System.out.println(forumService.getList().toString());;
        reactedForumServices.putLikeToPost(11111111,2);
        reactedForumServices.putUnLikeToPost(11111111,2);

        System.out.println(forumService.sortForumByid(forumService.getList()));


    }
}

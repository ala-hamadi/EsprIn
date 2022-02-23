package Services;

import Modules.Espritien;
import Modules.Forum;
import Modules.Post;
import Modules.User;
import Utils.BdConnection;
import Utils.Enums.Roles;
import Utils.Enums.State;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ForumService implements IServices<Forum> {
    private Connection connection;
    public static  ForumService instance;

    private ForumService() {
        connection = BdConnection.getInstance().cnx;
    }
    public static ForumService getInstance (){
        if (instance == null)
            instance = new ForumService();

        return instance;
    }

    @Override
    public void add(Forum p) {
        try {
            String querry = "INSERT INTO `forum`(`title`, `content`, `idOwner`) VALUES ('" + p.getTitle() + "','" + p.getContent() + "','" + p.getIdOwner() + "')";
            Statement statement = connection.createStatement();

            statement.executeUpdate(querry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Forum> getList() {
        List<Forum> forums = new ArrayList();

        try {
            Statement stm = connection.createStatement();
            String querry = "SELECT * FROM `forum`";

            ResultSet rs = stm.executeQuery(querry);

            while (rs.next()) {
                Forum forum = new Forum();
                forum.setIdForum(rs.getInt(1));
                forum.setTitle(rs.getString("title"));
                forum.setContent(rs.getString(3));
                forum.setIdOwner(rs.getInt(4));


                forums.add(forum);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return forums;
    }

    @Override
    public boolean update(Forum p) {
        try {
            String querry = "UPDATE `forum` SET `title`='" + p.getTitle() + "',`content`='" + p.getContent() + "' WHERE `idForum`='" + p.getIdForum() + "'";
            Statement statement = connection.createStatement();

            statement.executeUpdate(querry);
            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(Forum p) {
        try {
            String querry = "UPDATE `forum` set `state`= '"+ State.Deleted +"' WHERE `state`='" + p.getIdForum() + "'";
            Statement statement = connection.createStatement();

            statement.executeUpdate(querry);
            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    public List<Forum> searchByTitle(String title) {
        return this.getList()
                    .stream()
                    .map(f -> (Forum) f)
                    .filter(f -> f.getTitle().contains(title))
                    .collect(Collectors.toList());
    }
    public List<Forum> sortForumByid(List<Forum> forums) {
        Collections.sort(forums, new Comparator<Forum>() {
            public int compare(Forum o1, Forum o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
        return forums;
    }
}

package Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import Modules.CommentPost;
import Modules.LikePost;
import Modules.Post;
import Utils.BdConnection;
import Utils.Enums.Categories;
import Utils.Enums.State;

public class PostServices implements IPostServices<Post> {

    private Connection connection;

    public PostServices() throws SQLException{
        BdConnection connect = BdConnection.getInstance();
        this.connection = connect.cnx;
    }


    @Override
    public boolean addPost(Post post) {
        try {
            Statement std = connection.createStatement();
            String query = "";
            query =
                    "INSERT INTO `post`( `content`, `mediaURL`, `createdAt`, `categorie`, `idOwer`) VALUES ('" + post.getContent() + "', '" + post.getMediaURL()
                            + "', current_timestamp(), '" + post.getCategories() + "', '" + post.getCreatedBy()
                            + "');";
            int x = std.executeUpdate(query);
            System.out.println(x + " Row inserted");
            return true;
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return false;
    }

    @Override
    public boolean deletePost(int idPost) {
        try {
            Statement statement = connection.createStatement();
            String query = "UPDATE `post` SET `state` = '" + State.Deleted + "' WHERE `post`.`idPost` = " + idPost + ";";
            int x = statement.executeUpdate(query);
            System.out.println(x + " Row updated to Deleted");
            String query2 = "DELETE FROM `like` WHERE `likePost` ="+idPost+"";
            statement.executeUpdate(query2);
            String query3 = "DELETE FROM `commented` WHERE `postCommented` ="+idPost+"";
            statement.executeUpdate(query3);
            if (x > 0)
                return true;
            else
                return false;
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return false;
    }

    @Override
    public boolean updatePost(Post post) {
        try {
            Statement statement = connection.createStatement();
            String query =
                    "UPDATE `post` SET `content` = '" + post.getContent() + "', `mediaURL` = '" + post.getMediaURL() + "' WHERE `post`.`idPost` = " + post
                            .getIdPost() + ";";
            int x = statement.executeUpdate(query);
            System.out.println(x + " Row updated");
            return true;
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return false;
    }

    @Override
    public List<Post> getListPosts() {
        List<Post> posts = new ArrayList<Post>();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM `post`";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                if (resultSet.getString("state").equals(State.Deleted.name())) {
                    Post post = new Post(resultSet.getInt("idPost"), resultSet.getString("content"), resultSet.getString("mediaURL"),
                            resultSet.getInt("likeNum"), resultSet.getDate("createdAt"), resultSet.getString("idOwer"),
                            Categories.valueOf(resultSet.getString("categorie")));
                    posts.add(post);
                }


            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return posts;
    }

    @Override
    public Post getPost(int idPost) {
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM `post` WHERE `idPost`=" + idPost + ";";
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();

            Post post = new Post(resultSet.getInt("idPost"), resultSet.getString("content"), resultSet.getString("mediaURL"),
                    resultSet.getInt("likeNum"), resultSet.getDate("createdAt"), resultSet.getString("createdBy"),
                    Categories.valueOf(resultSet.getString("categorie")));

            return post;

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }

    public List<Post> filterPostByCategory(String x, List<Post> posts) {
        return posts
                .stream()
                .filter(c -> c.getCategories().toString().equals(x))
                .collect(Collectors.toList());
    }

    public List<Post> sortPostByDate(List<Post> posts) {
        Collections.sort(posts, new Comparator<Post>() {
            public int compare(Post o1, Post o2) {
                return o1.getCreatedAt().compareTo(o2.getCreatedAt());
            }
        });
        return posts;
    }

    //todo


}

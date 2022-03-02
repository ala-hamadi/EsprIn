package Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Modules.CommentPost;
import Utils.BdConnection;

public class CommentServices implements ICommentServices<CommentPost> {
  private Connection connection;

  public CommentServices() throws SQLException{
    BdConnection connect = BdConnection.getInstance();
    this.connection = connect.cnx;
  }
  @Override
  public boolean addCommentToPost(CommentPost commentPost) {
    try {
      Statement std = connection.createStatement();
      String query = "";
      query =
          "INSERT INTO `commented`(`userWhoCommented`, `postCommented`, `content`,`createdAt`) VALUES ('" + commentPost.getIdUser() + "', '"
              + commentPost.getIdPost() + "', '" + commentPost.getContent() + "', current_timestamp());";
      int x = std.executeUpdate(query);
      System.out.println(x + " Row inserted");
      return true;

    } catch (SQLException exception) {
      System.out.println(exception.getMessage());
    }
    return false;
  }

  @Override
  public boolean deleteCommentByPost(CommentPost commentPost) {
    try {
      Statement statement = connection.createStatement();
      String query =
          "DELETE FROM `commented` WHERE `commented`.`postCommented` = " + commentPost.getIdPost() + " AND `liked post`.`userWhoCommented` = "
              + commentPost.getIdUser() + " AND `commented`.`createdAt` ='+"+commentPost.getCreatedAt()+"';";
      int x = statement.executeUpdate(query);
      System.out.println(x + " Row Deleted");
      return true;
    } catch (SQLException exception) {
      System.out.println(exception.getMessage());
    }
    return false;
  }

  @Override
  public boolean updateCommentByPost(CommentPost commentPost) {
    try {
      Statement statement = connection.createStatement();
      String query =
          "UPDATE `commented` SET `content` = '" + commentPost.getContent() + "' WHERE `commented`.`postCommented` = " + commentPost
              .getIdPost() + " AND `commented`.`userWhoCommented` = " + commentPost.getIdUser() + " AND `commented`.`createdAt` ='"+commentPost.getCreatedAt()+"';";
      int x = statement.executeUpdate(query);
      System.out.println(x + " Row updated");
      return true;
    } catch (SQLException exception) {
      System.out.println(exception.getMessage());
    }
    return false;
  }

  @Override
  public List<CommentPost> getListCommentByPost(long idPost) {
    List<CommentPost> commentPosts = new ArrayList<CommentPost>();
    try {
      Statement statement = connection.createStatement();
      String query = "SELECT * FROM `commented` WHERE `commented`.`postCommented`= " + idPost + ";";
      ResultSet resultSet = statement.executeQuery(query);
      while (resultSet.next()) {

        CommentPost commentPost = new CommentPost(resultSet.getString("userWhoCommented"), resultSet.getInt("postCommented"),
            resultSet.getString("content"), resultSet.getDate("createdAt"));
        commentPosts.add(commentPost);
      }
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
    return commentPosts;
  }
}

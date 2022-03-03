package services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Utils.BdConnection;
import model.LikePost;

public class LikeServices implements ILikeServices<LikePost> {

  private Connection connection;

  public LikeServices() {
    BdConnection connect = BdConnection.getInstance();
    this.connection = connect.cnx;
  }
  @Override
  public boolean putLikeToPost(int idUser,int postId) {
    try {
      Statement statement = connection.createStatement();
      String query1 =
          "INSERT INTO `like`(`likeUser`, `likePost`, `createdAt`) VALUES('" + idUser + "', '" + postId
               + "', current_timestamp());";
      int y = statement.executeUpdate(query1);
      System.out.println(y + " Like added");
      return true;

    } catch (SQLException exception) {
      System.out.println(exception.getMessage());
    }
    return false;
  }

  @Override
  public boolean putUnLikeToPost(int idUser,int postId) {
    try {
      Statement statement = connection.createStatement();

      String query1 =
          "DELETE FROM `like` WHERE `like`.`likePost` = " + postId + " AND `like`.`likeUser` = " + idUser
              + ";";
      int y = statement.executeUpdate(query1);
      System.out.println(y + " Like deleted");
      return true;
    } catch (SQLException exception) {
      System.out.println(exception.getMessage());
    }
    return false;
  }

  @Override
  public long numberOfLikesByPost(long idPost) {
    try {
      Statement statement = connection.createStatement();
      String query = "SELECT `post`.`likeNum` FROM `post` WHERE `idPost`=" + idPost + ";";
      ResultSet resultSet = statement.executeQuery(query);
      resultSet.next();

      return resultSet.getInt("likeNum");

    } catch (SQLException exception) {
      System.out.println(exception.getMessage());
    }
    return 0;
  }
}

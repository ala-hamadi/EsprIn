package Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Modules.LikePost;
import Utils.BdConnection;

public class LikeServices implements ILikeServices<LikePost>{

  private Connection connection;

  public LikeServices() throws SQLException {
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
      return false;
    }

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


  @Override
  public long likeExists(long idPost,long idUser) {
    try {
      Statement statement = connection.createStatement();
      String query = "SELECT `like`.`likePost` FROM `like` WHERE `likePost`=" + idPost + " AND `like`.`likeUser` = " + idUser
          + ";";
      ResultSet resultSet = statement.executeQuery(query);
      resultSet.next();

      return resultSet.getInt("likePost");

    } catch (SQLException exception) {
      System.out.println(exception.getMessage());
    }
    return 0;
  }
}

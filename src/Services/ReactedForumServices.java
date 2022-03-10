package Services;

import Modules.Forum;
import Utils.BdConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReactedForumServices implements ILikeServices<Forum> {
    private Connection connection;
    public static ReactedForumServices instance;

    private ReactedForumServices() throws SQLException {
        connection = BdConnection.getInstance().cnx;
    }

    public static ReactedForumServices getInstance() throws SQLException {
        if (instance == null)
            instance = new ReactedForumServices();

        return instance;
    }

    @Override
    public boolean putLikeToPost(int idUser, int idForum) {
        try {
            Statement statement = connection.createStatement();
            String query1 =
                    "INSERT INTO `reacted forum`(`idCreater`, `idForum`) VALUES('" + idUser + "', '" + idForum + "');";
            int y = statement.executeUpdate(query1);
            System.out.println(y + " Like added");
            return true;

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return false;
    }

    @Override
    public boolean putUnLikeToPost(int idUser, int idForum) {
        try {
            Statement statement = connection.createStatement();

            String query1 =
                    "DELETE FROM `reacted forum` WHERE `idCreater` = " + idUser + " AND `idForum` = " + idForum
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
    public long numberOfLikesByPost(long id) {
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT  `nbrLikesForum` FROM `forum` WHERE `idForum`=" + id + ";";
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();

            return resultSet.getInt("nbrLikesForum");

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return 0;
    }

    @Override
    public long likeExists(long id, long idUser) {
        try {
            Statement stm = connection.createStatement();
            String query = "SELECT * FROM `reacted forum` WHERE `idForum` = " + id + " AND `idCreater` = " + idUser
                    + ";";
            ResultSet resultSet = stm.executeQuery(query);
            resultSet.next();
            return resultSet.getInt("idForum");
        }catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
        return 0;
    }

}


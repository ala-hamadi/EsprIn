package services;

import Utils.BdConnection;
import model.Forum;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ReactedForumServices implements services.ILikeServices<Forum> {
    private Connection connection;
    public static  ReactedForumServices instance;

    private ReactedForumServices() {
        connection = BdConnection.getInstance().cnx;
    }
    public static ReactedForumServices getInstance (){
        if (instance == null)
            instance = new ReactedForumServices();

        return instance;
    }
    @Override
    public boolean putLikeToPost(int idUser, int idForum) {
        try {
            Statement statement = connection.createStatement();
            String query1 =
                    "INSERT INTO `reacted forum`(`cinUser`, `idForum`) VALUES('" + idUser + "', '" + idForum + "');";
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
                    "DELETE FROM `reacted forum` WHERE `cinUser` = " + idUser + " AND `idForum` = " + idForum
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
        return 0;
    }
}

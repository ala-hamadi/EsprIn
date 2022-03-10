package Services;


import Utils.BdConnection;
import Modules.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RespondedService implements IServices<Responded> {
    private Connection connection;
    public static RespondedService instance;

    private RespondedService() throws SQLException {
        connection = BdConnection.getInstance().cnx;
    }

    public static RespondedService getInstance () throws SQLException {
        if (instance == null)
            instance = new RespondedService();

        return instance;
    }
    @Override
    public void add(Responded p) {
        try {
            String querry="INSERT INTO `responded`(`cinUser`, `idForum`, `content`) VALUES ('"+p.getCinUser()+"','"+p.getIdForum()+"','"+p.getContent()+"')";
            Statement statement =connection.createStatement();

            statement.executeUpdate(querry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Responded> getList() {
        List<Responded> respondeds = new ArrayList();

        try {
            Statement stm = connection.createStatement();
            String querry = "SELECT * FROM `responded`";

            ResultSet rs = stm.executeQuery(querry);

            while (rs.next()) {
                Responded responded = new Responded();
                responded.setCinUser(rs.getInt(1));
                responded.setIdForum(rs.getInt(2));
                responded.setContent(rs.getString(3));
                responded.setCreatedAt(rs.getTimestamp(4));

                respondeds.add(responded);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return respondeds;
    }

    @Override
    public boolean update(Responded p) {

        try {
            String querry = "UPDATE `forum` SET `content`='" + p.getContent() + "' WHERE `cinUser`='" + p.getCinUser() + "' AND `idForum`='" + p.getIdForum() + "'AND `createdAt`='" + p.getCreatedAt()+ "'";
            Statement statement = connection.createStatement();

            statement.executeUpdate(querry);
            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(Responded p) {
        try {
            String querry = "DELETE FROM `responded` WHERE `idForum`='" + p.getIdForum() + "' AND `cinUser`='" + p.getCinUser() + "' AND `createdAt`='" + p.getCreatedAt()+ "'";
            Statement statement = connection.createStatement();

            statement.executeUpdate(querry);
            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}

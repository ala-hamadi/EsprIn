package Services;

import Modules.Interest;
import Modules.Offre;
import Utils.BdConnection;
import Utils.Structure.Classe;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InterestServices implements IServices<Interest> {

    private Connection connection;
    private static InterestServices instance;

    private InterestServices() throws SQLException {
        BdConnection connect = BdConnection.getInstance();
        this.connection = connect.cnx;
    }

    public static InterestServices getInstance() throws SQLException{
        if (instance == null)
            instance = new InterestServices();
        return instance;
    }


    @Override
    public void add(Interest interest) {

        try {
            String querry = "INSERT INTO `intrest`(`IdOffer`, `cinIntrested`) VALUES ('" + interest.getIdOffer() + "','" + interest.getCinInterested() + "')";
            Statement stm = connection.createStatement();
            stm.executeUpdate(querry);
            System.out.println("ajouté");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public boolean delete(Interest interest) {
        try {
            Statement statement = connection.createStatement();
            String query = "DELETE FROM `intrest` WHERE `intrest`.`IdOffer`=" + interest.getIdOffer() + ";";
            statement.executeUpdate(query);
            System.out.println("supprimé");

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }

        return false;
    }

    @Override
    public boolean update(Interest interest) {

      /*  try {
            Statement std = connection.createStatement();
            String query = "";
            query = "SELECT * FROM `intrest` WHERE `intrest`.`IdOffer`="+interest.getIdOffer()+";";
            ResultSet rs = std.executeQuery(query);
            query="UPDATE `intrest` SET `IdOffer`='"+interest.getIdOffer()+"',`cinIntrested `='"+interest.getCinInterested()+"' WHERE `interest`.`IdOffer`="+interest.getIdOffer()+";";
            std.executeUpdate(query);
            System.out.println("updated");


        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }*/
        return false;
    }

    @Override
    public List<Interest> getList() {

        List<Interest> alerts = new ArrayList<Interest>();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM `intrest`";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Interest interest = new Interest(rs.getInt("IdOffer"), rs.getInt("cinIntrested"));
                alerts.add(interest);
            }
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return alerts;


    }

    public Interest retrive(int i,long cinIntrested) {
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM `intrest` WHERE `IdOffer`=" + i + " AND `cinIntrested`='"+cinIntrested+"';";
            ResultSet rs = statement.executeQuery(query);
            rs.next();
            Interest interest = new Interest(rs.getInt("IdOffer"), rs.getInt("cinIntrested"));
            return interest;
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        System.out.println("n'existe pas");
        return null;
    }
}

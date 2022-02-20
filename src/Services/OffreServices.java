package Services;

import Modules.Offre;
import Utils.BdConnection;
import Utils.Enums.OffreCategorie;
import Utils.Enums.Roles;
import Utils.Enums.State;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OffreServices implements IServices<Offre> {


    private Connection connection;
    private static OffreServices instance;

    private OffreServices() {
        BdConnection connect = BdConnection.getInstance();
        this.connection = connect.cnx;
    }

    public static OffreServices getInstance() {
        if (instance == null)
            instance = new OffreServices();
        return instance;
    }

    @Override
    public void add(Offre offre) {
        try {
            String query = "INSERT INTO `offre`(`offerProvider`, `titleOffer`, `descOffer`, `catOffre`) VALUES ('" + offre.getOfferProvider() + "','" + offre.getTitleOffer() + "','" + offre.getDescOffer() + "','" + offre.getCategory() + "')";
            Statement stm = connection.createStatement();
            stm.executeUpdate(query);
            System.out.println("Added");


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }


    }


    @Override
    public boolean delete(Offre offre) {
        try {
            Statement statement = connection.createStatement();
            String query = "UPDATE `offre` SET `state`='" + State.Deleted + "' WHERE `offre`.`IdOffer`=" + offre.getIdOffer() + ";";
            int x=statement.executeUpdate(query);
            System.out.println(x+" row deleted");
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }

        return false;

    }


    @Override
    public boolean update(Offre offre) {


        try {
            Statement std = connection.createStatement();
            String query = "UPDATE `offre` SET `IdOffer`='" + offre.getIdOffer() + "',`titleOffer`='" + offre.getTitleOffer() + "',`descOffer`='" + offre.getDescOffer() + "',`offerProvider`='" + offre.getOfferProvider() + "',`catOffre`='" + offre.getCategory() + "' WHERE `offre`.`IdOffer`=" + offre.getIdOffer() + ";";
            int rows = std.executeUpdate(query);
            System.out.println(rows + " rows updated");
            if (rows == 0)
                return false;
            else
                return true;


        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }

        return false;


    }

    @Override
    public List<Offre> getList() {

        List<Offre> offres = new ArrayList<Offre>();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM `offre`  ";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                //rs.getInt("IdOffer"), rs.getString("titleOffer"), rs.getString("descOffer"), rs.getInt("offerProvider")
                Offre offre = new Offre(rs.getInt("IdOffer"), rs.getString("titleOffer"), rs.getString("descOffer"), OffreCategorie.valueOf(rs.getString("catOffre")), rs.getLong("offerProvider"),State.valueOf(rs.getString("state")));
                offres.add(offre);
            }
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return offres;
    }

    public Offre retrive(int i) {
        try {

            Statement statement = connection.createStatement();
            String query = "SELECT * FROM `offre` WHERE `IdOffer`=" + i + " ;";
            ResultSet rs = statement.executeQuery(query);
            rs.next();
            Offre offre = new Offre(rs.getInt("IdOffer"), rs.getString("titleOffer"), rs.getString("descOffer"), OffreCategorie.valueOf(rs.getString("catOffre")), rs.getLong("offerProvider"),State.valueOf(rs.getString("state")));
            return offre;

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        System.out.println("vide");
        return null;
    }
}

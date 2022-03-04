package services;

import Modules.Offre;
import Utils.BdConnection;
import Utils.Enums.OffreCategorie;
import Utils.Enums.State;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class OffreServices implements IServices<Offre> {


    private Connection connection;
    private static OffreServices instance;

    private OffreServices() throws SQLException{
        BdConnection connect = BdConnection.getInstance();
        this.connection = connect.cnx;
    }

    public static OffreServices getInstance() throws SQLException{
        if (instance == null)
            instance = new OffreServices();
        return instance;
    }

    @Override
    public void add(Offre offre) {
        try {
            String query = "INSERT INTO `offre`(`offerProvider`, `titleOffer`, `descOffer`, `catOffre`, `imgOffre`) VALUES ('" + offre.getOfferProvider() + "','" + offre.getTitleOffer() + "','" + offre.getDescOffer() + "','" + offre.getCategory() + "', '"+ offre.getImgOffre() +"')";
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
            int x = statement.executeUpdate(query);
            System.out.println(x + " row deleted");
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }

        return false;

    }


    @Override
    public boolean update(Offre offre) {


        try {
            Statement std = connection.createStatement();
            String query = "UPDATE `offre` SET `IdOffer`='" + offre.getIdOffer() + "',`titleOffer`='" + offre.getTitleOffer() + "',`descOffer`='" + offre.getDescOffer() + "',`offerProvider`='" + offre.getOfferProvider() + "',`catOffre`='" + offre.getCategory() + "', `imgOffre`='" + offre.getImgOffre() + "' WHERE `offre`.`IdOffer`=" + offre.getIdOffer() + " AND `state`='" + State.Active + "' ;";
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
            String query = "SELECT * FROM `offre` WHERE `state`='" + State.Active + "'  ";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                //rs.getInt("IdOffer"), rs.getString("titleOffer"), rs.getString("descOffer"), rs.getInt("offerProvider")
                Offre offre = new Offre(rs.getInt("IdOffer"), rs.getString("titleOffer"), rs.getString("descOffer"), OffreCategorie.valueOf(rs.getString("catOffre")), rs.getLong("offerProvider"), State.valueOf(rs.getString("state")), rs.getString("imgOffre"));
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
            String query = "SELECT * FROM `offre` WHERE `IdOffer`=" + i + " AND `state`='" + State.Active + "' ;";
            ResultSet rs = statement.executeQuery(query);
            rs.next();
            Offre offre = new Offre(rs.getInt("IdOffer"), rs.getString("titleOffer"), rs.getString("descOffer"), OffreCategorie.valueOf(rs.getString("catOffre")), rs.getLong("offerProvider"), State.valueOf(rs.getString("state")), rs.getString("imgOffre"));
            return offre;

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        System.out.println("vide");
        return null;
    }

    public List<Offre> sort_categorie() {
        return this.getList().stream().sorted((o1, o2) -> String.valueOf(o1.getCategory())
                .compareTo(String.valueOf(o2.getDescOffer()))).collect(Collectors.toList());
    }

    public List<Offre> sort_titre() {
        return this.getList().stream().sorted((o1, o2) -> String.valueOf(o1.getTitleOffer())
                .compareTo(String.valueOf(o2.getTitleOffer()))).collect(Collectors.toList());
    }


    public List<Offre> recherche_title_id_categorie(String title, int id, OffreCategorie cat) {
       return this.getList()
                .stream()
                .filter(o -> Objects.equals(o.getTitleOffer(), title))
                .filter(o -> Objects.equals(o.getIdOffer(), id))
               .filter(o -> Objects.equals(o.getCategory(), cat))
               .collect(Collectors.toList());

    }

    public List<Offre> recherche_title(String title) {
        return this.getList()
                .stream()
                .filter(o -> Objects.equals(o.getTitleOffer(), title))
                .collect(Collectors.toList());

    }

    public List<Offre> recherche(String stage, int i, OffreCategorie cat) {
        return this.getList()
                .stream()
                .filter(o -> Objects.equals(o.getCategory(), cat))
                .collect(Collectors.toList());

    }
}
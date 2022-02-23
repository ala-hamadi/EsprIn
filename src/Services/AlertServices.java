package Services;

import Modules.Alert;
import Utils.BdConnection;
import Utils.Enums.Roles;
import Utils.Enums.State;
import Utils.Structure.Classe;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlertServices implements IServices<Alert>{
    private Connection connection;
    private static AlertServices instance;

    private AlertServices() {
        BdConnection connect = BdConnection.getInstance();
        this.connection= connect.cnx;
    }
    public static AlertServices getInstance(){
        if (instance==null)
            instance=new AlertServices();
        return instance;
    }

    @Override
    public void add(Alert alert) {
        try {
            Statement std = connection.createStatement();
            String query = "";
            query = "SELECT * FROM `user` WHERE `user`.`cinUser`=" + alert.getIdSender() + ";";
            ResultSet rs = std.executeQuery(query);

            rs.next();
                switch (Roles.valueOf(rs.getString("role"))) {
                    case Professeur:
                        query = "INSERT INTO `alert`(`content`, `destClass`, `idSender`, `state`) VALUES ('" + alert.getContentAlert() + "','" + alert.getDestClass() + "','" + alert.getIdSender() + "','" + alert.getState() + "');";
                        int x = std.executeUpdate(query);
                        System.out.println(x + "row inserted");
                        break;
                    default:
                        System.out.println("mahouch prof ya haj");
                }


        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public boolean delete(Alert alert) {
        try {
            Statement std = connection.createStatement();
            String query = "";
            query = "SELECT * FROM `user` WHERE `user`.`cinUser`=" + alert.getIdSender() + ";";
            ResultSet rs = std.executeQuery(query);

            while (rs.next()) {
                switch (Roles.valueOf(rs.getString("role"))) {
                    case Professeur:
                        query = "UPDATE alert SET state = '" + State.Deleted+ "' WHERE `alert`.`idAlert`="+alert.getIdAlert()+ ";";
                        int x = std.executeUpdate(query);
                        System.out.println(x + "row deleted");
                        return true;

                    default:
                        System.out.println("mahouch prof ya haj");

                }


            }
        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        return false;

    }
   /* public void changeState(Alert alert, State state){
        try {
            Statement statement = connection.createStatement();
            String query = "UPDATE alert SET state = '" + state+ "' WHERE user.cinUser = " + user.getCinUser() + ";";
            statement.executeUpdate(query);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }*/
//Roles.valueOf(rs.getString("role"))
    @Override
    public boolean update(Alert alert) {
        try {
            Statement std = connection.createStatement();
            String query = "";
            query = "SELECT * FROM `alert` WHERE `alert`.`idAlert`=" + alert.getIdAlert() + ";";
            ResultSet resultSet= std.executeQuery(query);
            resultSet.next();
            if (State.valueOf(resultSet.getString("state"))==State.Deleted){
                System.out.println("u cannot updated a deleted row");
                return false;
            }else {
                query = "SELECT * FROM `user` WHERE `user`.`cinUser`=" + alert.getIdSender() + ";";
                ResultSet rs = std.executeQuery(query);

                while (rs.next()) {
                    switch (rs.getString("role").toLowerCase()) {
                        case "professeur":
                            query = "UPDATE `alert` SET `idAlert`='" + alert.getIdAlert() + "',`content`='" + alert.getContentAlert() + "',`destClass`='" + alert.getDestClass() + "',`idSender`='" + alert.getIdSender() + "' WHERE `alert`.`idAlert`=" + alert.getIdAlert() + ";";
                            int x = std.executeUpdate(query);
                            System.out.println(x + "row updated");
                            return true;

                        default:
                            System.out.println("mahouch prof ya haj");

                    }


                }
            }
        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }

        return false;
    }

    @Override
    public List<Alert> getList() {
        List<Alert>alerts=new ArrayList<Alert>();
        try {
            Statement statement=connection.createStatement();
            String query="SELECT * FROM `alert` WHERE `alert`.`state` <> 'Deleted' ;";
            ResultSet rs=statement.executeQuery(query);
            while (rs.next()){
                String[] classe=rs.getString("destClass").split(" ");
                Alert alert=new Alert(rs.getInt("idAlert"),rs.getString("content"),new Classe(Integer.parseInt(classe[0]),classe[1],Integer.parseInt(classe[2])),rs.getInt("idSender"));
                alerts.add(alert);
            }
        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        return alerts;
    }


    public Alert retrive(long i) {
       try {
           Statement statement=connection.createStatement();
           String query="";
           query = "SELECT * FROM `alert` WHERE `alert`.`idAlert`=" + i + ";";
           ResultSet resultSet= statement.executeQuery(query);
           resultSet.next();
           if (State.valueOf(resultSet.getString("state"))==State.Deleted){
               System.out.println("u cannot show a deleted row");
               return null;

           }else {
               ResultSet rs = statement.executeQuery(query);
               rs.next();
               String[] classe = rs.getString("destClass").split(" ");
               Alert alert = new Alert(rs.getInt("idAlert"), rs.getString("content"), new Classe(Integer.parseInt(classe[0]), classe[1], Integer.parseInt(classe[2])), rs.getInt("idSender"));
               return alert;
           }
       }catch (SQLException exception){
           System.out.println(exception.getMessage());
       }
        System.out.println("mouch mawjoud");
       return null;
    }
}

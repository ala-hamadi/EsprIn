package Services;

import Modules.AlertProf;
import Utils.BdConnection;
import Utils.Enums.Roles;
import Utils.Enums.State;
import Utils.Structure.Classe;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AlertProfServices implements IServices<AlertProf> {
    private Connection connection;
    private static AlertProfServices instance;

    private AlertProfServices() throws SQLException {
        BdConnection connect = BdConnection.getInstance();
        this.connection= connect.cnx;
    }
    public static AlertProfServices getInstance() throws SQLException{
        if (instance==null)
            instance=new AlertProfServices();
        return instance;
    }

    @Override
    public void add(AlertProf alertProf) {
        try {
            Statement std = connection.createStatement();
            String query = "";
            query = "SELECT * FROM `user` WHERE `user`.`cinUser`=" + alertProf.getIdSender() + ";";
            ResultSet rs = std.executeQuery(query);

            rs.next();
            switch (Roles.valueOf(rs.getString("role"))) {
                case Professeur:
                    query = "INSERT INTO `alert`(`alertTitle`, `content`, `destClass`, `idSender`, createdAt) VALUES ('" + alertProf.getTitle() + "','" + alertProf.getContentAlert() + "','" + alertProf.getDestClass() + "','" + alertProf.getIdSender() + "','" + alertProf.getCreatedAt() + "');";
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
    public boolean delete(AlertProf alertProf) {
        try {
            Statement std = connection.createStatement();
            String query = "";
            query = "SELECT * FROM `user` WHERE `user`.`cinUser`=" + alertProf.getIdSender() + ";";
            ResultSet rs = std.executeQuery(query);

            while (rs.next()) {
                switch (Roles.valueOf(rs.getString("role"))) {
                    case Professeur:
                        query = "UPDATE alert SET state = '" + State.Deleted+ "' WHERE `alert`.`idAlert`="+ alertProf.getIdAlert()+ ";";
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
    public boolean update(AlertProf alertProf) {
        try {
            Statement std = connection.createStatement();
            String query = "";
            query = "SELECT * FROM `alert` WHERE `alert`.`idAlert`=" + alertProf.getIdAlert() + ";";
            ResultSet resultSet= std.executeQuery(query);
            resultSet.next();
            if (State.valueOf(resultSet.getString("state"))==State.Deleted){
                System.out.println("u cannot updated a deleted row");
                return false;
            }else {
                query = "SELECT * FROM `user` WHERE `user`.`cinUser`=" + alertProf.getIdSender() + ";";
                ResultSet rs = std.executeQuery(query);

                while (rs.next()) {
                    switch (rs.getString("role").toLowerCase()) {
                        case "professeur":
                            query = "UPDATE `alert` SET `content`='" + alertProf.getContentAlert() + "',`destClass`='" + alertProf.getDestClass() +  "' WHERE `alert`.`idAlert`=" + alertProf.getIdAlert() + ";";
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
    public List<AlertProf> getList() {
        List<AlertProf> alertProfs =new ArrayList<AlertProf>();
        try {
            Statement statement=connection.createStatement();
            String query="SELECT * FROM `alert` WHERE `alert`.`state` <> 'Deleted' ;";
            ResultSet rs=statement.executeQuery(query);
            while (rs.next()){
                String[] classe=rs.getString("destClass").split(" ");
                AlertProf alertProf =new AlertProf(rs.getInt("idAlert"),rs.getString("alertTitle"),rs.getString("content"),new Classe(Integer.parseInt(classe[0]),classe[1],Integer.parseInt(classe[2])),rs.getInt("idSender"),rs.getDate("createdAt"));
                alertProfs.add(alertProf);
            }
        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        return alertProfs;
    }


    public AlertProf retrive(long i) {
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
                AlertProf alertProf = new AlertProf(rs.getInt("idAlert"),rs.getString("alertTitle"), rs.getString("content"), new Classe(Integer.parseInt(classe[0]), classe[1], Integer.parseInt(classe[2])), rs.getInt("idSender"),rs.getDate("createdAt"));
                return alertProf;
            }
        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        System.out.println("mouch mawjoud");
        return null;
    }
    public List<AlertProf> filterAlertByClass(String classeid, List<AlertProf> alertProfs){
        return alertProfs.stream()
                .filter(comparator -> comparator.getDestClass().toString().equals(classeid))
                .collect(Collectors.toList());
    }

    public List<AlertProf> sortAlertById() {
        return this.getList().stream().sorted((o1, o2) -> String.valueOf(o1.getIdAlert())
                .compareTo(String.valueOf(o1.getIdAlert()))).collect(Collectors.toList());
    }
    public List<AlertProf> sortAlertByDate(List<AlertProf> alertProfs){
        Collections.sort(alertProfs, new Comparator<AlertProf>() {
            public int compare(AlertProf o1, AlertProf o2) {
                return o1.getCreatedAt().compareTo(o2.getCreatedAt());
            }
        });
        return alertProfs;
    }

}


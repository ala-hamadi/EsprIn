package Services;

import Modules.Espritien;
import Modules.Event;
import Modules.Participate;
import Utils.BdConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParticipateServices{
    private Connection connection;
    private static ParticipateServices instance;

    private ParticipateServices() throws SQLException{
        BdConnection connect = BdConnection.getInstance();
        this.connection = connect.cnx;
    }

    public static ParticipateServices getInstance() throws SQLException{
        if (instance == null)
            instance = new ParticipateServices();
        return instance;
    }


    public void Participate(Espritien espritien, Event event) {
        try {
            Statement statement = connection.createStatement();
            String query = "INSERT INTO `participate` (`cinUser` ,`idEvent` ) VALUES( '"
                    + espritien.getCinUser() + "' , '"
                    + event.getIdEvent() + "');";

            int x = statement.executeUpdate(query);
            System.out.println(x + " Row inserted");
            statement = connection.createStatement();
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
            System.out.println("Errooor! insertion de participant");
        }
    }


    public boolean delete(Participate participate) {
        try {
            Statement statement = connection.createStatement();
            String query = "DELETE FROM `participate` WHERE `participate`.`cinUser` = " + participate.getCinUser() + ";";

            int x = statement.executeUpdate(query);
            System.out.println(x + " Row Deleted");
            return true;

        } catch (SQLException exception) {
            exception.printStackTrace();
            System.out.println(exception.getMessage());
        }


        return false;
    }


    public List<Participate> getList() {
        List<Participate> participates = new ArrayList<Participate>();
        try {
            Statement statement = connection.createStatement();

            String query = "SELECT * FROM `participate`";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Participate participate = new Participate(resultSet.getInt("cinUser"), resultSet.getInt("idEvent"));
                participates.add(participate);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            System.out.println(exception.getMessage());
            System.out.println("Errooor! getlist de participate");
        }
        return participates;
    }


    public List<Participate> sortByCin(){
        return this.getList().stream()
                .sorted((o1,o2) -> String.valueOf(o1.getCinUser())
                        .compareTo(String.valueOf(o2.getCinUser())))
                .collect(Collectors.toList());
    }

    public List<Participate> filterParticipateByEventId(int eventId){
        return this.getList().stream()
                .filter(comparator -> comparator.getIdEvent()==eventId)
                .collect(Collectors.toList());
    }


}

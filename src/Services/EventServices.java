package Services;

import Modules.Event;
import Utils.BdConnection;
import Utils.Enums.State;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventServices implements IServices<Event> {
    private Connection connection;
    private static EventServices instance;

    private EventServices() {
        BdConnection connect = BdConnection.getInstance();
        this.connection = connect.cnx;
    }

    public static EventServices getInstance() {
        if (instance == null)
            instance = new EventServices();
        return instance;
    }

    @Override
    public void add(Event event) {
        try {PreparedStatement statement = connection.prepareStatement("INSERT INTO `event`(`titleEvent`, `contentEvent`, `imgURL`, `eventDate`, `idOrganizer`) VALUES (?,?,?,? ,?)");
            statement.setString(1, event.getTitleEvent());
            statement.setString(2, event.getDescription());
            statement.setString(3, event.getImgURL());
            statement.setTimestamp(4, event.getDateEvent());
            statement.setLong(5, event.getIdOrganizer());


            int x = statement.executeUpdate();
            System.out.println(x + " Row inserted");
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
            System.out.println("Errooor! insertion d'evenement ");
        }
    }

    @Override
    public boolean delete(Event event) {
        try {
            Statement statement = connection.createStatement();
            String query = "UPDATE `event` SET `state` = '" + State.Deleted + "' WHERE `event`.`idEvent` ='" + event.getIdEvent() + "';";
            int x = statement.executeUpdate(query);
            System.out.println(x + " Row Deleted");
            if (x > 0)
                return true;
            else
                return false;

        } catch (SQLException exception) {
            exception.printStackTrace();
            System.out.println(exception.getMessage());

        }
        return false;
    }

    public void changeState(Event event, State state) {
        try {
            Statement statement = connection.createStatement();
            String query = "UPDATE `event` SET `state` = '" + state + "' WHERE `event`.`idEvent` ='" + event.getIdEvent() + "';";
            statement.executeUpdate(query);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public boolean update(Event event) {
        try {
            Statement statement = connection.createStatement();
            String query = "UPDATE `event` SET `titleEvent` = '" + event.getTitleEvent() + "', `contentEvent` = '" + event.getDescription() + "', `imgURL` = '" + event.getImgURL() + "', `eventDate` = '" + event.getDateEvent()
                    + "' WHERE `idEvent` = '" + event.getIdEvent() + "';";
            int x = statement.executeUpdate(query);
            System.out.println(x + " Row updated");
            return true;

        } catch (SQLException exception) {
            exception.printStackTrace();
            System.out.println(exception.getMessage());
        }
        return false;
    }

    @Override
    public List<Event> getList() {
        List<Event> events = new ArrayList<Event>();
        try {
            Statement statement = connection.createStatement();

            String query = "SELECT * FROM `event`";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Event event = new Event(resultSet.getInt("idEvent"), resultSet.getString("titleEvent"), resultSet.getString("contentEvent"), resultSet.getString("imgURL"), resultSet.getTimestamp("eventDate"), resultSet.getLong("idOrganizer"), State.valueOf(resultSet.getString("state")));
                events.add(event);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            System.out.println(exception.getMessage());
            System.out.println("Errooor! getlist");
        }
        return events;
    }


    public Event retrive(String i) {
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM `event` WHERE `idEvent`=" + i + ";";
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            Event event = new Event(resultSet.getInt("idEvent"), resultSet.getString("titleEvent"), resultSet.getString("contentEvent"), resultSet.getString("imgURL"), resultSet.getTimestamp("eventDate"), resultSet.getLong("idOrganizer"), State.valueOf(resultSet.getString("state")));
            return event;
        } catch (SQLException exception) {
            exception.printStackTrace();
            System.out.println(exception.getMessage());
        }
        return null;
    }

}






















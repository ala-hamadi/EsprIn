package Services;

import Modules.Annoucement;
import Utils.BdConnection;
import Utils.Enums.AnnounceDestination;
import Utils.Enums.Roles;
import Utils.Enums.State;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class AnnouncementService implements IServices<Annoucement> {
    private Connection connection;
    private static AnnouncementService instance;

    public AnnouncementService() throws SQLException{
        BdConnection connect=BdConnection.getInstance();
        this.connection=connect.cnx;
    }
    public static AnnouncementService getInstance() throws SQLException{
        if(instance==null)
            instance=new AnnouncementService();
        return instance;
    }

    @Override
    public void add(Annoucement annoucement) {
        try {
            Statement std=connection.createStatement();
            String query="";
            query = "SELECT * FROM `user` WHERE `user`.`cinUser`=" + annoucement.getIdSender() + ";";
            ResultSet rs=std.executeQuery(query);
            rs.next();
            Roles role=Roles.valueOf(rs.getString("role"));
            if(role==Roles.Admin){
                query="INSERT INTO `annoncement`(`subject`, `content`, `destination`, `idSender`) VALUES ('"+annoucement.getSubjectAnn()+"','"+annoucement.getContentAnn()+"','"+annoucement.getDestAnn()+"','"+annoucement.getIdSender()+"');";
                int x= std.executeUpdate(query);
                System.out.println(x+"row inserted");
            }
        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public boolean delete(Annoucement annoucement) {
        try {
            Statement std=connection.createStatement();
            String query = "UPDATE `annoncement` SET `state` = '"+State.Deleted+"' WHERE `annoncement`.`idAnn` = "+annoucement.getIdAnn()+";";
            int x=std.executeUpdate(query);
            System.out.println(x+" rows deleted");

            return  true;

        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Annoucement annoucement) {
        try{
            Statement std=connection.createStatement();
            String query="";
            query = "SELECT * FROM `annoncement` WHERE `annoncement`.`idAnn`=" + annoucement.getIdAnn() + ";";
            ResultSet resultSet= std.executeQuery(query);
            resultSet.next();
            if (State.valueOf(resultSet.getString("state"))==State.Deleted){
                System.out.println("u cannot update a deleted row");
                return false;
            }else {
                query = "SELECT * FROM `user` WHERE `user`.`cinUser`=" + annoucement.getIdSender() + ";";
                ResultSet rs = std.executeQuery(query);

                while (rs.next()) {
                    switch (Roles.valueOf(rs.getString("role"))) {
                        case Admin:
                            query = "UPDATE `annoncement` SET `subject`='" + annoucement.getSubjectAnn() + "',`content`='" + annoucement.getContentAnn() + "',`destination`='" + annoucement.getDestAnn() + "' WHERE `annoncement`.`idAnn`=" + annoucement.getIdAnn() + ";";
                            int x = std.executeUpdate(query);
                            System.out.println(x + "row updated");
                            return true;

                        default:
                            System.out.println("mahouch admin ya haj");

                    }


                }
            }

        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        return false;

    }

    @Override
    public List<Annoucement> getList() {
        List<Annoucement>annoucements=new ArrayList<Annoucement>();
        try {
            Statement statement=connection.createStatement();
            String query="SELECT * FROM `annoncement`WHERE `annoncement`.`state` <> 'Deleted' ;";
            ResultSet rs=statement.executeQuery(query);
            while (rs.next()){
                Annoucement annoucement=new Annoucement(rs.getInt("idAnn"),rs.getString("subject"),rs.getString("content"), AnnounceDestination.valueOf(rs.getString("destination")),rs.getInt("idSender"),rs.getDate("createdAt"));
                annoucements.add(annoucement);
            }
        }catch(SQLException exception){
            System.out.println(exception.getMessage());
        }
        return annoucements;
    }


    public Annoucement retrive(long i) {
        try {
            Statement statement= connection.createStatement();
            String query="SELECT * FROM `annoncement` WHERE `idAnn`="+i+";";
            ResultSet rs=statement.executeQuery(query);
            rs.next();
            if (State.valueOf((rs.getString("state")))==State.Deleted){
                System.out.println("announce already deleted");
                return null;
            }else{


                Annoucement annoucement=new Annoucement(rs.getInt("idAnn"),rs.getString("subject"),rs.getString("content"),AnnounceDestination.valueOf(rs.getString("destination")),rs.getInt("idSender"),rs.getDate("createdAt"));
                return annoucement;
            }
        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        System.out.println("mouch mawjoud");
        return null;
    }



    public List<Annoucement> filterAlertBySubject(String subjectAnn, List<Annoucement> annoucements){
        return annoucements.stream()
            .filter(comparator -> comparator.getSubjectAnn().startsWith(subjectAnn))
            .collect(Collectors.toList());
    }
    public List<Annoucement> filterAlertByDestination(Roles role, List<Annoucement> annoucements){
        return annoucements.stream()
            .filter(comparator -> comparator.getDestAnn().toString().equals(role.toString()))
            .collect(Collectors.toList());
    }

    public List<Annoucement> sortAnnoucementById() {
        return this.getList().stream().sorted((o1, o2) -> String.valueOf(o2.getIdAnn())
            .compareTo(String.valueOf(o1.getIdAnn()))).collect(Collectors.toList());
    }
    public List<Annoucement>sortAnnoucementByDate(List<Annoucement>annoucements){
        Collections.sort(annoucements, new Comparator<Annoucement>() {
            @Override
            public int compare(Annoucement o1, Annoucement o2) {
                return o1.getCreatedAt().compareTo(o2.getCreatedAt());
            }
        });
        return annoucements;
    }

}

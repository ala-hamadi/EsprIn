package Controllers.AnnounceUser;

import Modules.AlertProf;
import Modules.Annoucement;
import Services.AlertProfServices;
import Services.AnnouncementService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AnnounceMenuController implements Initializable {



    @FXML
    private ListView<Node>  announceListView;
    @FXML
    private ListView<Node> alertListView;

    private List<AlertProf> alertProfList;
    private List<Annoucement> annoucementList;

    public AnnounceMenuController() {
        AnnouncementService announcementService= null;
        AlertProfServices alertProfServices=null;
        try {
            announcementService = new AnnouncementService();
            alertProfServices=new AlertProfServices();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        annoucementList = new ArrayList<Annoucement>();
        alertProfList=new ArrayList<AlertProf>();
        //annoucementList.add(new Annoucement(9,"Rappel 5lass","no 5lass no result", Roles.Etudiant,10020855, Timestamp.valueOf(LocalDateTime.now())));
        //annoucementList.add(new Annoucement(10,"Rappel 5lass","no 5lass no result",Roles.Etudiant,10020855,Timestamp.valueOf(LocalDateTime.now())));
        //annoucementList.add(new Annoucement(11,"Rappel 5lass","no 5lass no result",Roles.Etudiant,10020855,Timestamp.valueOf(LocalDateTime.now())));
        annoucementList=announcementService.getList();
        alertProfList=alertProfServices.getList();
        announceListView = new ListView<>();
        alertListView=new ListView<>();

       

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            int i=0;
            int j=0;

            while (i< annoucementList.size()||i< alertProfList.size()){
                if (i< annoucementList.size()) {
                    FXMLLoader fxmlLoader1 = new FXMLLoader();
                    fxmlLoader1.setLocation(getClass().getResource("/Views/Templates/AnnounceCell.fxml"));
                    AnchorPane anchorPane1 = fxmlLoader1.load();
                    AnnounceListViewCell itemController1 = fxmlLoader1.getController();
                    itemController1.setData(annoucementList.get(i));
                    announceListView.getItems().add(anchorPane1);
                    i++;
                }
                if (i< alertProfList.size()) {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("/Views/Templates/AlertCell.fxml"));
                    AnchorPane anchorPane = fxmlLoader.load();
                    AlertListViewCell itemController = fxmlLoader.getController();
                    itemController.setData(alertProfList.get(i));
                    announceListView.getItems().add(anchorPane);
                    j++;
                }
            }
            /*for (int i = 0; i< annoucementList.size(); i++ ){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/Views/Templates/AnnounceCell.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                AnnounceListViewCell itemController = fxmlLoader.getController();
                itemController.setData(annoucementList.get(i));
                announceListView.getItems().add(anchorPane);

            }
           for (int i = 0; i< alertProfList.size(); i++ ){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/Views/Templates/AlertCell.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                AlertListViewCell itemController = fxmlLoader.getController();
                itemController.setData(alertProfList.get(i));
                announceListView.getItems().add(anchorPane);

            }*/

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }



}

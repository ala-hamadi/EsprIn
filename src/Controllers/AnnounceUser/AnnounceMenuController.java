package Controllers.AnnounceUser;

import Modules.Annoucement;
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
    private ListView<Node>  eventListView;
    private List<Annoucement> annoucementList;

    public AnnounceMenuController() {
        AnnouncementService announcementService= null;
        try {
            announcementService = new AnnouncementService();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        annoucementList = new ArrayList<Annoucement>();
        //annoucementList.add(new Annoucement(9,"Rappel 5lass","no 5lass no result", Roles.Etudiant,10020855, Timestamp.valueOf(LocalDateTime.now())));
        //annoucementList.add(new Annoucement(10,"Rappel 5lass","no 5lass no result",Roles.Etudiant,10020855,Timestamp.valueOf(LocalDateTime.now())));
        //annoucementList.add(new Annoucement(11,"Rappel 5lass","no 5lass no result",Roles.Etudiant,10020855,Timestamp.valueOf(LocalDateTime.now())));
        annoucementList=announcementService.getList();
       eventListView = new ListView<>();
       

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            for (int i = 0; i< annoucementList.size(); i++ ){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/Views/Templates/AnnounceCell.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                AnnounceListViewCell itemController = fxmlLoader.getController();
                itemController.setData(annoucementList.get(i));
                eventListView.getItems().add(anchorPane);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



}

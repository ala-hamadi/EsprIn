package Controllers.AdminDashboardControllers;


import Modules.Annoucement;
import Services.AnnouncementService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AnnounceMenu implements Initializable {
    @FXML
    public GridPane grid;
    @FXML
    private ListView<Node> announceListView;
    private List<Annoucement> AnnoucementObservableList;


    public AnnounceMenu() {
        AnnouncementService announcementService=AnnouncementService.getInstance();
        AnnoucementObservableList = announcementService.getList();
        announceListView = new ListView<>();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int col = 0;
        int rows = 0;
        try {
            for (int i = 0; i < AnnoucementObservableList.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/Views/Cells/AnnounceCell.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                AnnounceListViewCell itemController = fxmlLoader.getController();
                itemController.setData(AnnoucementObservableList.get(i));
                announceListView.getItems().add(anchorPane);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void addAnnounce(ActionEvent actionEvent) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/Views/Windows/AddAnnounceWindow.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

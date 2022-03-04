package Controllers.AdminDashboardControllers.Announce;


import Controllers.Interfaces.DeleteListener;
import Modules.Annoucement;
import services.AnnouncementService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public class AnnounceMenu implements Initializable {

    @FXML
    public ListView<Node> announceListView;
    @FXML
    public TextField searchField;
    @FXML
    public ComboBox choiceBoxFiltre;
    private List<Annoucement> annoucementObservableList;
    AnnouncementService announcementService;
    DeleteListener<Annoucement> onDelete;

    public AnnounceMenu() {
        try {
            announcementService = AnnouncementService.getInstance();
        } catch (SQLException exception) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("DataBase Connection failed");
            alert.setContentText("Announces list won't load unless you assure a database connection");
            alert.show();
        }
        annoucementObservableList = announcementService.getList();
        announceListView = new ListView<>();
        onDelete = new DeleteListener<Annoucement>() {
            @Override
            public void onDelete(Annoucement annoucement) {
                announcementService.delete(annoucement);
                announceListView.getItems().setAll(bind(announcementService.getList()));
            }
        };
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        choiceBoxFiltre.getItems().addAll(new String[]{"Show by Newer","Show by older"});
        announceListView.getItems().setAll(bind(announcementService.getList()));
        choiceBoxFiltre.getSelectionModel().selectFirst();
    }

    private ObservableList<AnchorPane> bind(List<Annoucement> list) {

        List<AnchorPane> anchorPaneList = new ArrayList<>();
        Collections.reverse(list);
        annoucementObservableList = list;
        try {
            for (Annoucement annoucement : annoucementObservableList) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/Views/Cells/AnnounceCell.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                AnnounceListViewCell itemController = fxmlLoader.getController();
                itemController.setData(annoucement, onDelete);
                anchorPaneList.add(anchorPane);
            }
            return FXCollections.observableList(anchorPaneList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
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

    public void refresh(ActionEvent actionEvent) {
        try {
            announceListView.getItems().setAll(bind(announcementService.getList()));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void keyTyped(KeyEvent keyEvent) {
        String text = searchField.getText();
        System.out.println(text);
        List list = announcementService.getList();
        List listFiltred = announcementService.filterAlertBySubject(text, list);
        if (text == "")
            announceListView.getItems().setAll(bind(announcementService.getList()));
        System.out.println(list+"|*****************************************|\n" +
                listFiltred);
        announceListView.getItems().setAll(bind(listFiltred));
    }

    public void onChangeProp(ActionEvent actionEvent) {
        System.out.println(choiceBoxFiltre.getValue());
        if(choiceBoxFiltre.getItems().get(0).equals(choiceBoxFiltre.getValue()))
            announceListView.getItems().setAll(bind(announcementService.getList()));
        else {
            List list=announcementService.getList();
            Collections.reverse(list);
            announceListView.getItems().setAll(bind(list));
        }
    }
}

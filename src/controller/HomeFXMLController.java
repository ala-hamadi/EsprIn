package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeFXMLController{

    @FXML
    private Button exitBtn;

    @FXML
    private Button SearchBtn;

    @FXML
    private Button PostBtn;

    @FXML
    private Button EventBtn;

    @FXML
    private Button ForumBtn;

    @FXML
    private Button OfferBtn;

    @FXML
    private Button AnnounceBtn;

    @FXML
    private Button AddBtn;

    @FXML
    private Button LogoutBtn;

    @FXML
    private StackPane content;

    @FXML
    void exitApp(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();

    }
    @FXML
    void showAnnounceMenu(ActionEvent announce) {

        try {
            Parent menu = FXMLLoader.load(getClass().getResource("/view/UI/AnnounceMenu.fxml"));
            content.getChildren().removeAll();
            content.getChildren().setAll(menu);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void showEventMenu(ActionEvent event) {
}


    @FXML
    void showSearchList(MouseEvent event) {

    }

    @FXML
    void showForumMenu(ActionEvent event) {
        try {
            Parent menu = FXMLLoader.load(getClass().getResource("/view/UI/ForumMenu.fxml"));
            content.getChildren().removeAll();
            content.getChildren().setAll(menu);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

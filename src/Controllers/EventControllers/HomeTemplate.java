package Controllers.EventControllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HomeTemplate {

    @FXML
    private Button AddBtn;

    @FXML
    private Button AnnanceBtn;

    @FXML
    private StackPane content;

    @FXML
    private Button EventBtn;

    @FXML
    private Button ForumBtn;

    @FXML
    private Button LogoutBtn;

    @FXML
    private Button OfferBtn;

    @FXML
    private Button PostBtn;

    @FXML
    private Button SearchBtn;
    @FXML
    private Button exitBtn;

    @FXML
    void exitApp(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();

    }

    @FXML
    void AddEvent(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/Views/Windows/AddEvent.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void showSearchList(MouseEvent event) {

    }

    @FXML
    void showEventMenu(ActionEvent event) {

        try {
            Parent menu = FXMLLoader.load(getClass().getResource("/Views/UI/EventMenu.fxml"));
            content.getChildren().removeAll();
            content.getChildren().setAll(menu);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}

package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    @FXML
    public StackPane content;
    @FXML
    private Button exitBtn;
    private double x, y;

    @FXML
    void exitApp(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void mouseDragged(MouseEvent mouseEvent) {
        Stage stage = (Stage) ((Pane) mouseEvent.getSource()).getScene().getWindow();
        stage.setX(mouseEvent.getScreenX() - x);
        stage.setY(mouseEvent.getScreenY() - y);
    }

    @FXML
    void mousePressed(MouseEvent mouseEvent) {
        x = mouseEvent.getSceneX();
        y = mouseEvent.getSceneY();
    }

    public void showUsersMenu(ActionEvent actionEvent) {
        try {
            Parent menu = FXMLLoader.load(getClass().getResource("/Views/UI/UsersMenu.fxml"));
            content.getChildren().removeAll();
            content.getChildren().setAll(menu);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public void showAnnounceMenu(ActionEvent actionEvent) {
        try {
            Parent menu = FXMLLoader.load(getClass().getResource("/Views/UI/AnnounceMenu.fxml"));
            content.getChildren().removeAll();
            content.getChildren().setAll(menu);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

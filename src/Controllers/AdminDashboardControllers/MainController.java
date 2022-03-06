package Controllers.AdminDashboardControllers;

import Services.UserServices;
import Utils.CurrentUser;
import Utils.Enums.State;
import Utils.RessorcesManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class MainController {
    @FXML
    public StackPane content;
    @FXML
    private Button exitBtn;
    private double x, y;
    UserServices userServices;

    public MainController() {
        try {
            userServices=UserServices.getInstance();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        ;
    }

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
            Parent menu = FXMLLoader.load(getClass().getResource("/Views/UI/Dashboard/UsersMenu.fxml"));
            content.getChildren().removeAll();
            content.getChildren().setAll(menu);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public void showAnnounceMenu(ActionEvent actionEvent) {
        try {
            Parent menu = FXMLLoader.load(getClass().getResource("/Views/UI/Dashboard/AnnounceMenu.fxml"));
            content.getChildren().removeAll();
            content.getChildren().setAll(menu);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void onLogout(ActionEvent actionEvent) {
        System.out.println(CurrentUser.getInstance().getCurrentUser());
        userServices.changeState(CurrentUser.getInstance().getCurrentUser(), State.Disconnected);
        CurrentUser.clearInstance();
        RessorcesManager.delete("loggedUser.bin");
        try {
            Parent parent =FXMLLoader.load(getClass().getResource("/Views/UI/LoginInterface.fxml"));
            Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            Scene scene=new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

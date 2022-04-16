package Controllers.AdminDashboardControllers;

import Modules.Admin;
import Modules.User;
import Services.UserServices;
import Utils.CurrentUser;
import Utils.Enums.State;
import Utils.RessorcesManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    public StackPane content;
    @FXML
    public Label adminName;
    @FXML
    public Label adminLastName;
    @FXML
    public Label adminNameAndLastName;
    @FXML
    public Circle adminAvatar;
    @FXML
    private Button exitBtn;
    private double x, y;
    UserServices userServices;

    public MainController() {
        try {
            userServices = UserServices.getInstance();


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
    @FXML
    void showAlertsMenu(ActionEvent event) {
        try {
            Parent menu = FXMLLoader.load(getClass().getResource("/Views/UI/Dashboard/AlertMenu.fxml"));
            content.getChildren().removeAll();
            content.getChildren().setAll(menu);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


    @FXML
    void showEventsMenu(ActionEvent event) {
        try {
            Parent menu = FXMLLoader.load(getClass().getResource("/Views/UI/Dashboard/EventMenu.fxml"));
            content.getChildren().removeAll();
            content.getChildren().setAll(menu);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @FXML
    void showForumsMenu(ActionEvent event) {
        try {
            Parent menu = FXMLLoader.load(getClass().getResource("/Views/UI/Dashboard/ForumMenu.fxml"));
            content.getChildren().removeAll();
            content.getChildren().setAll(menu);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @FXML
    void showOffersMenu(ActionEvent event) {
        try {
            Parent menu = FXMLLoader.load(getClass().getResource("/Views/UI/Dashboard/OfferMenu.fxml"));
            content.getChildren().removeAll();
            content.getChildren().setAll(menu);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @FXML
    void showPostsMenu(ActionEvent event) {
        try {
            Parent menu = FXMLLoader.load(getClass().getResource("/Views/UI/Dashboard/PostMenu.fxml"));
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
            Parent parent = FXMLLoader.load(getClass().getResource("/Views/UI/LoginInterface.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Admin admin=(Admin) CurrentUser.getInstance().getCurrentUser();
       // adminAvatar.setFill(new ImagePattern(new Image(admin.getImgUrl(),false)));
        adminName.setText(admin.getFirstName());
        adminLastName.setText(admin.getLastName());
        adminNameAndLastName.setText(admin.getFirstName()+" "+admin.getLastName());
    }
}

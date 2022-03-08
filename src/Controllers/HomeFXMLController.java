package Controllers;

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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HomeFXMLController implements Initializable {

    @FXML
    private Button AnnounceBtn;

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
    private StackPane content;

    @FXML
    private Button exitBtn;

    @FXML
    private Button SearchBtn;

    @FXML
    private Button AddBtn;


    UserServices userServices;

    @FXML
    void exitApp(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();

    }


    @FXML
    void showAnnounceMenu(ActionEvent announce) {

        try {
            Parent menu = FXMLLoader.load(getClass().getResource("/Views/UI/Announcement/AnnounceMenu.fxml"));
            content.getChildren().removeAll();
            content.getChildren().setAll(menu);
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    @FXML
    void showForumMenu(ActionEvent event) {
        try {
            Parent menu = FXMLLoader.load(getClass().getResource("/Views/UI/ForumMenu.fxml"));
            content.getChildren().removeAll();
            content.getChildren().setAll(menu);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void showOfferMenu(ActionEvent event) {
        try {
            Parent menu = FXMLLoader.load(getClass().getResource("/Views/UI/Offer/OfferMenu.fxml"));
            content.getChildren().removeAll();
            content.getChildren().setAll(menu);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void showPostMenu(ActionEvent event) {
        try {
            Parent menu = FXMLLoader.load(getClass().getResource("/Views/UI/Post/PostMenu.fxml"));
            content.getChildren().removeAll();
            content.getChildren().setAll(menu);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @FXML
    void showSearchList(MouseEvent event) {

    }


    @FXML
    void Add(ActionEvent event) {

    }

    @FXML
    void AddAlert(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/Views/Windows/AddAlert.fxml"));
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
    void AddAnnounce(ActionEvent event) {
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
    void AddForum(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/Views/Windows/AddForumWindow.fxml"));
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
    void AddOffer(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/Views/Windows/AddOffer.fxml"));
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
    void AddPost(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/Views/Windows/AddPost.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }





    public void logout(ActionEvent actionEvent) {
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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            userServices=UserServices.getInstance();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }




}

package Controllers;

import Modules.Espritien;
import Modules.Extern;
import Services.UserServices;
import Utils.CropImg;
import Utils.CurrentUser;
import Utils.Enums.Roles;
import Utils.Enums.State;
import Utils.RessorcesManager;
import Utils.UserSerializableData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HomeFXMLController implements Initializable {

    @FXML
    public Text profileNameAndLastName;
    public Circle userAvatar;
    public Circle userAvatar2;
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
    private MenuItem eventAddItem;

    @FXML
    private MenuItem forumAddItem;

    @FXML
    private MenuItem offreAddItem;

    @FXML
    private MenuItem postAddItem;

    @FXML
    private MenuItem alertAddItem;


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
    }


    @FXML
    void showSearchList(MouseEvent event) {

    }

    @FXML
    void AddAlert(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/Views/UI/Announcement/AddAlert.fxml"));
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
    void showForum(ActionEvent event) {
        try {
            Parent menu = FXMLLoader.load(getClass().getResource("/Views/UI/ForumMenu.fxml"));
            content.getChildren().removeAll();
            content.getChildren().setAll(menu);
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
        try {
            userServices = UserServices.getInstance();
            try{
                Image image;
                if(!CurrentUser.getInstance().getCurrentUser().getImgUrl().equals("")) {
                    image = new Image("/Img/" + CurrentUser.getInstance().getCurrentUser().getImgUrl(), false);
                    userAvatar.setFill(new ImagePattern(image));
                    userAvatar2.setFill(new ImagePattern(image));
                }
            }catch (Exception exception){
                System.out.println(exception.getMessage());
            }

            if(CurrentUser.getInstance().getCurrentUser().getRole().equals(Roles.Externe))
            {
                Extern extern=(Extern)CurrentUser.getInstance().getCurrentUser();
                profileNameAndLastName.setText(extern.getEntrepriseName());
            }else {
                Espritien espritien=(Espritien) CurrentUser.getInstance().getCurrentUser();
                profileNameAndLastName.setText(espritien.getFirstName()+" "+espritien.getLastName());
            }

            switch (CurrentUser.getInstance().getCurrentUser().getRole()) {
                case Club:
                    postAddItem.setVisible(true);
                    eventAddItem.setVisible(true);
                    break;
                case Professeur:
                    postAddItem.setVisible(true);
                    alertAddItem.setVisible(true);
                    forumAddItem.setVisible(true);
                    break;
                case Etudiant:
                    postAddItem.setVisible(true);
                    forumAddItem.setVisible(true);
                    break;
                case Externe:
                    offreAddItem.setVisible(true);

                    break;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void AddOffer(ActionEvent actionEvent) {
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

    public void AddForum(ActionEvent actionEvent) {
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

    public void AddEvent(ActionEvent actionEvent) {
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

    public void AddPost(ActionEvent actionEvent) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/Views/Windows/AddPost.fxml"));
            System.out.println(parent);
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public void addPic(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/Templates/ImgCropInterface.fxml"));
            Parent parent=loader.load();
            ImgCropInterface imgCropInterface=loader.getController();
            File file=CropImg.importImg();
            Image image=CropImg.fileToImage(file);
            System.out.println(file);
            System.out.println(image);
            imgCropInterface.setImageFile(file);
            imgCropInterface.setImage(image);
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.DECORATED);
            stage.sizeToScene();
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }

    }
}

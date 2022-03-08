package Controllers.Offers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class OfferFXML {

    @FXML
    private Button AddBtn;

    @FXML
    private Button AnnanceBtn;

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
    private StackPane content;

    @FXML
    private Button exitBtn;

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
    public void addOffer(ActionEvent event){
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
}

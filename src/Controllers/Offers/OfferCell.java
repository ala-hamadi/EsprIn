package Controllers.Offers;

import Controllers.EventControllers.EditEventController;
import Modules.Espritien;
import Modules.Extern;
import Modules.Offre;
import Modules.User;
import Services.EventServices;
import Services.OffreServices;
import Services.UserServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class OfferCell {


    @FXML
    private Label ContentOffer;

    @FXML
    private Label OfferCategorie;

    @FXML
    private Circle OrgImage;

    @FXML
    private Label ProvName;

    @FXML
    private Label TitleOffer;

    @FXML
    private ImageView imageOffer;

    @FXML
    private AnchorPane pane;

    private Offre offre;

    private List<User> userList;

    private UserServices userServices;

    @FXML
    private Button DeleteBtn1;

    @FXML
    private Button ModBtn1;

    @FXML
    public void offerinterested(ActionEvent actionEvent) {
    }

    public void setData(Offre offre){
        this.offre = offre;

        try {
            UserServices userServices = UserServices.getInstance();
            userList = userServices.getList();

            long idProvider= offre.getOfferProvider();
            Extern user = (Extern) userServices.retrive(idProvider);
            System.out.println(user);
            ProvName.setText(user.getEntrepriseName());

            TitleOffer.setText(offre.getTitleOffer());
            ContentOffer.setText(offre.getDescOffer());
            OfferCategorie.setText(offre.getCategory().name());

//            if(10000000!=offre.getOfferProvider()){
//                DeleteBtn1.setVisible(false);
//                ModBtn1.setVisible(false);
//            }

        } catch (SQLException exception) {
            exception.printStackTrace();
            System.out.println(exception.getMessage());
        }


        /*if(offre.getImgOffre()!=null){
            Image image= new Image(offre.getImgOffre());
            imageOffer.setImage(image);
        }*/




    }

    @FXML
    void DeleteOffer(ActionEvent even) throws SQLException {

        OffreServices offreServices=new OffreServices();
        boolean deleted=offreServices.delete(offre);
        if(deleted){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("event is deleted successfully!");
            alert.show();

        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.show();
        }

    }

    @FXML
    void ModifyOffer(ActionEvent even) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/Views/Windows/ModifierOffer.fxml"));
            Parent parent = fxmlLoader.load();
            EditOfferController editPostController = fxmlLoader.getController();
            editPostController.setData(offre);
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

package Controllers.Offers;

import Modules.Offre;
import Services.UserServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

import java.sql.SQLException;

public class OfferCell {


    @FXML
    private Label ContentOffer;

    @FXML
    private Label OfferCategorie;

    @FXML
    private Circle OrgImage;

    @FXML
    private Label OrgName;

    @FXML
    private Label TitleOffer;

    @FXML
    private ImageView imageOffer;

    @FXML
    private AnchorPane pane;

    @FXML

    public void OfferParticiate(ActionEvent actionEvent) {
    }

    public void setData(Offre offre){

        try {
            UserServices userService = UserServices.getInstance();
           // OrgName.setText(userService.retri);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        TitleOffer.setText(offre.getTitleOffer());
        ContentOffer.setText(offre.getDescOffer());
        OfferCategorie.setText(offre.getCategory().name());



    }

}

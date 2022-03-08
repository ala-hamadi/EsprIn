package Controllers.Offers;

import Modules.Espritien;
import Modules.Extern;
import Modules.Offre;
import Modules.User;
import Services.UserServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

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

        } catch (SQLException exception) {
            exception.printStackTrace();
            System.out.println(exception.getMessage());
        }


        /*if(offre.getImgOffre()!=null){
            Image image= new Image(offre.getImgOffre());
            imageOffer.setImage(image);
        }*/




    }

}

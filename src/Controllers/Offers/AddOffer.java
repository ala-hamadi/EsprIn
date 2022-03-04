package Controllers.Offers;

import Modules.Offre;
import services.OffreServices;
import services.UserServices;
import Utils.Structure.Classe;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class AddOffer implements Initializable {

    @FXML
    private Button AddOfferBtn;

    @FXML
    private TextField OfferTitle;

    @FXML
    private ComboBox<?> categorie;

    @FXML
    private Circle circle;

    @FXML
    private TextField contentOffer;

    @FXML
    private ImageView image;

    @FXML
    private Label labAddOffer;

    @FXML
    private Label labDescription;

    @FXML
    private Label labTitle;

    @FXML
    private Label labdate;

    @FXML
    private Label labimage;

    @FXML
    private Pane pan1;

    private OffreServices offreServices;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
package Controllers.Offers;

import Modules.Annoucement;
import Modules.Offre;
import Services.AnnouncementService;
import Services.EventServices;
import Services.OffreServices;
import Services.UserServices;
import Utils.Enums.AnnounceDestination;
import Utils.Enums.OffreCategorie;
import Utils.Structure.Classe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddOffer implements Initializable {

    @FXML
    private Button AddOfferBtn;

    @FXML
    private TextField OfferTitle;

    @FXML
    private ChoiceBox<OffreCategorie> catOffre;

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
    private OffreCategorie[] categories = OffreCategorie.values();

    public void closeWindow(MouseEvent mouseEvent) {
        try {
            Stage stage = (Stage) ((ImageView) mouseEvent.getSource()).getScene().getWindow();
            stage.close();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }



        @Override
    public void initialize(URL location, ResourceBundle resources) {
            catOffre.getItems().addAll(categories);
            catOffre.setValue(categories[0]);
    }


    public void createOffre(ActionEvent actionEvent) {
        if ((OfferTitle.getText() != null) && (contentOffer.getText() != null) ) {
            try {
                offreServices = OffreServices.getInstance();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }


            Offre offre = new Offre(OfferTitle.getText(), contentOffer.getText(), catOffre.getValue(), 10020855);
            offreServices.add(offre);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Offer is added successfully!");
            alert.show();

            try {
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.close();
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setContentText("Merci de mettre un titre ou une description valide de Offre");
            alert.show();
        }
    }

}
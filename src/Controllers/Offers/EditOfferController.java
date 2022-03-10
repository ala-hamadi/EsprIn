package Controllers.Offers;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Modules.Offre;
import Services.OffreServices;
import Utils.CurrentUser;
import Utils.Enums.OffreCategorie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class EditOfferController implements Initializable {
  private OffreCategorie[] categories = OffreCategorie.values();

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

  Offre offre;
  public void setData(Offre offre){
    this.offre = offre;
  }

  @FXML
  public void EditOffre(ActionEvent actionEvent) {
    if ((OfferTitle.getText() != null) && (contentOffer.getText() != null) ) {
      try {
        offreServices = OffreServices.getInstance();
      } catch (SQLException exception) {
        exception.printStackTrace();
      }


      Offre offreMod = new Offre(OfferTitle.getText(), contentOffer.getText(), catOffre.getValue(), CurrentUser.getInstance().getCurrentUser().getCinUser());
      offreMod.setIdOffre(offre.getIdOffer());
      offreServices.update(offreMod);
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

}

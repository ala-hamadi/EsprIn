package Controllers.AdminDashboardControllers.Announce;

import Modules.Annoucement;
import Services.AnnouncementService;
import Utils.Enums.AnnounceDestination;
import com.sun.istack.internal.NotNull;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.management.relation.Role;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class AddAnnounceWindow implements Initializable {
    @FXML
    public TextField annTitle;
    @FXML
    public TextArea annDesc;
    @FXML
    private ChoiceBox<AnnounceDestination> destselection;

    private AnnounceDestination[] roles = AnnounceDestination.values();
    double x, y;
    private AnnouncementService announcementService;

    public AddAnnounceWindow() {
        try {
            announcementService = AnnouncementService.getInstance();
        } catch (SQLException exception) {
            Alert alert= new Alert(Alert.AlertType.ERROR) ;
            alert.setTitle("DataBase Connection failed");
            alert.setContentText("Announces list won't load unless you assure a database connection");
            alert.show();
        }
    }

    public void mouseDragged(MouseEvent mouseEvent) {
        Stage stage = (Stage) ((Pane) mouseEvent.getSource()).getScene().getWindow();
        stage.setX(mouseEvent.getScreenX() - x);
        stage.setY(mouseEvent.getScreenY() - y);
    }

    public void mousePressed(MouseEvent mouseEvent) {
        x = mouseEvent.getSceneX();
        y = mouseEvent.getSceneY();
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
        destselection.getItems().addAll(roles);
        destselection.setValue(roles[0]);

    }

    public void createAnnounce(ActionEvent actionEvent) {
        if ((annTitle.getText() != null) && (annDesc.getText() != null) && (annTitle.getText().length() > 4) && (annDesc.getText().length() > 6)) {
            Annoucement annoucement = new Annoucement(annTitle.getText(), annDesc.getText(), destselection.getValue(), 10020855);
            announcementService.add(annoucement);
            try {
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.close();
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setContentText("Merci de mettre un titre ou une description valide à l'annonce");
            alert.show();
        }
    }

}

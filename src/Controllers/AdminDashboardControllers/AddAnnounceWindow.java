package Controllers.AdminDashboardControllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.management.relation.Role;
import java.net.URL;
import java.util.ResourceBundle;


public class AddAnnounceWindow implements Initializable {
    @FXML
    private ChoiceBox<Role> destselection;
    //private Role[] roles = {Role.Tous, Role.Etudiants, Role.Proffeseurs, Role.Clubs};
    double x, y;

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
      /*  destselection.getItems().addAll(roles);
        destselection.setValue(roles[0]);*/
    }
}

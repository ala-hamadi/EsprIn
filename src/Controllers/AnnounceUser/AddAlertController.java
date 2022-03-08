package Controllers.AnnounceUser;

import Modules.AlertProf;
import Services.AlertProfServices;
import Utils.Structure.Classe;
import com.mysql.cj.protocol.InternalTimestamp;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class AddAlertController {


    @FXML
    private TextField TitleAlert;

    @FXML
    private TextArea ContentAlert;

    @FXML
    private TextArea niveau;

    @FXML
    private TextArea specialite;

    @FXML
    private TextArea numclass;
    double x, y;

    @FXML
    public void mouseDragged(MouseEvent mouseEvent) {
        Stage stage = (Stage) ((Pane) mouseEvent.getSource()).getScene().getWindow();
        stage.setX(mouseEvent.getScreenX() - x);
        stage.setY(mouseEvent.getScreenY() - y);
    }
    @FXML
    public void mousePressed(MouseEvent mouseEvent) {
        x = mouseEvent.getSceneX();
        y = mouseEvent.getSceneY();
    }
    @FXML
    public void closeWindow(MouseEvent mouseEvent) {
        try {
            Stage stage = (Stage) ((ImageView) mouseEvent.getSource()).getScene().getWindow();
            stage.close();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

    }



    public void AddAlert(javafx.event.ActionEvent event) {
        if ((ContentAlert.getText().length()>2) && (niveau.getText()!="")&&(specialite.getText()!="")&&(numclass.getText()!="")){
            AlertProfServices alertProfServices = null;
            try {
                alertProfServices = AlertProfServices.getInstance();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
            Classe classe1=new Classe();
            classe1.setNiveau(Integer.parseInt(niveau.getText()));
            classe1.setSpecialite(specialite.getText());
            classe1.setNumclass(Integer.parseInt(numclass.getText()));

            AlertProf alertProf1 =new AlertProf(TitleAlert.getText(), ContentAlert.getText(),classe1,55555555, Timestamp.valueOf(LocalDateTime.now()));
            alertProfServices.add(alertProf1);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Alert is added successfully!");
            alert.show();

            try{
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.close();
            }catch (Exception exception){
                System.out.println(exception.getMessage());
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setContentText("Merci de mettre un titre ou une description valide à l'alerte");
            alert.show();
        }
    }
}

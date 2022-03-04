package controller;

import Utils.Structure.Classe;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.AlertProf;
import services.AlertServices;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class AddAlertController {

    @FXML
    private TextArea ContentAlert;

    @FXML
    private TextArea Destination;
    double x, y;
    @FXML
    public void mouseDragged(javafx.scene.input.MouseEvent mouseEvent) {
        Stage stage = (Stage) ((Pane) mouseEvent.getSource()).getScene().getWindow();
        stage.setX(mouseEvent.getScreenX() - x);
        stage.setY(mouseEvent.getScreenY() - y);
    }
    @FXML
    public void mousePressed(javafx.scene.input.MouseEvent mouseEvent) {
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
        if ((ContentAlert.getText().length()>2) && (Destination.getText().length()>2)){
            AlertServices alertServices=new AlertServices();
            Classe classe1=new Classe();
            classe1.setSpecialite(Destination.getText());
            AlertProf alertProf1 =new AlertProf(2,ContentAlert.getText(),classe1,11111111, Timestamp.valueOf(LocalDateTime.now()));
            alertServices.add(alertProf1);
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

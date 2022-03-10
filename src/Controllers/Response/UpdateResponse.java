package Controllers.Response;

import Modules.Responded;
import Services.RespondedService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;

public class UpdateResponse {

    @FXML
    private TextArea responsecontent;

    @FXML
    private Button send;

    Responded responded;

    public void setData(Responded responded){
        this.responded = responded;
        responsecontent.setText(responded.getContent());
    }

    @FXML
    void closeWindow(MouseEvent event) {

    }

    @FXML
    void mouseDragged(MouseEvent event) {

    }

    @FXML
    void mousePressed(MouseEvent event) {

    }

    @FXML
    void updateresponse(ActionEvent event) throws SQLException {
        RespondedService respondedService = RespondedService.getInstance();
        responded.setContent(responsecontent.getText());
        respondedService.update(responded);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("Response is updated successfully !");
        alert.show();
    }

}

package Controllers.Response;

import Modules.Espritien;
import Modules.Responded;
import Services.RespondedService;
import Services.UserServices;
import Utils.CurrentUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class ResponseCell {
    @FXML
    private Text content;

    @FXML
    private Label username;

    @FXML
    private Button delete;

    @FXML
    private Button Edit;

    Responded responded;
    public void setData(Responded responded) {
        this.responded = responded;
        content.setText(responded.getContent());
        try {
            UserServices userServices = UserServices.getInstance();
            Espritien espritien = (Espritien) userServices.retrive(responded.getCinUser());
            username.setText(espritien.getFirstName());
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        if(CurrentUser.getInstance().getCurrentUser().getCinUser()!=responded.getCinUser()){
            delete.setVisible(false);
            Edit.setVisible(false);
        }
    }
    @FXML
    void EditComment(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/Views/Windows/UpdateResponse.fxml"));
            Parent menu = fxmlLoader.load();
            UpdateResponse updateResponse = fxmlLoader.getController();
            updateResponse.setData(responded);
            Scene scene = new Scene(menu);
            Stage stage = new Stage();
            stage.setScene(scene);
            //stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void deleteComment(ActionEvent event) {
        try {
            RespondedService respondedService = RespondedService.getInstance();
            respondedService.delete(responded);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Response is deleted successfully !");
            alert.show();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}

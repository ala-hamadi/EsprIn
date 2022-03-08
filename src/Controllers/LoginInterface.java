package Controllers;

import Modules.Espritien;
import Modules.User;
import Services.UserServices;
import Utils.CurrentUser;
import Utils.Enums.Roles;
import Utils.Enums.State;
import Utils.RessorcesManager;
import Utils.UserSerializableData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginInterface implements Initializable {

    @FXML
    public Label registerNowBtn;
    @FXML
    public AnchorPane loginInterface;
    @FXML
    private TextField emailAdresse;
    @FXML
    private PasswordField password;

    UserServices userServices;


    public LoginInterface() {
        try {

            userServices = UserServices.getInstance();

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @FXML
    void onLogin(ActionEvent event) {
        if (emailAdresse.getText().matches("[a-z A-Z]+[/.][a-z]+(@esprit.tn)") && (password.getText().length() > 3)) {
            User user = userServices.login(emailAdresse.getText(), password.getText());

            if (user != null) {
                CurrentUser.setInstance(user);
                userServices.changeState(user, State.Connected);
                UserSerializableData data = new UserSerializableData();
                data.userId = CurrentUser.getInstance().getCurrentUser().getCinUser();
                try {
                    RessorcesManager.save(data, "loggedUser.bin");
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                if (CurrentUser.getInstance().getCurrentUser().getRole().equals(Roles.Admin))
                    redirect("/Views/UI/Dashboard/DashboardMain.fxml");
                else
                    redirect("/Views/UI/HomeTemplate.fxml");

            }

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please check you mail or password", ButtonType.CLOSE);
            alert.setTitle("Login Error");
            alert.show();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            System.out.println(CurrentUser.getInstance().getCurrentUser());
        } catch (NullPointerException exception) {
            System.out.println("No User Found");
        }

    }

    public void redirect(String url) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(url));
            Stage stage = (Stage) emailAdresse.getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

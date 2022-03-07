package Controllers.AdminDashboardControllers.User;

import Modules.Extern;
import Services.UserServices;
import Utils.Enums.Roles;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class AddExternal {
    double x, y;
    @FXML
    private TextField entepriseName;

    @FXML
    private TextField entrepriseAdresse;

    @FXML
    private TextField entrepriseEmail;

    @FXML
    private TextField entrepriseId;

    @FXML
    private TextField entreprisePassword;

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

    public void addExtern(ActionEvent actionEvent) {
        try {
            UserServices userServices = UserServices.getInstance();
            if ((entrepriseEmail.getText().matches("[a-z A-Z]+[@][a-z A-Z]+[.][a-z A-Z]"))
                    && (entepriseName.getText().length() > 2)
                    && (entrepriseId.getText().matches("^[0-9]+[0-9]*$"))
                    && (entrepriseAdresse.getText().length() > 2)
                    && (entreprisePassword.getText().length() > 4)
            ) {
                Extern extern=new Extern(Long.parseLong(entrepriseId.getText())
                        , entrepriseEmail.getText()
                        , entreprisePassword.getText()
                        ,""
                        , Roles.Externe
                        , entepriseName.getText()
                        ,entrepriseAdresse.getText()
                        );
                userServices.add(extern);
                try {
                    Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    stage.close();
                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }
            }
            else{
                Alert alert=new Alert(Alert.AlertType.ERROR,"Cannot add Extern") ;
                alert.show();
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }
}

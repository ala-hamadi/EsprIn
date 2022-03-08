package Controllers.AdminDashboardControllers.User;

import APIs.Mailing;
import Modules.Admin;
import Modules.Extern;
import Services.UserServices;
import Utils.Enums.AdminDepartments;
import Utils.Enums.Roles;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddAdmin implements Initializable {
    double x, y;
    @FXML
    private TextField adminCin;

    @FXML
    private TextField adminEmail;

    @FXML
    private TextField adminFirstName;

    @FXML
    private TextField adminLastName;

    @FXML
    private TextField adminPassword;

    @FXML
    private ComboBox<AdminDepartments> department;

    public AddAdmin() {
        department=new ComboBox<>();
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
    @FXML
    void onAddingAdmin(ActionEvent event) {
        try {
            UserServices userServices = UserServices.getInstance();
            if ((adminEmail.getText().matches("[a-z A-Z]+[.][a-z]+(@esprit.tn)"))
                    && (adminFirstName.getText().length() > 2)
                    && (adminCin.getText().matches("^[0-9]+[0-9]*$"))
                    && (adminCin.getText().length()==8)
                    && (adminLastName.getText().length() > 2)
                    && (adminPassword.getText().length() > 4)
                    && (!department.getValue().equals(null))
            ) {
                Admin admin=new Admin(
                       Long.parseLong(adminCin.getText())
                        ,adminEmail.getText()
                        ,adminPassword.getText()
                        ,""
                        ,Roles.Admin
                        ,adminFirstName.getText()
                        ,adminLastName.getText()
                        , department.getValue()
                );

                userServices.add(admin);
                String text=Mailing.generateText(admin);
                Mailing.sendMail(admin.getEmail(),text,"Registration for EsprIN");
                try {
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.close();
                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }
            }
            else{
                Alert alert=new Alert(Alert.AlertType.ERROR,"Cannot add Admin") ;
                alert.show();
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        department.getItems().addAll(AdminDepartments.values());
    }
}

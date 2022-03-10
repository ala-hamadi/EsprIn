package Controllers.AnnounceUser;

import Modules.AlertProf;
import Modules.Espritien;
import Services.UserServices;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

import java.sql.SQLException;

public class AlertListViewCell {

    @FXML
    private AnchorPane pane;

    @FXML
    private Circle OrgImage;

    @FXML
    private Label ProfName;

    @FXML
    private Label DateAlert;

    @FXML
    private Label TitleAlert;

    @FXML
    private Label ContentAlert;

    @FXML
    private ImageView imageAlert;



    public void setData(AlertProf alertProf) {
        try {
            UserServices userServices=UserServices.getInstance();
            Espritien espritien=(Espritien) userServices.retrive(alertProf.getIdSender());
            ProfName.setText(espritien.getFirstName()+" "+espritien.getLastName());
            DateAlert.setText(alertProf.getCreatedAt().toString());
            TitleAlert.setText(alertProf.getTitle());
            ContentAlert.setText(alertProf.getContentAlert());
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}

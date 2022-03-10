package Controllers.AnnounceUser;

import Modules.*;
import Services.AnnouncementService;
import Services.UserServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import Modules.Annoucement;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AnnounceListViewCell {

    @FXML
    private AnchorPane pane;

    @FXML
    private Circle OrgImage;

    @FXML
    private Label TitleAnn;

    @FXML
    private Label DateAnn;

    @FXML
    private ImageView imageEvent;

    @FXML
    private Label ContentAnn;


    @FXML
    private Label AdminName;

    @FXML
    private Button downloadPDF;

    private Annoucement annoucement;

    private List<User> userList;

    private UserServices userServices;
    @FXML
    private Button DeleteBtn1;

    @FXML
    private Button ModBtn1;
    public void setData(Annoucement annoucement){

        this.annoucement = annoucement;
        try {
            userServices = UserServices.getInstance();
            userList = userServices.getList();
            long idSender= annoucement.getIdSender();
            Admin user = (Admin) userServices.retrive(idSender);

            String firstname= user.getFirstName();
            String lastname= user.getLastName();
            AdminName.setText(firstname + " " + lastname);

        } catch (SQLException exception) {
            exception.printStackTrace();
        }



        TitleAnn.setText(annoucement.getSubjectAnn());
        DateAnn.setText(annoucement.getDestAnn().toString());
        ContentAnn.setText(annoucement.getContentAnn());
        DateAnn.setText(annoucement.getCreatedAt().toString());

    }




}

package Controllers.AnnounceUser;

import java.sql.SQLException;

import Modules.Admin;
import Modules.Annoucement;
import Modules.Espritien;
import Services.UserServices;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

public class AnnounceListViewCell {

    @FXML
    private AnchorPane pane;

    @FXML
    private Circle OrgImage;

    @FXML
    private Label AdminName;

    @FXML
    private Label DateAnn;

    @FXML
    private ImageView QRIMG;

    @FXML
    private Label TitleAnn;

    @FXML
    private ImageView imageEvent;

    @FXML
    private Label ContentAnn;



    public void setData(Annoucement annoucement){
        TitleAnn.setText(annoucement.getSubjectAnn());
        Espritien a;
        UserServices s= null;
        try {
            s = UserServices.getInstance();
            a=(Espritien) s.retrive(annoucement.getIdSender());

            AdminName.setText(a.getFirstName()+" "+a.getLastName());
            ContentAnn.setText(annoucement.getContentAnn());
            DateAnn.setText(annoucement.getCreatedAt().toString());
            String nameQR= String.valueOf(annoucement.getIdAnn());
            String url="/QRCode/"+nameQR+".png";
            //Image image=new Image(url,false);
            Image image = new Image("Views/Icons/appicon.png");

            //QRIMG.setImage(image);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

}

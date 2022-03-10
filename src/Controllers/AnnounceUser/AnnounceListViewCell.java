package Controllers.AnnounceUser;

import Modules.Annoucement;
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
        DateAnn.setText(annoucement.getDestAnn().toString());
        ContentAnn.setText(annoucement.getContentAnn());
        DateAnn.setText(annoucement.getCreatedAt().toString());
        String nameQR= String.valueOf(annoucement.getIdAnn());
        String url="/QRCode/"+nameQR+".png";
        Image image=new Image(url,false);
        QRIMG.setImage(image);

    }

}

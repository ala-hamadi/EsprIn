package Controllers.AnnounceUser;

import Modules.Annoucement;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import Modules.Annoucement;

public class AnnounceListViewCell {

    @FXML
    private AnchorPane pane;

    @FXML
    private Circle OrgImage;

    @FXML
    private Label TitleAnn;

    @FXML
    private Label DestAn;

    @FXML
    private ImageView imageEvent;

    @FXML
    private Label ContentAnn;

    @FXML
    private Label DateAnn;

    public void setData(Annoucement annoucement){
        TitleAnn.setText(annoucement.getSubjectAnn());
        DestAn.setText(annoucement.getDestAnn().toString());
        ContentAnn.setText(annoucement.getContentAnn());
        DateAnn.setText(annoucement.getCreatedAt().toString());
    }
}

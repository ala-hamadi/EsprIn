package Controllers;


import Modules.Annoucement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class AnnounceListViewCell {
    public AnchorPane pane;
    @FXML
    private Label AnnoucementTitle;
    @FXML
    private Label dateSent;
    @FXML
    private Label destination;

    private Annoucement Annoucement;

    public void AnnoucementDeleted(ActionEvent actionEvent) {
    }

    public void setData(Annoucement Annoucement) {
        this.Annoucement = Annoucement;
        AnnoucementTitle.setText(Annoucement.getSubjectAnn());
        dateSent.setText(Annoucement.getCreatedAt().toString());
        destination.setText(Annoucement.getDestAnn().name());
    }

}

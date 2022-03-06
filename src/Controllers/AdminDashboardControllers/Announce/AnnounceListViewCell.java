package Controllers.AdminDashboardControllers.Announce;


import Controllers.Interfaces.DeleteListener;
import Modules.Annoucement;
import Services.AnnouncementService;
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
    private Label announceTitle;
    @FXML
    private Label dateSent;
    @FXML
    private Label destination;

    private Annoucement annoucement;



    DeleteListener<Annoucement> deleteListener;

    public AnnounceListViewCell() {
    }

    public void announceDeleted(ActionEvent actionEvent) {
        deleteListener.onDelete(annoucement);
    }

    public void setData(Annoucement annoucement, DeleteListener<Annoucement> deleteListener) {
        this.deleteListener=deleteListener;
        this.annoucement = annoucement;
        announceTitle.setText(annoucement.getSubjectAnn());
        dateSent.setText(annoucement.getCreatedAt().toString());
        destination.setText(annoucement.getDestAnn().name());
    }

}

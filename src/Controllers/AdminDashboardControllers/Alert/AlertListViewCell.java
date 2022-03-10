package Controllers.AdminDashboardControllers.Alert;

import Controllers.Interfaces.DeleteListener;
import Modules.AlertProf;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;


public class AlertListViewCell {

    @FXML
    private AnchorPane pane;

    @FXML
    private Label alertTitle;

    @FXML
    private Label dateSent;

    @FXML
    private Label destination;


    private AlertProf alertProf;



    DeleteListener<AlertProf> deleteListener;

    public AlertListViewCell(){
    }

    public void alertDeleted(ActionEvent event) {
        deleteListener.onDelete(alertProf);
    }
    public void setData(AlertProf alertprof,DeleteListener<AlertProf> deleteListener){
        this.deleteListener=deleteListener;
        this.alertProf=alertprof;
        alertTitle.setText(alertprof.getTitle());
        dateSent.setText(alertprof.getCreatedAt().toString());
        destination.setText(alertprof.getDestClass().toString());
    }
}

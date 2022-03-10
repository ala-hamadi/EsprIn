package Controllers.AdminDashboardControllers.Event;

import Controllers.Interfaces.DeleteListener;
import Modules.Espritien;
import Modules.Event;
import Services.UserServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.sql.SQLException;

public class EventListViewCell {

    @FXML
    private AnchorPane pane;

    @FXML
    private Label eventTitle;

    @FXML
    private Label eventDate;

    @FXML
    private Label eventOrganizer;

    private Event evenement;

    DeleteListener<Event> deleteListener;

    @FXML
    void eventDeleted(ActionEvent event) {
        deleteListener.onDelete(evenement);
    }
    public void setData(Event evenement,DeleteListener<Event>deleteListener){
        try {
            UserServices userServices=UserServices.getInstance();
            this.deleteListener=deleteListener;
            this.evenement=evenement;
            Espritien espritien=(Espritien) userServices.retrive(evenement.getIdOrganizer());
            eventTitle.setText(evenement.getTitleEvent());
            eventDate.setText(evenement.getDateEventDeb().toString());
            eventOrganizer.setText(espritien.getFirstName()+" "+espritien.getLastName());

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

}

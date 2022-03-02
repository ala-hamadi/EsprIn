package Controllers.EventControllers;

import Modules.Club;
import Modules.User;
import Services.EventServices;
import Services.UserServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import Modules.Event;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class EventListViewCell {
    @FXML
    private Label ContentEvent;

    @FXML
    private Circle OrgImage;

    @FXML
    private Label OrgName;

    @FXML
    private Label TitleEvent;

    @FXML
    private ImageView imageEvent;

    @FXML
    private AnchorPane pane;

    private Event event;

    @FXML
    private Label DateEvent;

    @FXML
    void EventParticiate(ActionEvent event) {

    }



    public void setData(Event event){
        this.event = event;


        TitleEvent.setText(event.getTitleEvent());
        ContentEvent.setText(event.getDescription());
        DateEvent.setText(String.valueOf(event.getDateEvent()));
    }
}

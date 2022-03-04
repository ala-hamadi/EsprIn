package Controllers.EventControllers;


import Modules.Event;
import Services.EventServices;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class EventMenu implements Initializable {

    @FXML
    private GridPane grid;

    @FXML
    private ListView<Node> eventListView;
    private List<Event> eventList;
    EventServices eventServices;

   /* public EventMenu() {
        eventList= new ArrayList<Event>();
        eventList.add(new Event("titlee","zesrytu ioiolk jhng fbugjgc; jfhg jbgff sfvbn,;:bn" + " \n " +
                "jlkmb jknlesr ytuio iolk jhn gfbugj gcg bhn,gjhklu rgr egth" + " \n " +
                "zesrytu ioiolk jhng fbugjgc; jfhg jbgff sfvbn,;:bn" + " \n " +
                "jlkmb jknlesr ytuio iolk jhn gfbugj gcg bhn,gjhklu rgr egth" + " \n " +
                "zesrytu ioiolk jhng fbugjgc; jfhg jbgff sfvbn,;:bn" + " \n " +
                "jlkmb jknlesr ytuio iolk jhn gfbugj gcg bhn,gjhklu rgr egth" + " \n " +
                "zesrytu ioiolk jhng fbugjgc; jfhg jbgff sfvbn,;:bn" + " \n " +
                "jlkmb jknlesr ytuio iolk jhn gfbugj gcg bhn,gjhklu rgr egth" + " \n "));
        eventList.add(new Event("Campiiing","efgfjh lkmb jknlesr yt lkm uio iolk jhn gfbugj gcg bhn,gjhklu rgr egth gfwzesrytu ioiolk jhng f;jkhjg"));
        eventList.add(new Event("fOEMATION","efeftqtzoejtmlZMG RJ HERUTLtTEZTV EZGV"));
        eventList.add(new Event("fOEMATION","efeftqtzoejtmlZMG RJ HERUTLtTEZTV EZGV"));
        eventList.add(new Event("fOEMATION","efeftqtzoejtmlZMG RJ HERUTLtTEZTV EZGV"));




        eventListView = new ListView<>();
    }*/

    public EventMenu() {
        try {
            eventServices=EventServices.getInstance();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        eventList = eventServices.getList();
        eventListView = new ListView<>();
        System.out.println(eventList);
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            for (int i=0; i< eventList.size(); i++ ){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/Views/Cells/EventCell.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                EventListViewCell itemController = fxmlLoader.getController();
                itemController.setData(eventList.get(i));
                eventListView.getItems().add(anchorPane);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
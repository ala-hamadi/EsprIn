package Controllers.EventControllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import Modules.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class ParticipateListController  implements Initializable {
    @FXML
    private ListView<?> participateListView;
    private List<Event> participateList;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

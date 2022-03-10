package Controllers.AdminDashboardControllers.Event;

import Controllers.Interfaces.DeleteListener;
import Modules.Event;
import Services.EventServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public class EventMenu implements Initializable {

    @FXML
    private ComboBox<String> choiceBoxFiltre;

    @FXML
    private TextField searchField;

    @FXML
    private Button refreshBtn;

    @FXML
    private ListView<Node> EventListView;

    private List<Event>EventObservableList;
    EventServices eventServices;
    DeleteListener<Event>onDelete;

    public EventMenu(){
        try {
            eventServices=EventServices.getInstance();

        } catch (SQLException exception) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("DataBase Connection failed");
            alert.setContentText("events list won't load unless you assure a database connection");
            alert.show();
        }
        EventObservableList=eventServices.getList();
        EventListView=new ListView<>();
        onDelete=new DeleteListener<Event>() {
            @Override
            public void onDelete(Event evenement) {
                eventServices.delete(evenement);
                EventListView.getItems().setAll((bind(eventServices.getList())));
            }
        };

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceBoxFiltre.getItems().addAll(new String[]{"Show by Newer","Show by older"});
        EventListView.getItems().setAll(bind(eventServices.getList()));
        choiceBoxFiltre.getSelectionModel().selectFirst();
        System.out.println(EventListView.getItems());
    }

    private ObservableList<AnchorPane>bind(List<Event>List){
        List<AnchorPane>anchorPaneList=new ArrayList<>();
        EventObservableList=List;
        try{
            for (Event evenement:EventObservableList){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/Views/Cells/EventCell.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                EventListViewCell itemController = fxmlLoader.getController();
                itemController.setData(evenement,onDelete);
                anchorPaneList.add(anchorPane);
            }
            return FXCollections.observableList(anchorPaneList);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }


    @FXML
    void keyTyped(KeyEvent event) {
        String text = searchField.getText();
        System.out.println(text);
        List list = eventServices.getList();
        List listFiltred = eventServices.searchEventByTitleEvent(text);
        if (text == "")
            EventListView.getItems().setAll(bind(eventServices.getList()));
        System.out.println(list+"|*****************************************|\n" +
                listFiltred);
        EventListView.getItems().setAll(bind(listFiltred));

    }

    @FXML
    void onChangeProp(ActionEvent event) {
        if(choiceBoxFiltre.getItems().get(0).equals(choiceBoxFiltre.getValue()))
            EventListView.getItems().setAll(bind(eventServices.getList()));
        else {
            List list=eventServices.getList();
            Collections.reverse(list);
            EventListView.getItems().setAll(bind(list));
        }

    }

    @FXML
    void refresh(ActionEvent event) {
        try {
            EventListView.getItems().setAll(bind(eventServices.getList()));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }


}

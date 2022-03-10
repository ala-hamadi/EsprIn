package Controllers.AdminDashboardControllers.Alert;

import Controllers.Interfaces.DeleteListener;
import Modules.AlertProf;
import Services.AlertProfServices;
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

public class AlertMenu implements Initializable {



    @FXML
    private ListView<Node> alertListView;

    @FXML
    private TextField searchField;

    @FXML
    private ComboBox<String> choiceBoxFiltre;
    private List<AlertProf>alertObservableList;
    AlertProfServices alertProfService;
    DeleteListener<AlertProf> onDelete;


    public AlertMenu(){
        try{
            alertProfService=AlertProfServices.getInstance();
        }catch (SQLException exception){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("DataBase Connection failed");
            alert.setContentText("Alerts list won't load unless you assure a database connection");
            alert.show();
        }
        alertObservableList=alertProfService.getList();
        alertListView=new ListView<>();
        onDelete=new DeleteListener<AlertProf>() {
            @Override
            public void onDelete(AlertProf alertProf) {
                alertProfService.delete(alertProf);
                alertListView.getItems().setAll(bind(alertProfService.getList()));
            }
        };
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        choiceBoxFiltre.getItems().addAll(new String[]{"Show by Newer","Show by older"});
        alertListView.getItems().setAll(bind(alertProfService.getList()));
        choiceBoxFiltre.getSelectionModel().selectFirst();
        System.out.println(alertListView.getItems());
    }

    private ObservableList<AnchorPane>bind(List<AlertProf>List){
        List<AnchorPane> anchorPaneList=new ArrayList<>();
        alertObservableList=List;
        try{
        for (AlertProf alertProf : alertObservableList) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/Views/Cells/AlertCell.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            AlertListViewCell itemController = fxmlLoader.getController();
            itemController.setData(alertProf,onDelete);
            anchorPaneList.add(anchorPane);
        }
        return FXCollections.observableList(anchorPaneList);
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
        return null;
    }
    @FXML
    private Button refreshBtn;





    @FXML
    void keyTyped(KeyEvent event) {
        String text = searchField.getText();
        System.out.println(text);
        List list = alertProfService.getList();
        List listFiltred = alertProfService.filterAlertByTitle(text, list);
        if (text == "")
            alertListView.getItems().setAll(bind(alertProfService.getList()));
        System.out.println(list+"|*****************************************|\n" +
                listFiltred);
        alertListView.getItems().setAll(bind(listFiltred));

    }

    @FXML
    void onChangeProp(ActionEvent event) {
        if(choiceBoxFiltre.getItems().get(0).equals(choiceBoxFiltre.getValue()))
            alertListView.getItems().setAll(bind(alertProfService.getList()));
        else {
            List list=alertProfService.getList();
            Collections.reverse(list);
            alertListView.getItems().setAll(bind(list));
        }

    }

    @FXML
    void refresh(ActionEvent event) {
        try {
            alertListView.getItems().setAll(bind(alertProfService.getList()));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}

package Controllers.AdminDashboardControllers.Offer;

import Controllers.Interfaces.DeleteListener;
import Modules.Offre;
import Services.OffreServices;
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

public class OfferMenu implements Initializable {


    @FXML
    private ComboBox<String> choiceBoxFiltre;

    @FXML
    private TextField searchField;

    @FXML
    private Button refreshBtn;

    @FXML
    private ListView<Node> OfferListView;

    private List<Offre>offerObservableList;
    OffreServices offreServices;
    DeleteListener<Offre> onDelete;

    public OfferMenu(){
        try {
            offreServices=OffreServices.getInstance();
        } catch (SQLException exception) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("DataBase Connection failed");
            alert.setContentText("offers list won't load unless you assure a database connection");
            alert.show();
        }
        offerObservableList=offreServices.getList();
        OfferListView=new ListView<>();
        onDelete=new DeleteListener<Offre>() {
            @Override
            public void onDelete(Offre offre) {
                offreServices.delete(offre);
                OfferListView.getItems().setAll(bind(offreServices.getList()));
            }
        };
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceBoxFiltre.getItems().addAll(new String[]{"Show by Newer","Show by older"});
        OfferListView.getItems().setAll(bind(offreServices.getList()));
        choiceBoxFiltre.getSelectionModel().selectFirst();
        System.out.println(OfferListView.getItems());
    }

    private ObservableList<AnchorPane> bind(List<Offre>List){
        List<AnchorPane> anchorPaneList=new ArrayList<>();
        offerObservableList=List;
        try{
            for (Offre offre : offerObservableList) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/Views/Cells/offerCell.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                OfferListViewCell itemController = fxmlLoader.getController();
                itemController.setData(offre,onDelete);
                anchorPaneList.add(anchorPane);
            }
            return FXCollections.observableList(anchorPaneList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }





    @FXML
    void keyTyped(KeyEvent event) {
        String text = searchField.getText();
        System.out.println(text);
        List list = offreServices.getList();
        List listFiltred = offreServices.recherche_title(text);
        if (text == "")
            OfferListView.getItems().setAll(bind(offreServices.getList()));
        System.out.println(list+"|*****************************************|\n" +
                listFiltred);
        OfferListView.getItems().setAll(bind(listFiltred));

    }

    @FXML
    void onChangeProp(ActionEvent event) {
        if(choiceBoxFiltre.getItems().get(0).equals(choiceBoxFiltre.getValue()))
           OfferListView.getItems().setAll(bind(offreServices.getList()));
        else {
            List list=offreServices.getList();
            Collections.reverse(list);
            OfferListView.getItems().setAll(bind(list));
        }

    }

    @FXML
    void refresh(ActionEvent event) {
        try {
            OfferListView.getItems().setAll(bind(offreServices.getList()));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


}

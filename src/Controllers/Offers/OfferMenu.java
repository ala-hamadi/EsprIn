package Controllers.Offers;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import Modules.Offre;
import Services.OffreServices;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

public class OfferMenu implements Initializable {

    private List<Offre> offres;
    private OffreServices offreServices;


    @FXML
    private ListView<AnchorPane> OfferListView;

    public OfferMenu() {
        try {
            offreServices = OffreServices.getInstance();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        offres = offreServices.getList();
        OfferListView = new ListView<>();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try{
            for(int i=0;i<offres.size();i++)
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/Views/Templates/OfferCell.fxml"));
                AnchorPane pane = loader.load();
                OfferCell offerCell = loader.getController();
                offerCell.setData(offres.get(i));
                OfferListView.getItems().add(pane);
            }


        }

        catch(Exception ex){

        }
    }
}

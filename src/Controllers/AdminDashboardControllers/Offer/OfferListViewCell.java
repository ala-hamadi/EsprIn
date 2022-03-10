package Controllers.AdminDashboardControllers.Offer;

import Controllers.Interfaces.DeleteListener;
import Modules.Espritien;
import Modules.Offre;
import Services.UserServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.sql.SQLException;

public class OfferListViewCell {

    @FXML
    private AnchorPane pane;

    @FXML
    private Label offerProvider;

    @FXML
    private Label OfferTitle;

    @FXML
    private Label OfferCategory;

    private Offre offre;

    DeleteListener<Offre> deleteListener;



    @FXML
    void OfferDeleted(ActionEvent event) {deleteListener.onDelete(offre); }

    public void setData(Offre offre,DeleteListener<Offre> deleteListener){
        try {
            UserServices userServices=UserServices.getInstance();
            this.deleteListener=deleteListener;
            this.offre=offre;
            Espritien espritien=(Espritien) userServices.retrive(offre.getOfferProvider());
            offerProvider.setText(espritien.getFirstName()+" "+espritien.getLastName());
            OfferTitle.setText(offre.getTitleOffer());
            OfferCategory.setText(offre.getCategory().toString());

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }

}

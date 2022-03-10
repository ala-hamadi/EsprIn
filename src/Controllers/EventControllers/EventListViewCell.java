package Controllers.EventControllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import Modules.Espritien;
import Modules.Event;
import Modules.User;
import Services.EventServices;
import Services.ParticipateServices;
import Services.UserServices;
import Utils.CurrentUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
    private Label ParticipateNb;


    @FXML
    private ImageView imageEvent;

    @FXML
    private AnchorPane pane;

    private Event event;

    @FXML
    private Label StartDate;

    @FXML
    private Label DateEvent;

    @FXML
    private Label Localisation;

    @FXML
    private Button ParticipateBtn;

    @FXML
    private Label EndDate;

    private List<User> userList;

    private UserServices userServices;

    @FXML
    private Button DeleteBtn1;

    @FXML
    private Button ModBtn1;


    public void setData(Event event){
        this.event = event;
        try {
            userServices = UserServices.getInstance();
            userList = userServices.getList();
            long idOrg= event.getIdOrganizer();
            Espritien user = (Espritien) userServices.retrive(idOrg);

            String firstname= user.getFirstName();
            String lastname= user.getLastName();
            OrgName.setText(firstname + " " + lastname);

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        if(event.getImgURL()!=null){
            Image image= new Image(event.getImgURL());
            imageEvent.setImage(image);
        }

        TitleEvent.setText(event.getTitleEvent());
        ContentEvent.setText(event.getDescription());
        StartDate.setText(String.valueOf(event.getDateDebut()));
        EndDate.setText(String.valueOf(event.getDateFin()));
        Localisation.setText(event.getEventLocal());

        ParticipateNb.setText(String.valueOf(event.getNbrParticipant()));
        if(CurrentUser.getInstance().getCurrentUser().getCinUser()!=event.getIdOrganizer()){
            DeleteBtn1.setVisible(false);
            ModBtn1.setVisible(false);
        }
    }

    @FXML
    void EventParticipate(ActionEvent e) {
        try {
            UserServices userServices = UserServices.getInstance();
            userList = userServices.getList();
            ParticipateServices participateServices = ParticipateServices.getInstance();
            int idEvent= this.event.getIdEvent();
            System.out.println(event);
            participateServices.ParticipateToEvent((int) CurrentUser.getInstance().getCurrentUser().getCinUser(),idEvent);

            int nbPartic = Integer.parseInt(ParticipateNb.getText())+1;
            ParticipateNb.setText(String.valueOf(nbPartic));

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }

    @FXML
    void DeleteEvent(ActionEvent even) throws SQLException {

        EventServices eventServices=new EventServices();
        boolean deleted=eventServices.delete(event);
        if(deleted){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("event is deleted successfully!");
            alert.show();

        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.show();
        }

    }

    @FXML
    void ModifyEvent(ActionEvent even) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/Views/Windows/ModifierEvent.fxml"));
            Parent parent = fxmlLoader.load();
            EditEventController editPostController = fxmlLoader.getController();
            editPostController.setData(event);
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

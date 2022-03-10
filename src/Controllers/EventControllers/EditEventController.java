package Controllers.EventControllers;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Modules.Event;
import Modules.Post;
import Services.EventServices;
import Services.PostServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class EditEventController {

  @FXML
  private Button AddEventBtn11;

  @FXML
  private ImageView AddImage;

  @FXML
  private Button AddImgBtn;

  @FXML
  private Button CloseBtn;

  @FXML
  private DatePicker EndDate;

  @FXML
  private TextArea EventLocation;

  @FXML
  private TextField EventTitle;

  @FXML
  private DatePicker StartDate;

  @FXML
  private Circle circle;

  @FXML
  private TextArea contentEvent;

  @FXML
  private ImageView imgAdd;

  @FXML
  private Label labAddEvent;

  @FXML
  private Label labDescription;

  @FXML
  private Label labTitle;

  @FXML
  private Label labdate;

  @FXML
  private Label labdate1;

  @FXML
  private Label labimage;

  @FXML
  private Label labimage1;

  @FXML
  private Pane pan1;
  String s;

  Event event;

  public void setData(Event event){
    this.event = event;
  }
  @FXML
  void CloseWindow(ActionEvent event) {
    Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    stage.close();
  }
  @FXML
  void EditEvent(ActionEvent even) throws SQLException {
    if ((EventTitle.getText().length()>2)&&(contentEvent.getText().length()>2)){

      EventServices eventServices= null;
      try {
        eventServices = EventServices.getInstance();
      } catch (SQLException exception) {
        exception.printStackTrace();
      }
      String Sdate = String.valueOf(StartDate.getValue());
      String Edate = String.valueOf(EndDate.getValue());
      Event ev= new Event( EventTitle.getText(),contentEvent.getText(),"https://media.timeout.com/images/105658195/image.jpg", Date.valueOf(Sdate), Date.valueOf(Edate), EventLocation.getText(), 10000000);
      ev.setIdEvent(event.getIdEvent());
      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      LocalDateTime now = LocalDateTime.now();
      String date= dtf.format(now);
      String startDate= String.valueOf(Sdate);
      String endDate= String.valueOf(Edate);

      if ((startDate.compareTo(date)>=0)&&(endDate.compareTo(startDate)>=0)){

        eventServices.update(ev);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("Event is added successfully!");
        alert.show();
        try {
          Stage stage = (Stage) ((Node) even.getSource()).getScene().getWindow();
          stage.close();
        }catch (Exception exception){
          System.out.println(exception.getMessage());
        }

      }else {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Echeec");
        alert.setContentText("date incorrect!");
        alert.show();
      }

    }else {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Echeec");
      alert.setContentText("Erooooooooor!");
      alert.show();
    }
  }


  public void AddImage(ActionEvent actionEvent) {
  }
}

package Controllers.EventControllers;


import Modules.Event;
import Services.EventServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.sql.Date;
import java.sql.SQLException;

public class AddEventController {

    @FXML
    private Button AddEventBtn;

    @FXML
    private TextField EventTitle;

    @FXML
    private Circle circle;

    @FXML
    private TextArea contentEvent;

    @FXML
    private DatePicker dateEvent;

    @FXML
    private ImageView image;

    @FXML
    private Label labAddEvent;

    @FXML
    private Label labDescription;

    @FXML
    private Label labTitle;

    @FXML
    private Label labdate;

    @FXML
    private Label labimage;

    @FXML
    private Pane pan1;

    @FXML
    private ImageView imgAdd;
    String s;


    @FXML
    void CloseWindow(ActionEvent event) {
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            stage.close();
    }

    @FXML
    void AddImage(ActionEvent event) {
      /*  JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        File f =fileChooser.getSelectedFile();
        String filename = f.getAbsolutePath();*/

       /* JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png");
        fileChooser.addChoosableFileFilter(filter);
        int result = fileChooser.showSaveDialog(null);
        if(result == JFileChooser.APPROVE_OPTION){
            File selectedFile = fileChooser.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            imgAdd.setImage(Image.impl_fromPlatformImage(path));
            s=path;
        }
        else if(result == JFileChooser.CANCEL_OPTION){
            System.out.println("No Data");
        }*/

    }

    @FXML
    void AddEvent(ActionEvent event) {
        if ((EventTitle.getText().length()>2)&&(contentEvent.getText().length()>2)){

            EventServices eventServices= new EventServices();
            String date = String.valueOf(dateEvent.getValue());
            Event ev= new Event(EventTitle.getText(),contentEvent.getText(),null, Date.valueOf(date), 10000000);

            eventServices.add(ev);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Event is added successfully!");
            alert.show();

            try {
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.close();
            }catch (Exception exception){
                System.out.println(exception.getMessage());
            }

        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Echeec");
            alert.setContentText("Erooooooooor!");
            alert.show();
        }

    }




}
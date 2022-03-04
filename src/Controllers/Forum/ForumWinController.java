package Controllers.Forum;

import java.sql.SQLException;

import Modules.Forum;
import services.ForumService;
import Utils.Enums.State;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class ForumWinController {

    @FXML
    private Button addForum;
    @FXML
    private ChoiceBox<?> destselection;

    @FXML
    private TextArea forumContent;

    @FXML
    private TextField forumTitle;
    @FXML
    private TextField forumtag;

    double x, y;
    @FXML
    void addForum(ActionEvent event) throws SQLException {
        ForumService forumService = ForumService.getInstance();
        if(forumTitle.getText().isEmpty() && forumContent.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR !");
            alert.setContentText("Forum is not added !");
            alert.show();
        } else {
            forumService.add(new Forum(1,forumTitle.getText(),forumContent.getText(),11111111,forumtag.getText(),State.Active));

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Forum is added successfully !");
            alert.show();

            forumTitle.setText("");
            forumContent.setText("");
        }

    }

    @FXML
    void closeWindow(MouseEvent event) {
        try {
            Stage stage = (Stage) ((ImageView) event.getSource()).getScene().getWindow();
            stage.close();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @FXML
    void mouseDragged(MouseEvent event) {
        Stage stage = (Stage) ((Pane) event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

    @FXML
    void mousePressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }

}

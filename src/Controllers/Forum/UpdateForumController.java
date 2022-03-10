package Controllers.Forum;

import Modules.Forum;
import Services.ForumService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.sql.SQLException;

public class UpdateForumController {

    @FXML
    private TextArea forumContent;

    @FXML
    private TextField forumTitle;

    @FXML
    private TextField forumtag;

    @FXML
    private Button updateForum;

    double x, y;
    Forum forum;

    public void setData(Forum forum){
        this.forum = forum;
        forumContent.setText(forum.getContent());
        forumTitle.setText(forum.getTitle());
        forumtag.setText(forum.getCategoryForum());
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

    @FXML
    void updateForum(ActionEvent event) throws SQLException {
        ForumService forumService = ForumService.getInstance();
        forum.setTitle(forumTitle.getText());
        forum.setContent(forumContent.getText());
        forum.setCategoryForum(forumtag.getText());
        forumService.update(forum);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("Response is updated successfully !");
        alert.show();
    }
}

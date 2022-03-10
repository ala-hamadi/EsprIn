package Controllers.Forum;

import java.io.IOException;
import java.sql.SQLException;

import Controllers.HomeFXMLController;
import Modules.Forum;
import Services.ReactedForumServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ForumCell {
    @FXML
    private Circle OrgImage;

    @FXML
    private Label category;

    @FXML
    private Text forumContent;

    @FXML
    private Label forumTitle;

    @FXML
    private Button like;

    @FXML
    private Button responded;

    @FXML
    private Label username;

    private Forum forum;
    private HomeFXMLController homeFXMLController = new HomeFXMLController();

    public void setData(Forum forum){
        this.forum = forum;
        forumTitle.setText(forum.getTitle());
        forumContent.setText(forum.getContent());
        category.setText(forum.getCategoryForum());
    }
    @FXML
    void Like(ActionEvent event) throws SQLException {
        ReactedForumServices reactedForumServices = ReactedForumServices.getInstance();
            reactedForumServices.putLikeToPost(11111111,forum.getIdForum());

    }

    @FXML
    void viewDetail(MouseEvent event) {

        try {
            Parent menu = FXMLLoader.load(getClass().getResource("/Views/Templates/ForumDetail.fxml"));
            /*homeFXMLController.getContent().getChildren().removeAll();
            homeFXMLController.getContent().getChildren().setAll(menu);*/
            Scene scene = new Scene(menu);
            Stage stage = new Stage();
            stage.setScene(scene);

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

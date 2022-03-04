package Controllers.Forum;

import java.sql.SQLException;

import Modules.Forum;
import Services.ReactedForumServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

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
}

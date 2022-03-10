package Controllers.AdminDashboardControllers.Forum;

import Controllers.Interfaces.DeleteListener;
import Modules.Espritien;
import Modules.Forum;
import Services.UserServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.sql.SQLException;

public class ForumListViewCell {

    @FXML
    private AnchorPane pane;

    @FXML
    private Label ForumOwner;

    @FXML
    private Label title;

    private Forum forum;
    DeleteListener<Forum> deleteListener;

    @FXML
    void ForumDeleted(ActionEvent event) {
        deleteListener.onDelete(forum);
    }
    public void setData(Forum forum,DeleteListener<Forum>deleteListener){
        try {
            UserServices userServices=UserServices.getInstance();
            this.deleteListener=deleteListener;
            this.forum=forum;
            Espritien espritien=(Espritien) userServices.retrive(forum.getIdOwner());
            ForumOwner.setText(espritien.getFirstName()+" "+espritien.getLastName());
            title.setText(forum.getTitle());

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }

}

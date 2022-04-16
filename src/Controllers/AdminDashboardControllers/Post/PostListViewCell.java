package Controllers.AdminDashboardControllers.Post;

import Controllers.Interfaces.DeleteListener;
import Modules.Espritien;
import Modules.Post;
import Services.UserServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.sql.SQLException;

public class PostListViewCell {

    @FXML
    private AnchorPane pane;

    @FXML
    private Label PostOwner;

    @FXML
    private Label CreatedAt;

    @FXML
    private Label Category;

    private Post post;

    DeleteListener<Post> deleteListener;

    public PostListViewCell(){
    }

    @FXML
    void PostDeleted(ActionEvent event) {
    deleteListener.onDelete(post);
    }

    public void setData(Post post,DeleteListener<Post> deleteListener){
        try {
            UserServices userServices=UserServices.getInstance();
            this.deleteListener=deleteListener;
            this.post=post;
            Espritien espritien=(Espritien) userServices.retrive(post.getIdOwner());
            PostOwner.setText(espritien.getFirstName()+" "+espritien.getLastName());
            CreatedAt.setText(post.getCreatedAt().toString());
            Category.setText(post.getCategories().toString());
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }

}

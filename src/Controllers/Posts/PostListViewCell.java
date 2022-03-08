package Controllers.Posts;

import Modules.Espritien;
import Modules.Post;
import Modules.User;
import Services.LikeServices;
import Services.UserServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

import java.sql.SQLException;
import java.util.List;

public class PostListViewCell {

    @FXML
    private AnchorPane pane;

    @FXML
    private Circle OrgImage;

    @FXML
    private Label UserName;

    @FXML
    private Label DestAn;

    @FXML
    private ImageView imagePost;

    @FXML
    private Label ContentPost;

    @FXML
    private Label CreatedAt;

    @FXML
    private Button LikeBtn;

    @FXML
    private Button CommentBtn;

    @FXML
    private Label CatPost;

    private Post post;

    private List<User> userList;

    private UserServices userServices;

    @FXML
    void Comment(ActionEvent event) {

    }




    public void setData(Post post){
        this.post = post;

        try {
            UserServices userServices = UserServices.getInstance();
            userList = userServices.getList();
            long idowner= post.getIdOwner();
            Espritien user = (Espritien) userServices.retrive(idowner);

            String firstname= user.getFirstName();
            String lastname= user.getLastName();
            UserName.setText(firstname + " " + lastname);

        } catch (SQLException exception) {
            exception.printStackTrace();
        }


        if(post.getMediaURL()!=null) {
            Image image = new Image(post.getMediaURL());
            imagePost.setImage(image);
        }
       // UserName.setText("foulen");
        CreatedAt.setText(post.getCreatedAt().toString());
        ContentPost.setText(post.getContent());
        CatPost.setText(post.getCategories().name());
        LikeBtn.setText(String.valueOf(post.getLikeNumber()));
     //   CommentBtn.setText(String.valueOf(post.getCommentNumber()));

    }


    @FXML
    void Like(ActionEvent event) {

        try {
            UserServices userServices = UserServices.getInstance();
            userList = userServices.getList();
            LikeServices likeServices = new LikeServices();
            int idPost= (int) post.getIdPost();

            likeServices.putLikeToPost(11111111,idPost);

            LikeBtn.setText(LikeBtn.getText()+1);

        } catch (SQLException exception) {
            exception.printStackTrace();
        }


    }

}

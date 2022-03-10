package Controllers.Posts;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modules.CommentPost;
import Modules.Espritien;
import Modules.Post;
import Modules.User;
import Services.CommentServices;
import Services.LikeServices;
import Services.UserServices;
import Utils.CurrentUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
    private Button ModBtn1;
    @FXML
    private Label CatPost;

    private Post post;

    private List<User> userList;

    private UserServices userServices;
    @FXML
    private Button DeleteBtn1;
    @FXML
    void Comment(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/Views/Windows/PostComments.fxml"));
            Parent parent = fxmlLoader.load();
            PostCommentsController postCommentsController = fxmlLoader.getController();
            postCommentsController.setData(post);
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public void setData(Post post) throws SQLException {
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
        CommentServices commentServices=new CommentServices();
        ArrayList<CommentPost> list= (ArrayList<CommentPost>) commentServices.getListCommentByPost(post.getIdPost());
      CommentBtn.setText(String.valueOf(list.size()));
        if(CurrentUser.getInstance().getCurrentUser().getCinUser()!=post.getIdOwner()){
            DeleteBtn1.setVisible(false);
            ModBtn1.setVisible(false);
        }

    }


    @FXML
    void Like(ActionEvent event) {

        try {
            UserServices userServices = UserServices.getInstance();
            userList = userServices.getList();
            LikeServices likeServices = new LikeServices();
            int idPost= (int) post.getIdPost();
            if(likeServices.likeExists(idPost,11111111)==0){
                likeServices.putLikeToPost(11111111,idPost);
                LikeBtn.setText(String.valueOf(Integer.parseInt(LikeBtn.getText())+1));

            }
          else{
                likeServices.putUnLikeToPost(11111111,idPost);
                LikeBtn.setText(String.valueOf(Integer.parseInt(LikeBtn.getText())-1));

            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }


    }

    @FXML
    void DeletePost(ActionEvent event) throws SQLException {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/Views/Windows/DeletePost.fxml"));
            Parent parent = fxmlLoader.load();
            DeletePostController deletePostController = fxmlLoader.getController();
            deletePostController.setData(post);
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void ModifyPost(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/Views/Windows/ModifierPost.fxml"));
            Parent parent = fxmlLoader.load();
            EditPostController editPostController = fxmlLoader.getController();
            editPostController.setData(post);
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

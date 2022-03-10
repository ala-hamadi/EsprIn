package Controllers.Posts;

import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Modules.CommentPost;
import Modules.Post;
import Services.CommentServices;
import Utils.CurrentUser;
import Utils.Enums.State;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PostCommentsController implements Initializable {

    @FXML
    private Label fTitle;

    @FXML
    private Text fcontent;

    @FXML
    private Label fcategory;

    @FXML
    private Label fdate;

    @FXML
    private Label fnbLikes;
    @FXML
    private TextField content;

    @FXML
    private Button response;

    @FXML
    private Button send;

    @FXML
    private ListView<Node> responseList;
    private List<CommentPost> comments;
    Post post;
    int id;


    public void setData(Post post) {
        this.post = post;
        this.id = (int) post.getIdPost();
        try {
            CommentServices commentServices = new CommentServices();
            comments = commentServices.getListCommentByPost(id);
            for (int i = 0; i < comments.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/Views/Templates/CommentCell.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                CommentCell itemController = fxmlLoader.getController();
                itemController.setData(comments.get(i));
                responseList.getItems().add(anchorPane);
                System.out.println(comments.get(i));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage()+"err");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public PostCommentsController() {
        comments = new ArrayList<CommentPost>();

        responseList = new ListView<>();


    }
    @FXML
    void addResponse(ActionEvent event) throws SQLException{
        CommentServices commentServices = new CommentServices();
        if(content.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR !");
            alert.setContentText("Forum is not added !");
            alert.show();
        } else {
            commentServices.addCommentToPost(new CommentPost((int) CurrentUser.getInstance().getCurrentUser().getCinUser(),id,content.getText(), Timestamp.valueOf(LocalDateTime.now()), State.Active));

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Response is added successfully !");
            alert.show();

           content.setText("");
        }
    }

    @FXML
    void CloseWindow(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();
    }


}

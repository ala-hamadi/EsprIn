package Controllers.Posts;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Modules.Post;
import Services.PostServices;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;


public class PostMenuController implements Initializable {


  @FXML
  private ListView<Node> eventListView;
  private List<Post> postList;

  public PostMenuController() throws SQLException {
    PostServices postServices = null;
    try {
      postServices = new PostServices();
    } catch (SQLException exception) {
      exception.printStackTrace();
    }

    postList = new ArrayList<Post>();
    postList = postServices.getListPosts();
    System.out.println(postList);
    eventListView = new ListView<>();

  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    try {
      for (int i = 0; i < postList.size(); i++) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/Views/Templates/PostCell.fxml"));
        AnchorPane anchorPane = fxmlLoader.load();
        PostListViewCell itemController = fxmlLoader.getController();
        itemController.setData(postList.get(i));
        eventListView.getItems().add(anchorPane);

      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

}
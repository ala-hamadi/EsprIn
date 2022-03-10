package Controllers.Posts;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Modules.Post;
import Services.PostServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


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

  @FXML
  void all(ActionEvent event) throws SQLException {
    PostServices postServices=new PostServices();
    postList=postServices.getListPosts();
    eventListView.getItems().clear();
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

  @FXML
  void covoiturage(ActionEvent event) throws SQLException {
    PostServices postServices=new PostServices();
    postList=postServices.filterPostByCategory("Covoiturage",postList);
    eventListView.getItems().clear();
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

  @FXML
  void defaultPost(ActionEvent event) throws SQLException {
    PostServices postServices=new PostServices();
    postList=postServices.filterPostByCategory("Default",postList);
    eventListView.getItems().clear();
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

  @FXML
  void lostandfound(ActionEvent event) throws SQLException {
    PostServices postServices=new PostServices();
    postList=postServices.filterPostByCategory("Lost_and_found",postList);
    eventListView.getItems().clear();
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

  @FXML
  void meme(ActionEvent event) throws SQLException {
    PostServices postServices=new PostServices();
    postList=postServices.filterPostByCategory("Meme",postList);
    eventListView.getItems().clear();
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

  @FXML
  void suggestion(ActionEvent event) throws SQLException {
    PostServices postServices=new PostServices();
    postList=postServices.filterPostByCategory("Suggestion",postList);
    eventListView.getItems().clear();
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

  @FXML
  void seeWeather(ActionEvent event) throws SQLException {
    try {
      FXMLLoader fxmlLoader = new FXMLLoader();
      fxmlLoader.setLocation(getClass().getResource("/Views/Windows/primary.fxml"));
      Parent parent = fxmlLoader.load();
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

package Controllers.Posts;

import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import Modules.Post;
import Services.PostServices;
import Utils.Enums.CategoryPost;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class EditPostController  implements Initializable {
  Post post;

  @FXML
  private TextField contentPost;

  @FXML
  private Button EditPostBtn;

  @FXML
  void CloseWindow(MouseEvent event) {
    Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    stage.close();
  }
  @FXML
  private ChoiceBox<CategoryPost> catPost;

  public void setData(Post post){
    this.post = post;
  }


  @FXML
  void EditPost(ActionEvent event) throws SQLException {
    if (contentPost.getText().length()>2){
      PostServices postServices=new PostServices();
      Post postMod =new Post((int) post.getIdPost(),contentPost.getText(),"https://vivreaberlin.com/wp-content/uploads/2015/07/4455_a6b402d1c41e.jpg.",post.getLikeNumber(), Timestamp.valueOf(LocalDateTime.now()),10000000,catPost.getValue());
      postServices.updatePost(postMod);
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("Success");
      alert.setContentText("Alert is added successfully!");
      alert.show();

      try{
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
      }catch (Exception exception){
        System.out.println(exception.getMessage());
      }
    }else{
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Erreur");
      alert.setContentText("Merci de mettre un titre ou une description valide à l'alerte");
      alert.show();
    }
  }




  @Override
  public void initialize(URL location, ResourceBundle resources) {
    CategoryPost[] categories = CategoryPost.values();
    catPost.getItems().addAll(categories);
    catPost.setValue(categories[0]);
  }
}

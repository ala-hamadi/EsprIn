package Controllers.Posts;

import java.sql.SQLException;

import Modules.Post;
import Services.PostServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class DeletePostController {

  @FXML
  private Button CloseBtn;

  @FXML
  private Circle circle;

  @FXML
  private Button deleteBtn;

  @FXML
  private Button keepBtn;

  Post post;

  public void setData(Post post){
    this.post = post;
  }

  @FXML
  void CloseWindow(ActionEvent event) {
    Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    stage.close();
  }

  @FXML
  void deleteAlert(ActionEvent event) throws SQLException {

            PostServices postServices=new PostServices();
            boolean deleted=postServices.deletePost((int) post.getIdPost());
            if(deleted){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setContentText("Alert is added successfully!");
                alert.show();

            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setContentText("Merci de mettre un titre ou une description valide à l'alerte");
                alert.show();
            }
  }

  @FXML
  void keepAlert(ActionEvent event) {
    Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    stage.close();
  }

}

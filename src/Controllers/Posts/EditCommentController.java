package Controllers.Posts;

import java.sql.SQLException;

import Modules.CommentPost;
import Services.CommentServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class EditCommentController {

  CommentPost comment;

  @FXML
  private TextField contentComment;

  @FXML
  private Button EditPostBtn;

  @FXML
  void CloseWindow(MouseEvent event) {
    Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    stage.close();
  }
  public void setData(CommentPost comment) {
    this.comment = comment;
  }


  @FXML
  void EditComment(ActionEvent event) throws SQLException {
    if (contentComment.getText().length()>0){
      CommentServices commentServices=new CommentServices();
      CommentPost commMod =new CommentPost(comment.getIdUser(),comment.getIdPost(),contentComment.getText(),comment.getCreatedAt());
      commentServices.updateCommentByPost(commMod);
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("Success");
      alert.setContentText("Comment is updated successfully!");
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
      alert.show();
    }
  }
}

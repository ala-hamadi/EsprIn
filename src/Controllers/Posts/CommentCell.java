package Controllers.Posts;

import java.io.IOException;
import java.sql.SQLException;

import Modules.CommentPost;
import Services.CommentServices;
import Utils.CurrentUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CommentCell {
    @FXML
    private Text content;

    @FXML
    private Label username;

    @FXML
    private Button DeleteBtn1;

    @FXML
    private Button ModBtn1;

    CommentPost comment;
    public void setData(CommentPost comment) {
        this.comment = comment;

        content.setText(comment.getContent());
        if(CurrentUser.getInstance().getCurrentUser().getCinUser()!=comment.getIdUser()){
            DeleteBtn1.setVisible(false);
            ModBtn1.setVisible(false);

        }
    }

    @FXML
    void ModifyPost(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/Views/Windows/ModifierComment.fxml"));
            Parent parent = fxmlLoader.load();
            EditCommentController editCommentController = fxmlLoader.getController();
            editCommentController.setData(comment);
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
    void DeletePost(ActionEvent event) throws SQLException {

        CommentServices commentServices=new CommentServices();
        boolean deleted=commentServices.deleteCommentByPost(comment);
        System.out.println(comment+"aze");
        if(deleted){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Comment is deleted successfully!");
            alert.show();

        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.show();
        }
    }


}

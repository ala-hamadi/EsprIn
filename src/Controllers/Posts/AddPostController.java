package Controllers.Posts;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import Utils.Enums.Categories;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Post;
import services.PostServices;

public class AddPostController {

    @FXML
    private TextArea ContentAlert;


    double x, y;
    @FXML
    public void mouseDragged(MouseEvent mouseEvent) {
        Stage stage = (Stage) ((Pane) mouseEvent.getSource()).getScene().getWindow();
        stage.setX(mouseEvent.getScreenX() - x);
        stage.setY(mouseEvent.getScreenY() - y);
    }
    @FXML
    public void mousePressed(MouseEvent mouseEvent) {
        x = mouseEvent.getSceneX();
        y = mouseEvent.getSceneY();
    }
    @FXML
    public void closeWindow(MouseEvent mouseEvent) {
        try {
            Stage stage = (Stage) ((ImageView) mouseEvent.getSource()).getScene().getWindow();
            stage.close();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

    }



    public void AddPost(javafx.event.ActionEvent event) {
        if (ContentAlert.getText().length()>2){
            PostServices postServices=new PostServices();
            Post post =new Post(2,ContentAlert.getText(),"10000000",0, Timestamp.valueOf(LocalDateTime.now()),"10000000", Categories.Covoiturage);
            postServices.addPost(post);
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
}

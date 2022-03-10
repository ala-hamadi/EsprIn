package Controllers.Posts;

import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import Modules.Post;
import Services.PostServices;
import Utils.Enums.Categories;
import Utils.Enums.CategoryPost;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
public class AddPostController implements Initializable {

    @FXML
    private Button AddPostBtn;

    @FXML
    private ChoiceBox<CategoryPost> catPost;

    @FXML
    private Circle circle;

    @FXML
    private TextField contentPost;

    @FXML
    private ImageView image;

    @FXML
    private Label labAddOffer;

    @FXML
    private Label labDescription;

    @FXML
    private Label labdate;

    @FXML
    private Label labimage;

    @FXML
    private Pane pan1;


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
    void CloseWindow(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();
    }


    @FXML
    public void AddPost(javafx.event.ActionEvent event) throws SQLException {
        if (contentPost.getText().length()>2){
            PostServices postServices=new PostServices();
            Post post =new Post(2,contentPost.getText(),"https://vivreaberlin.com/wp-content/uploads/2015/07/4455_a6b402d1c41e.jpg.",0, Timestamp.valueOf(LocalDateTime.now()),10000000,catPost.getValue());
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
         CategoryPost[] categories = CategoryPost.values();
        catPost.getItems().addAll(categories);
        catPost.setValue(categories[0]);
    }
}

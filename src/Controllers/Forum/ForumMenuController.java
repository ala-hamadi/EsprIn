package Controllers.Forum;

import Modules.Forum;
import Services.ForumService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ForumMenuController implements Initializable {
    @FXML
    private ListView<Node> forumListView;
    private List<Forum> forumObservableList;

    @FXML
    private Button AddForumBtn;

    public ForumMenuController() throws SQLException {
        ForumService forumService = ForumService.getInstance();
        forumObservableList = new ArrayList<Forum>();
        /*forumObservableList.add(new Forum(1,"title","descriptoon qdhq dqjhqshfjsqhf "));
        forumObservableList.add(new Forum(1,"title","descriptoon qdhq dqjhqshfjsqhf "));
        forumObservableList.add(new Forum(1,"title","descriptoon qdhq dqjhqshfjsqhf "));*/
        forumObservableList = forumService.getList();
       forumListView = new ListView<>();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            for (int i=0; i< forumObservableList.size(); i++){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/Views/Templates/ForumCell.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                ForumCell itemController = fxmlLoader.getController();
                itemController.setData(forumObservableList.get(i));
                forumListView.getItems().add(anchorPane);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void addForum(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/Views/Windows/AddForumWindow.fxml"));
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

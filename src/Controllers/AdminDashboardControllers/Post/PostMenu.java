package Controllers.AdminDashboardControllers.Post;

import Controllers.Interfaces.DeleteListener;
import Modules.Post;
import Services.PostServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public class PostMenu implements Initializable {

    @FXML
    private ComboBox<String> choiceBoxFiltre;

    @FXML
    private TextField searchField;

    @FXML
    private Button refreshBtn;

    @FXML
    private ListView<Node> PostListView;

    private  List<Post>PostObservableList;
    PostServices postServices;
    DeleteListener<Post> onDelete;

    public PostMenu(){
        try {
            postServices=new PostServices();
        } catch (SQLException exception) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("DataBase Connection failed");
            alert.setContentText("posts list won't load unless you assure a database connection");
            alert.show();
        }
        PostObservableList=postServices.getListPosts();
        PostListView=new ListView<>();
        onDelete=new DeleteListener<Post>() {
            @Override
            public void onDelete(Post post) {
                postServices.deletePost((int) post.getIdPost());
                PostListView.getItems().setAll(bind(postServices.getListPosts()));
            }
        };
    }



    @FXML
    void keyTyped(KeyEvent event) {
        String text = searchField.getText();
        System.out.println(text);
        List list = postServices.getListPosts();
        List listFiltred = postServices.filterPostByCategory(text,list);
        if (text == "")
            PostListView.getItems().setAll(bind(postServices.getListPosts()));
        System.out.println(list+"|*****************************************|\n" +
                listFiltred);
        PostListView.getItems().setAll(bind(listFiltred));


    }

    @FXML
    void onChangeProp(ActionEvent event) {
        if(choiceBoxFiltre.getItems().get(0).equals(choiceBoxFiltre.getValue()))
            PostListView.getItems().setAll(bind(postServices.getListPosts()));
        else {
            List list=postServices.getListPosts();
            Collections.reverse(list);
            PostListView.getItems().setAll(bind(list));
        }

    }

    @FXML
    void refresh(ActionEvent event) {
        try {
            PostListView.getItems().setAll(bind(postServices.getListPosts()));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceBoxFiltre.getItems().addAll(new String[]{"Show by newer","Show by older"});

        PostListView.getItems().setAll(bind(postServices.getListPosts()));

        choiceBoxFiltre.getSelectionModel().selectFirst();
        System.out.println(PostListView.getItems());

    }
    private ObservableList<AnchorPane>bind(List<Post>List){
        List<AnchorPane> anchorPaneList=new ArrayList<>();
        PostObservableList=List;
        try{
            for (Post post : PostObservableList) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/Views/Cells/PostCell.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                PostListViewCell itemController = fxmlLoader.getController();
                itemController.setData(post,onDelete);
                anchorPaneList.add(anchorPane);
            }
            return FXCollections.observableList(anchorPaneList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}

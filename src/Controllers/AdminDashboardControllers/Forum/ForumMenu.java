package Controllers.AdminDashboardControllers.Forum;

import Controllers.Interfaces.DeleteListener;
import Modules.Forum;
import Services.ForumService;
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

public class ForumMenu implements Initializable {

    @FXML
    private ComboBox<String> choiceBoxFiltre;

    @FXML
    private TextField searchField;

    @FXML
    private Button refreshBtn;

    @FXML
    private ListView<Node> forumListView;

    private List<Forum> ForumObservableList;
    ForumService forumService;
    DeleteListener<Forum> onDelete;

    public ForumMenu(){
        try {
            forumService=ForumService.getInstance();
        } catch (SQLException exception) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("DataBase Connection failed");
            alert.setContentText("Forums list won't load unless you assure a database connection");
            alert.show();
        }
        ForumObservableList=forumService.getList();
        forumListView=new ListView<>();
        onDelete=new DeleteListener<Forum>() {
            @Override
            public void onDelete(Forum forum) {
                forumService.delete(forum);
                forumListView.getItems().setAll(bind(forumService.getList()));
            }
        };
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceBoxFiltre.getItems().addAll(new String[]{"Show by Newer","Show by older"});
        forumListView.getItems().setAll(bind(forumService.getList()));
        choiceBoxFiltre.getSelectionModel().selectFirst();
        System.out.println(forumListView.getItems());

    }
    private ObservableList<AnchorPane> bind(List<Forum>List){
        List<AnchorPane> anchorPaneList=new ArrayList<>();
        ForumObservableList=List;
        try{
            for (Forum forum : ForumObservableList) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/Views/Cells/ForumCell.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                ForumListViewCell itemController = fxmlLoader.getController();
                itemController.setData(forum,onDelete);
                anchorPaneList.add(anchorPane);
            }
            return FXCollections.observableList(anchorPaneList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }



    @FXML
    void keyTyped(KeyEvent event) {
        String text = searchField.getText();
        System.out.println(text);
        List list = forumService.getList();
        List listFiltred = forumService.searchByTitle(text);
        if (text == "")
            forumListView.getItems().setAll(bind(forumService.getList()));
        System.out.println(list+"|*****************************************|\n" +
                listFiltred);
        forumListView.getItems().setAll(bind(listFiltred));

    }

    @FXML
    void onChangeProp(ActionEvent event) {
        if(choiceBoxFiltre.getItems().get(0).equals(choiceBoxFiltre.getValue()))
            forumListView.getItems().setAll(bind(forumService.getList()));
        else {
            List list=forumService.getList();
            Collections.reverse(list);
            forumListView.getItems().setAll(bind(list));
        }

    }

    @FXML
    void refresh(ActionEvent event) {
        try {
            forumListView.getItems().setAll(bind(forumService.getList()));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}

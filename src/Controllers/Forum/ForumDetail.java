package Controllers.Forum;

import Controllers.Response.ResponseCell;
import Modules.Espritien;
import Modules.Forum;
import Modules.Responded;
import Services.ReactedForumServices;
import Services.RespondedService;
import Services.UserServices;
import Utils.CurrentUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ForumDetail implements Initializable {

    @FXML
    private Label fTitle;

    @FXML
    private Text fcontent;

    @FXML
    private Label fcategory;

    @FXML
    private Label fdate;

    @FXML
    private Label fnbLikes;
    @FXML
    private TextField content;

    @FXML
    private Button response;

    @FXML
    private Button send;

    @FXML
    private Button like;


    @FXML
    private ListView<Node> responseList;


    @FXML
    private Label username1;
    private List<Responded> respondeds;
    Forum forum;
    int id;


    public void setData(Forum forum) {
        this.forum = forum;
        this.id = forum.getIdForum();
        fTitle.setText(forum.getTitle());
        fcontent.setText(forum.getContent());
        fcategory.setText(forum.getCategoryForum());
        fdate.setText(String.valueOf(forum.getCreatedAt()));
        fnbLikes.setText(Integer.toString(forum.getNbLikes()));

        try {
            UserServices userServices = UserServices.getInstance();
            Espritien espritien = (Espritien) userServices.retrive(forum.getIdOwner());
            username1.setText(espritien.getFirstName());
            RespondedService respondedService = RespondedService.getInstance();
            System.out.println(forum.getIdForum());
            respondeds = respondedService.getListCommentByPost(id);
            for (int i = 0; i < respondeds.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/Views/Templates/ResponseCell.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                ResponseCell itemController = fxmlLoader.getController();
                itemController.setData(respondeds.get(i));
                responseList.getItems().add(anchorPane);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    public ForumDetail() {
        respondeds = new ArrayList<Responded>();
        responseList = new ListView<>();
    }

    @FXML
    void addResponse(ActionEvent event) throws SQLException{
        RespondedService respondedService = RespondedService.getInstance();
        if(content.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR !");
            alert.setContentText("Forum is not added !");
            alert.show();
        } else {
            respondedService.add(new Responded((int) CurrentUser.getInstance().getCurrentUser().getCinUser(),id,content.getText()));

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Response is added successfully !");
            alert.show();

           content.setText("");
        }
    }

    @FXML
    void showResponse(ActionEvent event) {

    }
    @FXML
    void like(ActionEvent event) throws SQLException{
        ReactedForumServices reactedForumServices = ReactedForumServices.getInstance();
        if(reactedForumServices.likeExists(forum.getIdForum(),CurrentUser.getInstance().getCurrentUser().getCinUser()) ==0){
            reactedForumServices.putLikeToPost((int) CurrentUser.getInstance().getCurrentUser().getCinUser(), forum.getIdForum());
            fnbLikes.setText(String.valueOf(forum.getNbLikes()+1));
        }else {
            reactedForumServices.putUnLikeToPost((int) CurrentUser.getInstance().getCurrentUser().getCinUser(), forum.getIdForum());
            fnbLikes.setText(String.valueOf(forum.getNbLikes()-1));
        }
    }

}

package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import model.Post;

public class PostListViewCell {

    @FXML
    private AnchorPane pane;

    @FXML
    private Circle OrgImage;

    @FXML
    private Label TitleAnn;

    @FXML
    private Label DestAn;

    @FXML
    private ImageView imageEvent;

    @FXML
    private Label ContentAnn;

    @FXML
    private Label DateAnn;

    public void setData(Post post){
        TitleAnn.setText("foulen");
        DestAn.setText(post.getCreatedAt().toString());
       ContentAnn.setText(post.getContent());
    }
}

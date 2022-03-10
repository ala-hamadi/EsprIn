package Controllers;

import Services.UserServices;
import Utils.CropImg;
import Utils.CurrentUser;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class ImgCropInterface implements Initializable {
    public ImageView image;
    public Circle idCircle;
    public AnchorPane anchorPane;
    File imageFile;
    double orgSceneX;
    double orgSceneY;

    public void mouseDragged(MouseEvent mouseEvent) {
        double offsetX = mouseEvent.getSceneX() - orgSceneX;
        double offsetY = mouseEvent.getSceneY() - orgSceneY;
        idCircle.setCenterX(idCircle.getCenterX() + offsetX);
        idCircle.setCenterY(idCircle.getCenterY() + offsetY);
        orgSceneX = mouseEvent.getSceneX();
        orgSceneY = mouseEvent.getSceneY();
    }

    public void mousePressed(MouseEvent mouseEvent) {
        orgSceneX = mouseEvent.getSceneX();
        orgSceneY = mouseEvent.getSceneY();
    }

    public void onCrop(ActionEvent actionEvent) {
        try {
            UserServices userServices = UserServices.getInstance();
            CropImg.crop(idCircle.getBoundsInParent(), image, imageFile);
            CurrentUser.getInstance().getCurrentUser().setImgUrl(imageFile.getName());
            userServices.updateImg(CurrentUser.getInstance().getCurrentUser());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.close();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void setImageFile(File imageFile) {
        this.imageFile = imageFile;
    }

    public void setImage(Image imageImported) {
       this.image.setImage(imageImported);
        System.out.println(image);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            image.setImage(new Image(new FileInputStream(imageFile)));
            System.out.println(image);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}

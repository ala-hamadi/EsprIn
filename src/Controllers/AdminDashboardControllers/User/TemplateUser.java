package Controllers.AdminDashboardControllers.User;

import Controllers.Interfaces.BanUserListener;
import Controllers.Interfaces.DeleteListener;
import Modules.Espritien;
import Modules.Extern;
import Modules.User;
import Utils.Enums.Roles;
import Utils.Enums.State;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.sql.Date;
import java.time.LocalDate;

public class TemplateUser {
    @FXML
    public Circle userAvatar;
    @FXML
    public Label userFirstName;
    @FXML
    public Label userLastName;
    @FXML
    public Label userRole;
    @FXML
    public Label userCreationDate;
    @FXML
    public Label userState;

    private User user;
    BanUserListener banUserListener;
    DeleteListener<User> deleteUserListener;

    public void setData(User user,BanUserListener banUserListener,DeleteListener<User> deleteUserListener) {

        try{
            Image image = new Image("/Img/" + user.getImgUrl(), false);
            this.userAvatar.setFill(new ImagePattern(image));
        }catch (Exception exception){
            System.out.println(user+"\n");
            System.out.println(exception.getMessage());
            Image image=new Image("https://www.jbrhomes.com/wp-content/uploads/blank-avatar.png",false);
            this.userAvatar.setFill(new ImagePattern(image));


        }


        this.user=user;
        if(user.getRole()!= Roles.Extern) {
            Espritien espritien=(Espritien)user;
            this.userFirstName.setText(espritien.getFirstName());
            this.userLastName.setText(espritien.getLastName());
        }
        else {
            Extern extern=(Extern)user;
            this.userFirstName.setText(extern.getEntrepriseName());
            this.userLastName.setText(extern.getAdresse());
        }
        this.userRole.setText(user.getRole().name());
        this.userCreationDate.setText(user.getCreatedAt().toString());
        this.userState.setText(user.getState().name());
        this.deleteUserListener=deleteUserListener;
        this.banUserListener=banUserListener;

    }

    public void onBanUser(ActionEvent actionEvent) {
        banUserListener.onBanUser(user);
    }

    public void onDeleteUser(ActionEvent actionEvent) {
        deleteUserListener.onDelete(user);
    }
}

package Controllers.AdminDashboardControllers.User;

import Controllers.Interfaces.BanUserListener;
import Controllers.Interfaces.DeleteListener;
import Modules.User;
import services.UserServices;
import Utils.Enums.State;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class UsersMenu implements Initializable {
    @FXML
    public GridPane usersGrid;

    private List<User> userList;

    private UserServices userServices;

    DeleteListener<User> userDeleteListener;

    BanUserListener banUserListener;

    public UsersMenu() {
        usersGrid = new GridPane();
        try {
            userServices = UserServices.getInstance();
            userList = userServices.getList();
            userDeleteListener = new DeleteListener<User>() {
                @Override
                public void onDelete(User user) {
                    userServices.delete(user);
                    bind(userServices.getList());
                }
            };
            banUserListener = new BanUserListener() {
                @Override
                public void onBanUser(User user) {
                    if (user.getState() != State.Disabled) {
                        userServices.changeState(user, State.Disabled);
                        bind(userServices.getList());
                    }
                    else {
                        userServices.changeState(user, State.Disconnected);
                        bind(userServices.getList());
                    }
                }
            };
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void bind(List<User> list) {
        usersGrid.getChildren().clear();
        int rows = 0;
        int columns = 0;
        try {
            for (int i = 0; i < userList.size(); i++) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/Views/Templates/TemplateUser.fxml"));
                AnchorPane userTemplate = loader.load();
                TemplateUser userTemplateController = loader.getController();
                userTemplateController.setData(list.get(i), banUserListener, userDeleteListener);
                usersGrid.add(userTemplate, columns++, rows);
                if (columns == 3) {
                    columns = 0;
                    rows++;
                }
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bind(userServices.getList());
    }
}

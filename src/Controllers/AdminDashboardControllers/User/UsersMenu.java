package Controllers.AdminDashboardControllers.User;

import Controllers.Interfaces.BanUserListener;
import Controllers.Interfaces.DeleteListener;
import Modules.User;
import Services.UserServices;
import Utils.Enums.Roles;
import Utils.Enums.State;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class UsersMenu implements Initializable {
    @FXML
    public GridPane usersGrid;
    @FXML
    public ComboBox roleSelector;
    @FXML
    public TextField searchBar;

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
        roleSelector.getItems().addAll(new String[]{"Show All","Show Admins","Show Students","Show Clubs","Show Professors","Show Externals"});
        roleSelector.getSelectionModel().selectFirst();
    }

    public void onSelection(ActionEvent actionEvent) {
        List list = userServices.getList();
        switch ((String) roleSelector.getValue()){
            case "Show All":
                System.out.println("all");
                bind(userServices.getList());
                break;
            case "Show Admins":
                System.out.println("admins");
                bind(userServices.filtreByRole(Roles.Admin));
                break;
            case "Show Students":
                System.out.println("students");
                bind(userServices.filtreByRole(Roles.Etudiant));
                break;
            case "Show Clubs":
                System.out.println("clubs");
                bind(userServices.filtreByRole(Roles.Club));
                break;
            case "Show Professors":
                System.out.println("profs");
                bind(userServices.filtreByRole(Roles.Professeur));
                break;
            case "Show Externals":
                System.out.println("externals");
                bind(userServices.filtreByRole(Roles.Externe));
                break;
        }
    }

    public void onUserSearched(KeyEvent keyEvent) {
        String text = searchBar.getText();
        System.out.println(text);
        List list = userServices.getList();
        List listFiltred = userServices.searchByName(text);
        if (text == "")
            bind(userServices.getList());
        System.out.println(list+"|*****************************************|\n" +
                listFiltred);
        bind(listFiltred);
    }
}

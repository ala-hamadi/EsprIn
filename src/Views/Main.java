package Views;

import Modules.User;
import Services.UserServices;
import Utils.CurrentUser;
import Utils.Enums.Roles;
import Utils.RessorcesManager;
import Utils.UserSerializableData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class Main extends Application {
    double x, y;

    @Override
    public void start(Stage primaryStage) throws Exception {
        String url;
//        url = "/Views/UI/Announcement/AnnounceMenu.fxml";
//        Parent root = FXMLLoader.load(getClass().getResource(url));

       if (isUserConnected()) {
            if (CurrentUser.getInstance().getCurrentUser().getRole().equals(Roles.Admin))
                url = "/Views/UI/Dashboard/DashboardMain.fxml";
            else
                url = "/Views/UI/HomeTemplate.fxml";
        } else
            url = "/Views/UI/LoginInterface.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(url));
        primaryStage.setTitle("Hello World");
        try {
            Image image = new Image("Views/Icons/appicon.png");
            primaryStage.getIcons().add(image);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }


        primaryStage.setMaximized(true);
        //primaryStage.initStyle(StageStyle.UNDECORATED);

        primaryStage.setResizable(true);
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setScene(new Scene(root, 1080, 720));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public boolean isUserConnected() {
        try {
            UserServices userServices = UserServices.getInstance();
            UserSerializableData data = (UserSerializableData) RessorcesManager.load("loggedUser.bin");
            CurrentUser.setInstance(userServices.retrive(data.userId));
            User user=CurrentUser.getInstance().getCurrentUser();
            System.out.println(user);
            return true;

        } catch (FileNotFoundException e) {
            System.out.println("User Not Found");
            return false;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getException());
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }
}

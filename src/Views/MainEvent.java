package Views;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainEvent extends Application {

    Parent parent;
    Stage stage;

    @Override
   public void start(Stage primaryStage) {
        this.stage = primaryStage;
        try {
            parent = FXMLLoader.load(getClass().getResource("/Views/UI/Login.fxml"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.out.println("erreur");
        }
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Add and Show Persons");
        stage.show();
    }
   /* public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/Views/UI/.fxml"));
        primaryStage.setTitle("Hello World");
        try {
            Image image = new Image("Views/Images/appicon.png");
            primaryStage.getIcons().add(image);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        primaryStage.setMaximized(true);
        //primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setScene(new Scene(root, 1080, 720));
        primaryStage.show();
    }*/


    public static void main(String[] args) {
        launch(args);
    }


}

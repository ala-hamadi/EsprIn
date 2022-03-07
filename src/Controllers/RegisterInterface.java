package Controllers;

import Modules.Club;
import Modules.Professor;
import Modules.Student;
import Services.UserServices;
import Utils.CurrentUser;
import Utils.Enums.Domaine;
import Utils.Enums.Roles;
import Utils.Enums.TypeClub;
import Utils.RessorcesManager;
import Utils.Structure.Classe;
import Utils.UserSerializableData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class RegisterInterface implements Initializable {

    //region variables
    @FXML
    private TextField cinNumberInput;

    @FXML
    private ComboBox<Roles> roleSelection;
    @FXML
    private TextField classLvl;

    @FXML
    private TextField classNum;

    @FXML
    private TextField classSoec;

    @FXML
    private VBox classVbox;

    @FXML
    private ComboBox<TypeClub> clubTypeSelection;

    @FXML
    private ComboBox<Domaine> domaineSelection;

    @FXML
    private VBox domaineVBox;

    @FXML
    private TextField emailInput;

    @FXML
    private TextField firstNameInput;

    @FXML
    private TextField lastNameInput;

    @FXML
    private PasswordField passwordInput;

    @FXML
    private PasswordField passwordInputConfirm;

    @FXML
    private StackPane registerContent;


    @FXML
    private VBox typeClubVBox;

    //endregion


    public RegisterInterface() {
        roleSelection = new ComboBox<>();
        clubTypeSelection = new ComboBox<>();
        domaineSelection = new ComboBox<>();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        roleSelection.getItems().addAll(new Roles[]{Roles.Etudiant, Roles.Club, Roles.Professeur});
        clubTypeSelection.getItems().addAll(TypeClub.values());
        domaineSelection.getItems().addAll(Domaine.values());
        clubTypeSelection.getSelectionModel().selectFirst();
        domaineSelection.getSelectionModel().selectFirst();
    }

    public void selectRole(ActionEvent actionEvent) {
        switch (roleSelection.getValue()) {
            case Club:
                typeClubVBox.setVisible(true);
                domaineVBox.setVisible(false);
                classVbox.setVisible(false);
                break;
            case Professeur:
                typeClubVBox.setVisible(false);
                domaineVBox.setVisible(true);
                classVbox.setVisible(false);
                break;
            case Etudiant:
                typeClubVBox.setVisible(false);
                domaineVBox.setVisible(true);
                classVbox.setVisible(true);
                break;

        }
    }

    public void onCreateUser(ActionEvent actionEvent) {
        try {
            UserServices userServices = UserServices.getInstance();
            if ((!emailInput.getText().matches("[a-z A-Z]+[/.][a-z]+(@esprit.tn)"))
                    || (firstNameInput.getText().length() <= 2)
                    || (!cinNumberInput.getText().matches("^[0-9]+[0-9]*$"))
                    || (lastNameInput.getText().length() <= 2)
                    || (passwordInput.getText().length() <= 4)
                    || (!passwordInput.getText().equals(passwordInputConfirm.getText()))
                    || (roleSelection.getValue().equals(null))
            ) {
                Alert alert=new Alert(Alert.AlertType.ERROR,"Try Again");
                alert.show();
            } else {
                switch (roleSelection.getValue()) {
                    case Etudiant:
                        if ((!domaineSelection.getValue().equals(null))
                                && (!classLvl.getText().equals(null))
                                && (!classNum.getText().equals(null))
                                && (!classSoec.getText().equals(null))
                        ) {
                            Student student=new Student(Long.parseLong(cinNumberInput.getText())
                                    , emailInput.getText()
                                    , passwordInput.getText()
                                    , ""
                                    , Roles.Etudiant
                                    , firstNameInput.getText()
                                    , lastNameInput.getText()
                                    , new Classe(Integer.parseInt(classLvl.getText()), classSoec.getText(), Integer.parseInt(classNum.getText()))
                                    , domaineSelection.getValue()
                            );
                            userServices.add(student);
                            CurrentUser.setInstance(student);
                            UserSerializableData data = new UserSerializableData();
                            data.userId = CurrentUser.getInstance().getCurrentUser().getCinUser();
                            try {
                                RessorcesManager.save(data, "loggedUser.bin");
                            } catch (IOException e) {
                                System.out.println(e.getMessage());
                            }
                            redirect("/Views/UI/HomeTemplate.fxml");
                        }
                        break;
                    case Professeur:
                        if (!domaineSelection.getValue().equals(null)){
                            Professor professor=new Professor(
                                    Long.parseLong(cinNumberInput.getText())
                                    , emailInput.getText()
                                    , passwordInput.getText()
                                    , ""
                                    , Roles.Professeur
                                    , firstNameInput.getText()
                                    , lastNameInput.getText()
                                    ,domaineSelection.getValue()
                            );
                            userServices.add(professor);
                            CurrentUser.setInstance(professor);
                            UserSerializableData data = new UserSerializableData();
                            data.userId = CurrentUser.getInstance().getCurrentUser().getCinUser();
                            try {
                                RessorcesManager.save(data, "loggedUser.bin");
                            } catch (IOException e) {
                                System.out.println(e.getMessage());
                            }
                            redirect("/Views/UI/HomeTemplate.fxml");
                        }

                        break;
                    case Club:
                        if(!clubTypeSelection.getValue().equals(null)){
                            Club club=new Club(
                                    Long.parseLong(cinNumberInput.getText())
                                    , emailInput.getText()
                                    , passwordInput.getText()
                                    , ""
                                    , Roles.Club
                                    , firstNameInput.getText()
                                    , lastNameInput.getText()
                                    ,clubTypeSelection.getValue()
                            );
                            userServices.add(club);
                            CurrentUser.setInstance(club);
                            UserSerializableData data = new UserSerializableData();
                            data.userId = CurrentUser.getInstance().getCurrentUser().getCinUser();
                            try {
                                RessorcesManager.save(data, "loggedUser.bin");
                            } catch (IOException e) {
                                System.out.println(e.getMessage());
                            }
                            redirect("/Views/UI/HomeTemplate.fxml");
                        }
                        break;
                }
            }
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }
    private void redirect(String url) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(url));
            Stage stage = (Stage) cinNumberInput.getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

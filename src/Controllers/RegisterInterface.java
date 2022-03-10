package Controllers;

import APIs.Captcha;
import APIs.CaptchaGenerator;
import Modules.Club;
import Modules.Professor;
import Modules.Student;
import Services.UserServices;
import Utils.CropImg;
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
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class RegisterInterface implements Initializable {

    @FXML
    public WebView reCaptcha;
    @FXML
    public TextField captchaResponse;
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

    private WebEngine webEngine;
    Captcha captcha;

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
        webEngine = reCaptcha.getEngine();
        webEngine.setJavaScriptEnabled(true);
        captcha = CaptchaGenerator.getCaptcha();
        webEngine.loadContent("<html lang=\"en\">\n" +
                "<head>\n" +
                "    <title>Document</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <style>\n" +
                "        html, body {\n" +
                "height: 100%;\n" +
                "margin: 0;\n" +
                "background-color: "+captcha.getBgColor()+";\n" +
                "}\n" +
                "\n" +
                "#section1 {\n" +
                "    height: 90%; \n" +
                "text-align:center; \n" +
                "    display:table;\n" +
                "    width:100%;\n" +
                "}\n" +
                "\n" +
                "#section1 h1 {\n" +
                "    display:table-cell; \n" +
                "    vertical-align:middle;\n" +
                "    color: "+captcha.getColor()+"; \n" +
                "    font-family: "+captcha.getFont()+";"+
                "font-style: oblique;\n" +
                        "    font-size: 40px;"+
                "text-decoration: line-through;"+
                "    }\n" +
                "    </style>\n" +
                "    <div class=\"section\" id=\"section1\">\n" +
                "        <h1>"+captcha.getGenenumber()+"</h1>\n" +
                "        </div> \n" +
                "</body>\n" +
                "</html>");
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
            System.out.println();
            if ((emailInput.getText().matches("[a-z A-Z]+[.][a-z]+(@esprit.tn)"))
                    && (firstNameInput.getText().length() > 2)
                    && (cinNumberInput.getText().matches("^[0-9]+[0-9]*$"))
                    && (lastNameInput.getText().length() > 2)
                    && (passwordInput.getText().length() > 4)
                    && (captchaResponse.getText().equals(captcha.getGenenumber()))
                    && (!roleSelection.getValue().equals(null))
                    && (passwordInput.getText().equals(passwordInputConfirm.getText()))
            ) {
                System.out.println("chbik?");
                switch (roleSelection.getValue()) {
                    case Etudiant:
                        if ((!domaineSelection.getValue().equals(null))
                                && (!classLvl.getText().equals(null))
                                && (!classNum.getText().equals(null))
                                && (!classSoec.getText().equals(null))
                        ) {
                            Student student = new Student(Long.parseLong(cinNumberInput.getText())
                                    , emailInput.getText()
                                    , passwordInput.getText()
                                    , ""
                                    , Roles.Etudiant
                                    , firstNameInput.getText()
                                    , lastNameInput.getText()
                                    , new Classe(Integer.parseInt(classLvl.getText()), classSoec.getText(), Integer.parseInt(classNum.getText()))
                                    , domaineSelection.getValue()
                            );
                            if (userServices.addAndcheck(student)){
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
                        }
                        break;
                    case Professeur:
                        if (!domaineSelection.getValue().equals(null)) {
                            Professor professor = new Professor(
                                    Long.parseLong(cinNumberInput.getText())
                                    , emailInput.getText()
                                    , passwordInput.getText()
                                    , ""
                                    , Roles.Professeur
                                    , firstNameInput.getText()
                                    , lastNameInput.getText()
                                    , domaineSelection.getValue()
                            );
                            if (userServices.addAndcheck(professor)){
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
                        }

                        break;
                    case Club:
                        if (!clubTypeSelection.getValue().equals(null)) {
                            Club club = new Club(
                                    Long.parseLong(cinNumberInput.getText())
                                    , emailInput.getText()
                                    , passwordInput.getText()
                                    , ""
                                    , Roles.Club
                                    , firstNameInput.getText()
                                    , lastNameInput.getText()
                                    , clubTypeSelection.getValue()
                            );
                            if (userServices.addAndcheck(club)){
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
                            }

                        break;
                }
                System.out.println("out");
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Try Again");
                alert.show();
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

    public void backbtn(ActionEvent actionEvent) {
        redirect("/Views/UI/LoginInterface.fxml");
    }

    public void refreshCaptcha(ActionEvent actionEvent) {
        captcha = CaptchaGenerator.getCaptcha();
        webEngine.loadContent("<html lang=\"en\">\n" +
                "<head>\n" +
                "    <title>Document</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <style>\n" +
                "        html, body {\n" +
                "height: 100%;\n" +
                "margin: 0;\n" +
                "background-color: "+captcha.getBgColor()+";\n" +
                "}\n" +
                "\n" +
                "#section1 {\n" +
                "    height: 90%; \n" +
                "text-align:center; \n" +
                "    display:table;\n" +
                "    width:100%;\n" +
                "}\n" +
                "\n" +
                "#section1 h1 {\n" +
                "    display:table-cell; \n" +
                "    vertical-align:middle;\n" +
                "    color: "+captcha.getColor()+"; \n" +
                "    font-family: "+captcha.getFont()+";"+
                "font-style: oblique;\n" +
                "    font-size: 40px;"+
                "text-decoration: line-through;"+
                "    }\n" +
                "    </style>\n" +
                "    <div class=\"section\" id=\"section1\">\n" +
                "        <h1>"+captcha.getGenenumber()+"</h1>\n" +
                "        </div> \n" +
                "</body>\n" +
                "</html>");
    }


}

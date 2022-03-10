package APIs;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;

public class SMS {


    @FXML
    private Button SMSBtn;

    @FXML
    private Circle circle;

    @FXML
    private Label labAddOffer;

    @FXML
    private Label labDescription;

    @FXML
    private Label labTitle;

    @FXML
    private TextField messageContent;

    @FXML
    private TextField number;

    @FXML
    void sendSMS(ActionEvent event) {
        String ACCOUNT_SID = "AC0161c407dcf7c534c333eeaef7e654c1";
        String AUTH_TOKEN = "d5c7bcf5790d3c9e3515abee41d720f1";

        String content = messageContent.getText();
        String telephone = "+"+number.getText();
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(telephone),
                new com.twilio.type.PhoneNumber("+447360265238"),
                content)
                .create();


    }




}

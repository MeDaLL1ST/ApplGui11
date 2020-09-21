package sample;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.Animations.Shake;

public class SignUpController<ButEnter> {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField MailBoxF;

    @FXML
    private PasswordField PassF;

    @FXML
    private Button ButRegistr;

    @FXML
    private Button ButEnter1;

    @FXML
    private TextField LoginF;

    @FXML
    private CheckBox ButMale;

    @FXML
    private CheckBox ButFemale;

    @FXML
    void initialize() {



ButRegistr.setOnAction(event ->  {

        signUpNewUser();

        });


        ButEnter1.setOnAction(event->   {

            ButEnter1.getScene().getWindow().hide();

            FXMLLoader loader1=new FXMLLoader();
            loader1.setLocation(getClass().getResource("sample.fxml"));

            try {
                loader1.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root=loader1.getRoot();
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();

        });


    }

    private void signUpNewUser() {

        DatabaseHandler dbHandler=new DatabaseHandler();
        String MailBox=MailBoxF.getText();
        String Password=PassF.getText();
        String Login=LoginF.getText();
        String Gender="";
        if (ButMale.isSelected())
            Gender="Male";
        else
            Gender="Female";

        User user=new User(MailBox,Login,Password,Gender);

        dbHandler.signUpUser(user);

        if (!MailBoxF.equals("")&&!PassF.equals("")&&!LoginF.equals("")) {

            Shake userLoginAnim = new Shake(LoginF);
            Shake userPassAnim = new Shake(PassF);
            Shake userMailAnim = new Shake(MailBoxF);
            userLoginAnim.playAnim();
            userPassAnim.playAnim();
            userMailAnim.playAnim();

        }



    }


}


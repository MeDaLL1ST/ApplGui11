package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Animations.Shake;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField LoginF;

    @FXML
    private PasswordField PassF;

    @FXML
    private Button ButEnter;

    @FXML
    private Button ButRegistration;

    @FXML
    void initialize() {



        ButEnter.setOnAction(event -> {
            String loginText=LoginF.getText().trim();
                    String loginPassword=PassF.getText().trim();

                    if (!loginText.equals("")&&!loginPassword.equals(""))
                        loginUser(loginText,loginPassword);
                 else {

                        Shake userLoginAnim = new Shake(LoginF);
                        Shake userPassAnim = new Shake(PassF);
                        userLoginAnim.playAnim();
                        userPassAnim.playAnim();
                    }
                });


        ButRegistration.setOnAction(event->   {

            ButRegistration.getScene().getWindow().hide();

            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/SignUp.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root=loader.getRoot();
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();

    });

    }

    private void loginUser(String loginText, String loginPassword) {

DatabaseHandler dbHandler = new DatabaseHandler();
User user = new User();
        user.setLogin(loginText);
        user.setPassword(loginPassword);
ResultSet result=dbHandler.getUser(user);

int counter=0;
while(true) {
    try {
        if (!result.next()) break;
    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }
    counter++;
}

if (counter>=1) {


    ButRegistration.getScene().getWindow().hide();

    FXMLLoader loader=new FXMLLoader();
    loader.setLocation(getClass().getResource("/sample/App.fxml"));

    try {
        loader.load();
    } catch (IOException e) {
        e.printStackTrace();
    }

    Parent root=loader.getRoot();
    Stage stage=new Stage();
    stage.setScene(new Scene(root));
    stage.showAndWait();


} else {

    Shake userLoginAnim=new Shake(LoginF);
    Shake userPassAnim=new Shake(PassF);
userLoginAnim.playAnim();
userPassAnim.playAnim();
}

    }
}

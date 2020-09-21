package sample;

public class User {
    private String MailBox;
    private String Login;
    private String Password;
    private String Gender;


    public User(String mailBox, String login, String password, String gender) {
        MailBox = mailBox;
        Login = login;         //this.
        Password = password;
        Gender = gender;
    }

    public User() {

    }

    public String getMailBox() {
        return MailBox;
    }

    public void setMailBox(String mailBox) {
        MailBox = mailBox;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }
}

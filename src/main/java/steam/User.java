package steam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    protected static final String PASS_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@.-_])(?=\\S+$).{8,}$";
    protected String username;
    protected String password;

    public User(String username, String password){
        setPassword(password);
        setUsername(username);
    }

    public User(){
    }

    public String getUsername(){
        return username;
    }

    public boolean setUsername(String username){
        if (usernameValidator(username)){
            this.username = username;
            return true;
        }else return false;
    }

    public String getPassowrd(){
        return password;
    }

    public boolean setPassword(String password){
        if (passwordValidator(password)){
            this.password = password;
            return true;
        }else return false;
    }

    public static boolean passwordValidator(String password){
        Pattern pattern = Pattern.compile(PASS_REGEX);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
    public static boolean usernameValidator(String username){
        return username.length()>=4;
    }

    public String toString(){
        return "username: "+username+" - password: "+password;
    }

    public boolean equals(Object o){
        if (o instanceof User){
            User u = (User) o;
            return this.username.equals(u.username) && this.password.equals(u.password);
        }else return false;
    }
}

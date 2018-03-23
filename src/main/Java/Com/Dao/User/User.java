package Com.Dao.User;

public class User {


    static String Name;
    static String Password;

    public User() {

    }

    public void setName1(String name) {
        this.Name = name;
    }

    public void setPassword1(String password) {
        this.Password = password;
    }

    public static String getName() {
        return Name;

    }

    public static String getPassword() {
        return Password;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setPassword(String password) {
        this.Password = password;
    }
}



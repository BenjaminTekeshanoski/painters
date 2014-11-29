package tr.edu.itu.cs.users;

public class User {
    public static User user;
    private String nickName;
    private String name, surname;
    private String password;
    private int accessLevel;

    public User(String name, String surname, String password, String nickname,
            int accessLevel) {

        this.name = name;
        this.surname = surname;
        this.password = password;
        this.accessLevel = accessLevel;
        user = this;

    }

    public boolean passwordCheck(String password) {
        if (this.password.equals(password))
            return true;
        return false;
    }

    public int getAccesslevel() {
        return accessLevel;
    }
}

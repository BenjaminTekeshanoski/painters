package tr.edu.itu.cs.users;

public class User {
    private int id;
    private String nickName;
    private String name, surname;
    private String password;
    private String email;
    private int accessLevel;

    public User(String name, String surname, String password, String nickname,
            String email, int accessLevel, int id) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.password = password;
        this.accessLevel = accessLevel;

    }

    public boolean passwordCheck(String password) {
        if (this.password.equals(password))
            return true;
        return false;
    }
}

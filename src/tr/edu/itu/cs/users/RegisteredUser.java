package tr.edu.itu.cs.users;

public class RegisteredUser extends User implements GeneralMethods {
    private boolean onlineStatus;
    private static int numberOfRegisteredUsers;

    public RegisteredUser(String name, String surname, String password,
            String nickname, String email, int id) {
        super(name, surname, password, nickname, email, 2,
                numberOfRegisteredUsers++);
        numberOfRegisteredUsers++;
        onlineStatus = false;
    }

    @Override
    public void logOut() {
        onlineStatus = false;

    }

    @Override
    public void singIn() {
        onlineStatus = true;

    }

}

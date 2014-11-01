package tr.edu.itu.cs.users;

public class Moderator extends User implements GeneralMethods {
    private static int numberOfModerator;
    private boolean onlineStatus;

    public Moderator(String name, String surname, String password,
            String nickname, String email, int accessLevel, int id) {
        super(name, surname, password, nickname, email, 3,
                numberOfModerator + 1);
        numberOfModerator++;
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

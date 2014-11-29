package tr.edu.itu.cs.users;



public class Moderator extends RegisteredUser {
    private static int numberOfModerator;
    private boolean onlineStatus;

    public Moderator(String name, String surname, String password,
            String nickname, int accessLevel, int id) {
        super(name, surname, password, nickname, 3);
        numberOfModerator++;
        onlineStatus = false;
    }

}

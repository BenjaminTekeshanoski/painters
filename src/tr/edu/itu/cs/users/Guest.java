package tr.edu.itu.cs.users;

public class Guest extends User {
    private static int numberOfGuests = 0;

    public Guest() {
        super(null, null, null, null, 1);
        numberOfGuests++;
    }

}

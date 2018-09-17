import java.sql.Time;

/**
 * Test.java is the class that tests the program
 * Danan High, 9/16/2018
 */
public class Test {

    /**
     * main method to run the program
     * @param args
     */
    public static void main(String[] args) {
        TupleSpace ts = new TupleSpace();
        User<String, String, Boolean, String, Time> user = new User<>("Danan",
                                                                      "dhigh",
                                                                      null,
                                                                      null,
                                                                      null);
        User<String, String, Boolean, String, Time> user1 = new User<>("DananQ",
                                                                      "dhigh",
                                                                      false,
                                                                      "nope ggth",
                                                                      null);
        User<String, String, Boolean, String, Time> user2 = new User<>("Danan",
                                                                      "dhighq",
                                                                      null,
                                                                      "nopeasdf",
                                                                      null);
        User<String, String, Boolean, String, Time> user3 = new User<>("Danan",
                                                                      "dhiasdfgh",
                                                                      false,
                                                                      "nopeddddddd",
                                                                      null);

        ts.add(user, user1, user2, user3);
        ts.printMap();
        ts.removeUser(user2);
        ts.printMap();
    }

}

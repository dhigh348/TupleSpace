
/**
 * Test.java is the class that tests the program
 * Danan High, 9/16/2018
 */
public class Test {

    /**
     * main method to run the program
     * @param args to run the main program
     */
    public static void main(String[] args) {
        TupleSpace ts = new TupleSpace(6);
        Tuple tuple = null;

        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            if (i % 5 == 0) {
                tuple = new Tuple("anna",
                                  "filling good",
                                  "Way to go");
            } else if (i % 5 == 1) {
                tuple = new Tuple(("anna" + i));
            } else if (i % 5 == 2) {
                tuple = new Tuple("anna");
            } else if (i % 5 == 3) {
                tuple = new Tuple("anna",
                                  "abc",
                                  true);
            } else if (i % 5 == 4) {
                tuple = new Tuple("anna",
                                  "abc",
                                  true,
                                  "Hi hows it going");
            }
            ts.add(tuple);
        }
        
        System.out.println(System.currentTimeMillis() - time1);
//        ts.print();
        long time2 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            System.out.println(ts.remove("anna", "abc", true));
        }
        System.out.println(System.currentTimeMillis() - time2);
    }

}

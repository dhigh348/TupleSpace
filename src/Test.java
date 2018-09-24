import java.util.ArrayList;

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
        ArrayList<Tuple> tupleList = new ArrayList<>();

        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            if (i % 5 == 0) {
                tuple = new Tuple("anna",
                                  "filling good",
                                  "Way to go");
            } else if (i % 5 == 1) {
                tuple = new Tuple(("anna"));
            } else if (i % 5 == 2) {
                tuple = new Tuple("anna", "cool", "why");
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
        
        ts.printMap();
        
        System.out.println(System.currentTimeMillis() - time1);
        long time2 = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            tupleList.add(ts.read("anna", "filling good", "Way to go"));
        }
        
        System.out.println(tupleList);
        
        for (Tuple t: tupleList) {
            t.printObjects();
            ts.add(t);
        }

        System.out.println("++++++++++++++++");

        System.out.println(System.currentTimeMillis() - time2);
    }

}

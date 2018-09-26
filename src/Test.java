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
        Tuple tuple = new Tuple("orange");
        ArrayList<Tuple> tupleList = new ArrayList<>();

        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            if (i % 10 == 0) {
                tuple = new Tuple("anna",
                                  "filling good",
                                  "Way to go");
            } else if (i % 10 == 1) {
                tuple = new Tuple("anna");
            } else if (i % 10 == 2) {
                tuple = new Tuple("anna" + i, "cool",
                                  "why");
            } else if (i % 10 == 3) {
                tuple = new Tuple("anna",
                                  "abc",
                                  true);
            } else if (i % 10 == 4) {
                tuple = new Tuple("anna",
                                  "abc",
                                  true,
                                  "Hi hows it going");
            } else if (i % 10 == 5) {
                tuple = new Tuple("cole",
                                  "abc",
                                  false,
                                  "Hi hows it going");
            }else if (i % 10 == 6) {
                tuple = new Tuple("sheela",
                                  "abc",
                                  true,
                                  "Hi hows it going");
            }else if (i % 10 == 7) {
                tuple = new Tuple("anna",
                                  "abc",
                                  true,
                                  " why",
                                  8,
                                  8.7,
                                  'c');
            }else if (i % 10 == 8) {
                tuple = new Tuple("bill",
                                  "abc",
                                  13.56,
                                  "Hi hows it going",
                                  "yellow",
                                  101);
            }else if (i % 10 == 9) {
                tuple = new Tuple("bob",
                                  "abc",
                                  123458679,
                                  "Hi hows it going",
                                  true,
                                  5,
                                  'c');
            }
            ts.add(tuple);
        }
        
        System.out.println("TimeOne: " + (System.currentTimeMillis() - time1) +
                               "\n");
        long time2 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            Tuple tup = ts.read("anna",
                                "abc",
                                true);
            if (tup != null) {
                System.out.println(tup + " = " + tup.getSet());
            }
        }
        
        System.out.println(ts.remove("anna39052", "*", "*"));
        
        System.out.println(tupleList.size());
        for (Tuple t: tupleList) {
            ts.add(t);
        }
        
        System.out.println("TimeTwo: " + (System.currentTimeMillis() - time2) +
                               "\n");
    }

}

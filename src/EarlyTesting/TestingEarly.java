package EarlyTesting;

import java.util.ArrayList;

/**
 * Test.java is the class that tests the program
 * Danan High, 9/16/2018
 */
public class TestingEarly {

    /**
     * main method to run the program
     * @param args to run the main program
     */
    public static void main(String[] args) {
        TupleSpaceEarly ts = new TupleSpaceEarly(6);
        TupleEarly tuple = new TupleEarly();
        ArrayList<TupleEarly> tupleList = new ArrayList<>();

        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            if (i % 10 == 0) {
                tuple = new TupleEarly("anna",
                                  "filling good",
                                  "Way to go");
            } else if (i % 10 == 1) {
                tuple = new TupleEarly("anna");
            } else if (i % 10 == 2) {
                tuple = new TupleEarly("anna",
                                  "cool",
                                  "why");
            } else if (i % 10 == 3) {
                tuple = new TupleEarly("anna",
                                  "abc",
                                  true);
            } else if (i % 10 == 4) {
                tuple = new TupleEarly("anna",
                                  "abc" + i,
                                  true,
                                  "Hi hows it going");
            } else if (i % 10 == 5) {
                tuple = new TupleEarly("cole",
                                  "abc",
                                  false,
                                  "Hi hows it going");
            } else if (i % 10 == 6) {
                tuple = new TupleEarly("sheela" + i,
                                  "abc",
                                  true,
                                  "Hi hows it going");
            } else if (i % 10 == 7) {
                tuple = new TupleEarly("anna",
                                  "abc",
                                  true,
                                  " why",
                                  8);
            } else if (i % 10 == 8) {
                tuple = new TupleEarly("bill" + i,
                                  "abc",
                                  13.56,
                                  "Hi hows it going" + i,
                                  "yellow",
                                  101);
            } else if (i % 10 == 9) {
                tuple = new TupleEarly("bob",
                                  "abc" + i,
                                  123458679,
                                  "Hi hows it going",
                                  true);
            }
            ts.add(tuple);
        }
        System.out.println("After Add: " +
                                   (System.currentTimeMillis() - time1) + "\n");



        long time2 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            ts.read("*", "abc", "*", "*");
        }
        System.out.println("After Read: " +
                                   (System.currentTimeMillis() - time2) + "\n");




        long time3 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            tuple = ts.remove("*", "*", "*", "Hi hows it going");
            if (tuple != null) {
                tupleList.add(tuple);
            }
        }

        for (TupleEarly t: tupleList) {
            ts.add(t);
        }
        System.out.println("After Remove: " +
                                   (System.currentTimeMillis() - time3) + "\n");
    }

}


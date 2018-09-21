
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
        TupleSpace ts = new TupleSpace(6);
        Tuple tuple = null;
        
        for (int i = 0; i < 10000; i++) {
            if (i % 5 == 0) {
                tuple = new Tuple();
            } else if (i % 5 == 1) {
                tuple = new Tuple(("anna" + i));
            } else if (i % 5 == 2) {
                tuple = new Tuple("anna" + i,
                                  "abc");
            } else if (i % 5 == 3) {
                tuple = new Tuple("anna" + i,
                                  "abc",
                                  true);
            } else if (i % 5 == 4) {
                tuple = new Tuple("anna" + i,
                                  "abc",
                                  true,
                                  System.currentTimeMillis(),
                                  "Hi hows it going");
            }
            ts.add(tuple);
        }
        
        long time1 = System.currentTimeMillis();
        System.out.println(time1);
        
        ts.print();
        
        
        System.out.println(System.currentTimeMillis() - time1);
    }

}

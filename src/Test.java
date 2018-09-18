
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
        
        for (int i = 0; i < 10; i++) {
            if (i % 5 == 0) {
                tuple = new Tuple();
            } else if (i % 5 == 1) {
                tuple = new Tuple(1);
            } else if (i % 5 == 2) {
                tuple = new Tuple(1, "hello");
            } else if (i % 5 == 3) {
                tuple = new Tuple(1, "hey", 3.14);
            } else if (i % 5 == 4) {
                tuple = new Tuple(1, "why", "tree", 8);
            }
    
            ts.add(tuple);
        }
        
//        ts.print();
//        System.out.println("+++++++++++++++");
//        ts.remove(1, "hey", 3.12);
        ts.print();
        
        
//        System.out.println(System.currentTimeMillis());
    }

}

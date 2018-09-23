
import java.util.*;


/**
 * TupleSpace.java is the data center for holding the users and their associated
 *   messages and statuses.
 * Danan High, 9/18/2018
 */
public class TupleSpace {

    private int size;
    private HashMap<Object, ArrayList<Object>> map;

    /**
     * Constructor for the TupleSpace
     * @param size of the tuples
     */
    public TupleSpace(int size) {
        this.size = size;
        this.map = new HashMap<>();
    }
    
    /**
     * Adding the specified tuple to the TupleSpace repository
     */
    public void add(Tuple tuple) {
        ArrayList<Object> temp, checker = tuple.getSet();
        int size = tuple.getSize();

        for (int i = 0; i < size; i++) {
            if (i < size - 1) {
                if (!map.containsKey(checker.get(i))) {
                    map.put(checker.get(i), new ArrayList<Object>());
                }

                temp = map.get(checker.get(i));

                if (!temp.contains(checker.get(i + 1))) {
                    temp.add(checker.get(i + 1));
                }
            } else {
                if (!map.containsKey(checker.get(i))) {
                    map.put(checker.get(i), new ArrayList<Object>());
                }

                temp = map.get(checker.get(i));

                if (!temp.contains(checker.get(i))) {
                    temp.add(tuple);
                }
            }
        }
    }
    
    
    /**
     * Returning the individual tuple from the repository
     * @return tuple to print
     */
    public Tuple read(Object...objects) {
        return checkSpace(objects);
    }
    
    
    /**
     * Returning and removing the tuple from the repository.
     * @return tuple from the repository
     */
    public Tuple remove(Object...objects) {
        return checkSpace(objects);
    }


    /**
     * Checking if the tuple space contains a Tuple with the specified values
     * @return tuple of null or found tuple
     */
    private Tuple checkSpace(Object...objects) {
        Random rand = new Random();
        Tuple tuple = null;
        ArrayList<Object> temp;

        if (map.containsKey(objects[0])) {
            ArrayList<Object> subList = new ArrayList<>();
            temp = map.get(objects[0]);
            int randomPos = rand.nextInt(temp.size());

            for (int i = 1; i < objects.length; i++) {
                subList.add(objects[i]);
            }
            remove(subList);

            Class classCheck = temp.get(randomPos).getClass();
            while (classCheck != Tuple.class) {
                randomPos = rand.nextInt(temp.size());
                classCheck = temp.get(randomPos).getClass();
            }
            tuple = (Tuple)temp.get(randomPos);
            temp.remove(randomPos);
        }
        return tuple;
    }

    // printer
    public void print() {
        for (Map.Entry<Object, ArrayList<Object>> map: map.entrySet()) {
            System.out.println(map.getKey() + " = " +  map.getValue());
        }
    }
}

























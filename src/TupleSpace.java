import java.util.*;


/**
 * TupleSpace.java is the data center for holding the users and their associated
 *   messages and statuses.
 * Danan High, 9/18/2018
 */
public class TupleSpace {

    private int size;
    private List<Tuple> repository;
    private HashMap<Integer, ArrayList<Tuple>> map;

    /**
     * Constructor for the TupleSpace
     */
    public TupleSpace(int size) {
        this.size = size;
        this.repository = new LinkedList<>();
        this.map = new HashMap<>();
    }
    
    /**
     * Adding the specified tuple to the TupleSpace repository
     */
    public void add(Tuple tuple) {
//        if (tuple != null) {
//            this.repository.add(tuple);
//        }
        if (this.map.containsKey(tuple.getSize())) {
            ArrayList<Tuple> list = map.get(tuple.getSize());
            if (tuple != null) {
                if (!list.contains(tuple)) {
                    list.add(tuple);
                }
            }
        } else {
            this.map.put(tuple.getSize(), new ArrayList<Tuple>());
            ArrayList<Tuple> list = map.get(tuple.getSize());
            list.add(tuple);
        }
    }


    /**
     * Returning the individual tuple from the repository
     * @return tuple to print
     */
    public Tuple read(Object...objects) {
        Tuple tuple = null;
        
        for (Tuple t: repository) {
            if (t.getSize() == objects.length) {
                if (t.checkPattern(objects)) {
                    tuple = t;
                }
            }
        }
        
        return tuple;
    }
    
    
    /**
     * Returning and removing the tuple from the repository.
     * @return tuple from the repository
     */
    public Tuple remove(Object...objects) {
        Random rand = new Random();
        Tuple tuple = null;
        
//        for (Tuple t: repository) {
//            if (t.getSize() == objects.length) {
//                if (t.checkPattern(objects)) {
//                    tuple = t;
//                }
//            }
//        }
//
//        if (tuple != null) {
//            repository.remove(tuple);
//        }

        if (map.containsKey(objects.length)) {
            ArrayList<Tuple> list = map.get(objects.length);
            int number = rand.nextInt(list.size());
            tuple = list.get(number);
            list.remove(number);
        }
        
        return tuple;
    }

}

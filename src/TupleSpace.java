
import java.util.*;


/**
 * TupleSpace.java is the data center for holding the users and their associated
 *   messages and statuses.
 * Danan High, 9/18/2018
 */
public class TupleSpace {

    private int size;
    private HashMap<Object, TupleNode> map;

    /**
     * Constructor for the TupleSpace
     * @param size of the tuples
     */
    public TupleSpace(int size) {
        this.size = size;
        this.map = new HashMap<>();
    }


    /**
     * Adding the specified tuple to the TupleSpace repo
     */
    public void add(Tuple tuple) {
        int tupleSize = tuple.getSize();
        ArrayList<Object> tupleObjects = tuple.getSet();
        HashMap<Object, TupleNode> temp = map;
        
        for (int i = 0; i < tupleSize; i++) {
            Object obj = tupleObjects.get(i);
            
            if (!temp.containsKey(obj)) {
                temp.put(obj, new TupleNode(obj));
                temp = temp.get(obj).getNodes();
            } else {
                temp = temp.get(obj).getNodes();
            }
        }
        
        if (!temp.containsKey(tuple)) {
            temp.put(tuple, new TupleNode(tuple));
        }
    }
    
    
    /**
     * Returning the individual tuple from the repository
     * @return tuple to print
     */
    public Tuple read(Object...objects) { return checkSpace(objects); }
    
    
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
        HashMap<Object, TupleNode> temp = map;
        
        for (Object o: objects) {
            if (temp.containsKey(o)) {
                temp = temp.get(o).getNodes();
            } else {
                return null;
            }
        }
        
        for (Object o: temp.keySet()) {
            if (o.getClass().equals(Tuple.class)) {
                Tuple tuple = (Tuple) temp.get(o).getObject();
                temp.remove(o);
                return tuple;
            }
        }
        return null;
    }

    
    /**
     * Getting a tuple using the object parameters that contain wildcards
     * @return tuple from the map
     */
    private Tuple getWildTuples() {

        return null;
    }
    
    
    /**
     * Checking if the objects list contains a wildcard character
     * @return true if contains, false otherwise
     */
    private boolean hasWildCard(Object...objects) {
        for (Object o: objects) {
            if (o.equals("*")) {
                return true;
            }
        }
        return false;
    }
}





















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
        TupleNode tNode = null;
        ArrayList<Object> tupleObjects = tuple.getSet();
        HashMap<Object, TupleNode> temp = map;
        
        for (int i = 0; i < tupleSize; i++) {
            Object obj = tupleObjects.get(i);
            
            if (!temp.containsKey(obj)) {
                temp.put(obj, new TupleNode(obj));
                tNode = temp.get(obj);
                temp = tNode.getNodes();
            } else {
                tNode = temp.get(obj);
                temp = tNode.getNodes();
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
    public Tuple read(Object...objects) {
        Tuple tuple = null;
        HashMap<Object, TupleNode> temp = map;
        TupleNode tupleNode = null;
        
        for (Object o: objects) {
            if (!temp.containsKey(o)) {
                return tuple;
            } else {
                temp = temp.get(o).getNodes();
                tupleNode = temp.get(o);
            }
        }
        
        
        return tuple;
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
    private Tuple checkSpace(Object object) {
        Random rand = new Random();
        Tuple tuple = null;
        ArrayList<Object> temp;

//            if (map.containsKey(objects[0])) {
//                ArrayList<Object> subList = new ArrayList<>();
//                temp = map.get(objects[0]);
//                int randomPos = rand.nextInt(temp.size());
//
//                for (int i = 1; i < objects.length; i++) {
//                    subList.add(objects[i]);
//                }
//                checkSpace(subList);
//
//                Class classCheck = temp.get(randomPos).getClass();
//                while (classCheck != Tuple.class) {
//                    randomPos = rand.nextInt(temp.size());
//                    classCheck = temp.get(randomPos).getClass();
//                }
//                tuple = (Tuple) temp.get(randomPos);
//                temp.remove(randomPos);
//            }
        return tuple;
    }
    
    public void printMap() {
    
    }
}

























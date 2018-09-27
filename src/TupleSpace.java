
import java.util.*;


/**
 * TupleSpace.java is the data center for holding the users and their associated
 *   messages and statuses.
 * Danan High, 9/18/2018
 */
public class TupleSpace {

    private int size;
    private HashMap<Object, TupleNode> map;
    private HashMap<Integer, HashMap<Object, TupleNode>> sizeMap;

    /**
     * Constructor for the TupleSpace
     * @param size of the tuples
     */
    public TupleSpace(int size) {
        this.size = size;
        this.map = new HashMap<>();
        this.sizeMap = new HashMap<>();
        for (int i = 0; i < size + 1; i++) {
            sizeMap.put(i, new HashMap<>());
        }
    }


    /**
     * Adding the specified tuple to the TupleSpace repo
     */
    public void add(Tuple tuple) {
        int tupleSize = tuple.getSize();
        ArrayList<Object> tupleObjects = tuple.getSet();
        HashMap<Object, TupleNode> temp = sizeMap.get(tupleSize);

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
    public Tuple read(Object...objects) {
        if (hasWildCard(objects)) {
            return checkSpace(sizeMap.get(objects.length), objects);
        } else {
            return checkSpace(objects);
        }
    }
    
    
    /**
     * Returning and removing the tuple from the repository.
     * @return tuple from the repository
     */
    public Tuple remove(Object...objects) {
        if (hasWildCard(objects)) {
            return checkSpace(sizeMap.get(objects.length), objects);
        } else {
            return checkSpace(objects);
        }
    }



    /**
     * Checking if the tuple space contains a Tuple with the specified values
     * @return tuple of null or found tuple
     */
    private Tuple checkSpace(Object...objects) {
        HashMap<Object, TupleNode> temp = sizeMap.get(objects.length);
        
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
     * Check space two
     */
    private Tuple checkSpace(HashMap<Object, TupleNode> check,
                             Object...objects) {
        HashMap<Object, TupleNode> temp;
        Object[] subList;
        
        if (objects.length > 0) {
            subList = new Object[objects.length - 1];
            for (int i = 1; i < objects.length; i++) {
                subList[i - 1] = objects[i];
            }

            if (objects[0].equals("*")) {
                for (Object o: check.keySet()) {
                    temp = check.get(o).getNodes();
                    if (objects.length > 1) {
                        if (!objects[1].equals("*")) {
                            if (temp.containsKey(objects[1])){
                                return checkSpace(temp, subList);
                            }
                        } else if (objects[1].equals("*")) {
                            return checkSpace(temp, subList);
                        }
                    } else {
                        return getTuple(temp);
                    }
                }
            } else {
                temp = check.get(objects[0]).getNodes();
                return checkSpace(temp, subList);
            }
        } else {
            return getTuple(check);
        }
        return null;
    }

    
    /**
     * Getting a tuple using the object parameters that contain wildcards
     * @return tuple from the map
     */
    private Tuple getTuple(HashMap<Object, TupleNode> tupMap) {
        for (Object o: tupMap.keySet()) {
            if (o.getClass().equals(Tuple.class)) {
                Tuple tuple = (Tuple) tupMap.get(o).getObject();
                tupMap.remove(o);
                return tuple;
            }
        }
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




















import java.util.*;


/**
 * TupleSpace.java is the data center for holding the users and their associated
 *   messages and statuses.
 * Danan High, 9/18/2018
 */
public class TupleSpace {

    private int size;
    private ArrayList<Object> removalList;
    private HashMap<Integer, HashMap<Object, TupleNode>> sizeMap;

    /**
     * Constructor for the TupleSpace
     * @param size of the tuples
     */
    public TupleSpace(int size) {
        this.size = size;
        this.removalList = new ArrayList<>();
        this.sizeMap = new HashMap<>();
        for (int i = 0; i < size + 1; i++) {
            sizeMap.put(i, new HashMap<>());
        }
    }


    /**
     * Adding the specified tuple to the TupleSpace repository
     * @param tuple to add to the TupleSpace
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
     * @param objects to search for
     * @return tuple to print
     */
    public Tuple read(Object...objects) {
        if (hasWildCard(objects)) {
            return checkSpace(false, sizeMap.get(objects.length), objects);
        } else {
            return checkSpace(false, objects);
        }
    }
    
    
    /**
     * Returning and removing the tuple from the repository.
     * @param objects to search for
     * @return tuple from the repository
     */
    public Tuple remove(Object...objects) {
        if (hasWildCard(objects)) {
            return checkSpace(true, sizeMap.get(objects.length), objects);
        } else {
            return checkSpace(true, objects);
        }
    }



    /**
     * Checking if the tuple space contains a Tuple with the specified values
     * @param objects to search for
     * @return tuple of null or found tuple
     */
    private Tuple checkSpace(Boolean removeTup, Object...objects) {
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
                return getTuple(temp, removeTup);
            }
        }
        return null;
    }
    
    
    /**
     * Returning a tuple from wildcard parameters
     * @param check map of the current level from the TupleSpace map
     * @param objects to search for
     * @return tuple from the space
     */
    private Tuple checkSpace(Boolean removeTup,
                             HashMap<Object, TupleNode> check,
                             Object...objects) {
        HashMap<Object, TupleNode> temp;
        ArrayList<Object> list = new ArrayList<>();
        Object[] subList;
        Tuple tuple = null;
        
        if (objects.length > 0) {
            subList = new Object[objects.length - 1];
            for (int i = 1; i < objects.length; i++) {
                subList[i - 1] = objects[i];
            }

            if (objects[0].equals("*")) {
                list.addAll(check.keySet());
                Collections.shuffle(list);
                for (Object o: list) {
                    if (tuple == null) {
                        temp = check.get(o).getNodes();
                        if (objects.length > 1) {
                            if (!objects[1].equals("*")) {
                                if (temp.containsKey(objects[1])){
                                    tuple = checkSpace(removeTup,
                                                       temp,
                                                       subList);
                                }
                            } else if (objects[1].equals("*")) {
                                tuple = checkSpace(removeTup,
                                                   temp,
                                                   subList);
                            }
                        } else {
                            tuple = getTuple(temp,
                                             removeTup);
                        }
                    } else {
                        return tuple;
                    }
                }
            } else {
                temp = check.get(objects[0]).getNodes();
                tuple = checkSpace(removeTup,
                                   temp,
                                   subList);
            }
        } else {
            tuple = getTuple(check,
                             removeTup);
        }
        return tuple;
    }

    
    /**
     * Getting a tuple using the object parameters that contain wildcards
     * @param tupMap level to get the tuples from
     * @return tuple from the map
     */
    private Tuple getTuple(HashMap<Object, TupleNode> tupMap, Boolean remove) {
        Random rand = new Random();
        Tuple tuple = null;
        Object obj;
        ArrayList<Object> objList = new ArrayList<>();

        if (tupMap.keySet().isEmpty()) {
            return tuple;
        }

        objList.addAll(tupMap.keySet());
        obj = objList.get(rand.nextInt(objList.size()));

        if (obj.getClass().equals(Tuple.class)) {
            tuple = (Tuple) obj;
            if (remove) {
                tupMap.remove(obj);
            }
        } else {
            while (!obj.getClass().equals(Tuple.class) && objList.size() > 0) {
                obj = objList.get(rand.nextInt(objList.size()));
                objList.remove(obj);

                if (obj.getClass().equals(Tuple.class)) {
                    tuple = (Tuple) obj;
                }
            }

            if (remove) {
                tupMap.remove(tuple);
            }
        }
        return tuple;
    }
    
    
    /**
     * Checking if the objects list contains a wildcard character
     * @param objects to check for wildcard parameters
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




















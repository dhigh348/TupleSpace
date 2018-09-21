
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
    private HashMap<String, ArrayList<Object>> obMap;


    /**
     * Constructor for the TupleSpace
     */
    public TupleSpace(int size) {
        this.size = size;
        this.repository = new LinkedList<>();
        this.map = new HashMap<>();
        this.obMap = new HashMap<>();
    }
    
    /**
     * Adding the specified tuple to the TupleSpace repository
     */
    public void add(Tuple tuple) {
        ArrayList<Object> temp;
        String tupParamName = "";

        for (Object o: tuple.getSet()) {
            if (!obMap.containsKey(o)) {
                obMap.put(tupParamName, new ArrayList<>());
                temp = obMap.get(tupParamName);
                temp.add(o);
            } else {

            }
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
        
        if (map.containsKey(objects.length)) {
            ArrayList<Tuple> list = map.get(objects.length);
            int number = rand.nextInt(list.size());
            tuple = list.get(number);
            list.remove(number);
        }
        
        return tuple;
    }
    
    // printer
    public void print() {
        for (Map.Entry<String, ArrayList<Object>> map: obMap.entrySet()) {
            System.out.println(map.getKey() + " = " +  map.getValue());
        }
    }
    
}

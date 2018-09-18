import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * TupleSpace.java is the data center for holding the users and their associated
 *   messages and statuses.
 * Danan High, 9/18/2018
 */
public class TupleSpace {

    private int size;
    private List<Tuple> repository;

    /**
     * Constructor for the TupleSpace
     */
    public TupleSpace(int size) {
        this.size = size;
        this.repository = new LinkedList<>();
    }
    
    /**
     * Adding the specified tuple to the TupleSpace repository
     */
    public void add(Tuple tuple) {
        if (tuple != null) {
            this.repository.add(tuple);
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
        Tuple tuple = null;
        
        for (Tuple t: repository) {
            if (t.getSize() == objects.length) {
                if (t.checkPattern(objects)) {
                    tuple = t;
                }
            }
        }
        
        if (tuple != null) {
            repository.remove(tuple);
        }
        
        return tuple;
    }


    /**
     * Printing the map
     */
    public void print(Object...objects) {
        Tuple tuple = null;
        ArrayList<Tuple> list = new ArrayList<>();
        
        
    }

}

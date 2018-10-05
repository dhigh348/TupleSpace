package ChatRoom;

import java.util.ArrayList;
import java.math.*;


/**
 * ChatRoom.Tuple.java is the class that holds all of the data for a single tuple.
 * Danan High, 9/18/2018
 */
public class Tuple {
    
    private int size;
    private ArrayList<Object> set;
    
    
    /**
     * Constructor for making the ChatRoom.Tuple
     * @param objects for the tuple constructor
     */
    public Tuple(Object...objects) {
        this.size = objects.length;
        this.set = new ArrayList<>();
        for (Object o: objects) {
            this.set.add(o);
        }
    }
    
    
    /**
     * Returning the object set from the constructor pattern
     * @return set of objects from the constructor
     */
    public ArrayList<Object> getSet() { return this.set; }
    
    
    /**
     * Returning the size of the tuple, how many parameters it contains.
     * @return number of parameters of the tuple
     */
    public int getSize() { return this.size; }
}









































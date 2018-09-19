import java.util.ArrayList;


/**
 * Tuple.java is the class that holds all of the data for a single tuple.
 * Danan High, 9/18/2018
 */
public class Tuple {
    
    private int size;
    private ArrayList<Object> set;
    
    
    /**
     * Constructor for making the Tuple
     * @param objects
     */
    public Tuple(Object...objects) {
        this.size = objects.length;
        this.set = new ArrayList<>();
        for (Object o: objects) {
            this.set.add(o);
        }
        
    }
    
    
    /**
     * Returning the size of the tuple, how many parameters it contains.
     * @return number of parameters of the tuple
     */
    public int getSize() {
        return this.size;
    }


    /**
     * Returning the list of objects associated with this tuple
     * @return set of objects
     */
    public ArrayList<Object> getTupleSet() {
        return this.set;
    }


    /**
     * Checking if the tuple pattern is a match for the pattern being searched for
     * @return true if the same and false otherwise
     */
    public boolean checkPattern(Object...objects) {
        for (int i = 0; i < this.set.size(); i++) {
            if (this.set.get(i).getClass().equals(objects[i].getClass()) &&
                this.set.get(i) != null &&
                objects[i] != null) {
                if (!this.set.get(i).equals(objects[i])) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}

package EarlyTesting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * ChatRoom.TupleSpace.java is the data center for holding the users and their associated
 *   messages and statuses.
 * Danan High, 9/18/2018
 */
public class TupleSpaceEarly {

    private int size;
    private List<TupleEarly> repository;

    /**
     * Constructor for the ChatRoom.TupleSpace
     */
    public TupleSpaceEarly(int size) {
        this.size = size;
        this.repository = new LinkedList<>();
    }

    /**
     * Adding the specified tuple to the ChatRoom.TupleSpace repository
     */
    public void add(TupleEarly tuple) {
        if (tuple != null) {
            this.repository.add(tuple);
        }
    }


    /**
     * Returning and removing the tuple from the repository.
     * @return tuple from the repository
     */
    public TupleEarly remove(Object...objects) {
        TupleEarly tuple = null;

        for (TupleEarly t: repository) {
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
     * Returning the individual tuple from the repository
     * @return tuple to print
     */
    public TupleEarly read(Object...objects) {
        TupleEarly tuple = null;

        for (TupleEarly t: repository) {
            if (t.getSize() == objects.length) {
                if (t.checkPattern(objects)) {
                    tuple = t;
                }
            }
        }

        return tuple;
    }


    /**
     * Printing the map
     */
    public void print(Object...objects) {
        TupleEarly tuple = null;
        ArrayList<TupleEarly> list = new ArrayList<>();


    }

}


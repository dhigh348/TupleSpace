package ChatRoom;

import java.util.HashMap;

/**
 * ChatRoom.TupleNode.java is the class that makes up the nodes of the ChatRoom.TupleSpace
 *   retrieval tree.
 * Danan High, 9/25/2018
 */
public class TupleNode {

    private HashMap<Object, TupleNode> nodes;
    private Object object;
    
    
    /**
     * Constructor for the ChatRoom.TupleNode that contains the data (object) and the
     * new map that holds the data.
     * @param object of data
     */
    public TupleNode(Object object) {
        this.nodes = new HashMap<>();
        this.object = object;
    }
    
    
    /**
     * Returning the node from the tree
     * @return node of the map
     */
    public HashMap<Object, TupleNode> getNodes() { return this.nodes; }
    
    
    /**
     * Returning the Object data from the node
     * @return object data
     */
    public Object getObject() { return this.object; }
}






























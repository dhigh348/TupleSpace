import javafx.application.Application;
import javafx.stage.Stage;

import java.util.LinkedList;

/**
 * Controller.java is the class that manages the interactions between the
 * interactions between the chat room and the tuple space.
 * Danan High, 9/27/2018
 */
public class Controller extends Application{
    private TupleSpace tupSpace = new TupleSpace(5);
    private LinkedList<Tuple> messageList = new LinkedList<>();


    @Override
    public void start(Stage primaryStage) throws Exception {
        ChatRoom chatRoom = new ChatRoom(this);
        chatRoom.show(primaryStage);
    }
    
    
    /**
     * Adding to the tuple space
     * @return tupleSpace from the controller
     */
    public void addToTupleSpace(Tuple tuple) {
        this.tupSpace.add(tuple);
    }
    
    
    /**
     * Removing from the tuple space
     * @return tuple from the tuple space
     */
    public Tuple removeFromTheTupleSpace(Object...objects) {
        return this.tupSpace.remove(objects);
    }
    
    
    /**
     * Reading from the tuple space
     * @return tuple from the tuple space
     */
    public Tuple readFromTupleSpace(Object...objects) {
        return this.tupSpace.read(objects);
    }


    /**
     * Returning the list of the last messages up to ten
     * @return messageList of the messages
     */
    public LinkedList<Tuple> getMessageStack() { return this.messageList; }
    
    
    /**
     * Returning the list of all users in the tuple space
     * @return list of users
     */
    public LinkedList<Tuple> getUsers() {
        return messageList;
    }

/**
     * main method to run the program
     */
    public static void main(String[] args) throws Exception {
        launch(args);
    }
}

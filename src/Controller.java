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
    private LinkedList<User> messageList = new LinkedList<>();
    private LinkedList<User> userOrder = new LinkedList<>();
    private User currentUser = null;


    @Override
    public void start(Stage primaryStage) throws Exception {
        // adding the starting three users
        this.tupSpace.add(new Tuple("Danan", true));
        this.tupSpace.add(new Tuple("Kyle", true));
        this.tupSpace.add(new Tuple("Diana", false));
        this.tupSpace.add(new Tuple("Kalam", true));
        Tuple tup = tupSpace.read("*", "*");
        this.currentUser = new User((String) tup.getSet().get(0),
                                    (Boolean) tup.getSet().get(1),
                                    null,
                                    null);

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
    public LinkedList<User> getMessageStack() { return this.messageList; }


    /**
     * Returning the order of the list of users
     * @return ordered list of the users
     */
    public LinkedList<User> getUserOrder() { return this.userOrder; }


    /**
     * Returning a list of all users from the tuple space.
     * @return list of all users
     */
    public LinkedList<User> getAllUsers() {
        return search("*", "*");
    }


    /**
     * Returning a list of all of the online users from the tuple space.
     * @return list of online users
     */
    public LinkedList<User> getOnlineUsers() {
        return search("*", true);
    }


    /**
     * Performing a search of the tuple space for the specific objects
     */
    private LinkedList<User> search(Object...objects) {
        LinkedList<Tuple> list = new LinkedList<>();
        LinkedList<User> userList = new LinkedList<>();
        Tuple tuple;

        tuple = tupSpace.remove(objects);
        while (tuple != null) {
            if (!list.contains(tuple)) {
                list.add(tuple);
            }
            tuple = tupSpace.remove(objects);
        }

        for (Tuple t: list) {
            userList.add(new User((String) t.getSet().get(0),
                                  (Boolean) t.getSet().get(1),
                                  null,
                                  null));
            tupSpace.add(t);
        }
        return userList;
    }


    /**
     * Returning the current user of the tuple space
     * @return current user of the tuple space
     */
    public User getCurrentUser() {
        return this.currentUser;
    }


    /**
     * main method to run the program
     */
    public static void main(String[] args) throws Exception { launch(args); }
}

/*

 how to structure users
    group for users, online status (which means you can get all users this way)
    group for users, time stamp and message
    name of the user is always first parameter

 */
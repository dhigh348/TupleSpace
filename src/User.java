import java.sql.Time;
import java.util.ArrayList;


/**
 * User.java is the class that holds the user's information
 * Danan High, 9/28/2018
 */
public class User extends Tuple {

    private String name;
    private Boolean online;
    private String message;
    private Time time;

    /**
     * Constructor for the user
     * @param name of the user
     * @param online status of the user
     * @param time stamp of the user
     * @param message from the user
     */
    public User(String name, Boolean online, Time time, String message) {
        super(name, online, time, message);
        this.name = name;
        this.online = online;
        this.message = message;
        this.time = time;
    }


    /**
     * Function to return the name
     * @return name of the user
     */
    public String getName() { return this.name; }
    
    
    /**
     * Function to return the online status of the user
     * @return online status boolean value
     */
    public Boolean getOnline() { return online; }
    
    
    /**
     * Function to return the time of the user
     * @return the time stamp that the user has when making a move
     */
    public Time getTime() { return time; }

    
    /**
     * Function to get the message from the user
     * @return message that the user is associated with
     */
    public String getMessage() { return message; }


    /**
     * Returning the object list from the user
     * @return object list
     */
    public ArrayList<Object> getObjects() { return super.getSet(); }


    /**
     * Setting the user online status to the opposite. If online the user will
     * now be set to offline
     */
    public void setOnlineStatus() { this.online = !online; }


    /**
     * Setting the user to have the new associated message value
     * @param newMessage
     */
    public void setMessage(String newMessage) { this.message = newMessage; }


    /**
     * Setting the new time stamp for the user
     */
    public void setTimeStamp() {
        Time nextTime = new Time(System.currentTimeMillis());
        this.time = nextTime;
    }


    /**
     * Printing functionality for the user's parameters.
     * @return text for the messages
     */
    @Override
    public String toString() {
        return ""+ this.time + " " + this.name + ": " + this.message + "\n";
    }
}









































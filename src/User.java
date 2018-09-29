import java.sql.Time;


/**
 * User.java is the class that holds the user's information
 * Danan High, 9/28/2018
 */
public class User extends Tuple{

    private String name;
    private Boolean online;
    private String message;
    private Time time;
    
    /**
     * Constructor for the user
     * @param name of the user
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
     */
    public String getName() {
        return this.name;
    }
    
    
    /**
     * Function to return the online status of the user
     */
    public Boolean getOnline() {
        return online;
    }
    
    
    /**
     * Function to return the time of the user
     */
    public Time getTime() {
        return time;
    }

    
    /**
     * Function to get the message from the user
     */
    public String getMessage() {
        return message;
    }
}

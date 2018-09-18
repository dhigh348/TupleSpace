/**
 * User.java is the class that makes up the individual user
 * Danan High, 9/16/2018
 */
public class User<T1, T2, T3, T4, T5> {

    private T1 name;
    private T2 username;
    private T3 online;
    private T4 message;
    private T5 time;


    /**
     * Constructor of the user
     * @param name name of the user
     * @param username username of the user
     * @param online online status of the user
     * @param message message from the user
     * @param time time stamp of the message
     */
    public User(T1 name, T2 username, T3 online, T4 message, T5 time) {
        this.name = name;
        this.username = username;
        this.online = online;
        this.message = message;
        this.time = time;
    }


    /**
     * Function to return the name of the user
     * @return name of the user
     */
    public T1 getName() {
        return this.name;
    }


    /**
     * Function to return the username of the user
     * @return username of the user
     */
    public T2 getUserName() {
        return this.username;
    }


    /**
     * Function to return the online status of the user
     * @return online status, true if online and false otherwise
     */
    public T3 getOnlineStatus() {
        return this.online;
    }


    /**
     * Function to return the message that the user has created
     * @return message the user has provided
     */
    public T4 getMessage() {
        return this.message;
    }

    /**
     * Function to return the time stamp of the message.
     * @return time of the message
     */
    public T5 getTimeStamp() {
        return this.time;
    }


    /**
     * Function to change the online status of the user
     */
    public void setUserStatus() {

    }


    /**
     * Function to return the size of the user
     * @return size int of number of fields
     */
    public int userSize() {
        int size = 0;
        if (this.name != null) {
            size++;
        }

        if (this.username != null) {
            size++;
        }

        if (this.online != null) {
            size++;
        }

        if (this.message != null) {
            size++;
        }

        if (this.time != null) {
            size++;
        }

        return size;
    }
}

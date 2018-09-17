import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TupleSpace {

    private HashMap<Integer, ArrayList<User>> repository;

    public TupleSpace() {
        this.repository = new HashMap<>();
    }


    /**
     * Making the data repository
     *
     */


    /**
     * Add a value to the hash map
     * @param users adding to the map
     */
    public void add(User...users) {
        ArrayList<User> list;

        for (User user: users) {
            if (!this.repository.containsKey(user.userSize())) {
                this.repository.put(user.userSize(), new ArrayList<User>());
            }
        }

        for (User user: users) {
            list = this.repository.get(user.userSize());
            if (!list.contains(user)) {
                list = this.repository.get(user.userSize());
                list.add(user);
            }
        }
    }


    /**
     * Retrieving the user from the map
     * @return user searching for
     */
    public void removeUser(User user) {
        int numberOfParameters = user.userSize();
        if (this.repository.containsKey(user.userSize())) {
            ArrayList<User> list = this.repository.get(user.userSize());
            if (list.contains(user)) {
                list.remove(user);
            }
        }
    }


    /**
     * Printing the map
     */
    public void printMap() {
        System.out.println(this.repository);
    }

}

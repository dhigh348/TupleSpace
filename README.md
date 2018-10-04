Program Use: 

    There aren't any command line arguments when running the program. The main class
    for the entry point of the program is the Controller class. This class handles
    all of the interactions between the tuple space and the chat room.

    The tuple space takes in tuples and stores them in a trie data structure
    contained within a HashMap in the TupleSpace class. The tuple space can add, 
    remove and read tuples from and to the space. 

    The chat room is the user interface for users to create messages between one 
    another. The chat has been populated with 4 users to begin. One has been set 
    offline and the other users are online. Users can be added to the chat room by 
    typing in their name and either typing enter or clicking on the add button. Each
    user gets a turn to make and send a message before returning back to their turn.
    The messages are created down in the bottom text field and are sent either by 
    typing enter or by clicking the send button. Users can see all of the other 
    members in the chat room by clicking on the all button, and the users can also 
    see a list of only the active users by clicking on the active button. A user 
    can be logged on/off by clicking on the log on/off button. 

    When a user is logged on or off the label at the top of the chat that displays 
    the current user's name changes colors depending on their status. If the user is
    online the background color will turn green and if they are offline the color
    displayed will be red.


Testing/Debugging:

    Testing was done on the tuple space to make a version that was efficient 
    enough to handle many user queries at a single time. This involved adding
    100,000 users to the space and the proceeding to read 10,000, remove 10,000
    and to add 10,000 users back in. These results are posted in the docs 
    folder in the project. The testing file used to test the project is Test.java.

Known Bugs/Issues: 

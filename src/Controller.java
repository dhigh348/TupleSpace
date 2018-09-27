import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Controller.java is the class that manages the interactions between the
 * interactions between the chat room and the tuple space.
 * Danan High, 9/27/2018
 */
public class Controller extends Application{
    TupleSpace tupSpace = new TupleSpace(5);
    ChatRoom chatRoom = new ChatRoom();


    @Override
    public void start(Stage primaryStage) throws Exception {
        chatRoom.show(primaryStage);
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }

}

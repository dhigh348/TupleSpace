import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * ChatRoom.java
 */
public class ChatRoom {

    private Button addButton, sendButton;
    private HBox userBox;
    private TextField textField;
    private Background blue = new Background(new BackgroundFill(Color.WHITESMOKE,
                                                                CornerRadii
                                                                    .EMPTY,
                                                                Insets.EMPTY));
    
    public void show(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Chat Room");
        primaryStage.setMinWidth(400);
        primaryStage.setMaxWidth(400);
        primaryStage.setMinHeight(600);
        primaryStage.setMaxHeight(600);
    
        makeAddUserButton();
        makeSendButton();
        
        VBox vbox = new VBox();
        vbox.getChildren().addAll(addButton, sendButton);
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * Adding "add user" button to the stage
     */
    private void makeAddUserButton() {
        addButton = new Button("Add User");
        addButton.setMinWidth(100);
        addButton.setMinHeight(50);
        addButton.setBackground(blue);
    }
    
    
    /**
     * Making the send button
     */
    public void makeSendButton() {
        sendButton = new Button("Send");
        sendButton.setBackground(blue);
        sendButton.setMinWidth(100);
        sendButton.setMinHeight(50);
    }
    
    
//    public static void main(String[] args) { launch(args); }

}

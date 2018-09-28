import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * ChatRoom.java is the class that displays the gui for users of the chat room
 * Danan High, 9/28/2018
 */
public class ChatRoom {

    private Button addButton = new Button("Add User");
    private Button sendButton = new Button("Send");
    private Button activeUsersButton = new Button("Active");
    private Button allUsersButton = new Button("All");
    private HBox userInfoBox = new HBox(), dispUsers = new HBox();
    private HBox dispMessages = new HBox(), enterMessageBox = new HBox();
    private VBox chatRoomLayout = new VBox();
    private TextField textField = new TextField();
    private Text userList = new Text(), messages = new Text();
    private Label userLabel = new Label();
    
    private Background blue = new Background(new BackgroundFill(Color.BLUE,
                                                                CornerRadii
                                                                    .EMPTY,
                                                                Insets.EMPTY));
    private Background green = new Background(new BackgroundFill(Color.GREEN,
                                                                CornerRadii
                                                                .EMPTY,
                                                                Insets.EMPTY));
    private Background grey = new Background(new BackgroundFill(Color.GREY,
                                                                 CornerRadii
                                                                     .EMPTY,
                                                                 Insets.EMPTY));
    private Background red = new Background(new BackgroundFill(Color.RED,
                                                                CornerRadii
                                                                        .EMPTY,
                                                                Insets.EMPTY));
    private Background orange = new Background(new BackgroundFill(Color.ORANGE,
                                                                CornerRadii
                                                                        .EMPTY,
                                                                Insets.EMPTY));

    /**
     * Showing and making the stage for the chat room
     * @param primaryStage to show the chat room
     * @throws Exception
     */
    public void show(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Chat Room");
        primaryStage.setMinWidth(400);
        primaryStage.setMinHeight(700);
        primaryStage.setResizable(false);
        
        setup(primaryStage);
        
        Scene scene = new Scene(chatRoomLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    /**
     * Making the layout and the interface of the chat room
     */
    private void setup(Stage primaryStage) {
        makeAddUserButton();
        makeSendButton();
        makeUserLabel();
        makeAllUsersButton();
        makeActiveUsersButton();
        makeTextField();
        makeUserBox();
        makeDispUsersBox();
        makeMessagesBox();
        makeMessageEnterBox();
        makeChatLayout(primaryStage);
    }


    /***********************************************************************/
    /*                          Layout Functions                           */
    /***********************************************************************/


    /**
     * Make the box to contain the buttons to get all and active users
     */
    private void makeUserBox() {
        userInfoBox.setMinWidth(390);
        userInfoBox.setMinHeight(100);
        userInfoBox.setSpacing(5);
        userInfoBox.setAlignment(Pos.CENTER);
        userInfoBox.getChildren().addAll(activeUsersButton,
                                         addButton,
                                         allUsersButton);
    }


    /**
     * Make list of users in the chat
     */
    private void makeDispUsersBox() {
        dispUsers.setMinHeight(200);
        dispUsers.setMinWidth(390);
        dispUsers.setAlignment(Pos.CENTER);
        dispUsers.setBackground(red);
        dispUsers.getChildren().addAll(userList);
    }


    /**
     * Make list of messages in the chat
     */
    private void makeMessagesBox() {
        dispMessages.setMinHeight(300);
        dispMessages.setMinWidth(390);
        dispMessages.setAlignment(Pos.CENTER);
        dispMessages.setBackground(orange);
        dispMessages.getChildren().addAll(messages);
    }


    /**
     * Make the message entry box for the users
     */
    private void makeMessageEnterBox() {
        enterMessageBox.setMinHeight(100);
        enterMessageBox.setMinWidth(390);
        enterMessageBox.setSpacing(5);
        enterMessageBox.setAlignment(Pos.CENTER);
        enterMessageBox.getChildren().addAll(textField, sendButton);
    }


    /**
     * Making the text field for the users message.
     */
    private void makeTextField() {
        textField.setMinWidth(290);
        textField.setMinHeight(100);
    }
    
    
    /**
     * Making the user label that contains the name of the current user.
     */
    private void makeUserLabel() {
        userLabel.setText("Test");
        userLabel.setAlignment(Pos.CENTER);
        userLabel.setTextFill(Color.WHITE);
        userLabel.setMinWidth(390);
        userLabel.setMinHeight(50);
        userLabel.setBackground(green);
    }

    /**
     * Making the whole chat room layout
     * @param primaryStage stage to place the chat room layout
     */
    private void makeChatLayout(Stage primaryStage) {
        chatRoomLayout.setMinHeight(primaryStage.getMinHeight());
        chatRoomLayout.setMinWidth(primaryStage.getMinWidth());
        chatRoomLayout.setBackground(grey);
        chatRoomLayout.getChildren().addAll(userLabel,
                                            userInfoBox,
                                            dispUsers,
                                            dispMessages,
                                            enterMessageBox);
    }
    
    
    /***********************************************************************/
    /*                          Button Functions                           */
    /***********************************************************************/


    /**
     * Making the button to get all of the users in the chat room
     */
    private void makeAllUsersButton() {
        allUsersButton.setMinWidth(100);
        allUsersButton.setMaxWidth(100);
        allUsersButton.setMinHeight(50);
        allUsersButton.setMaxHeight(50);
        allUsersButton.setOnAction(e -> {
            System.out.println("All users button click.");
        });
    }


    /**
     * Making the active users button.
     */
    private void makeActiveUsersButton() {
        activeUsersButton.setMinHeight(50);
        activeUsersButton.setMaxHeight(50);
        activeUsersButton.setMaxWidth(100);
        activeUsersButton.setMinWidth(100);
        activeUsersButton.setOnAction(e -> {
            System.out.println("Active users button click.");
        });
    }
    
    
    /**
     * Adding "add user" button to the stage
     */
    private void makeAddUserButton() {
        addButton.setMinWidth(100);
        addButton.setMaxWidth(100);
        addButton.setMinHeight(50);
        addButton.setMaxHeight(50);
        addButton.setOnAction(e -> {
            System.out.println("Add users button click.");
        });
    }
    
    
    /**
     * Making the send button
     */
    private void makeSendButton() {
        sendButton.setTextFill(Color.WHITE);
        sendButton.setMinWidth(100);
        sendButton.setMaxWidth(100);
        sendButton.setMaxHeight(50);
        sendButton.setMinHeight(50);
        sendButton.setBackground(blue);
        sendButton.setOnAction(e -> {
            System.out.println("Send button click.");
        });
    }
}

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.LinkedList;

/**
 * ChatRoom.java is the class that displays the gui for users of the chat room
 * Danan High, 9/28/2018
 */
public class ChatRoom {

    private Button addButton = new Button("Add User");
    private Button sendButton = new Button("Send");
    private Button logOffButton = new Button("Logoff");
    private Button activeUsersButton = new Button("Active");
    private Button allUsersButton = new Button("All");
    private Controller controller;
    
    private TextField textField = new TextField();
    private TextField addUserTextField = new TextField();
    private Text userList = new Text(), messages = new Text();
    private Text onlineUsers = new Text();
    private Label userLabel = new Label();

    private HBox userButtonBox = new HBox(), dispUsers = new HBox();
    private HBox dispMessages = new HBox(), messageEntryBox = new HBox();
    private HBox userInputBox = new HBox(), onlineUsersBox = new HBox();
    private HBox userStatusInformationBox = new HBox();
    private VBox chatRoomLayout = new VBox();
    
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
    private Background white = new Background(new BackgroundFill(Color.WHITE,
                                                                CornerRadii
                                                                        .EMPTY,
                                                                Insets.EMPTY));
    /**
     * Constructor for the ChatRoom
     * @param controller for the Chat to be able to talk to the TupleSpace
     */
    public ChatRoom(Controller controller) {
        this.controller = controller;
    }
    

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
        // button setup
        makeAddUserButton();
        makeSendButton();
        makeAllUsersButton();
        makeActiveUsersButton();
        makeLogOffButton();

        // label setup
        makeUserLabel();

        // text field setup
        makeUserTextField();
        makeTextField();

        // containers setup
        makeAddUserInputBox();
        makeButtonBox();
        makeAllUsersDisplay();
        makeOnlineUsersBox();
        makeUserInformationContainer();
        makeMessagesBox();
        makeMessageEnterBox();
        makeChatLayout(primaryStage);
    }


    /***********************************************************************/
    /*                          Layout Functions                           */
    /***********************************************************************/


    /**
     * Making the add user input box
     */
    private void makeAddUserInputBox() {
        userInputBox.setMinWidth(390);
        userInputBox.setMinHeight(50);
        userInputBox.setPadding(new Insets(5));
        userInputBox.setSpacing(5);
        userInputBox.setAlignment(Pos.CENTER);
        userInputBox.getChildren().addAll(addUserTextField, addButton);
    }
    
    
    /**
     * Make the box to contain the buttons to get all and active users
     */
    private void makeButtonBox() {
        userButtonBox.setMinWidth(390);
        userButtonBox.setMinHeight(50);
        userButtonBox.setPadding(new Insets(2));
        userButtonBox.setSpacing(10);
        userButtonBox.setAlignment(Pos.CENTER);
        userButtonBox.getChildren().addAll(allUsersButton,
                                           logOffButton,
                                           activeUsersButton);
    }


    /**
     * Making the display of the full list of users in the chat
     */
    private void makeAllUsersDisplay() {
        dispUsers.setMinHeight(200);
        dispUsers.setMinWidth(160);
        dispUsers.setAlignment(Pos.TOP_LEFT);
        dispUsers.setBackground(white);
        dispUsers.setPadding(new Insets(5));
        dispUsers.getChildren().addAll(userList);
    }


    /**
     * Making the display of only the online users in the chat
     */
    private void makeOnlineUsersBox() {
        onlineUsersBox.setMinHeight(200);
        onlineUsersBox.setMinWidth(160);
        onlineUsersBox.setAlignment(Pos.TOP_LEFT);
        onlineUsersBox.setBackground(white);
        onlineUsersBox.setPadding(new Insets(5));
        onlineUsersBox.getChildren().addAll(onlineUsers);
    }


    /**
     * Making the container for the users information storage.
     */
    private void makeUserInformationContainer() {
        userStatusInformationBox.setMinWidth(390);
        userStatusInformationBox.setMinHeight(200);
        userStatusInformationBox.setAlignment(Pos.CENTER);
        userStatusInformationBox.setSpacing(60);
        userStatusInformationBox.setPadding(new Insets(5));
        userStatusInformationBox.getChildren().addAll(dispUsers,
                                                      onlineUsersBox);
    }


    /**
     * Make list of messages in the chat
     */
    private void makeMessagesBox() {
        dispMessages.setMinHeight(300);
        dispMessages.setMinWidth(390);
        dispMessages.setAlignment(Pos.TOP_LEFT);
        dispMessages.setBackground(white);
        dispMessages.setPadding(new Insets(5));
        dispMessages.getChildren().addAll(messages);
    }


    /**
     * Make the message entry box for the users
     */
    private void makeMessageEnterBox() {
        messageEntryBox.setMinHeight(100);
        messageEntryBox.setMinWidth(390);
        messageEntryBox.setPadding(new Insets(5));
        messageEntryBox.setSpacing(5);
        messageEntryBox.setAlignment(Pos.CENTER);
        messageEntryBox.getChildren().addAll(textField, sendButton);
    }
    
    
    /**
     * Making the user label that contains the name of the current user.
     */
    private void makeUserLabel() {
        userLabel.setFont(Font.font(20));
        userLabel.setText(this.controller.getCurrentUser().getName());
        userLabel.setAlignment(Pos.CENTER);
        userLabel.setTextFill(Color.WHITE);
        userLabel.setMinWidth(390);
        userLabel.setMinHeight(50);
        userLabel.setBackground(white);
    }

    /**
     * Making the whole chat room layout
     * @param primaryStage stage to place the chat room layout
     */
    private void makeChatLayout(Stage primaryStage) {
        chatRoomLayout.setMinHeight(primaryStage.getMinHeight());
        chatRoomLayout.setMinWidth(primaryStage.getMinWidth());
        chatRoomLayout.setAlignment(Pos.CENTER);
        chatRoomLayout.setPadding(new Insets(5));
        chatRoomLayout.setSpacing(5);
        chatRoomLayout.setBackground(grey);
        chatRoomLayout.getChildren().addAll(userLabel,
                                            userInputBox,
                                            userButtonBox,
                                            userStatusInformationBox,
                                            dispMessages,
                                            messageEntryBox);
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
        allUsersButton.setMinHeight(40);
        allUsersButton.setMaxHeight(40);
        allUsersButton.setOnAction(e -> {
            e.consume();
            setTextOfUsers(this.controller.getAllUsers(), userList);
        });
    }


    /**
     * Making the active users button.
     */
    private void makeActiveUsersButton() {
        activeUsersButton.setMinHeight(40);
        activeUsersButton.setMaxHeight(40);
        activeUsersButton.setMaxWidth(100);
        activeUsersButton.setMinWidth(100);
        activeUsersButton.setOnAction(e -> {
            e.consume();
            setTextOfUsers(this.controller.getOnlineUsers(), onlineUsers);
        });
    }
    
    
    /**
     * Adding "add user" button to the stage
     */
    private void makeAddUserButton() {
        addButton.setMinWidth(100);
        addButton.setMaxWidth(100);
        addButton.setMinHeight(40);
        addButton.setMaxHeight(40);
        addButton.setOnAction(e -> {
            e.consume();
            addUser();
        });
    }
    
    
    /**
     * Making the send button
     */
    private void makeSendButton() {
        sendButton.setTextFill(Color.WHITE);
        sendButton.setMinWidth(100);
        sendButton.setMaxWidth(100);
        sendButton.setMaxHeight(40);
        sendButton.setMinHeight(40);
        sendButton.setBackground(blue);
        sendButton.setOnAction(e -> {
            e.consume();
            respondToMessageAction();
        });
    }


    /**
     * Making the log off button
     */
    private void makeLogOffButton() {
        logOffButton.setMinHeight(40);
        logOffButton.setMinWidth(100);
        logOffButton.setMaxHeight(40);
        logOffButton.setMaxWidth(100);
        logOffButton.setBackground(white);
        logOffButton.setOnAction(e -> {
            e.consume();
            if (this.controller.getCurrentUser() != null) {
                this.controller.getCurrentUser().setOnlineStatus();
            }
        });
    }

    /**
     * Making the text field to add a user to the tuple space
     */
    private void makeUserTextField() {
        addUserTextField.setMinWidth(300);
        addUserTextField.setMinHeight(50);
        addUserTextField.setPromptText("Add user here...");
        addUserTextField.setOnAction(e -> {
            e.consume();
            addUser();
        });
    }
    

    /**
     * Making the text field for the users message.
     */
    private void makeTextField() {
        textField.setPrefWidth(300);
        textField.setPrefHeight(50);
        textField.setPromptText("Enter message here...");
        textField.setOnAction(e -> {
            e.consume();
            respondToMessageAction();
        });
    }
    
    
    /**
     * Function to add a user from the user text field to the tuple space
     */
    private void addUser() {
//        if (!addUserTextField.getText().isEmpty()) {
//            controller.addToTupleSpace(new Tuple(false,
//                                                 addUserTextField.getText()));
//            controller.getUserOrder()
//                      .add(new Tuple(false,
//                                     addUserTextField.getText()));
//            addUserTextField.clear();
//        }
    }
    
    
    /**
     * Setting up actions to when the user types in a message
     */
    private void respondToMessageAction() {
//        Tuple tuple = null;
//        if (!controller.getUserOrder().isEmpty()) {
//            currentUser = controller.getUserOrder().removeFirst();
//            if (!textField.getText().isEmpty()) {
//                if (controller.getMessageStack().size() < 10) {
//                    tuple = new Tuple(new Time(System.currentTimeMillis()),
//                                      currentUser.getSet().get(1),
//                                      textField.getText());
//
//                    controller.getMessageStack().push(tuple);
//                    controller.addToTupleSpace(tuple);
//
//                } else {
//                    tuple = new Tuple(new Time(System.currentTimeMillis()),
//                                      currentUser.getSet().get(1),
//                                      textField.getText());
//                    controller.getMessageStack().removeLast();
//                    controller.getMessageStack().push(tuple);
//                    controller.addToTupleSpace(tuple);
//                }
//            }
//            setTextField();
//            textField.clear();
//            controller.getUserOrder().addLast(tuple);
//        } else {
//            textField.clear();
//        }
    }


    /**
     * Setting the printing of all of the users in the chat
     */
    private void setTextOfUsers(LinkedList<User> list, Text field) {
        String text = "";

        this.userList.setText("");
        for (User u: list) {
            text += (u.getName() + "\n");
        }

        field.setTextAlignment(TextAlignment.LEFT);
        field.setText(text);
    }


    /**
     * Setting the text field of the interface
     */
    private void setTextField(LinkedList<User> list) {
        String text = "";
        
        this.messages.setText("");
        for (User u: list) {
            text += (u.getName() + "\n");
        }
        
        this.messages.setTextAlignment(TextAlignment.LEFT);
        this.messages.setText(text);
    }
}

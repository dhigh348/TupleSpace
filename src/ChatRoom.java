import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.sql.Time;
import java.util.LinkedList;

/**
 * ChatRoom.java is the class that displays the gui for users of the chat room
 * Danan High, 9/28/2018
 */
public class ChatRoom {

    private Button addButton = new Button("Add User");
    private Button sendButton = new Button("Send");
    private Button activeUsersButton = new Button("Active");
    private Button allUsersButton = new Button("All");
    private Controller controller;
    
    private TextField textField = new TextField();
    private TextField addUserTextField = new TextField();
    private Text userList = new Text(), messages = new Text();
    private Label userLabel = new Label();
    private User currentUser = new User("Danan",
                                        false,
                                        new Time(System.currentTimeMillis()),
                                        "");
    
    private HBox userInfoBox = new HBox(), dispUsers = new HBox();
    private HBox dispMessages = new HBox(), enterMessageBox = new HBox();
    private HBox userInputBox = new HBox();
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
        makeAddUserButton();
        makeSendButton();
        makeUserLabel();
        makeAllUsersButton();
        makeActiveUsersButton();
        makeUserTextField();
        makeTextField();
        makeAddUserInputBox();
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
    private void makeUserBox() {
        userInfoBox.setMinWidth(390);
        userInfoBox.setMinHeight(50);
        userInfoBox.setPadding(new Insets(2));
        userInfoBox.setSpacing(5);
        userInfoBox.setAlignment(Pos.CENTER);
        userInfoBox.getChildren().addAll(activeUsersButton,
                                         allUsersButton);
    }


    /**
     * Make list of users in the chat
     */
    private void makeDispUsersBox() {
        dispUsers.setMinHeight(200);
        dispUsers.setMinWidth(390);
        dispUsers.setAlignment(Pos.TOP_LEFT);
        dispUsers.setBackground(white);
        dispUsers.setPadding(new Insets(5));
        dispUsers.getChildren().addAll(userList);
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
        enterMessageBox.setMinHeight(100);
        enterMessageBox.setMinWidth(390);
        enterMessageBox.setPadding(new Insets(5));
        enterMessageBox.setSpacing(5);
        enterMessageBox.setAlignment(Pos.CENTER);
        enterMessageBox.getChildren().addAll(textField, sendButton);
    }
    
    
    /**
     * Making the user label that contains the name of the current user.
     */
    private void makeUserLabel() {
        userLabel.setFont(Font.font(20));
        userLabel.setText("");
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
                                            userInfoBox,
                                            userInputBox,
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
        allUsersButton.setMinHeight(40);
        allUsersButton.setMaxHeight(40);
        allUsersButton.setOnAction(e -> {
            e.consume();
            LinkedList<Tuple> allUsers = new LinkedList<>();
            Tuple tuple = this.controller.readFromTupleSpace("*"), temp;
            Object[] objList = new Object[tuple.getSize()];

            while (tuple != null){
                temp = this.controller.readFromTupleSpace("*");

                for (int i = 0; i < objList.length; i++) {
                    objList[0] = tuple.getSet().get(i);
                }
                this.controller.removeFromTheTupleSpace(objList);

                tuple = temp;

                if (tuple != null && !allUsers.contains(tuple)) {
                    allUsers.push(tuple);
                }
            }
            setActiveUserText(allUsers);

            for (Tuple t: allUsers) {
                this.controller.addToTupleSpace(t);
            }
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
            System.out.println("Active users button click.");
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
            respondToAction();
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
            respondToAction();
        });
    }
    
    
    /**
     * Function to add a user from the user text field to the tuple space
     */
    private void addUser() {
        if (!addUserTextField.getText().isEmpty()) {
            controller.addToTupleSpace(new Tuple(addUserTextField.getText()));
            addUserTextField.clear();
        }
    }
    
    
    /**
     * Setting up actions to when the user types in a message
     */
    private void respondToAction() {
        if (controller.getMessageStack().size() < 10) {
            Tuple tuple = new Tuple(new Time(System.currentTimeMillis()),
                                    currentUser.getName(),
                                    textField.getText());
            if (!textField.getText().isEmpty()) {
                controller.getMessageStack().push(tuple);
                controller.addToTupleSpace(tuple);
                
            }
        } else {
            if (!textField.getText().isEmpty()) {
                Tuple tuple = new Tuple(new Time(System.currentTimeMillis()),
                                        currentUser.getName(),
                                        textField.getText());
                controller.getMessageStack().removeLast();
                controller.getMessageStack().push(tuple);
                controller.addToTupleSpace(tuple);
            }
        }
        setTextField();
        textField.clear();
    }


    /**
     * Setting the printing of all of the users in the chat
     */
    public void setActiveUserText(LinkedList<Tuple> list) {
        String text = "";

        this.userList.setText("");
        for (Tuple t: list) {
            text += (t.printTuple() + "\n");
        }

        this.userList.setTextAlignment(TextAlignment.LEFT);
        this.userList.setText(text);
    }


    /**
     * Setting the text field of the interface
     */
    public void setTextField() {
        LinkedList<Tuple> list = this.controller.getMessageStack();
        String text = "";
        
        this.messages.setText("");
        for (Tuple t: list) {
            text += (t.printTuple() + "\n");
        }
        
        this.messages.setTextAlignment(TextAlignment.LEFT);
        this.messages.setText(text);
    }
}

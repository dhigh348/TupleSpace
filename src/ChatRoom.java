import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * ChatRoom.java
 */
public class ChatRoom {

    private Button addButton, sendButton;
    private HBox userBox;
    private VBox chatRoomLayout;
    private TextField textField;
    private Label userLabel;
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
    
    public void show(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Chat Room");
        primaryStage.setMinWidth(400);
        primaryStage.setMinHeight(600);
        primaryStage.setResizable(false);
        
        makeAddUserButton();
        makeSendButton();
        makeUserLabel();
        makeUserInfoArea();
        makeChatLayout(primaryStage);
        
        Scene scene = new Scene(chatRoomLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
    /**
     * Making the whole chat room layout
     * @param primaryStage stage to place the chat room layout
     */
    private void makeChatLayout(Stage primaryStage) {
        chatRoomLayout = new VBox();
        chatRoomLayout.setMinHeight(primaryStage.getMinHeight());
        chatRoomLayout.setMinWidth(primaryStage.getMinWidth());
        chatRoomLayout.setBackground(grey);
        chatRoomLayout.getChildren().addAll(userBox, sendButton);
    }
    
    
    /**
     * Making the user label that contains the name of the current user.
     */
    private void makeUserLabel() {
        userLabel = new Label();
        userLabel.setText("Test");
        userLabel.setAlignment(Pos.CENTER);
        userLabel.setTextFill(Color.WHITE);
        userLabel.setMinWidth(100);
        userLabel.setMinHeight(50);
        userLabel.setBackground(green);
    }
    
    
    /**
     * Making the portion of the chat room that contains the
     * add users button and the user label.
     */
    private void makeUserInfoArea() {
        userBox = new HBox();
        userBox.setPadding(new Insets(5));
        userBox.setSpacing(5);
        userBox.getChildren().addAll(userLabel, addButton);
    }
    
    
    /**
     * Adding "add user" button to the stage
     */
    private void makeAddUserButton() {
        addButton = new Button("Add User");
        addButton.setTextFill(Color.WHITE);
        addButton.setMinWidth(100);
        addButton.setMinHeight(50);
        addButton.setBackground(blue);
        addButton.setOnAction(e -> {
            System.out.println("Hello");
        });
    }
    
    
    /**
     * Making the send button
     */
    private void makeSendButton() {
        sendButton = new Button("Send");
        sendButton.setTextFill(Color.WHITE);
        sendButton.setBackground(blue);
        sendButton.setMinWidth(100);
        sendButton.setMinHeight(50);
    }
}

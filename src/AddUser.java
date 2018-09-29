import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * AddUser.java is a class used to display the prompt to add user to the
 * TupleSpace, if that user does not already exist.
 * Danan High, 9/28/2018
 */
public class AddUser {
    private String name = "";
    private Label label = new Label("Name: ");
    private Label instructions = new Label("Hit enter when finished " +
                                               "typing the user's name.");
    
    
    /**
     * Running the new user window
     */
    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Add New User");
        stage.setMinHeight(200);
        stage.setMinWidth(400);
        stage.setResizable(false);
    
        // exit button
        Button exit = new Button("Exit");
        exit.setOnAction(event -> {
            event.consume();
            stage.close();
        });
        
        // text field to enter the user name
        TextField userName = new TextField();
        userName.setMinSize(100, 25);
        userName.setOnAction(e -> {
            e.consume();
            if (!userName.getText().isEmpty()) {
                this.name = userName.getText();
            }
        });
    
        // setting up the layout of the display
        HBox hbox = new HBox(label, userName, exit);
        hbox.setSpacing(10);
        hbox.setPadding(new Insets(10));
        hbox.setAlignment(Pos.CENTER);
    
        VBox vBox = new VBox(instructions, hbox);
        vBox.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
    }
    
    
    /**
     * Returning the name of the user
     * @return name of the new user
     */
    public String getText() { return this.name; }
}

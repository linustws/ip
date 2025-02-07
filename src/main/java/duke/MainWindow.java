package duke;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Pair;

/**
 * Controller for MainWindow. Provides the layout for the other controls.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private Pane background;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Duke duke;

    private final Image userImage = new Image(this.getClass().getResourceAsStream("/images/Catto.png"));
    private final Image dukeImage = new Image(this.getClass().getResourceAsStream("/images/Borzoi.png"));

    /**
     * Initialises the MainWindow.
     */
    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());

        // Add the logo and welcome message
        dialogContainer.getChildren().add(DialogBox.getDukeDialog(dukeImage, "Let me do it for you~~~", false));
    }

    public void setDuke(Duke d) {
        duke = d;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText().trim();
        if (!input.isEmpty()) {
            Pair<String, Boolean> response = duke.getResponse(input);
            dialogContainer.getChildren().addAll(
                    DialogBox.getUserDialog(userImage, input),
                    DialogBox.getDukeDialog(dukeImage, response.getKey(), response.getValue())
            );
        }
        userInput.clear();
    }
}

import java.util.Optional;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author ahennessy6
 * @version 1.0.1
 */
public class OfficeHourQueue extends Application {

    private LinkedQueue<String> queue;
    private ListView<String> listView;
    private int maxQueue = 0;

    @Override
    public void start(Stage stage) {
        queue = new LinkedQueue<String>();

        Label currentLabel = new Label(
                "Current Number Of Students In Queue: 0");
        Label maxLabel = new Label("Max Number of Students in Queue: 0");

        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("Privilege Check");
        dialog.setHeaderText("Confirmation");
        dialog.setContentText("Please Enter Password:");

        listView = new ListView<String>(queue);

        Button addButton = new Button();
        addButton.setText("Add Student");

        Button removeButton = new Button();
        removeButton.setText("Remove Student");

        TextField inputField = new TextField();

        addButton.setOnAction(e -> {
                queue.enqueue(inputField.getText());
            // System.out.println(queue);
                currentLabel.setText(
                    String.format("Current Number Of Students In Queue: %d",
                            this.queue.size()));
                this.maxQueue++;
                maxLabel.setText(String.format(
                    "Max Number Of Students In Queue: %d", this.maxQueue));

                inputField.setText("");
                inputField.requestFocus();
            });

        removeButton.setOnAction(e -> {
                Optional<String> result = dialog.showAndWait();
                if (result.isPresent()) {
                    //System.out.println(result.get());
                    if (result.get().equals((String) "CS1321R0X")) {
                        queue.dequeue();
                    // System.out.println(queue);
                        currentLabel.setText(String.format(
                              "Current Number Of Students In Queue: %d",
                              this.queue.size()));
                    } else {
                    assert true;
                    }
                }

                inputField.setText("");
                inputField.requestFocus();
            });

        removeButton.disableProperty().bind(Bindings.isEmpty(queue));

        addButton.disableProperty()
                .bind(Bindings.isEmpty(inputField.textProperty()));

        HBox entryBox = new HBox();
        entryBox.getChildren().addAll(inputField, addButton, removeButton);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(currentLabel, maxLabel, listView, entryBox);

        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.setTitle("CS 1321 Office Hours Queue");
        stage.show();
    }
}

package cs3500.pa05.controller;

import cs3500.pa05.model.Week;
import cs3500.pa05.model.assignments.Task;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class NewTaskController extends AbstractNewAssignmentController implements Controller {

    private Stage stage;
    @FXML
    private Button finish;
    @FXML
    private TextField nameContent;
    @FXML
    private TextField descriptionContent;
    private String name;
    private String description;
    private Task t;
    private JavaJournalController controller;

    public NewTaskController(Stage stage, Week week, JavaJournalController controller) {
        this.stage = stage;
        this.week = week;
        this.controller = controller;
    }

    @Override
    public void run() throws IllegalStateException {
        initRadioButtons();
        initCategories();
        initFinishButton();
        initCategory();
    }

    private void initFinishButton() {
        finish.setOnAction(event -> {
            if (nameContent.getText() != ""
                    && day != null) {
                name = nameContent.getText();
                if (descriptionContent.getText() != "") {
                    description = descriptionContent.getText();
                    t = new Task(name, day, description);
                    setCategory();
                } else {
                    t = new Task(name, day);
                    setCategory();
                }
                week.addTask(t);
                controller.updateAssignmentDisplay(t);
                controller.updateStatistics();
            } else {
                showInvalidTaskAlert();
            }

            stage.close();
        });
    }

    private void setCategory() {
        if (category != null) {
            t.setCategory(category);
        }
    }

    private void showInvalidTaskAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Invalid Task");
        alert.setHeaderText(null);
        alert.setContentText("Task could not be created because you left one or more required fields blank.");
        alert.showAndWait();
    }
}

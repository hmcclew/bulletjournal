package cs3500.pa05.controller;

import cs3500.pa05.model.Week;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SetMaxController implements Controller {

    private Stage stage;

    private Week week;
    @FXML
    private Button finish;
    @FXML
    private TextField setMaxEventsContent;
    @FXML
    private TextField setMaxTasksContent;

    private JavaJournalController controller;

    public SetMaxController(Stage stage, Week week, JavaJournalController controller) {
        this.stage = stage;
        this.week = week;
        this.controller = controller;
    }

    @Override
    public void run() throws IllegalStateException {
        initFinishButton();
    }

    private void initFinishButton() {
        finish.setOnAction(event -> {
            try {
                int maxEvents = Integer.parseInt(setMaxEventsContent.getText());
                int maxTasks = Integer.parseInt(setMaxTasksContent.getText());
                week.setMaximumEvents(maxEvents);
                week.setMaximumTasks(maxTasks);
                controller.displayMaxEventsWarning();
                controller.displayMaxTasksWarning();
            } catch (Exception e) {
                showInvalidMaximumError();
            }
            stage.close();
        });
    }

    private void showInvalidMaximumError() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Invalid Maximums");
        alert.setHeaderText(null);
        alert.setContentText("Maximums could not be set because there are invalid or nonexistent " +
                "entries in one or " +
                "more fields. Please ensure you are only entering integers.");
        alert.showAndWait();
    }

}

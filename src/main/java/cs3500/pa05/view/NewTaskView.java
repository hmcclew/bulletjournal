package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class NewTaskView implements JavaJournalView {
    FXMLLoader loader;

    public NewTaskView(Controller controller) {
        this.loader = new FXMLLoader();
        this.loader.setLocation(getClass().getClassLoader().getResource("newTask.fxml"));
        this.loader.setController(controller);
    }

    /**
     * Loads a scene from the Java Journal
     *
     * @return the layout
     */
    @Override
    public Scene load() throws IllegalStateException {
        try {
            return this.loader.load();
        } catch (IOException exc) {
            throw new IllegalStateException("Unable to load layout.");
        }
    }
}

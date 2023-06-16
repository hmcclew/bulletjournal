package cs3500.pa05.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public abstract class AbstractView implements JavaJournalView {

    protected FXMLLoader loader;

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

package cs3500.pa05.view;

import javafx.scene.Scene;

/**
 * Interface for a scene in the Java Journal Application
 */
public interface JavaJournalView {
  /**
   * loads a scene for the application
   *
   * @return the scene
   * @throws IllegalStateException if the scene cannot be loaded
   */
  Scene load() throws IllegalStateException;
}

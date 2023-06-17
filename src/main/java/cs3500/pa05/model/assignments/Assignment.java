package cs3500.pa05.model.assignments;

/**
 * interface for an assignment for a week
 */
public interface Assignment {

  /**
   * getter method for the assignment day
   *
   * @return the assignment day
   */
  String getDay();

  /**
   * getter method for the assignment name
   *
   * @return the assignment name
   */
  String getName();

  /**
   * gets the description for this assignment
   *
   * @return the appropriate description
   */
  String getDescription();

  /**
   * gets the category for this assignment
   *
   * @return the appropriate category
   */
  String getCategory();

  /**
   * returns the event as a json string
   *
   * @return the formatted json string
   */
  String toJsonFormat();

  /**
   * sets the category of this assignment
   *
   * @param category the category to be set
   */
  void setCategory(String category);
}

package cs3500.pa05.model.assignments;

/**
 * interface for an assignment for a week
 */
public interface Assignment {

  /**
   * sets the day of this assignment
   *
   * @param day the day to be set
   */
  void setDay(String day);

  /**
   * sets the name of this assignment
   *
   * @param name the name to be set
   */
  void setName(String name);

  /**
   * sets the description of this assignment
   *
   * @param description the description to be set
   */
  void setDescription(String description);

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
   * sets the category of this assignment
   *
   * @param category the category to be set
   */
  void setCategory(String category);
}

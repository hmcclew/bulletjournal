package cs3500.pa05.model.assignments;

/**
 * abstract class for an assignment for a java journal week
 */
public abstract class AbstractAssignment implements Assignment {

  protected String name;
  protected String day;
  protected String description;
  protected String category;

  /**
   * getter method for the assignment day
   *
   * @return the assignment day
   */
  @Override
  public String getDay() {
    return this.day;
  }

  /**
   * getter method for the assignment name
   *
   * @return the assignment name
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * gets the category for this assignment
   *
   * @return the appropriate category
   */
  @Override
  public String getCategory() {
    if (this.category != null) {
      return this.category;
    } else {
      return "No Category Available.";
    }
  }

  /**
   * gets the description for this assignment
   *
   * @return the appropriate description
   */
  @Override
  public String getDescription() {
    if (this.description != null) {
      return this.description;
    } else {
      return "No Description Available.";
    }
  }

  /**
   * sets the category of this assignment
   *
   * @param category the category to be set
   */
  public void setCategory(String category) {
    this.category = category;
  }

  /**
   * returns the event as a json string
   *
   * @return the formatted json string
   */
  public abstract String toJsonFormat();
}
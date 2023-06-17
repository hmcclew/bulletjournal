package cs3500.pa05.model.assignments;

public abstract class AbstractAssignment implements Assignment {

  protected String name;
  protected String day;
  protected String description;
  protected String category;

  @Override
  public String getDay() {
    return this.day;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public String getCategory() {
    if (this.category != null) {
      return this.category;
    } else {
      return "No Category Available.";
    }
  }

  @Override
  public String getDescription() {
    if (this.description != null) {
      return this.description;
    } else {
      return "No Description Available.";
    }
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public abstract String toJsonFormat();
}

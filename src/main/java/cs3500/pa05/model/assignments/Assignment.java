package cs3500.pa05.model.assignments;

/**
 * interface for an assignment for a week
 */
public interface Assignment {
  String getDay();

  String getName();

  String getDescription();

  String getCategory();

  String toJsonFormat();

  void setCategory(String category);
}

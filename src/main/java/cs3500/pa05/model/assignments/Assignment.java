package cs3500.pa05.model.assignments;

public interface Assignment {
  String getDay();
  String getName();
  String getDescription();
  String getCategory();
  String toJsonFormat();
  void setCategory(String category);
}

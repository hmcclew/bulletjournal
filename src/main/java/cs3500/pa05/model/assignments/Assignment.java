package cs3500.pa05.model.assignments;

public interface Assignment {
  String toString();

  String getDay();
  String getName();
  String toJsonFormat();
}

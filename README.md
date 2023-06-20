[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/x6ckGcN8)
# 3500 PA05 Project Repo

Pitch:

This application is a weekly journal that allows the user to neatly organize their tasks, events, and other relevant information 
for their week. Developed using java and javafx.
User features include:

- Week View
  The Week View displays a clear and concise overview of tasks and events for each day of the week.
  Users can effortlessly navigate through their schedule and plan their activities accordingly.
  The week view is designed to provide a visually appealing and easy-to-read representation of the entire
  week's schedule.

- Event and Task Creation
  Users can easily create new tasks and events directly within the Week View. The interface includes intuitive
  buttons for adding new tasks and events, allowing users to quickly input important information such as title,
  date, time, duration, and any additional notes. Users can also set maximum limits for tasks and events to ensure
  they maintain a manageable workload.

- Open File and Save File
  Users can open and save files associated with their weekly schedules. This feature allows users to store or retrieve
  their schedules from a .bujo file, ensuring easy access across devices. Users can save their weekly view as a file,
  allowing them to share or import it into other applications as needed. The file management functionality enhances
  the portability and flexibility of the Week View feature.

- Commitment Warnings
  Users receive a notification when their tasks or events added exceed the maximum number of events and tasks
  they set for themselves, to ensure that the student is not overworked. Those maximums and being kept track of
  in the .bujo file.

- Sidebar and Task Queue
  To further enhance task management, the Week View feature includes a task queue sidebar. This sidebar provides a
  convenient and easily accessible list of all tasks. Users can easily view and access their tasks to make sure they
  don't fall behind!

- Categories
  Users can create categories for tasks and events to facilitate organization and categorize their schedule
  based on different projects, areas of focus, or personal preferences. The feature allows users to assign a category
  to each task or event, making it easier to understand their schedule based on specific categories.

- Quotes and Notes
  Users can write any quotes and notes of their preference to their Week View and they could see it anytime on their
  schedule.

- Mini-viewer
  The user can open any single Event or Task in a new window which displays all details of the Event or Task
  including its day of the week.

- Weekly Overview
  The weekly overview feature provides users with valuable insights into their progress and productivity.
  Users can view statistics on the total number of events and tasks scheduled, as well as the percentage of completed
  tasks. The feature calculates the completion percentage based on marked tasks, giving users a visual representation
  of their accomplishments and motivating them to stay on track.

- Edit Event or Task
  This feature allows the user to edit the content of an event or task anytime and it will update
  in their week view. They can edit the name, description, and category.

- Task Search
  This feature allows the user to type to search for any Task. Only Tasks relevant to the search are shown.
  Search results are updated on each key press.

- Splash Screen
  Created a splash screen effect where the welcome screen pauses for 2 seconds then
  shows the week view.

- Privacy Lock
  Ability for user to add a password which is required before showing the contents of any journal.

- Weekly Starters
  This feature allows users to open a .bujo file as a template. Users are then be prompted to give the new week a
  name, and it overrides the name in the template if one exists. Features carried over include categories,
  weekly maximums, and the week's notes. 
  

[PA Write Up](https://markefontenot.notion.site/PA-05-8263d28a81a7473d8372c6579abd6481)
![WeekView.png](WeekView.png)

SOLID:

Single Responsibility Principle: We applied single responsibility by ensuring each class only served one main function 
in the program. For example, each Scene associated with a feature has its own controller and view (e.g., EditTaskView 
and EditTaskController). These controllers and views are instantiated based on user interaction in the main WeekView 
controlled by the main JavaJournalController. In the model, the Week class was the main model comprised of Task, 
Assignment, and Day classes. Any logic specifically involving one of these components was handled in the respective 
class. That component was updated within the week, as the week was composed of several of these smaller class 
components.

Open-Closed Principle: We used several abstract classes in this program, including AbstractAssignment. Both the Event 
and Task classes extended AbstractAssignment and protected fields. However, AbstractAssignment only contained methods 
and fields used by both assignments (e.g., name, day, category). For example, an Event includes start time and duration 
while Task does not. These fields were not placed in AbstractAssignment and only within Event. We followed this same 
practice for Tasks and their completion status. We also used an AbstractView for the load method; however, each class 
that extended AbstractView had its own constructor since each view loaded a different .fxml file. 
AbstractNewAssignmentController initializes .fxml fields and buttons for selecting categories and weekdays,
but what to do with those selections is determined by the subclasses.

Liskov-Substitution Principle: Our program also used an AbstractNewAssignmentController. This class was responsible 
for initializing fields used while creating an event and creating a task, such as toggling the Monday-Sunday buttons, 
as only one could be selected at a time. The class also initializes the categories in the choice box. 
EditTaskController, NewTaskController, and AbstractEventController all extend this class. AbstractEventController adds 
specifications for the text fields in start time and duration to only allow numerical input up to two digits. 
These abstract classes define no additional abstract methods that all other extending classes must implement. Since 
Task and Event have the same required fields in terms of what’s defined for the abstract classes, replacing the 
superclass would not break the system. Abstract classes contain no implemented methods that are overridden in any 
subclass, only methods marked as abstract to be implemented.

Interface Segregation Principle: Our program uses several interfaces that are kept short and sweet. Our controller 
interface only features the run() method, even though each controller contains several additional helper methods 
depending on the controller’s purpose. Because the controllers do not have much overlap in purpose, these methods are 
left out of the controller interface. When multiple classes used a method, Abstract Classes were implemented instead. 
Similarly, our view interface only contains the load() method used by all implementing classes. Our assignment 
interface also only contains methods applicable to the fields that a task and event share, such as day, description, 
name, and category. Methods associated with fields, such as start time, duration, and completion status, were only 
implemented in their relevant classes.

Dependency Inversion Principle: When handling the appearance of our Week View after creating or editing an assignment, 
the logic was handled in methods that used Assignment as a parameter instead of specifically Task or Event. They were 
then sent to respective methods to handle their class-specific data. This way, the weekly display depends on the 
interface Assignment instead of the specific implementation of the Task or Event. 

FUTURE EXTENSION:

Our program could be extended in several ways. For example, we allow assignment editing but not assignment deletion. 
Upon saving an edit, the old assignment is removed from the week and displayed, and a new one with the updated 
information is added. This could easily be implemented via a new button in the editor display that simply removes the 
VBox containing the assignment information from the display and updates the week with this data. Simply 
skipping the step of adding a new assignment. Another way our program could be extended is through a progress bar. 
Our program already tracks the percentage of completed tasks for a week, and this could easily be extended to calculate 
for days. The progress bar could also show completed tasks for a week. Each time the week’s statistics are updated in 
the program, functionality could simply be added to update the fill of the progress bar. 

Image used for background visuals:
![25bc5b65efbcc01d0aff1481db1d88c4.jpg](..%2F..%2F25bc5b65efbcc01d0aff1481db1d88c4.jpg)
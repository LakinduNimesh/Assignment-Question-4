
import java.util.Scanner;
import java.util.Stack;

class EmergencyTask {
    private int taskId;
    private String taskDescription;
    private int priorityLevel;
    private boolean isCompleted;

    public EmergencyTask(int taskId, String taskDescription, int priorityLevel) {
        this.taskId = taskId;
        this.taskDescription = taskDescription;
        this.priorityLevel = priorityLevel;
        this.isCompleted = false;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markAsCompleted() {
        this.isCompleted = true;
    }

    @Override
    public String toString() {
        return " Task ID        : " + taskId + "\n Description    : " + taskDescription +
                "\n Priority Level : " + priorityLevel + "\n Status         : " + (isCompleted ? "Completed" : "Pending");
    }
}

class TaskManager {
    private Stack<EmergencyTask> taskStack;

    public TaskManager() {
        taskStack = new Stack<>();
    }

    public void addTask(EmergencyTask task) {
        taskStack.push(task);
        System.out.println(" Task added successfully. Current stack size: " + taskStack.size());
    }

    public void completeTask() {
        if (taskStack.isEmpty()) {
            System.out.println(" No tasks to complete.");
            return;
        }
        EmergencyTask task = taskStack.pop();
        task.markAsCompleted();
        System.out.println(" Completed Task:");
        System.out.println(task);
    }

    public void displayTasks() {
        if (taskStack.isEmpty()) {
            System.out.println(" No pending tasks.");
            return;
        }
        System.out.println();
        System.out.println(" Current Tasks in the Stack:");
        System.out.println("================================================");

        for (int i = 0; i < taskStack.size(); i++) {
            EmergencyTask task = taskStack.get(i);
            System.out.println("               {" + (i + 1) + "} ");
            System.out.println("================================================");
            System.out.println();
            System.out.println(task);
        }
    }
}

public class EmergencyTaskSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        System.out.println("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
        System.out.println("+                                                   +");
        System.out.println("+         Emergency Task Handling System            +");
        System.out.println("+                                                   +");
        System.out.println("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
        System.out.println();


        while (true) {
            System.out.println();
            System.out.println(" Choose an option (1/2/3/4)");
            System.out.println(" 1. Add an Urgent Task");
            System.out.println(" 2. Complete the most Urgent Task");
            System.out.println(" 3. Display all Urgent Tasks");
            System.out.println(" 4. Exit the system");
            System.out.print("--> ");
            String choice = scanner.nextLine();
            System.out.println();

            switch (choice) {
                case "1":
                    System.out.print(" Enter Task ID             : ");
                    int id;
                    while (true) {
                        try {
                            id = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.print(" Invalid input. Please enter a valid Task ID: ");
                        }
                    }
                    System.out.print(" Enter Task Description    : ");
                    String description = scanner.nextLine();
                    System.out.println(" |  Higher the number higher the priority |");
                    System.out.print(" Enter Task Priority Level : ");
                    int priority;

                    while (true) {
                        try {
                            priority = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.print(" Invalid input. Please enter a valid Priority Level: ");
                        }
                    }
                    EmergencyTask newTask = new EmergencyTask(id, description, priority);
                    taskManager.addTask(newTask);
                    break;

                case "2":
                    taskManager.completeTask();
                    break;

                case "3":
                    taskManager.displayTasks();
                    break;

                case "4":
                    System.out.println(" Exiting the system.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println(" Invalid option. Please try again.");
            }
        }
    }
}
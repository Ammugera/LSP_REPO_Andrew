package org.howard.edu.lsp.lspfinal.question2;

import java.util.HashMap;
import java.util.Map;

/**
 * Core service class that tracks tasks in memory using a HashMap.
 */
public class TaskManager {
    /** Key = task name, Value = Task object. */
    private final Map<String, Task> tasks = new HashMap<>();

    /**
     * Add a new unique task.
     *
     * @throws DuplicateTaskException if the name already exists
     */
    public void addTask(String name, int priority, String status)
            throws DuplicateTaskException {
        if (tasks.containsKey(name)) {
            throw new DuplicateTaskException("Task '" + name + "' already exists.");
        }
        tasks.put(name, new Task(name, priority, Status.fromString(status)));
    }

    /**
     * Retrieve a task by its unique name.
     *
     * @throws TaskNotFoundException if no task matches
     */
    public Task getTaskByName(String name) throws TaskNotFoundException {
        Task t = tasks.get(name);
        if (t == null) {
            throw new TaskNotFoundException("Task '" + name + "' not found.");
        }
        return t;
    }

    /**
     * Update the status field of an existing task.
     *
     * @throws TaskNotFoundException if the task name is unknown
     */
    public void updateStatus(String name, String newStatus)
            throws TaskNotFoundException {
        Task t = getTaskByName(name);      // re-uses validation
        t.setStatus(Status.fromString(newStatus));
    }

    /** Print every task, grouped by status, in the order TODO, IN_PROGRESS, DONE. */
    public void printTasksGroupedByStatus() {
        System.out.println("Tasks grouped by status:");
        for (Status s : Status.values()) {
            System.out.println(s + ":");
            tasks.values().stream()
                 .filter(t -> t.getStatus() == s)
                 .sorted((a, b) -> Integer.compare(a.getPriority(), b.getPriority()))
                 .forEach(t -> System.out.println("  " + t));
        }
    }
}
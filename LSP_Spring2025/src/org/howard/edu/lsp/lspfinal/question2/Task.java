package org.howard.edu.lsp.lspfinal.question2;

/**
 * Immutable value object representing an individual task
 */
public class Task {
    private final String name;
    private final int priority;
    private Status status;

    /**
     * constructs a new task
     *
     * @param name     unique task name
     * @param priority smaller number → higher priority
     * @param status   initial Status
     */
    public Task(String name, int priority, Status status) {
        this.name = name;
        this.priority = priority;
        this.status = status;
    }

    /** @return the unique task name */
    public String getName() { return name; }

    /** @return integer priority (smaller ⇒ higher) */
    public int getPriority() { return priority; }

    /** @return current {@link Status} of the task */
    public Status getStatus() { return status; }

    /**
     * Update task status
     * @param status new status to apply
     */
    public void setStatus(Status status) { 
    	this.status = status; 
    	}

    @Override
    public String toString() {
        return "Task{name='" + name + "', priority=" + priority
               + ", status='" + status + "'}";
    }
}

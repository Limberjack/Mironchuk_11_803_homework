package task_manager.state;

import task_manager.Task;

public class Open extends State {
    @Override
    public State up(String [] arg) {
        return new Assigned(arg);
    }

    @Override
    public State down(String [] arg) {
        return new Backlog();
    }

    @Override
    public void updateTask(Task task) {
        ;
    }

    @Override
    public String toString() {
        return "Task's state has changed to \"open\"";
    }
}

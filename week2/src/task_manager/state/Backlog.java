package task_manager.state;

import task_manager.Task;

public class Backlog extends State {
    @Override
    public State up(String[] arg) {
        return new Open();
    }

    @Override
    public State down(String[] arg) {
        return this;
    }

    @Override
    public void updateTask(Task task) {
        ;
    }

    @Override
    public String toString() {
        return "Task's state has changed to \"backlog\"";
    }
}

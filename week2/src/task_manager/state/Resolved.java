package task_manager.state;

import task_manager.Task;

public class Resolved extends State {

    @Override
    public State up(String[] arg) {
        return new Testing(arg);
    }

    @Override
    public State down(String[] arg) {
        return new InProgress();
    }

    @Override
    public void updateTask(Task task) {
        ;
    }

    @Override
    public String toString() {
        return "Task's state has changed to \"resolved\"";
    }
}

package task_manager.state;

import task_manager.Task;
import task_manager.prototype.Prototype;

public class Assigned extends State {

    private String developerId;

    public Assigned(String []arg){
        developerId = arg[0];
    }

    @Override
    public State up(String[] arg) {
        return new Resolved();
    }

    @Override
    public State down(String[] arg) {
        return new Open();
    }

    @Override
    public void updateTask(Task task) {
        task.setDeveloperId(developerId);
    }

    @Override
    public String toString() {
        return "Task's state has changed to \"assigned\" with developer: " + developerId;
    }

    @Override
    public Prototype copy(){
        String [] arg = new String [1];
        arg[0] = developerId;
        return  new Assigned(arg);
    }
}

package task_manager.state;

import task_manager.Task;
import task_manager.prototype.Prototype;

public class Testing extends State {
    private String testerId;

    public Testing(String []arg){
        testerId = arg[0];
    }

    @Override
    public State up(String[] arg) {
        return new Resolved();
    }

    @Override
    public State down(String[] arg) {
        return new Closed();
    }

    @Override
    public void updateTask(Task task) {
        task.setTesterId(testerId);
    }

    @Override
    public Prototype copy(){
        String [] arg = new String [1];
        arg[0] = testerId;
        return  new Assigned(arg);
    }

    @Override
    public String toString() {
        return "Task's state has changed to \"testing\" with developer: " + testerId;
    }
}

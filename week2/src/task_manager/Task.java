package task_manager;

import task_manager.prototype.Prototype;
import task_manager.state.Draft;
import task_manager.state.State;

public class Task implements Prototype {
    private State state;
    private String developerId;
    private String testerId;
    private String taskID;

    public void setState(State state) {
        this.state = state;
    }

    public void setDeveloperId(String developerId) {
        this.developerId = developerId;
    }

    public void setTesterId(String testerId) {
        this.testerId = testerId;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    public Task(){
        state = new Draft();
        developerId = null;
        testerId = null;
        taskID = null;
    }

    public Task(int id){
        state = new Draft();
        developerId = null;
        testerId = null;
        taskID = ""+id;
    }

    public void Up(String [] arg){
        state = state.up(arg);
        state.updateTask(this);
    }
    public void Down(String [] arg){
        state = state.down(arg);
        state.updateTask(this);
    }

    @Override
    public Prototype copy() {
        Task newOne = new Task();
        newOne.setTesterId(this.testerId);
        newOne.setDeveloperId(this.developerId);
        newOne.setState(this.state);
        return newOne;
    }

    public void setTaskID(int id) {
        taskID = "" + id;
    }

    public State getState() {
        return state;
    }

    public String getDeveloperId() {
        return developerId;
    }

    public String getTesterId() {
        return testerId;
    }

    public String getTaskID() {
        return taskID;
    }
}

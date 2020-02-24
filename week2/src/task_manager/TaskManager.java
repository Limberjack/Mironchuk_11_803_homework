package task_manager;

import task_manager.proxy.TaskProxy;

import java.util.LinkedList;

public class TaskManager {
    private LinkedList<Task> tasks;
    public TaskManager(){
        tasks = new LinkedList<>();
    }

    public int createTask(){
        tasks.addLast(new Task());
        tasks.getLast().setTaskID(tasks.size() - 1);
        return tasks.size() - 1;
    }

    public Task getTask(int id){
        return tasks.get(id);
    }
    public int copyTask(int id){
        tasks.addLast((Task)tasks.get(id).copy());
        tasks.getLast().setTaskID(tasks.size() - 1);
        return tasks.size() - 1;
    }
}

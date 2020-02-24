package task_manager.proxy;

import task_manager.Task;
import task_manager.TaskManager;

import java.io.*;

public class TaskProxy {
    private Task task;
    private Writer log;

    public TaskProxy (Task task){
        this.task = task;
        try {
            log = new FileWriter(new File("log.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            log.write("created task: " + this.task.getTaskID());
            log.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public TaskProxy (TaskManager taskManager){
        task = taskManager.getTask(taskManager.createTask());

        try {
            log = new FileWriter(new File("log.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            log.write("created task: " + task.getTaskID());
            log.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public TaskProxy (TaskManager taskManager, int id){
        task = taskManager.getTask(taskManager.copyTask(id));

        try {
            log = new FileWriter(new File("log.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            log.write("created task: " + task.getTaskID());
            log.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goBack(String args[]){
        task.Down(args);
        logAction();
    }

    public void goForward(String args[]){
        task.Up(args);
        logAction();
    }

    private void logAction(){
        try {
            log.write( task.getTaskID() + " " + task.getState().toString() + "\n");
            log.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

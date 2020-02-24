package task_manager.state;

import task_manager.Task;
import task_manager.prototype.Prototype;

public abstract class State implements Prototype {
    public abstract State up(String [] arg);
    public abstract State down(String [] arg);
    public abstract void updateTask(Task task);
    public abstract String toString();
    public Prototype copy(){
      State newOne = this;
      return newOne;
    }
}

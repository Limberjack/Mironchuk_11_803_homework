package task_manager;

import task_manager.proxy.TaskProxy;

public class Demo {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        TaskProxy taskProxy = new TaskProxy(taskManager);

        String args_[] = new String[1];
        args_[0] = "qwerty123";

        taskProxy.goForward(args_);
        taskProxy.goForward(args_);
        taskProxy.goForward(args_);
        taskProxy.goForward(args_);
    }
}

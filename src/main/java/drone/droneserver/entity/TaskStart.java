package drone.droneserver.entity;

/**
 *
 * @author alex
 */
public class TaskStart extends Block {

    private String node;
    private String task;

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

}

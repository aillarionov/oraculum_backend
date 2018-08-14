package drone.droneserver.entity;

/**
 *
 * @author alex
 */
public class TaskFinish extends Block {

    private String node;
    private String task;
    private Boolean success;

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

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

}

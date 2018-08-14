package drone.droneserver.entity;

import java.util.Set;

/**
 *
 * @author alex
 */
public class Telemetry extends Block {

    private String node;
    private String task;
    private String cargo;
    private String route;
    private Object data;
    private Set<String> meet;

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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Set<String> getMeet() {
        return meet;
    }

    public void setMeet(Set<String> meet) {
        this.meet = meet;
    }

}

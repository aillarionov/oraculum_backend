package drone.droneserver.entity;

/**
 *
 * @author alex
 */
public class PathPoint {

    private Number lat;
    private Number lon;
    private Number alt;
    private String action;
    private Object parameters;

    public Number getLat() {
        return lat;
    }

    public void setLat(Number lat) {
        this.lat = lat;
    }

    public Number getLon() {
        return lon;
    }

    public void setLon(Number lon) {
        this.lon = lon;
    }

    public Number getAlt() {
        return alt;
    }

    public void setAlt(Number alt) {
        this.alt = alt;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Object getParameters() {
        return parameters;
    }

    public void setParameters(Object parameters) {
        this.parameters = parameters;
    }

}

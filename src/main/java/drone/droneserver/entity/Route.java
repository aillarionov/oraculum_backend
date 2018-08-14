package drone.droneserver.entity;

import java.util.LinkedHashSet;

/**
 *
 * @author alex
 */
public class Route extends Block {

    LinkedHashSet<PathPoint> points;

    public LinkedHashSet<PathPoint> getPoints() {
        return points;
    }

    public void setPoints(LinkedHashSet<PathPoint> points) {
        this.points = points;
    }

}

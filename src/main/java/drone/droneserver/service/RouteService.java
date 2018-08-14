package drone.droneserver.service;

import drone.droneserver.dao.RouteDAO;
import drone.droneserver.entity.Route;

/**
 *
 * @author alex
 */
public class RouteService extends CommonService<Route> {

    private final RouteDAO dao = new RouteDAO();

    public Route get(String id) {
        return dao.get(id);
    }

    public void create(String id, Route route) {
        dao.put(id, route);
    }

}

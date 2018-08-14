package drone.droneserver.service;

import drone.droneserver.dao.NodeDAO;
import drone.droneserver.entity.Node;

/**
 *
 * @author alex
 */
public class NodeService extends CommonService<Node> {

    private final NodeDAO dao = new NodeDAO();

    public Node get(String id) {
        return dao.get(id);
    }

    public void create(String id, Node node) {
        dao.put(id, node);
    }

}

package drone.droneserver.service;

import drone.droneserver.dao.TelemetryDAO;
import drone.droneserver.entity.Telemetry;
import java.util.Map;

/**
 *
 * @author alex
 */
public class TelemetryService extends CommonService<Telemetry> {

    private final TelemetryDAO dao = new TelemetryDAO();

    public Telemetry get(String id) {
        return dao.get(id);
    }

    public void create(Map<String, Telemetry> nodeData) {
        dao.put(nodeData);
    }

}

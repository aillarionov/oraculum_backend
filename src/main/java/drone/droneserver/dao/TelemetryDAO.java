package drone.droneserver.dao;

import com.mongodb.client.FindIterable;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import drone.droneserver.entity.Telemetry;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author alex
 */
public class TelemetryDAO extends CommonDAO<Telemetry> {

    public Set<Telemetry> getByContractAndNode(String contract, String node) {
        Set<Telemetry> result = new HashSet<>();

        FindIterable<Telemetry> data = getCollection().find(
                and(
                        eq("type", "node_data"),
                        eq("contract", contract),
                        eq("node", node)
                )
        );

        for (Iterator<Telemetry> iterator = data.iterator(); iterator.hasNext();) {
            result.add(iterator.next());
        }

        return result;
    }
}

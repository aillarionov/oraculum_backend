package drone.droneserver.dao;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.model.Aggregates;
import drone.droneserver.entity.Task;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.bson.Document;

/**
 *
 * @author alex
 */
public class TaskDAO extends CommonDAO<Task> {

    public Set<String> getFree() {
        Set<String> result = new HashSet<>();

        AggregateIterable<Document> data = getDocumentCollection().aggregate(Arrays.asList(
                Aggregates.match(new Document("type", "task")),
                Aggregates.lookup("blocks", "_id", "task", "__linked"),
                Aggregates.match(new Document("__linked", new Document("$size", 0))),
                Aggregates.project(new Document("_id", 1))
        ));

        for (Document d : data) {
            String id = d.getString("_id");
            result.add(id);
        }

        return result;
    }

}

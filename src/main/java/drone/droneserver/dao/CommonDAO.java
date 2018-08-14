package drone.droneserver.dao;

import com.google.gson.Gson;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Aggregates;
import static com.mongodb.client.model.Filters.eq;
import drone.droneserver.DBConfig;
import drone.droneserver.entity.Block;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.bson.Document;

/**
 *
 * @author alex
 * @param <T>
 */
public class CommonDAO<T extends Block> {

    protected Gson gson = new Gson();

    private Class<T> getGenericTypeClass() {
        try {
            String className = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0].getTypeName();
            Class<?> clazz = Class.forName(className);
            return (Class<T>) clazz;
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Class is not parametrized with generic type");
        }
    }

    protected MongoCollection<T> getCollection() {
        return DBConfig.getDB().getCollection("blocks", getGenericTypeClass());
    }

    protected MongoCollection<Document> getDocumentCollection() {
        return DBConfig.getDB().getCollection("blocks");
    }

    public T get(String id) {
        return getCollection().find(eq("_id", id)).first();
    }

    public void put(String id, T entity) {
        getDocumentCollection().insertOne(toDocument(id, entity));
    }

    public void put(Map<String, T> entities) {
        List<Document> ds = entities.entrySet().stream().map((t) -> toDocument(t.getKey(), t.getValue())).collect(Collectors.toList());
        getDocumentCollection().insertMany(ds);
    }

    public Set<String> getPrevious() {
        Set<String> result = new HashSet<>();

        AggregateIterable<Document> data = getDocumentCollection().aggregate(Arrays.asList(
                Aggregates.lookup("blocks", "_id", "previous", "__linked"),
                Aggregates.match(new Document("__linked", new Document("$size", 0))),
                Aggregates.project(new Document("_id", 1))
        ));

        for (Document d : data) {
            String id = d.getString("_id");
            result.add(id);
        }

        return result;
    }

    protected Document toDocument(String id, T entity) {
        Document d = Document.parse(gson.toJson(entity));
        d.append("_id", id);
        return d;
    }

}

package drone.droneserver;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author alex
 */
public class DBConfig {

    private static final CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(), fromProviders(PojoCodecProvider.builder().automatic(true).build()));
    private static final MongoClient mongoClient = new MongoClient("127.0.0.1", MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
    //private static final MongoClient mongoClient = new MongoClient("10.211.55.6", MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
    private static final MongoDatabase db = mongoClient.getDatabase("drone");

    public static MongoDatabase getDB() {
        return db;
    }
}

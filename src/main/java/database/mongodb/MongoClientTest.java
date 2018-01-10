package database.mongodb;

import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.ListCollectionsIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;

/**
 * Created by srapolu on 1/25/17.
 */
public class MongoClientTest {
    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient("localhost", 27017);

        MongoIterable<String> mongoDatabaseNames = mongoClient.listDatabaseNames();
        for (String mongoDatabaseName : mongoDatabaseNames) {
            System.out.println("MongoClientTest: " + mongoDatabaseName);
        }

        MongoDatabase database = mongoClient.getDatabase("local");
        ListCollectionsIterable<Document> tables = database.listCollections();
        for (Document table: tables ) {
            System.out.println("mbureauTable: " + table);
        }

        
        MongoCollection<Document> weigntSensorTable =  database.getCollection("weightsensor");
        
        
    }
}

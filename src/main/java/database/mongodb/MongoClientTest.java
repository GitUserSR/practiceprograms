package database.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.ListCollectionsIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;

/**
 * Created by srapolu on 1/25/17.
 */
public class MongoClientTest {
    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient();

        MongoIterable<String> mongoDatabaseNames = mongoClient.listDatabaseNames();
        for (String mongoDatabaseName : mongoDatabaseNames) {
            System.out.println("MongoClientTest: " + mongoDatabaseName);
        }

        MongoDatabase mbureauDatabase = mongoClient.getDatabase("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz1111111111");
        ListCollectionsIterable<Document> mbureauTables = mbureauDatabase.listCollections();
        for (Document mbureauTable: mbureauTables ) {
            System.out.println("mbureauTable: " + mbureauTable);
        }




    }
}

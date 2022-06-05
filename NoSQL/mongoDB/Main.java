import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.Document;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {



        MongoClient mongo = new MongoClient( "localhost" , 27017 );

         String path = "C:\\Users\\abake\\IdeaProjects\\mongoDb\\data\\mongo (1).csv";
         List<String> csv =  parseFile(path);
        MongoCredential credential;
        credential = MongoCredential.createCredential("sampleUser", "myDb",
                "password".toCharArray());
        MongoDatabase database = mongo.getDatabase("myDb");
        System.out.println("Credentials ::"+ credential);


        MongoCollection<Document> collection = database.getCollection("students");

        for (int i = 0; i < csv.size(); i++) {
            Document document = new Document();
            String studentInfo = csv.get(i);

            String[] splittedInfo = studentInfo.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

            String name = splittedInfo[0];
            String age = splittedInfo[1];
            String courses = splittedInfo[2];
            document.append("name", name)
            .append("age", age)
            .append("courses",courses);
            collection.insertOne(document);
        }

        BsonDocument query =  BsonDocument.parse("{age: {$gt: 40}}");
        System.out.println("Кол-во студентов " + collection.countDocuments());
        System.out.println("Кол-во студентов старше 40:" + collection.find(query).iterator().next().size());


        collection.drop();
    }

    public static List<String> parseFile(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }


        return lines;
    }
}

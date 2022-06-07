import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.Document;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Indexes;
import com.mongodb.client.model.Updates;

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

        BsonDocument query =  BsonDocument.parse("{age: {$gt: 40} }");
        BsonDocument query2 =  BsonDocument.parse("{age: 1}");
        BsonDocument query3 =  BsonDocument.parse("{age: -1}");

        System.out.println("Кол-во студентов " + collection.countDocuments());


        collection.find().sort(query2).limit(1).forEach((Consumer<Document>) document -> {
            System.out.println("Имя самого молодого студента: " + document.get("name"));
        });
        collection.find().sort(query3).limit(1).forEach((Consumer<Document>) document -> {
            System.out.println("Список курсов самого старого студента: " + document.get("courses"));
        });

        System.out.println(collection.countDocuments(Filters.gt("age", 40L)));



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


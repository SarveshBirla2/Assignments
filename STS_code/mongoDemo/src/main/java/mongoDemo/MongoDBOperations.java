package mongoDemo;



import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.Updates;

public class MongoDBOperations {
  public static void main(String[] args) {
	  System.out.println("***MongoDB operations demo 12434*****");
	  
	  MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
	  MongoDatabase database = mongoClient.getDatabase("demodb");
	  MongoCollection<Document> collection = database.getCollection("Employee");
	  
	  /*
	  FindIterable<Document> i = collection.find();
	  
	  for(Document d :i) {
		  System.out.println(d);
		  
	  }
	  */
	  
	  
	  /*
	  Document doc = new Document();
	  
	  doc.append("name", "Omkar");
	  doc.append("age", 33);
	  doc.append("salary", 60000);
	  doc.append("designation", "Programmer");
	  collection.insertOne(doc);
	  
	  */
	  
	//  collection.insertOne(new Document().append("name", "Kaif").append("age", 38).append("salary",75000).append("designation", "Programmmer"));
	
	  /*
	  List<Document> empList =new ArrayList<Document>();
	  
	  empList.add(new Document().append("name", "Harshal").append("age", 39).append("salary",40000).append("designation", "Programmmer"));
	  empList.add(new Document().append("name", "Shoyab").append("age", 25).append("salary",60000).append("designation", "Programmmer"));
	  empList.add(new Document().append("name", "Sanchit").append("age", 30).append("salary",50000).append("designation", "Programmmer"));
	  
	  collection.insertMany(empList);
	  */
	  
	  /*
	  Bson projection1 = Projections.excludeId() ;
	  Bson projection2 = Projections.exclude("_id","age","salary");
	  
	  Bson filter = Filters.eq("designation","Programmmer");
	  
	  Bson asort = Sorts.ascending("salary");
	  Bson dsort = Sorts.descending("age");
	  
	  
	  FindIterable<Document> i =  collection.find(filter).projection(projection2).sort(asort);
	  
	  for(Document d :i) {
		  System.out.println(d.toJson());
	  }
	  
	  */
	  
	  Bson filter = Filters.gt("age", 35);
	  Bson update = Updates.set("designation", "Manager");
	  collection.updateMany(filter, update);
	  
	  
	  Bson filter2 = Filters.eq("name", "Harshal");
	  collection.deleteOne(filter2);
	  
	  System.out.println("Successfully did opearations to MongDB");
	  
	  mongoClient.close();
	  
	  
  }
}

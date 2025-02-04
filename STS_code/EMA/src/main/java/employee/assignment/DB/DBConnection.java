package employee.assignment.DB ;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class DBConnection {
	  static MongoClient mongoClient = null ;
	  private DBConnection(){
		  
	  }
	  
	  public static MongoClient getConnection() {
		  if(mongoClient == null) {
			  mongoClient = MongoClients.create("mongodb://localhost:27017");
		  }
		  return mongoClient ;
	  }
	  public static void close() {
		  if(mongoClient!=null) {
			  mongoClient.close();
		  }
	  }
}

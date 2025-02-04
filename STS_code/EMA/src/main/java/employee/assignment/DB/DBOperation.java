package employee.assignment.DB;
import employee.assignment.*;
import EMA.*;
import java.util.*;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.Updates;
public class DBOperation {
	
	 private static MongoClient con = DBConnection.getConnection();
     private static MongoDatabase database = con.getDatabase("demodb");
     private static MongoCollection<Document> collection = database.getCollection("Employee");
     
     public static int giveEmployeecount() {
    	return (int)collection.countDocuments();
     }
    public static void save(Employee e) {
        
        Document doc = new Document();
      doc.append("_id", EmployeeManagementApp.empCount);
   	  doc.append("name", e.getName() );
   	  doc.append("age", e.getAge());
   	  doc.append("salary", e.getSalary());
   	  doc.append("designation", e.getDesignation()) ;	
   	  doc.append("department", e.getDepartment());
   	  collection.insertOne(doc);  
   	  
    }
    public static HashMap<Integer,String> readDesignations(){
    	Bson projection = Projections.include("designation");
    	FindIterable<Document> itr =  collection.find().projection(projection);
    	HashMap<Integer,String> hmp =new HashMap<Integer,String>();
    	
    	for(Document d : itr) {
    		
    		String  designation = d.getString("designation");
    		hmp.put(hmp.size()+1, designation);
    	}
    	return hmp;
    	
    }
    
    public static <T> void updateById(int id ,String parameter,T updatedValue) {
      Bson filter = Filters.eq("_id", id);
  	  Bson update = Updates.set(parameter, updatedValue );
  	  collection.updateOne(filter, update);
    }
    public static Document readById(int id){
    	Bson filter = Filters.eq("_id", id);
    	Document doc  = collection.find(filter).first();
    	return doc;
    }
    
    public static HashMap<Integer,String> readDepartments(){
    	Bson projection = Projections.include("department");
    	FindIterable<Document> itr =  collection.find().projection(projection);
    	HashMap<Integer,String> hmp =new HashMap<Integer,String>();
    	
    	for(Document d : itr) {
    		
    		String  department = d.getString("department");
    		hmp.put(hmp.size()+1, department);
    	}
    	return hmp;
    	
    }
    
    public static FindIterable<Document> read(String orderBy){
    	Bson asort = Sorts.ascending(orderBy);
    	FindIterable<Document> i =  collection.find().sort(asort);
    	return i;
    }
    
	public static void delete(int id ){
		Bson filter = Filters.eq("_id", id);
		  collection.deleteOne(filter); 
	}
}

package JSONdemo;
import java.sql.*;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class learnJSON {
   public static void main(String[] args) {
	    
	  
    try {
    	
    	String menu = "1 .Create\n2 .Read\n3 .Update\n4 .Delete\n5 .Exit";
    	int ch=0;
    	while(ch!=5) {
    		ch = Menu.readChoice(5, menu);
    		switch(ch) {
    		case 1: DBoperation.create();
    		break;
    		case 2: DBoperation.read();
    		break;
    		case 3: DBoperation.update();
    		break;
    		case 4: DBoperation.delete();
    		break;
    		case 5: 
    		break;
    		}
    	}
    	
   }
   catch(Exception e) {
	   System.out.println(e);
   }
   finally{
	  DBConnection.close(); 
	  DBoperation.close();
   }
   }
}

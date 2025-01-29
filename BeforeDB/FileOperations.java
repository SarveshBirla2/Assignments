package employee.assignment ;
import java.io.*;

import java.util.*;

import employee.assignment.Designation;
import employee.assignment.Employee;
import employee.assignment.EmployeeMap;
import employee.assignment.Programmer;

public class FileOperations {
    public static void readEmployees() {
//    //  HashMap<Integer,Employee> list;
//      try(
//         RandomAccessFile raf = new RandomAccessFile("employees.csv", "r")
//      ){
//        String line = null;
//        while((line=raf.readLine())!=null){
//         String data[]= line.split(",");
//         int id = Integer.parseInt(data[0]);
//         int salary = Integer.parseInt(data[1]);
//         Designation d = Designation.valueOf(data[2]);
//         int age = Integer.parseInt(data[3]);
//         String name= data[4];
       

//        // int EmployeeID,int salary,Designation designation ,int age , String name
//         switch(d){
//             case CEO -> {
//                 EmployeeMap.isCeoPresent=true;
//                 CEO.getCEO(id, salary, d, age, name) ;
//             }   
//             case CLERK-> new Clerk(id,salary,d,age,name) ;
//             case PROGRAMMER -> new Programmer(id,salary,d,age,name) ;
//             case MANAGER -> new Manager(id,salary,d,age,name) ;
//         }
        
//        }
//      } 
//      catch (Exception e){
//         System.out.println(e);
//      } 
//     // return list;
   try{
    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Employees.ser"));

    EmployeeMap.Employees = (HashMap<Integer,Employee>)ois.readObject() ;
   }
  catch(Exception e){
    System.out.println(e);
  }
    }
    
    public static void save(){
        
        // try(RandomAccessFile raf = new RandomAccessFile("employees.csv", "rw")){
        //         Iterator itr = EmployeeMap.Employees.entrySet().iterator();
        //         while(itr.hasNext()){
        //             Map.Entry me = (Map.Entry)itr.next();
        //             Employee emp=(Employee)me.getValue();
        //             raf.writeBytes(emp.toString());
        //         }
        // }
        // catch(Exception e){
        //     System.out.println(e);
        // }

    try{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Employees.ser"));

        oos.writeObject(EmployeeMap.Employees);
    }
    catch(Exception e){
        System.out.println(e);
    }
  
    }
}

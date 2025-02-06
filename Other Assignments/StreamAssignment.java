import java.util.*;
import java.util.stream.*;
public class StreamAssignment {

    public static void main(String[] args) {
        List<Student> StudentList = new ArrayList<Student>();  
        Student.Dummydata(StudentList);
        
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        // System.out.println("How many students in each standard");
        // System.out.println(StudentList.stream().collect(Collectors.groupingBy(e->e.getStandard())));
        System.out.println("*How many students male and Female");
        System.out.println(StudentList.stream().collect(Collectors.groupingBy(e->e.getGender(),Collectors.counting())));
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("*How many students failed and passed ( 40% ) - Whole University ");
        System.out.println(StudentList.stream().collect(Collectors.partitioningBy(e->e.getPercentage()>40.00,Collectors.counting())));
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("*How many students failed and passed ( 40% ) - School Wise");
        System.out.println(StudentList.stream().collect(Collectors.groupingBy(e->e.getSchool(),Collectors.partitioningBy(e->e.getPercentage()>40.00,Collectors.counting()))));
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("*Top 3 students based on percentage");
        System.out.println(StudentList.stream().sorted((a, b) -> (double) (a.getPercentage() - b.getPercentage())>0?-1:1).limit(3).collect(Collectors.toList()));
        
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
       
        System.out.println("*Top scorer school wise");
        System.out.println(StudentList.stream().collect(Collectors.toMap(
                Student::getSchool, // Key: School name
                student -> student, // Value: Student object
                (s1, s2) -> s1.getPercentage() > s2.getPercentage() ? s1 : s2 // Keep the student with the highest percentage
        )));


        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    
        System.out.println("*Average age of male & female");
        System.out.println(StudentList.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge))));
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
              
       System.out.println("*Total fees collected school-wise");
      System.out.println(StudentList.stream().collect(Collectors.groupingBy(Student::getSchool, Collectors.summingInt(s -> s.getFee().getFeesPaid()))));
        
      System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");     
      System.out.println("*Total fees pending school-wise");
       System.out.println(StudentList.stream() .collect(Collectors.groupingBy(Student::getSchool, Collectors.summingInt(s -> s.getFee().getFeesPending()))));
       System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
      System.out.println("*Total number of students in the university");
      System.out.println(StudentList.size());
      System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        

        //   - Whole University
        //   - School Wise 
        // 
        // 
        // 
        // 
        // 
        // 
        
        
    }
}

class Student{
   private int rollNo;
   private String name;
   private int age;
   private String school;
   private int standard;
   
   Gender gender;
   private double percentage;
   private Fees fee;
   Student(int rollNo,String name,int age,String school,int standard, Gender g,double percentage,int feesPaid){
    this.rollNo = rollNo ;
    this.name = name ;
    this.age =  age;
    this.school = school ;
    this.standard = standard ;
    this.gender= g;
    this.percentage = percentage ;
    fee = new Fees(standard,feesPaid);
   }

   public int getRollNo() { return rollNo; }
   public String getName() { return name; }
   public int getAge() { return age; }
   public String getSchool() { return school; }
   public int getStandard() { return standard; }
   public Gender getGender() { return gender; }
   public double getPercentage() { return percentage; }
   public Fees getFee() { return fee; }

  
   public String toString(){
    return "\n------------------------------------\nName :"+name+"  Age :"+age+"  School :"+school+"  Percentage :"+percentage+"  gender  :"+gender+"\n"; 
  } 

    public static void Dummydata(List<Student> studentList){
        studentList.add(new Student(2021200015, "Sarvesh Birla", 18, "St. Lawrence High School", 10, Gender.MALE, 99.86, 8000));
        studentList.add(new Student(2021200016, "Priya Sharma", 17, "St. Xavier's", 10, Gender.FEMALE, 89, 7000));
        studentList.add(new Student(2021200017, "Rahul Verma", 16, "DPS Delhi", 9, Gender.MALE, 85, 6000));
        studentList.add(new Student(2021200018, "Ananya Sen", 15, "Modern School", 8, Gender.FEMALE, 91, 5000));
        studentList.add(new Student(2021200019, "Amit Gupta", 18, "Springfield Academy", 12, Gender.MALE, 88, 12000));
        studentList.add(new Student(2021200020, "Neha Yadav", 17, "St. Lawrence High School", 11, Gender.FEMALE, 92, 11000));
        studentList.add(new Student(2021200021, "Rohit Das", 16, "St. Xavier's", 10, Gender.MALE, 86, 9000));
        studentList.add(new Student(2021200022, "Kavita Nair", 15, "DPS Delhi", 9, Gender.FEMALE, 90, 8000));
        studentList.add(new Student(2021200023, "Sameer Khan", 14, "Modern School", 8, Gender.MALE, 87, 7000));
        studentList.add(new Student(2021200024, "Rina Bose", 18, "Springfield Academy", 12, Gender.FEMALE, 94, 12000));
        studentList.add(new Student(2021200025, "Arjun Mehta", 17, "St. Lawrence High School", 11, Gender.MALE, 89, 11000));
        studentList.add(new Student(2021200026, "Sneha Iyer", 16, "St. Xavier's", 10, Gender.FEMALE, 85, 9000));
        studentList.add(new Student(2021200027, "Vikram Chauhan", 15, "DPS Delhi", 9, Gender.MALE, 88, 8000));
        studentList.add(new Student(2021200028, "Ritika Singh", 14, "Modern School", 8, Gender.FEMALE, 91, 7000));
        studentList.add(new Student(2021200029, "Aditya Roy", 18, "Springfield Academy", 12, Gender.MALE, 93, 12000));
        studentList.add(new Student(2021200030, "Madhavi Joshi", 17, "St. Lawrence High School", 11, Gender.FEMALE, 90, 11000));
        studentList.add(new Student(2021200031, "Karan Malhotra", 16, "St. Xavier's", 10, Gender.MALE, 88, 9000));
        studentList.add(new Student(2021200032, "Rhea Kapoor", 15, "DPS Delhi", 9, Gender.FEMALE, 87, 8000));
        studentList.add(new Student(2021200033, "Aayush Singh", 14, "Modern School", 8, Gender.MALE, 85, 7000));
        studentList.add(new Student(2021200034, "Nisha Patil", 18, "Springfield Academy", 12, Gender.FEMALE, 93, 12000));
        studentList.add(new Student(2021200035, "Varun Sharma", 17, "St. Lawrence High School", 11, Gender.MALE, 89, 11000));
        studentList.add(new Student(2021200036, "Harsh Tiwari", 16, "St. Xavier's", 10, Gender.MALE, 87, 8500));
        studentList.add(new Student(2021200037, "Pooja Mishra", 15, "DPS Delhi", 9, Gender.FEMALE, 92, 7500));
        studentList.add(new Student(2021200038, "Nitin Sharma", 14, "Modern School", 8, Gender.MALE, 84, 6500));
        studentList.add(new Student(2021200039, "Megha Patel", 18, "Springfield Academy", 12, Gender.FEMALE, 90, 9500));
        studentList.add(new Student(2021200040, "Ravi Kumar", 17, "St. Lawrence High School", 11, Gender.MALE, 85, 10500));
        studentList.add(new Student(2021200041, "Divya Malhotra", 16, "St. Xavier's", 10, Gender.FEMALE, 91, 9500));
        studentList.add(new Student(2021200042, "Siddharth Jain", 15, "DPS Delhi", 9, Gender.MALE, 89, 7800));
        studentList.add(new Student(2021200043, "Tanya Rao", 14, "Modern School", 8, Gender.FEMALE, 86, 7200));
        studentList.add(new Student(2021200044, "Aakash Bhatia", 18, "Springfield Academy", 12, Gender.MALE, 94, 10000));
        studentList.add(new Student(2021200045, "Shreya Kapoor", 17, "St. Lawrence High School", 11, Gender.FEMALE, 89, 11000));
        

         // Add dummy data here
    }
  
}

class Fees{
    
  private int  totalFees;
  private int feesPaid ;
  private int feesPending ;
  
  Fees(int standard,int feesPaid){
    this.totalFees=standard*1000;
    this.feesPaid=feesPaid ;
    this.feesPending = this.totalFees-this.feesPaid ;
  }
   


   public int getTotalFees() { return totalFees; }
   public int getFeesPaid() { return feesPaid; }
   public int getFeesPending() { return feesPending; }
}

enum Gender{
    MALE ,
    FEMALE
   }


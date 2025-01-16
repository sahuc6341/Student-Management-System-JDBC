package StudentManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentManagement {
 private static final String url="jdbc:mysql://localhost:3306/student";
 private static final String username="root";
 private static final String password="WJ28@Krhps";
 public static void main(String[]args) {
	 try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 
	 }catch(ClassNotFoundException e) {
		 e.printStackTrace();
	 }
	 try {
		 Scanner sc=new Scanner(System.in);
		 Connection con=DriverManager.getConnection(url,username,password);
		 Student student=new Student(con,sc);
		 while(true) {
			 System.out.println("Student management System");
			 System.out.println("1. Add Student");
			 System.out.println("2. view Students");
			 System.out.println("3. Update Student");
			 System.out.println("4. Delete Student");
			 System.out.println("5. Exit");
			 System.out.println("Enter your Choice: ");
			 int Choice=sc.nextInt();
			 switch(Choice){
				 case 1:
					 //add student
					 student.addStudent();8
					 break;
				 case 2:
					 //view Students
					 student.viewStudent();
					break;
				 case 3:
					 //Update student
					 student.updateStudent();
					 break;	
				 case 4:
					 //Delete student
					 student.deleteStudent();
					 break;	
				 case 5:
			    	 return;
			    
			    	
			     default:
			    	 System.out.println("Enter valid Choice!!");
			    	 break;	 
			 }
			 
		 }
		 
	 }catch(SQLException e) {
		 e.printStackTrace();
     }
 }
}

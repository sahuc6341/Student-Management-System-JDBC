package StudentManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Student {
	  private Connection con;
	  private Scanner sc;

	public Student(Connection con, Scanner sc) {
		
		// TODO Auto-generated constructor stub
		 this.con=con;
    	 this.sc=sc;
	}
   public void addStudent() {
	   System.out.print("Enter Student name: ");
	   String name=sc.next();
	   System.out.print("Enter gender: ");
	   String gender=sc.next();
	   System.out.print("Enter Age: ");
	   int age=sc.nextInt();
	   System.out.print("Enter Email id: ");
	   String Email=sc.next();
	   System.out.print("course: ");
	   String course=sc.next();
	   System.out.print("fee: ");
	   int fee=sc.nextInt();
	   System.out.print("Address: ");
	   String address=sc.next();
	   System.out.print("Contact no: ");
	   int contact=sc.nextInt();
	   
	   try {
		   String query="insert into students(name,gender,age,Email,course,fee,address,contact) values(?,?,?,?,?,?,?,?)";
		   PreparedStatement pre=con.prepareStatement(query);
		   pre.setString(1,name);
		   pre.setString(2,gender);
		   pre.setInt(3,age);
		   pre.setString(4,Email);
		   pre.setString(5,course);
		   pre.setInt(6,fee);
		   pre.setString(7,address);
		   pre.setInt(8,contact);
		   int affectedRows=pre.executeUpdate();
		   if(affectedRows>0) {
			   System.out.println("success");
			   
		   }else {
			   System.out.println("fail");
		   }
		   
		   
	   }catch(SQLException e) {
  		 e.printStackTrace();
	     }
	   
   } 
   public void viewStudent() {
  	 String query="select * from students";
  	 try {
  		 PreparedStatement pre=con.prepareStatement(query);
  		 ResultSet resultSet= pre.executeQuery();
  		 System.out.println("Students: ");
  		 System.out.println("+----+---------+--------+------+-----------------------+--------+------+---------+-----------+");
  		 System.out.println("| id | name    | gender | age  | Email                 | course | fee  | address | contact   |");
  		 System.out.println("+----+---------+--------+------+-----------------------+--------+------+---------+-----------+");
  		 while(resultSet.next()) {
  			 int id=resultSet.getInt("id");
  			 String name=resultSet.getString("name");
  			 String age=resultSet.getString("gender");
  			 int gender=resultSet.getInt("age");
  			 String Email=resultSet.getString("Email");
  			 String course=resultSet.getString("course");
  			 int fee=resultSet.getInt("fee");
  			 String address=resultSet.getString("address");
  			 int contact=resultSet.getInt("contact");
  			 System.out.printf("|%-4s|%-10s|%-6s|%-5s| %-20s | %-8s|%-8s|%-10s|%-7s|\n",id,name,gender,age,Email,course,fee,address,contact);   
  			 System.out.println("+----+---------+--------+------+-----------------------+--------+------+---------+-----------+");
  			 }
  		 
  	 }catch(SQLException e) {
  		 e.printStackTrace();
  	 }
   }
   public void deleteStudent() {
	   System.out.print("Enter student id to delete: ");
	   int id=sc.nextInt();
	   String query="delete from students where id= "+id;
	   try {
		PreparedStatement pre=con.prepareStatement(query);
		int affectedRows=pre.executeUpdate();
		   if(affectedRows>0) {
			   System.out.println("success");
			   
		   }else {
			   System.out.println("fail");
		   }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	   
   }
   public void updateStudent(){
	   System.out.print("Enter student id: ");
	   int id=sc.nextInt();
	   System.out.print("Enter new name: ");
	   String newName=sc.next();
	   System.out.print("enter new Email id: ");
	   String newEmail=sc.next();
	   String query="update students set name=?, Email=? where id= "+id;
	   try {
		   PreparedStatement pre=con.prepareStatement(query);
		   pre.setString(1, newName);
		   pre.setString(2, newEmail);
		   
			int affectedRows=pre.executeUpdate();
			   if(affectedRows>0) {
				   System.out.println(" update success");
				   
			   }else {
				   System.out.println("fail");
			   }
		   
	   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
   
}

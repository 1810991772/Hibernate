package org.example.demo;

import java.util.List;
import java.util.Scanner;

import org.example.demo.entity.Address;

import org.example.demo.entity.Student;
import org.example.demo.service.StudentService;
import org.example.demo.service.StudentServiceImpl;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	StudentService studentService=new StudentServiceImpl();
        
    	try {
    		
    		Scanner scn=new Scanner(System.in);
    	       int ch=9999;
    	    System.out.println("Enter 1 for create Student");
    	    System.out.println("Enter 2 for All Student");
    	    System.out.println("Enter 3 for Search Student");
    	    System.out.println("Enter 4 for Update Student");
    	    System.out.println("Enter 5 for Delete Student");
    	        while(ch!=0) {
    	       ch=scn.nextInt();
    	        switch(ch) {
    	        case 1:
    	        try {
    	        	System.out.println("Enter Student Name");
    	        	String name=scn.next();
    	        	System.out.println("Enter Student email");
    	        	String email=scn.next();
    	        	System.out.println("Enter Student Address Details");
    	        	System.out.println("Enter Street");
    	        	String street=scn.next();
    	        	System.out.println("Enter City");
    	        	String city=scn.next();
    	        	System.out.println("Enter Zipcode");
    	        	String zipcode=scn.next();
    	        	Address home=new Address(city,street,zipcode);
    	        			studentService.createStudent(new Student(2, name,email,home));
    	        }
    	        catch(Exception e) {
    	        	System.err.println(e.getMessage());
    	        }
    	        break;
    	        case 2:
    	        
    	        	try {
    	        		 List<Student> list=studentService.getAllStudents(); 
    	        		 if(list.isEmpty())
    	        			 System.out.println("No Student is Registered");
    	        		 for(Student e:list) 
    	        		 {
    	        			  System.out.println(e);
    	        		 }
    	    			 
    	        	}
    	        	catch(Exception e) {
    	        		System.err.println(e.getMessage());
    	        	}
    	        break;
    	        case 3:
    	        	try {
    	        		System.out.print("Enter Student  Id :: ");
    	        		int id=scn.nextInt();
    	        		Student student=studentService.findStudentById(id);
    	        		if(student==null)
    	       			  {
    	        			System.out.println("Student not found");
    	        		} 
    	        		else {
    	       			  
    	       			  System.out.println(student);
    	       			  }	
    	        	}
    	        	catch(Exception e)
    	        	{
    	        		System.err.println("Student not found u put a Wrong Id");
    	        	}
    	        	break;
    	        case 4:
    	        try {
    	        	System.out.print("Enter Student  Id :: ");
	        		int id=scn.nextInt();
	        		studentService.updateStudentById(id);
    	        	
    	        }
    	        catch(Exception e) {
    	        	System.err.println("Student not found u put a Wrong Id");
    	        }
    	        break;
    	        case 5:
    	        
    	        try {
    	        	System.out.print("Enter Student  Id :: ");
	        		int id=scn.nextInt();
    	        	studentService.deleteStudentById(id);
    	        }
    	        catch(Exception e)
    	        {
    	        	System.err.println("Student not found u put a Wrong Id");
    	        }
    	        break;
    	        default:
    	        System.out.println("Thank u For Using us.");
    	        }
    	        }
    	        scn.close();
    	}
        catch (Exception e){
        	e.printStackTrace();
        }
    }
}

package org.example.demo.service;

import java.util.List;
import java.util.Scanner;

import javax.persistence.TypedQuery;

import org.example.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentServiceImpl implements StudentService {

	SessionFactory sessionFactory=new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
	private Session session=sessionFactory.openSession();;
	private Scanner scanner=new Scanner(System.in);
	@Override
	public void createStudent(Student student) {
		
		session.getTransaction().begin();
		session.save(student);
		session.getTransaction().commit();
		System.out.println("Student created. sucessfully..");
		
	}

	@Override
	public List<Student> getAllStudents() {
		
		session.getTransaction().begin();
		TypedQuery<Student> query=session.createQuery("FROM Student",Student.class);
		session.getTransaction().commit();
		return query.getResultList();
	}

	@Override
	public Student findStudentById(int id) {
		
		session.getTransaction().begin();
		Student student=session.get(Student.class, id);
		session.getTransaction().commit();
		return student;
	}

	@Override
	public void updateStudentById(int id) {
		Student student=findStudentById(id);
		if(student==null)
		{
			System.out.println("Student not found.");
		}
		else
		{
			System.out.println("SStudent Found...");
			System.out.print("Enter New Student Name: ");
			String name=scanner.next();
			student.setName(name);
			session.getTransaction().begin();
			session.merge(student);
			session.getTransaction().commit();
			System.out.println("Updated sucessfully..");
		}
		
	}

	@Override
	public void deleteStudentById(int id) {
		Student student=findStudentById(id);
		if(student==null)
		{
			System.out.println("Student Not Found.");
		}
		else
		{
			session.getTransaction().begin();
			session.remove(student);
			session.getTransaction().commit();
			System.out.println("deletion sucessed.");
		}
		
		
	}

}

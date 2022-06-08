package org.example.demo;

import org.example.demo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
        	SessionFactory sessionFactory=new Configuration().configure().addAnnotatedClass(Customer.class).buildSessionFactory();
     	   Session session=sessionFactory.openSession();
     	   
     	   session.getTransaction().begin();
     	   session.save(new Customer(1, "john","marry@email.com"));
     	   session.getTransaction().commit();
     	   System.out.println("inserted sucessfully");;
        }
        catch (Exception e){
        	e.printStackTrace();
        }
    }
}

package com.abhi.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.abhi.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		//create session factory
		
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		//create session
		 Session session=factory.getCurrentSession();
		try {
			//use the session object to save the object
			System.out.println("Creating new Student object");
			
			//create  a student object
			Student tempStudent=new Student("paul","wall","paul@gmail.com");
			
			//start transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the student");
			session.save(tempStudent);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println(" Done! ");
		}
		finally {
			factory.close();
		}
	}

}

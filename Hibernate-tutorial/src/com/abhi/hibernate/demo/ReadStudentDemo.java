package com.abhi.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.abhi.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			Student tempStudent=new Student("Daffy","duck","daffy@gmail.com");
			
			//start transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the student");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			//commit transaction
			session.getTransaction().commit();
			
			
			//find out the student's id:primary key
			
			System.out.println("Saved student,Generted Id:"+tempStudent.getId());
			
			//now get a new session and transaction 
			
			session=factory.getCurrentSession();
			session.beginTransaction();
			//retrieve student based on the id:primary key
			System.out.println("\nGeeting student with id:"+tempStudent.getId());
			
			Student myStudent=session.get(Student.class, tempStudent.getId());
			System.out.println("Get complete::"+myStudent);
			
			//commit the transation
			session.getTransaction().commit();
			System.out.println(" Done! ");
		}
		finally {
			factory.close();
		}
	}

}

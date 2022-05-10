package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class EmDemo {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("com/tut/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Student student1 = new Student();
		student1.setId(1111);
		student1.setName("Raaaaaaj");
		student1.setAge(23);
		student1.setCity("Pune");
		
		Certificate certificate1 = new Certificate();
		certificate1.setCourse("JAVA");
		certificate1.setDuration("2 months");
		student1.setCertificate(certificate1);
		
		Student student2 = new Student();
		student2.setId(2222);
		student2.setName("Arjun");
		student2.setAge(20);
		student2.setCity("Aurangabad");
		
		Certificate certificate2 = new Certificate();
		certificate2.setCourse("MBA");
		certificate2.setDuration("12 months");
		student2.setCertificate(certificate2);
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		//object save
		session.save(student1);
		session.save(student2);
		
		transaction.commit();
		session.clear();
		factory.close();
	}

}

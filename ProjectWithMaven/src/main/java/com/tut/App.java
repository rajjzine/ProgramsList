package com.tut;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("project started!");
		Configuration cfg = new Configuration();
		cfg.configure("com/tut/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		System.out.println(factory);
		System.out.println(factory.isClosed());
		// creating student object
		Student student = new Student();
		student.setId(101);
		student.setName("Raaj");
		student.setAge(23);
		student.setCity("Aurangabad");
		System.out.println(student);
		// creating address object
		Address address = new Address();
		address.setStreet("street1");
		address.setCity("Aurangabad");
		address.setOpen(true);
		address.setAddedDate(new Date());
		address.setX(1234.234);
		
		//for adding image
		FileInputStream file = new FileInputStream("src/main/java/admi.png");
		byte[] data = new byte[file.available()];
		file.read(data);
		address.setImage(data);

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(student);
		session.save(address);
		transaction.commit();
		session.close();
		System.out.println("Done...");
	}
}

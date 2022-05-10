package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
	public static void main(String[] args) {
		//get,load
		Configuration cfg = new Configuration();
		cfg.configure("com/tut/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		Student student = (Student)session.load(Student.class,101);
		System.out.println(student);
		
		Address address = (Address)session.get(Address.class,2);
		System.out.println(address.getStreet()+" : "+address.getCity());
		
		session.close();
		session.close();
	}

}

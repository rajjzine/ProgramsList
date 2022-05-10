package com.mapping.oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneDemo {
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("com/tut/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// creating qestion object
		Question question = new Question();
		question.setQuestionId(121);
		question.setQuestion("What is JAVA");

		// creating answeer object
		Answer answer = new Answer();
		answer.setAnswerId(222);
		answer.setAnswer("JAVA is a programming language");
		answer.setQuestion(question);
		question.setAnswer(answer);

		Question question1 = new Question();
		question1.setQuestionId(122);
		question1.setQuestion("What is @entity?");

		Answer answer1 = new Answer();
		answer1.setAnswerId(333);
		answer1.setAnswer("@entity is use to mark class as entity.");
		answer1.setQuestion(question1);
		question1.setAnswer(answer1);

		Question question2 = new Question();
		question2.setQuestionId(123);
		question2.setQuestion("What is @table");

		Answer answer2 = new Answer();
		answer2.setAnswerId(444);
		answer2.setAnswer("@table is use to change table details or name. ");
		answer2.setQuestion(question2);
		question2.setAnswer(answer2);

		// session
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		// save
		session.save(question);
		session.save(question1);
		session.save(question2);
		session.save(answer);
		session.save(answer1);
		session.save(answer2);

		transaction.commit();
		
		//fetching
		Question newQ = (Question)session.get(Question.class,123);
		System.out.println(newQ.getQuestion());
		System.out.println(newQ.getAnswer().getAnswer());
		
		session.clear();

		factory.close();
	}

}

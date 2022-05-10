package com.ExofOneToMany;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToManyDemo {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("com/ExofOneToMany/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// creating qestion object
		QuestionEx question = new QuestionEx();
		question.setQuestionId(9999);
		question.setQuestion("What is JAVA");

		// creating answeer object
		AnswerEx answer = new AnswerEx();
		answer.setAnswerId(7777);
		answer.setAnswer("JAVA is a programming language");
		answer.setQuestion(question);

		AnswerEx answer1 = new AnswerEx();
		answer1.setAnswerId(6666);
		answer1.setAnswer("with the help of java we can create software");
		answer1.setQuestion(question);

		AnswerEx answer2 = new AnswerEx();
		answer2.setAnswerId(5555);
		answer2.setAnswer("java has different type of frameworks.");
		answer2.setQuestion(question);

		List<AnswerEx> list = new ArrayList<AnswerEx>();
		list.add(answer);
		list.add(answer1);
		list.add(answer2);
		question.setAnswers(list);
		
		// session
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		// save
		session.save(question);
		//session.save(answer);

		transaction.commit();

//		// fetching
//		Question_OTM newQ = (Question_OTM) session.get(Question_OTM.class, 123);
//		System.out.println(newQ.getQuestion());
//		System.out.println(newQ.getAnswer_otm().get);

		session.clear();
		factory.close();
	}

}

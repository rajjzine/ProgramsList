package com.ExofOneToMany;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AnswerEx {
	@Id
	@Column(name = "answer_id")
	private int answerId;
	private String answer;

	@ManyToOne
	private QuestionEx question;

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public QuestionEx getQuestion() {
		return question;
	}

	public void setQuestion(QuestionEx question) {
		this.question = question;
	}

	public AnswerEx() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnswerEx(int answerId, String answer) {
		super();
		this.answerId = answerId;
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", answer=" + answer + "]";
	}

}

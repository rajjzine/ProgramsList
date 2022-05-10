package com.ExofOneToMany;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class QuestionEx {
	@Id
	@Column(name = "question_id")
	private int questionId;
	private String question;
	@OneToMany
	private List<AnswerEx> answers;

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<AnswerEx> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AnswerEx> answers) {
		this.answers = answers;
	}

	public QuestionEx(int questionId, String question, List<AnswerEx> answers) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answers = answers;
	}

	public QuestionEx() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", question=" + question + ", answers=" + answers + "]";
	}

}

package net.tsolval.poc.ql.entity;

import java.util.List;

/**
 * A Survey is a list of questions filled out by a respondent and contains not
 * only the questions they were asked, but also records the answers they gave.
 * 
 * @author walker.d.adams
 */
public class Survey {

	List<Question> questions;

	public Survey() {
		// default constructor; do nothing
	}

	public Survey(List<Question> questions) {
		setQuestions(questions);
	}

	/**
	 * @return the questions
	 */
	public List<Question> getQuestions() {
		return questions;
	}

	/**
	 * @param questions
	 *            the questions to set
	 */
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
}

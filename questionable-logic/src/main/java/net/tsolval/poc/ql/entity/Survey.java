package net.tsolval.poc.ql.entity;

import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/**
 * A Survey is a list of questions filled out by a respondent and contains not
 * only the questions they were asked, but also records the answers they gave.
 * 
 * @author walker.d.adams
 */
public class Survey {

	private Question currentQ;
	private List<Question> questions;
	private Map<String, Question> questionMap;

	public Survey() {
		currentQ = null;
	}

	public Survey(List<Question> questions) {
		this();
		setQuestions(questions);
	}

	public Question getNextQuestion() {
		if (questions == null) {
			currentQ = null;
		} else if (currentQ == null) {
			currentQ = questions.get(0);
		} else if (currentQ.hasChildren()) {
			currentQ = currentQ.getChildren().get(0);
		} else {
			currentQ = getNextSibling(currentQ);
		}
		return currentQ;
	}

	public Question getNextSibling(Question current) {
		if (current == null) {
			return current;
		}
		Question parent = current.getParent();
		List<Question> siblings = parent == null ? questions : parent.getChildren();
		int index = siblings.indexOf(current);
		ListIterator<Question> listIterator = siblings.listIterator(++index);
		return listIterator.hasNext() ? listIterator.next() : getNextSibling(parent);
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

	/**
	 * @return the questionMap
	 */
	public Map<String, Question> getQuestionMap() {
		return questionMap;
	}

	/**
	 * @param questionMap
	 *            the questionMap to set
	 */
	public void setQuestionMap(Map<String, Question> questionMap) {
		this.questionMap = questionMap;
	}
}

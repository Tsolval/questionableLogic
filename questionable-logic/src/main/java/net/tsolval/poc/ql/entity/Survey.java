package net.tsolval.poc.ql.entity;

import java.util.Map;

/**
 * A Survey is a list of questions filled out by a respondent and contains not
 * only the questions they were asked, but also records the answers they gave.
 * 
 * @author walker.d.adams
 */
public class Survey {
	private String name;
	private Map<String, Question> questionMap;

	public Survey() {
		// default constructor; does nothing
	}

	public Survey(String name, Map<String, Question> questionMap) {
		this();
		setName(name);
		setQuestionMap(questionMap);
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

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}

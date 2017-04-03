package net.tsoval.poc.ql.form;

import java.util.HashMap;
import java.util.Map;

import net.tsolval.poc.ql.entity.Question;

public class FormData {
	private Map<String, Question> questionsMap = new HashMap<String, Question>();

	/**
	 * @return the questionsMap
	 */
	public Map<String, Question> getQuestionsMap() {
		return questionsMap;
	}

	/**
	 * @param questionsMap the questionsMap to set
	 */
	public void setQuestionsMap(Map<String, Question> questionsMap) {
		this.questionsMap = questionsMap;
	}
}

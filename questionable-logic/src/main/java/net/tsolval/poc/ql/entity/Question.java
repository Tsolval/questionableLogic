package net.tsolval.poc.ql.entity;

import java.util.List;

import net.tsolval.poc.ql.constants.ResponseType;

/**
 * This object represents a question to be asked. A Question is related to an
 * Answer. TODO: Decide whether to create an Answer object to compose with.
 * 
 * @author walker.d.adams
 *
 */
public class Question {
	private String questionId;
	private String questionString;
	private Question parent;
	private List<Question> children;
	private ResponseType responseType;

	/**
	 * @return the questionId
	 */
	public String getQuestionId() {
		return questionId;
	}

	/**
	 * @param questionId
	 *            the questionId to set
	 */
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	/**
	 * @return the questionString
	 */
	public String getQuestionString() {
		return questionString;
	}

	/**
	 * @param questionString
	 *            the questionString to set
	 */
	public void setQuestionString(String questionString) {
		this.questionString = questionString;
	}

	/**
	 * @return the parent
	 */
	public Question getParent() {
		return parent;
	}

	/**
	 * @param parent
	 *            the parent to set
	 */
	public void setParent(Question parent) {
		this.parent = parent;
	}

	/**
	 * @return the children
	 */
	public List<Question> getChildren() {
		return children;
	}

	/**
	 * @param children
	 *            the children to set
	 */
	public void setChildren(List<Question> children) {
		this.children = children;
	}

	/**
	 * @return the responseType
	 */
	public ResponseType getResponseType() {
		return responseType;
	}

	/**
	 * @param responseType
	 *            the responseType to set
	 */
	public void setResponseType(ResponseType responseType) {
		this.responseType = responseType;
	}

}

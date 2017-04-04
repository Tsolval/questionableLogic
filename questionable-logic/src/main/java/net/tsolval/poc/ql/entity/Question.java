package net.tsolval.poc.ql.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.tsolval.poc.ql.constants.ResponseType;

/**
 * This object represents a question to be asked. A Question is related to an
 * Answer.
 * 
 * @author walker.d.adams
 */
public class Question {
	private String questionId;
	private String questionString;
	private Question parent;
	private List<Question> children;
	private ResponseType responseType;
	private Response response;
	private Conditional conditional;

	public Question() {
		children = new ArrayList<Question>();
		setResponse(new Response(this));
	}

	public Question(String question) {
		this();
		setQuestionString(question);
	}

	public Question(String question, ResponseType responseType) {
		this(question);
		setResponseType(responseType);
	}

	public Question(String questionId, String question, ResponseType responseType) {
		this(question);
		setResponseType(responseType);
		setQuestionId(questionId);
	}

	public Question(String question, ResponseType responseType, Conditional conditional) {
		this(question, responseType);
		setConditional(conditional);
	}

	public Question(String questionId, String question, ResponseType responseType, Conditional conditional) {
		this(question, responseType);
		setQuestionId(questionId);
		setConditional(conditional);
	}

	public Question(String question, Question parent) {
		this(question);
		setParent(parent);
	}

	public Question(String question, Question parent, ResponseType responseType) {
		this(question, parent);
		setResponseType(responseType);
	}

	public Question(String question, List<Question> children) {
		this(question);
		setChildren(children);
	}

	public Question(String question, List<Question> children, ResponseType responseType) {
		this(question, children);
		setResponseType(responseType);
	}

	public Question(String question, Question parent, List<Question> children) {
		this(question, parent);
		setChildren(children);
	}

	public Question(String question, Question parent, List<Question> children, ResponseType responseType) {
		this(question, parent, children);
		setResponseType(responseType);
	}

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
	 * @param child
	 *            the child question to add
	 */
	public void addChild(Question child) {
		child.setParent(this);
		children.add(child);
	}

	/** @return true if this question has children */
	public boolean hasChildren() {
		return !getChildren().isEmpty();
	}

	/**
	 * @param children
	 *            the children to set
	 */
	public void setChildren(List<Question> children) {
		for (Question child : children) {
			addChild(child);
		}
	}

	/**
	 * @param children
	 *            the children to set
	 */
	public void setChildren(Question... questions) {
		setChildren(Arrays.asList(questions));
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

	/**
	 * @return the response
	 */
	public Response getResponse() {
		return response;
	}

	/**
	 * @param response
	 *            the response to set
	 */
	public void setResponse(Response response) {
		this.response = response;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		List<String> childIds = new ArrayList<String>();
		for (Question child : children) {
			childIds.add(child.getQuestionId());
		}
		String parentId = parent == null ? null : parent.getQuestionId();
		String message = String.format("Question [id=%s, question=%s, responseType=%s, parent=%s, children=%s]",
				questionId, questionString, responseType, parentId, childIds);
		return message;
	}

	/**
	 * @return the conditional
	 */
	public Conditional getConditional() {
		return conditional;
	}

	/**
	 * @param conditional
	 *            the conditional to set
	 */
	public void setConditional(Conditional conditional) {
		this.conditional = conditional;
	}
}

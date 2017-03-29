package net.tsolval.poc.ql.entity;

import net.tsolval.poc.ql.constants.ResponseType;

/**
 * @author walker.d.adams
 *
 */
public class Response {

	private String id;
	private ResponseType responseType;
	private String answer;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
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
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * @param answer
	 *            the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}
}

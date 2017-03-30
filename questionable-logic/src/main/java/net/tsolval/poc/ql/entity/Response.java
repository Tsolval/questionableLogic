package net.tsolval.poc.ql.entity;

/**
 * The response to a question.
 * 
 * @author walker.d.adams
 */
public class Response {

	private String id;
	private Question question;
	private String answerString;

	public Response() {
		// default constructor; do nothing
	}

	public Response(Question q) {
		setQuestion(q);
	}

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
	 * @return the question
	 */
	public Question getQuestion() {
		return question;
	}

	/**
	 * @param question
	 *            the question to set
	 */
	public void setQuestion(Question question) {
		this.question = question;
	}

	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answerString;
	}

	/**
	 * @param answer
	 *            the answer to set
	 */
	public void setAnswer(String answer) {
		this.answerString = answer;
	}
}

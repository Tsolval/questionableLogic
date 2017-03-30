package net.tsolval.poc.ql.entity;

/**
 * 
 * @author walker.d.adams
 *
 */
public class Conditional {
	private Question question;
	private String expected;

	public Conditional(Question q, String expected) {
		this.question = q;
		this.expected = expected;
	}

	public Boolean evaluate() {
		boolean result = expected.equals(question.getResponse().getAnswer());
		return result;
	}
}

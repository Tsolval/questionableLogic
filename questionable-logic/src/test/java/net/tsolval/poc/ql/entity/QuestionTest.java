package net.tsolval.poc.ql.entity;

import static org.junit.Assert.*;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import net.tsolval.poc.ql.constants.ResponseType;

public class QuestionTest {

	@Test
	public void testToString() throws Exception {
		Question q1 = new Question("Q1", "TQ?", ResponseType.CHECKBOX);
		Question q2 = new Question("Q2", "TQ2", ResponseType.CHECKBOX);
		Question q3 = new Question("Q3", "TQ3", ResponseType.CHECKBOX);
		q1.setChildren(q2, q3);
		q2.setParent(q1);
		q3.setParent(q1);
		assertThat(q1.toString(), CoreMatchers.containsString("parent=null"));
		assertThat(q1.toString(), CoreMatchers.containsString("children=[Q2, Q3]"));
		assertThat(q2.toString(), CoreMatchers.containsString("parent=Q1"));
	}
}

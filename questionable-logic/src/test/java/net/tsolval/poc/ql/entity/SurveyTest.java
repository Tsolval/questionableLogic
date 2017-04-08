package net.tsolval.poc.ql.entity;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.tsolval.poc.ql.constants.ResponseType;

/**
 * Tests for survey class.
 * 
 * @author walker.d.adams
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class SurveyTest {
	private Survey survey;

	/** Build a question hierarchy to loop through. */
	@Before
	public void setupSurvey() {
		survey = new Survey();
		List<Question> questions = new ArrayList<Question>();
		Question q1 = new Question("Q1", "Is this a question?", ResponseType.BOOLEAN);
		Question q2 = new Question("Q2", "You're right! How does that make you feel?", ResponseType.TEXTBOX,
				new Conditional(q1, "YES"));
		Question q3 = new Question("Q3", "Of course it's a question! How could you get that wrong!?",
				ResponseType.TEXTAREA, new Conditional(q1, "NO"));
		q1.setChildren(q2, q3);
		questions.add(q1);
//		survey.setQuestions(questions);

		Map<String, Question> questionMap = new HashMap<String, Question>();
		questionMap.put(q1.getQuestionId(), q1);
		questionMap.put(q2.getQuestionId(), q2);
		questionMap.put(q3.getQuestionId(), q3);
		survey.setQuestionMap(questionMap);
	}

	/**
	 * Test method for
	 * {@link net.tsolval.poc.ql.entity.Survey#getNextQuestion(net.tsolval.poc.ql.entity.Question)}.
	 */
	@Test
	public void testGetNextQuestion() throws Exception {
//		assertThat(survey.getNextQuestion().toString(), CoreMatchers.allOf(CoreMatchers.containsString("id=Q1"),
//				CoreMatchers.containsString("parent=null"), CoreMatchers.containsString("children=[Q2, Q3]")));
//		assertThat(survey.getNextQuestion().toString(), CoreMatchers.allOf(CoreMatchers.containsString("id=Q2"),
//				CoreMatchers.containsString("parent=Q1"), CoreMatchers.containsString("children=[]")));
//		assertThat(survey.getNextQuestion().toString(), CoreMatchers.allOf(CoreMatchers.containsString("id=Q3"),
//				CoreMatchers.containsString("parent=Q1"), CoreMatchers.containsString("children=[]")));
//		assertNull(survey.getNextQuestion());
//		assertThat(survey.getNextQuestion().toString(), CoreMatchers.allOf(CoreMatchers.containsString("id=Q1"),
//				CoreMatchers.containsString("parent=null"), CoreMatchers.containsString("children=[Q2, Q3]")));
	}
}

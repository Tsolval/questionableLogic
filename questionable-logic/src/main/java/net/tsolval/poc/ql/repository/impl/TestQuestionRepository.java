package net.tsolval.poc.ql.repository.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import net.tsolval.poc.ql.constants.ResponseType;
import net.tsolval.poc.ql.entity.Conditional;
import net.tsolval.poc.ql.entity.Question;
import net.tsolval.poc.ql.repository.QuestionRepository;

/**
 * @author walker.d.adams
 *
 */
@Repository
public class TestQuestionRepository implements QuestionRepository {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.tsolval.poc.ql.repository.QuestionRepository#getQuestions(java.lang.
	 * String)
	 */
	@Override
	public Map<String, Question> getQuestions(String questionGroup) {
		Map<String, Question> questions = new HashMap<String, Question>();
		Question q1 = new Question("1", "Is this a question?", ResponseType.BOOLEAN);
		Question q2 = new Question("2", "You're right! How does that make you feel?", ResponseType.TEXTBOX,
				new Conditional(q1, "YES"));
		Question q3 = new Question("3", "Of course it's a question! How could you get that wrong!?",
				ResponseType.TEXTAREA, new Conditional(q1, "NO"));
		q1.setChildren(q2, q3);
		questions.put(q1.getQuestionId(), q1);
		questions.put(q2.getQuestionId(), q2);
		questions.put(q3.getQuestionId(), q3);
		return questions;
	}
}

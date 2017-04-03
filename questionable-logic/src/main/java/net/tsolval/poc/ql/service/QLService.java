package net.tsolval.poc.ql.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import net.tsolval.poc.ql.constants.ResponseType;
import net.tsolval.poc.ql.entity.Conditional;
import net.tsolval.poc.ql.entity.Question;
import net.tsolval.poc.ql.entity.Survey;

/**
 * The Questionable Logic service for handling question logic in the
 * application. This class manages navigation through a question hierarchy based
 * on answers to previous questions.
 * 
 * @author walker.d.adams
 */
@Service
public class QLService {

	/** Return the list questions for the specified question group. **/
	public List<Question> getQuestions(String questionGroup) {
		// TODO: Replace this test implementation.
		List<Question> questions = new ArrayList<Question>();
		Question q1 = new Question("1", "Is this a question?", ResponseType.BOOLEAN);
		Question q2 = new Question("2", "You're right! How does that make you feel?", ResponseType.TEXTBOX,
				new Conditional(q1, "YES"));
		Question q3 = new Question("3", "Of course it's a question! How could you get that wrong!?", ResponseType.TEXTAREA,
				new Conditional(q1, "NO"));
		q1.setChildren(q2, q3);
		questions.add(q1);
		return questions;
	}

	/**
	 * Initialize a new survey with questions from the specified question group.
	 **/
	public Survey getNewSurvey(String group) {
		return new Survey(getQuestions(group));
	}
}

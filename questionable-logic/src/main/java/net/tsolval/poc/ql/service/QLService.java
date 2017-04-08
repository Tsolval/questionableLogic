package net.tsolval.poc.ql.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.tsolval.poc.ql.entity.Question;
import net.tsolval.poc.ql.entity.Survey;
import net.tsolval.poc.ql.repository.QuestionRepository;

/**
 * The Questionable Logic service for handling question logic in the
 * application. This class manages navigation through a question hierarchy based
 * on answers to previous questions.
 * 
 * @author walker.d.adams
 */
@Service
public class QLService {
	@Autowired
	private QuestionRepository repository;

	/**
	 * Initialize a new survey with questions from the specified question group.
	 **/
	public Survey getNewSurvey(String name) {
		Map<String, Question> questions = repository.getQuestions(name);
		Survey survey = new Survey(name, questions);
		return survey;
	}
}

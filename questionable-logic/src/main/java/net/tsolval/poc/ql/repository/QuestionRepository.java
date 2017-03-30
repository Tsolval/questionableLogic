package net.tsolval.poc.ql.repository;

import java.util.Map;

import net.tsolval.poc.ql.entity.Question;

/**
 * This defines the interface for a question repository.
 * 
 * @author walker.d.adams
 */
public interface QuestionRepository {

	public Map<String, Question> getQuestions(String questionGroup);
}

package net.tsolval.poc.ql.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import net.tsolval.poc.ql.service.QLService;

/**
 * A Survey is a list of questions filled out by a respondent and contains not
 * only the questions they were asked, but also records the answers they gave.
 * 
 * @author walker.d.adams
 */
public class Survey {

	@Autowired
	QLService service;
	List<Question> questions;
	List<Response> responses;

	public Survey() {
		questions = service.getQuestions("testGroup");
	}
}

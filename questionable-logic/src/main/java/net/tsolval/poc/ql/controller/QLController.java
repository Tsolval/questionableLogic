package net.tsolval.poc.ql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import net.tsolval.poc.ql.entity.Survey;
import net.tsolval.poc.ql.service.QLService;

/**
 * Questionable Logic Controller displays questions and handles answer input.
 * 
 * @author walker.d.adams
 */
@Controller
public class QLController {
	@Autowired
	private QLService service;

	@GetMapping(value = "/survey")
	public ModelAndView doSurvey() {
		Survey survey = service.getNewSurvey("testGroup");
		ModelAndView view = new ModelAndView("survey", "survey", survey);
		return view;
	}

	@PostMapping(value = "/survey")
	public String doSurveySubmission(@ModelAttribute Survey survey) {
		return "surveyResult";
	}
}

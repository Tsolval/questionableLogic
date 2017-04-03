package net.tsolval.poc.ql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.tsolval.poc.ql.entity.Question;
import net.tsolval.poc.ql.entity.Survey;
import net.tsolval.poc.ql.service.QLService;
import net.tsoval.poc.ql.form.FormData;

/**
 * Questionable Logic Controller displays questions and handles answer input.
 * 
 * @author walker.d.adams
 */
@Controller
public class QLController {
	@Autowired
	private QLService service;

	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

	@RequestMapping(value="/survey/{surveyName}", method = RequestMethod.GET)
	public ModelAndView doSurvey() {
		System.out.println("first Spring method");
		Survey survey = service.getNewSurvey("testGroup");
		ModelAndView mav = new ModelAndView("survey", "survey", survey);
		
		FormData formData = new FormData();
		
		for(Question question : survey.getQuestions()){
			formData.getQuestionsMap().put(question.getQuestionId(), question);
		}
		
		mav.addObject("formData", formData);
		return mav;
	}
	
	@RequestMapping(value = "/survey/{surveyName}/continue", method = RequestMethod.POST)
	public ModelAndView doSurvey(@ModelAttribute("formData") FormData formData, BindingResult bindingResult) {
		for(String q : formData.getQuestionsMap().keySet()){
			System.out.println(formData.getQuestionsMap().get(q));
			System.out.println(formData.getQuestionsMap().get(q).getResponse().getAnswer());
		}
		System.out.println("second method: " + formData.getQuestionsMap());
		Survey survey = service.getNewSurvey("testGroup");
		return new ModelAndView("survey", "survey", survey);
	}
}

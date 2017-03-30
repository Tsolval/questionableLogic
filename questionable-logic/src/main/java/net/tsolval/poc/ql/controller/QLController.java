package net.tsolval.poc.ql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

	@RequestMapping("/survey/{surveyName}")
	public ModelAndView doSurvey() {
		Survey survey = service.getNewSurvey("testGroup");

		return new ModelAndView("survey", "survey", survey);
	}
}

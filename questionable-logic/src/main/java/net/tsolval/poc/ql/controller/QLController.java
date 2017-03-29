package net.tsolval.poc.ql.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Questionable Logic Controller displays questions and handles answer input.
 * 
 * @author walker.d.adams
 */
@Controller
public class QLController {
	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

	@RequestMapping("/survey/{surveyName}")
	public ModelAndView doSurvey() {
		List<String> questions = new ArrayList<String>();
		return new ModelAndView("questionairre", "questions", questions);
	}
}

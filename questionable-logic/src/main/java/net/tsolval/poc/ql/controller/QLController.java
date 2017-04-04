package net.tsolval.poc.ql.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import net.tsolval.poc.ql.entity.Question;
import net.tsolval.poc.ql.entity.Survey;
import net.tsolval.poc.ql.service.QLService;

/**
 * Questionable Logic Controller displays questions and handles answer input.
 * 
 * @author walker.d.adams
 */
@Controller
@SessionAttributes({ "survey" })
public class QLController {
	@Autowired
	private QLService service;

	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "Thank You") String name,
			Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

	@RequestMapping(value = "/survey/{surveyName}", method = RequestMethod.GET)
	public ModelAndView doSurvey() {
		Survey survey = service.getNewSurvey("testGroup");

		ModelAndView mav = new ModelAndView("survey", "survey", survey);
		Question question = survey.getNextQuestion();
		mav.addObject("question", question);

		return mav;
	}

	@RequestMapping(value = "/survey/{surveyName}/continue", method = RequestMethod.POST)
	public ModelAndView doSurvey(@ModelAttribute("survey") Survey survey, @ModelAttribute("question") Question q,
			BindingResult bindingResult, HttpServletRequest request) {

		request.getParameter("questionId");
		System.out.println("second method: ");

		System.out.println("q: " + q);
		for (Question question1 : survey.getQuestions()) {
			if (question1.getQuestionId().equals(q.getQuestionId())) {
				question1.getResponse().setAnswer(q.getResponse().getAnswer());
			}
		}

		Question question = survey.getNextQuestion();
		ModelAndView mav = null;
		if (question == null) {
			mav = new ModelAndView("redirect:/greeting");
		} else {
		mav = new ModelAndView("survey", "survey", survey);
		mav.addObject("question", question);
		System.out.println(question);
		}
		return mav;
	}
}
